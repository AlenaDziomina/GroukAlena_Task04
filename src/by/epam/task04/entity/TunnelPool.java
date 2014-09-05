/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

import by.epam.task04.entity.Train.Direct;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;

/**
 *
 * @author Helena.Grouk
 */
public class TunnelPool {
    
    private final int count;    
    private final ArrayBlockingQueue<Tunnel> tunnels;
    
    public TunnelPool(int count) {
        
        this.count = count;
        this.tunnels = new ArrayBlockingQueue(this.count);
        
        for (int i = 0; i < count; i ++) {
            tunnels.add(new Tunnel(i));
        }
    }
    
    public Tunnel getTunnel(Train.Direct direct) {
        switch (direct) {
            case LEFT: return getLeftTunnel(direct);
            case RIGTH: return getRigthTunnel(direct);
            default: return null;
        }
    }
    
    private Tunnel getLeftTunnel(Train.Direct direct){
        
        while (true) {
            for (Iterator<Tunnel> it = tunnels.iterator(); it.hasNext();) {
                Tunnel tunnel = it.next();
                if (tunnel.left.tryAcquire())
                {
                    try {
                        tunnel.lock.lock();
                        
                        if (null == tunnel.currentPhaser) {
                            Phaser phaser;
                            phaser = new Phaser(1) {
                                @Override
                                protected boolean onAdvance(int phase, int registeredParties) {
                                    return this.getUnarrivedParties() == 0;
                                }
                            };
                            
                            TunnelPhaser tp = new TunnelPhaser(phaser, tunnel, direct);
                            tunnel.currentPhaser = tp;

//                            int n1 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
                            tunnel.currentPhaser.getPhaser().register();
//                            int n2 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
//                            System.out.println(tunnel.toString() + ": " + n1 + " - " + n2);

                            new Thread(tp).start();
                            return tunnel;
                        } else {
                            if (Direct.LEFT == tunnel.currentPhaser.getDirect()) {

                                //int n1 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
                                if (tunnel.currentPhaser.getPhaser().register() < 0) {
                                    System.out.println("OLREADY TERMINATED");
                                } else {
//                                int n2 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
//                                System.out.println(tunnel.toString() + ": " + n1 + " - " + n2);

                                return tunnel;
                                }
                            } else {
                                
                                tunnel.left.release();
                            }
                        }
                    } finally {
                        tunnel.lock.unlock();
                    }
                }
            }
        }
        
    }
    
    private Tunnel getRigthTunnel(Train.Direct direct){
        
        while (true) {
            for (Iterator<Tunnel> it = tunnels.iterator(); it.hasNext();) {
                Tunnel tunnel = it.next();
                if (tunnel.rigth.tryAcquire())
                
                    try {
                        tunnel.lock.lock();
                        if (null == tunnel.currentPhaser) {
                            Phaser phaser = new Phaser(1);
                            TunnelPhaser tp = new TunnelPhaser(phaser, tunnel, direct);
                            tunnel.currentPhaser = tp;

                            //int n1 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
                            tunnel.currentPhaser.getPhaser().register();
//                            int n2 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
//                            System.out.println(tunnel.toString() + ": " + n1 + " - " + n2);

                            new Thread(tp).start();
                            return tunnel;
                        } else {
                            if (Direct.RIGTH == tunnel.currentPhaser.getDirect()) {

//                                int n1 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
                                tunnel.currentPhaser.getPhaser().register();
//                                int n2 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
//                                System.out.println(tunnel.toString() + ": " + n1 + " - " + n2);

                                return tunnel;
                            } else {
                                tunnel.rigth.release();
                            }
                        }
                    } finally {
                        tunnel.lock.unlock();
                    }
                }
            }
        }
        
    }
    

    

