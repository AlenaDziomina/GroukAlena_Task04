/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task04;

import by.epam.task04.entity.Train;
import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import by.epam.task04.logic.TunnelAndTrainAdjustment;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author Helena.Grouk
 */
public class Task04 {

    private static final String LOG_PROPERTIES_FILE = "Log4J.properties";
    public static Logger LOCAL_LOGGER = Logger.getLogger("localLoger");
    static {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE); 
    }
    
   
    public static void main(String[] args) throws InterruptedException {
        
        ConcurrentHashMap<String, Tunnel> ttt = new ConcurrentHashMap();
        
        ttt.put("id"+1, new Tunnel(1, TrainDirection.LEFT, TrainDirection.RIGTH));
        ttt.put("id"+2, new Tunnel(2, TrainDirection.LEFT, TrainDirection.RIGTH));
        
        Set set = ttt.entrySet();
        
        ttt.entrySet().stream().forEach((t) -> {
            System.out.println("ĘRWÜ" + t);
        });
        
        TunnelAndTrainAdjustment.addTunnel(new Tunnel(1, TrainDirection.LEFT, TrainDirection.RIGTH));
        TunnelAndTrainAdjustment.addTunnel(new Tunnel(2, TrainDirection.LEFT, TrainDirection.RIGTH));
        
        int i = 0;
        int N = 30;
        ThreadGroup trains = new ThreadGroup("Группа поездов");
        
        while (i < N) {
            
            new Thread(trains, new Train(i, TrainDirection.LEFT)).start();
            i++;
            new Thread(trains, new Train(i, TrainDirection.RIGTH)).start();
            i++;
        }
        

    }
    
}
