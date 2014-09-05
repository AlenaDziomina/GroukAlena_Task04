/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

import java.util.Objects;
import java.util.concurrent.Semaphore;

/**
 *
 * @author grouk.alena
 */
public class TunnelSemaphore extends Semaphore {
    
    private TrainDirection direct;

    public TunnelSemaphore(int permits, TrainDirection direct) {
        super(permits);
        this.direct = direct;
    }
    
    public TunnelSemaphore(int permits, boolean fair, TrainDirection direct) {
        super(permits, fair);
        this.direct = direct;
    }
    
    public TrainDirection getDirect(){
        return this.direct;
    }
    
    public void setDirect(TrainDirection direct){
        this.direct = direct;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(getClass().getSimpleName());
        str.append('@');
        str.append("direct: ");
        str.append(direct);
        return str.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        TunnelSemaphore semaphore = (TunnelSemaphore)obj;
        if (!super.equals(semaphore)){
            return false;
        }
        
        if(direct != semaphore.direct) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.direct);
        return hash;
    }
 
}
