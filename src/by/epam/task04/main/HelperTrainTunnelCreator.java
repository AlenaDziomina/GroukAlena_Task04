/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.main;

import by.epam.task04.entity.Train;
import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import by.epam.task04.exeption.EntityInitException;
import by.epam.task04.logic.TunnelAndTrainAdjustment;
import static by.epam.task04.main.Task04.LOCAL_LOGGER;
import java.util.HashMap;

/**
 *
 * @author grouk.alena
 */
public class HelperTrainTunnelCreator {
    
    private HelperTrainTunnelCreator(){}
    
    public static void trainsCreator(){
        
        int i = 0;
        int N = 30;
        ThreadGroup trains = new ThreadGroup("Orient-Express");

        while (i < N) {

            Train train1 = new Train(i, "Paris-Istanbul", TrainDirection.BRIG, TrainDirection.DOMODOSSOLA);
            new Thread(trains, train1).start();
            i++;

            Train train2 = new Train(i, "Istanbul-Paris", TrainDirection.DOMODOSSOLA, TrainDirection.BRIG);
            new Thread(trains, train2).start();
            i++;
        }
    
    }
    
    public static void tunnelCreator() {
        
        HashMap<Integer, Tunnel> tunnels = new HashMap<>();
        tunnels.put(1, new Tunnel(1, "Simplon_1", TrainDirection.BRIG, TrainDirection.DOMODOSSOLA));
        tunnels.put(2, new Tunnel(2, "Simplon_2", TrainDirection.BRIG, TrainDirection.DOMODOSSOLA));
        
        TunnelAndTrainAdjustment.addAllTunnels(tunnels);
                
        try {
            TunnelAndTrainAdjustment.addTunnel(new Tunnel(3, "Mont Cenis", TrainDirection.BARDONECCHIA, TrainDirection.MODANE));
        } catch (EntityInitException ex) {
            LOCAL_LOGGER.info("Tunnels creating failed.");
        }
        
    }
    
}
