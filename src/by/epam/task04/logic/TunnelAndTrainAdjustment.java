/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;


import by.epam.task04.entity.Train;
import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import by.epam.task04.entity.TunnelControlSystem;
import by.epam.task04.entity.TunnelPhaser;
import by.epam.task04.entity.TunnelSemaphore;
import static java.lang.Thread.sleep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Phaser;
import static task04.Task04.LOCAL_LOGGER;

/**
 *
 * @author Helena.Grouk
 */
public class TunnelAndTrainAdjustment {
    
    public static final int TUNNEL_COUNT = 2;
    private static ConcurrentHashMap<String, Tunnel> tunnels = new ConcurrentHashMap();
    
    private TunnelAndTrainAdjustment(){}
    
    public static void addTunnel(Tunnel tunnel) {
        tunnels.put("id" + tunnel.getId(), tunnel);
    }
    
    public static void addAllTunnels(Map<String, Tunnel> tunnels) {
        tunnels.putAll(tunnels);
    }
    
    public static Tunnel getTunnel(TrainDirection direct) { 
        while (true) {
            for (Map.Entry<String, Tunnel> ent: tunnels.entrySet()) {
                Tunnel tunnel = ent.getValue();
                TunnelControlSystem control = tunnel.control;
                TunnelSemaphore semaphore = control.getSemaphore(direct);
                
                if (null != semaphore && semaphore.tryAcquire())
                {
                    try {
                        control.controlLock.lock();
                        TunnelPhaser tp = control.tunnelPhaser;
                        if (null == tp) {
                            tp = createTunnelPhaser(tunnel, direct);
                            tp.getPhaser().register();
                            return tunnel;
                        } else {
                            if (direct == tp.getDirect() && tp.getPhaser().register() >= 0) {
                                return tunnel;
                            } else {
                                semaphore.release();
                            }
                        }
                    } finally {
                        control.controlLock.unlock();
                    }
                }
            }
        }
    }
    
    private static TunnelPhaser createTunnelPhaser(Tunnel tunnel, TrainDirection direct){
        Phaser phaser;
        phaser = new Phaser(1) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return this.getUnarrivedParties() == 0;
            }
        };
        
        TunnelPhaser tp = new TunnelPhaser(phaser, tunnel, direct);
        tunnel.control.tunnelPhaser = tp;
        new Thread(tp).start();
        
        return tp;                    
    }
    
    public static void terminateTunnelPhaser(TunnelPhaser tunnelPhaser){
        
        TunnelControlSystem control = tunnelPhaser.getTunnel().control;
        
        try { 
            control.controlLock.lock();
            LOCAL_LOGGER.info("Phase mooving to the " + tunnelPhaser.getDirect() + " in " + tunnelPhaser.getTunnel() + " complite.");
            control.tunnelPhaser = null;
            
            TunnelSemaphore semaphore = control.getSemaphore(tunnelPhaser.getDirect());
            int permitsCount = semaphore.availablePermits();
            if (0 == permitsCount) {
                control.controlLock.unlock();
                try {
                    sleep(100); //позволяем противоположному направлению завладеть потоком
                } catch (InterruptedException ex) {
                    LOCAL_LOGGER.error("Expectation of the opposite flow in " + tunnelPhaser.getTunnel() + "was interrupted.");
                }
                control.controlLock.lock();
            }
            semaphore.release(Tunnel.MAX_IN_SAME_DIRECTION - permitsCount);
    
        } finally {
            control.controlLock.unlock();
        }
    }
    
    public static void enterTheTunnel(Train train, Tunnel tunnel) {
        
        try {
            tunnel.control.trainsInTunnel.put(train);
        } catch (InterruptedException ex) {
            LOCAL_LOGGER.error("Enter the " + train + " in the " + tunnel + " was interrupted");
        }
        
    }
    
    public static void exitTunnel(Train train, Tunnel tunnel) {
        tunnel.control.trainsInTunnel.remove(train);    
        tunnel.control.tunnelPhaser.getPhaser().arrive();
    }

    

    
    
    
    
    
    
    
    
}
