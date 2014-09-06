package by.epam.task04.entity;

import by.epam.task04.implement.FollowTheTunnel;
import by.epam.task04.logic.TunnelAndTrainAdjustment;
import java.util.Objects;
import static by.epam.task04.main.Task04.LOCAL_LOGGER;


/**
 *
 * @author Helena.Grouk
 */
public class Train implements Runnable, FollowTheTunnel{
    
    public static final int FOLLOW_THE_TUNNEL_TIME = 10000;
    private int id;
    private String name;
    private TrainDirection from;
    private TrainDirection to;
    
    public Train(){}
    public Train(int id, String name, TrainDirection from, TrainDirection to){
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
    }
    
    public int getId(){
        return this.id;
    }
    
    public TrainDirection getFrom(){
        return this.from;
    }
    
    public void setFrom(TrainDirection from){
        this.from = from;
    }
    
    public TrainDirection getTo(){
        return this.to;
    }
    
    public void setTo(TrainDirection to){
        this.to = to;
    }
    
    @Override
    public String toString(){
//        StringBuilder str = new StringBuilder(getClass().getSimpleName());
//        str.append('@');
//        str.append("id:");
//        str.append(id);  
//        str.append(" from:");
//        str.append(from);
//        str.append(" to:");
//        str.append(to);
//        return str.toString();
        
        return "Train_"+id;
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
        
        if(from != train.from) {
            return false;
        }
        
        if(to != train.to) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.from);
        hash = 97 * hash + Objects.hashCode(this.to);
        return hash;
    }

    

    @Override
    public void run() {
        
        LOCAL_LOGGER.info(this + " is running.");
        
        Tunnel tunnel = TunnelAndTrainAdjustment.getTunnel(this.from, this.to);
        
        LOCAL_LOGGER.info(this + " obtain permission to pass in the " + tunnel);
        
        moveThrowTunnel(tunnel);
        
        LOCAL_LOGGER.info(this + " movement finished.");
        
    }

    @Override
    public void moveThrowTunnel(Tunnel tunnel) {
        
        TunnelAndTrainAdjustment.enterTheTunnel(this, tunnel);
        
        
        try {
            Thread.sleep(Train.FOLLOW_THE_TUNNEL_TIME);
        } catch (InterruptedException ex) {
            LOCAL_LOGGER.error("Movement of the " + this + " in the "
                    + tunnel + " is interrupted");
        }
        
        TunnelAndTrainAdjustment.exitTunnel(this, tunnel);
        
    }
    
    
}
