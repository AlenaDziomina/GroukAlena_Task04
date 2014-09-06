/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.exeption;

/**
 *
 * @author Helena.Grouk
 */
public class LogicException extends ProjectException {
    
    Exception ex;
    
    public LogicException(){}
    
    public LogicException(String msg) {
        super(msg);
        //localLog.error("LogicException " + msg);
        //localLog.info(this.getStackTrace());
    }
    
    public LogicException(String msg, Exception ex) {
        
        super(msg);
        this.ex = ex;
        //localLog.error("LogicException " + msg);
        //localLog.info(this.getStackTrace());
        //localLog.info(ex.getMessage(), ex);
    }
    
    
}
