/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Helena.Grouk
 */
public class Tunnel {
    
    //максимальное кол-во одновременно следующих по тоннелю поездов
    public static final int MAX_TRAIN_COUNT = 3; 
    /* 
     * максимальное кол-во поездов в одном направлении следующих по тоннелю 
     * при наличии поездов в обратном направлении
    */
    public static final int MAX_IN_SAME_DIRECTION = 5; 

    private int id;
    
    //public SemaphorePool semaphor;
    public Semaphore sem1 = new Semaphore(MAX_IN_SAME_DIRECTION, true);
    public Semaphore sem2 = new Semaphore(MAX_IN_SAME_DIRECTION, true);
    
    public BlockingQueue<Train> trainsInTunnel = new ArrayBlockingQueue(MAX_TRAIN_COUNT);
    public TunnelPhaser currentPhaser;
    
    public Lock lock = new ReentrantLock();
    
    
    
    

    public Tunnel(){}
    public Tunnel(int id) {
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    
    
    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + this.id);
    }
    
}
