/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;

import by.epam.task04.entity.TrainDirection;
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
public class TunnelSemaphoreTest {
    
    public TunnelSemaphoreTest() {
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
     * Test of getDirect method, of class TunnelSemaphore.
     */
    @Test
    public void testGetDirect() {
        System.out.println("getDirect");
        TunnelSemaphore instance = null;
        TrainDirection expResult = null;
        TrainDirection result = instance.getDirect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirect method, of class TunnelSemaphore.
     */
    @Test
    public void testSetDirect() {
        System.out.println("setDirect");
        TrainDirection direct = null;
        TunnelSemaphore instance = null;
        instance.setDirect(direct);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TunnelSemaphore.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TunnelSemaphore instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TunnelSemaphore.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        TunnelSemaphore instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TunnelSemaphore.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TunnelSemaphore instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
