/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;

import by.epam.task04.entity.TrainDirection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author grouk.alena
 */
public class TunnelControlSystemTest {
    
    public TunnelControlSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSemaphore method, of class TunnelControlSystem.
     */
    @Test
    public void testGetSemaphore() {
        System.out.println("getSemaphore");
        
        TrainDirection direct1 = null;
        TrainDirection direct2 = TrainDirection.BARDONECCHIA;
        TrainDirection direct3 = TrainDirection.BRIG;
        TrainDirection direct4 = TrainDirection.DOMODOSSOLA;
        
        TunnelControlSystem instance = new TunnelControlSystem(TrainDirection.BARDONECCHIA, TrainDirection.BRIG);
        
        TunnelSemaphore expResult1 = null;
        TunnelSemaphore expResult2 = instance.sem1;
        TunnelSemaphore expResult3 = instance.sem2;
        TunnelSemaphore expResult4 = null;
        
        TunnelSemaphore result1 = instance.getSemaphore(direct1);
        assertEquals(expResult1, result1);
        
        TunnelSemaphore result2 = instance.getSemaphore(direct2);
        assertEquals(expResult2, result2);
        
        TunnelSemaphore result3 = instance.getSemaphore(direct3);
        assertEquals(expResult3, result3);
        
        TunnelSemaphore result4 = instance.getSemaphore(direct4);
        assertEquals(expResult4, result4);
        
    }
    
}
