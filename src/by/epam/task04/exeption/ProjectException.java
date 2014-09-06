/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.exeption;

import static by.epam.task04.main.Task04.LOCAL_LOGGER;

/**
 *
 * @author Helena.Grouk
 */
public class ProjectException extends Exception{
    
    public ProjectException(){}

    public ProjectException(String msg) {
        super(msg);
        LOCAL_LOGGER.error("ProjectException: " + msg);
        LOCAL_LOGGER.info(this.getStackTrace());
    }
   
}
