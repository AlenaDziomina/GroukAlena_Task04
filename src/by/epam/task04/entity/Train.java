package by.epam.task04.entity;

import by.epam.task04.logic.TrainAdjustment;
import java.util.Objects;
import static task04.Task04.LOCAL_LOGGER;


/**
 *
 * @author Helena.Grouk
 */
public class Train implements Runnable, FollowTheTunnel{
    
    public static final int FOLLOW_THE_TUNNEL_TIME = 10000;
    private int id;
    private TrainDirection direct;
    
    public Train(){}
    public Train(int id, TrainDirection direct){
        this.id = id;
        this.direct = direct;
    }
    
    public int getId(){
        return this.id;
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
        str.append("id: ");
        str.append(id);  
        str.append(" direct: ");
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
        
        Train train = (Train)obj;
        if (!super.equals(train)){
            return false;
        }
        
        if(id != train.id) {
            return false;
        }
        
        if(direct != train.direct) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.direct);
        return hash;
    }

    @Override
    public void run() {
        
        LOCAL_LOGGER.info(this.toString() + " is running.");
        
        Tunnel tunnel = TrainAdjustment.getTunnel(this.direct);
        
        LOCAL_LOGGER.info(this.toString() + " obtain permission to pass in the " + tunnel.toString());
        
        moveThrowTunnel(tunnel);
        
        LOCAL_LOGGER.info(this.toString() + " movement finished.");
        
    }

    @Override
    public void moveThrowTunnel(Tunnel tunnel) {
        
        TrainAdjustment.enterTheTunnel(this, tunnel);
        LOCAL_LOGGER.info(this.toString() + " enter the " + tunnel.toString());
        
        try {
            Thread.sleep(Train.FOLLOW_THE_TUNNEL_TIME);
        } catch (InterruptedException ex) {
            LOCAL_LOGGER.error("Movement of the " + this.toString() + " in the "
                    + tunnel.toString() + " is interrupted");
        }
        
        TrainAdjustment.exitTunnel(this, tunnel);
        LOCAL_LOGGER.info(this.toString() + " exit the " + tunnel.toString());
    }
    
    
}
