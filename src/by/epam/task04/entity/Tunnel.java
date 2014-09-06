package by.epam.task04.entity;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helena.Grouk
 */
public class Tunnel {
    /* 
     * максимальное кол-во поездов в одном направлении следующих по тоннелю 
     * при наличии поездов в обратном направлении
    */
    public static final int MAX_IN_SAME_DIRECTION = 5;
    //максимальное кол-во одновременно следующих по тоннелю поездов
    public static final int MAX_TRAIN_COUNT = 3; 
     
    private int id;
    public TunnelControlSystem control;

    public Tunnel(){}
    public Tunnel(int id, TrainDirection direct1, TrainDirection direct2) {
        this.id = id;
        control = new TunnelControlSystem(direct1, direct2);
    }
    public int getId(){
        return this.id;
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
        
        Tunnel tunnel = (Tunnel)obj;
        if (!super.equals(tunnel)){
            return false;
        }
        
        if(id != tunnel.id) {
            return false;
        }
        
        if(! control.equals(tunnel.control)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.control);
        return hash;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(getClass().getSimpleName());
        str.append('@');
        str.append("id: ");
        str.append(id);  
        str.append(" control: ");
        str.append(control);
        return str.toString();
    }
    
}
