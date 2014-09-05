/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;


import by.epam.task04.entity.Train;
import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import by.epam.task04.entity.TunnelPool;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helena.Grouk
 */
public class TrainAdjustment {
    
    public static final int TUNNEL_COUNT = 2;
    private static final TunnelPool TUNNEL_POOL = new TunnelPool(TUNNEL_COUNT);
    
    public static Tunnel getTunnel(TrainDirection direct) {
        return TUNNEL_POOL.getTunnel(direct);
    }
    
    public static void enterTheTunnel(Train train, Tunnel tunnel) {
        
        try {
            tunnel.trainsInTunnel.put(train);
        } catch (InterruptedException ex) {
            Logger.getLogger(TrainAdjustment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void exitTunnel(Train train, Tunnel tunnel) {
        tunnel.trainsInTunnel.remove(train);
        
        //int n1 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
                        
        tunnel.currentPhaser.getPhaser().arrive();

//        int n2 = tunnel.currentPhaser.getPhaser().getRegisteredParties();
//
//        System.out.println(tunnel.toString() + " dereg : " + n1 + " - " + n2);
        
        
    }

    

    
    
    
    
    
    
    
    
}
