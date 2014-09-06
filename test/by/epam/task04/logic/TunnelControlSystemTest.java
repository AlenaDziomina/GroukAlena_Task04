/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;

import by.epam.task04.entity.TrainDirection;
import by.epam.task04.logic.TunnelControlSystem;
import by.epam.task04.logic.TunnelSemaphore;
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
        TrainDirection direct = null;
        TunnelControlSystem instance = new TunnelControlSystem();
        TunnelSemaphore expResult = null;
        TunnelSemaphore result = instance.getSemaphore(direct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
