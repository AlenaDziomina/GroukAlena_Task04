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
import by.epam.task04.exeption.EntityInitException;
import static by.epam.task04.main.Task04.LOCAL_LOGGER;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Phaser;

/**
 *
 * @author Helena.Grouk
 */
public class TunnelAndTrainAdjustment {
    
    public static final int TUNNEL_COUNT = 2;
    private static ConcurrentHashMap<Integer, Tunnel> tunnels = new ConcurrentHashMap();
    
    private TunnelAndTrainAdjustment(){}
    
    public static void addTunnel(Tunnel tunnel) throws EntityInitException {
        if (null == tunnel) {
            throw new EntityInitException("Can't add tunnel = null.");
        }
        tunnels.put(tunnel.getId(), tunnel);
    }
    
    public static void addAllTunnels(HashMap<Integer, Tunnel> tunnels) {
        TunnelAndTrainAdjustment.tunnels.putAll(tunnels);
        System.out.println("!!!!!!!!!!!" + tunnels);
    }
    
    public static Tunnel getTunnel(TrainDirection from, TrainDirection to) {
        TrainDirection direct = to;
        
        while (true) {
            for (Map.Entry<Integer, Tunnel> ent : tunnels.entrySet()) {
                Tunnel tunnel = ent.getValue();
                TunnelSemaphore semaphore = tunnel.control.getSemaphore(direct);
                if (null != semaphore) {
                    try {
                        tunnel.control.controlLock.lock();
                        if (semaphore.tryAcquire()) {
                            TunnelPhaser tp = tunnel.control.tunnelPhaser;
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
                        }
                    } finally {
                        tunnel.control.controlLock.unlock();
                    }
                }
            }
        }
    }
    
    private static boolean isSameDirection(TrainDirection from, TrainDirection to, Tunnel tunnel) {
        if (tunnel.getPoint1() == from && tunnel.getPoint2() == to) {
            return true;
        }
        if (tunnel.getPoint1() == to && tunnel.getPoint2() == from) {
            return true;
        }
        return false;
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
    
    public static void terminateTunnelPhaser(Tunnel tunnel){
        
        TunnelControlSystem control = tunnel.control;
        
        try { 
            control.controlLock.lock();
            LOCAL_LOGGER.info("Phase mooving to the " + control.tunnelPhaser.getDirect() + " in " + control.tunnelPhaser.getTunnel() + " complite.");
            
            
            TunnelSemaphore semaphore = control.getSemaphore(control.tunnelPhaser.getDirect());
            int permitsCount = semaphore.availablePermits();
            control.tunnelPhaser = null;
            
            if (0 == permitsCount) {
                control.controlLock.unlock();
                try {
                    sleep(100); //позволяем противоположному направлению завладеть потоком
                } catch (InterruptedException ex) {
                    LOCAL_LOGGER.error("Expectation of the opposite flow in " + control.tunnelPhaser.getTunnel() + "was interrupted.");
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
            LOCAL_LOGGER.info(train + " enter the " + tunnel);
        } catch (InterruptedException ex) {
            LOCAL_LOGGER.error("Enter the " + train + " in the " + tunnel + " was interrupted");
        }
        
    }
    
    public static void exitTunnel(Train train, Tunnel tunnel) {
        try { 
            tunnel.control.controlLock.lock();
            tunnel.control.trainsInTunnel.remove(train);    
            tunnel.control.tunnelPhaser.getPhaser().arrive();
            LOCAL_LOGGER.info(train + " exit the " + tunnel);
        } catch (NullPointerException ex) {
            LOCAL_LOGGER.info(ex);
            LOCAL_LOGGER.info("ERROR TRAIN: " + train);
            LOCAL_LOGGER.info(("ERROR TUNNEL: " + tunnel));
        } finally {
            tunnel.control.controlLock.unlock();
        }
    }

    

    
    
    
    
    
    
    
    
}
