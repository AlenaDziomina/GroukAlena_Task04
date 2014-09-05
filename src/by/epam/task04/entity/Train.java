package by.epam.task04.entity;

import by.epam.task04.logic.TrainAdjustment;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helena.Grouk
 */
public class Train implements Runnable {
    
    public enum Direct {
        LEFT(1), RIGTH(2);
        private final int directNo;
        private Direct(int no) {
            directNo = no;
        }
        public int getDirectNo(){
            return directNo;
        }
    };
 
    public static final int FOLLOW_THE_TUNNEL_TIME = 10000;
    private int id;
    private Direct direct;
    
    
   
    public Train(){}
    public Train(int id, Direct direct){
        this.id = id;
        this.direct = direct;
    }
    public int getId(){
        return this.id;
    }
    public Direct getDirect(){
        return this.direct;
    }
    
    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + this.id + this.direct);
    }
    
    public void followThe_Tunnel(Tunnel tunnel){ 
        System.out.println(this.toString() + " follow the tunnel " + tunnel.toString());
        try {
            Thread.sleep(Train.FOLLOW_THE_TUNNEL_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        System.out.println(this.toString() + " ranning.");
        
        Tunnel tunnel = TrainAdjustment.getTunnel(this.direct);
        System.out.println(this.toString() + " get " + tunnel.toString());
        
        TrainAdjustment.enterTheTunnel(this, tunnel);
        System.out.println(this.toString() + " enter " + tunnel.toString());
        
        
        try {
            Thread.sleep(Train.FOLLOW_THE_TUNNEL_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TrainAdjustment.exitTunnel(this, tunnel);
        System.out.println(this.toString() + " exit " + tunnel.toString());
        
    }
    
    
}
