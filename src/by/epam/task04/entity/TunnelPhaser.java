/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

import by.epam.task04.entity.Train.Direct;
import static java.lang.Thread.sleep;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helena.Grouk
 */
public class TunnelPhaser implements Runnable{
    private Phaser phaser;
    private Tunnel tunnel;
    private Direct direct;
    
    public TunnelPhaser(){}
    public TunnelPhaser(Phaser phaser, Tunnel tunnel, Direct direct) {
        this.phaser = phaser;
        this.tunnel = tunnel;
        this.direct = direct;
    }
    
    public Direct getDirect() {
        return direct;
    }
    
    public Tunnel getTunnel(){
        return tunnel;
    }
    
    public Phaser getPhaser() {
        return phaser;
    }

    @Override
    public void run() {
        
        phaser.arriveAndAwaitAdvance();
        
        //int n2 = tunnel.currentPhaser.getPhaser().getArrivedParties();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! PHASER = " + phaser.isTerminated() + phaser.register());
        try { tunnel.lock.lock();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! PHASER = " + phaser.getArrivedParties());
//        phaser.bulkRegister(1); //TO DO
//        phaser.arriveAndAwaitAdvance();
//        if (phaser.getUnarrivedParties() > 0) {
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! ONE MORE = " + phaser.getArrivedParties());
//            TunnelPhaser tp = new TunnelPhaser(phaser, tunnel, direct);
//            //tunnel.currentPhaser.getPhaser().bulkRegister(1);
//            new Thread(tp).start();
//        } else {
        phaser.forceTermination();
        tunnel.currentPhaser = null;
        
        if (Direct.LEFT == direct) {
            
            int n = tunnel.left.availablePermits();
            if (0 == n) {
                tunnel.lock.unlock();
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TunnelPhaser.class.getName()).log(Level.SEVERE, null, ex);
                }
                tunnel.lock.lock();
            }
            tunnel.left.release(Tunnel.MAX_IN_SAME_DIRECTION - n);
            
        }
        
        if (Direct.RIGTH == direct) {
            
            int n = tunnel.rigth.availablePermits();
            if (0 == n) {
                tunnel.lock.unlock();
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TunnelPhaser.class.getName()).log(Level.SEVERE, null, ex);
                }
                tunnel.lock.lock();
            }
            tunnel.rigth.release(Tunnel.MAX_IN_SAME_DIRECTION - n);
            
        
        }
        } finally {
            tunnel.lock.unlock();
        }
        
    }
    
    
}
