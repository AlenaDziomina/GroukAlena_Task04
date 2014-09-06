/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.entity;

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
public class TrainTest {
    
    public TrainTest() {
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
     * Test of getId method, of class Train.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Train instance = new Train();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrom method, of class Train.
     */
    @Test
    public void testGetFrom() {
        System.out.println("getFrom");
        Train instance = new Train();
        TrainDirection expResult = null;
        TrainDirection result = instance.getFrom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFrom method, of class Train.
     */
    @Test
    public void testSetFrom() {
        System.out.println("setFrom");
        TrainDirection from = null;
        Train instance = new Train();
        instance.setFrom(from);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTo method, of class Train.
     */
    @Test
    public void testGetTo() {
        System.out.println("getTo");
        Train instance = new Train();
        TrainDirection expResult = null;
        TrainDirection result = instance.getTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTo method, of class Train.
     */
    @Test
    public void testSetTo() {
        System.out.println("setTo");
        TrainDirection to = null;
        Train instance = new Train();
        instance.setTo(to);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Train.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Train instance = new Train();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Train.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Train instance = new Train();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Train.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Train instance = new Train();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class Train.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Train instance = new Train();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveThrowTunnel method, of class Train.
     */
    @Test
    public void testMoveThrowTunnel() {
        System.out.println("moveThrowTunnel");
        Tunnel tunnel = null;
        Train instance = new Train();
        instance.moveThrowTunnel(tunnel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
