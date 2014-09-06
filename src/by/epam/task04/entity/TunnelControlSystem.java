/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

import static by.epam.task04.entity.Tunnel.MAX_IN_SAME_DIRECTION;
import static by.epam.task04.entity.Tunnel.MAX_TRAIN_COUNT;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author grouk.alena
 */
public class TunnelControlSystem {
    
    public TunnelSemaphore sem1;
    public TunnelSemaphore sem2;
    
    public TunnelPhaser tunnelPhaser;
    public final Lock controlLock = new ReentrantLock();
    
    public BlockingQueue<Train> trainsInTunnel = new ArrayBlockingQueue(MAX_TRAIN_COUNT);
    
    public TunnelControlSystem(){}
    public TunnelControlSystem(TrainDirection direct1, TrainDirection direct2){
        sem1 = new TunnelSemaphore(MAX_IN_SAME_DIRECTION, true, direct1);
        sem2 = new TunnelSemaphore(MAX_IN_SAME_DIRECTION, true, direct2);
    }

    public TunnelSemaphore getSemaphore(TrainDirection direct) {
        if (sem1.getDirect() == direct) {
            return sem1;
        } else {
            if (sem2.getDirect() == direct) {
                return sem2;
            }
        }
        
        return null;
    }
    
}
