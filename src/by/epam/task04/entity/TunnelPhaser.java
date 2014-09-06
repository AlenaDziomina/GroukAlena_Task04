/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;


import by.epam.task04.logic.TunnelAndTrainAdjustment;
import java.util.concurrent.Phaser;

/**
 *
 * @author Helena.Grouk
 */
public class TunnelPhaser implements Runnable{
    private Phaser phaser;
    private Tunnel tunnel;
    private TrainDirection direct;
    
    public TunnelPhaser(){}
    public TunnelPhaser(Phaser phaser, Tunnel tunnel, TrainDirection direct) {
        this.phaser = phaser;
        this.tunnel = tunnel;
        this.direct = direct;
    }
    
    public TrainDirection getDirect() {
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
        TunnelAndTrainAdjustment.terminateTunnelPhaser(tunnel);
    }
}
