/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task04;

import by.epam.task04.entity.Train;
import by.epam.task04.entity.Train.Direct;

/**
 *
 * @author Helena.Grouk
 */
public class Task04 {

   
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        int N = 30;
        ThreadGroup trains = new ThreadGroup("Группа поездов");
        
        while (i < N) {
            
            new Thread(trains, new Train(i, Direct.LEFT)).start();
            i++;
            new Thread(trains, new Train(i, Direct.RIGTH)).start();
            i++;
        }
        

    }
    
}
