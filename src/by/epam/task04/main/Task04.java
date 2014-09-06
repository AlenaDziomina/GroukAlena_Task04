/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.main;

import static by.epam.task04.main.HelperTrainTunnelCreator.trainsCreator;
import static by.epam.task04.main.HelperTrainTunnelCreator.tunnelCreator;
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
                
        tunnelCreator();
        
        trainsCreator();
        
    }
    
}
