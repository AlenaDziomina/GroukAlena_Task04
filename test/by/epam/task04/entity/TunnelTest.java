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
public class TunnelTest {
    
    public TunnelTest() {
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
     * Test of getId method, of class Tunnel.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tunnel instance = new Tunnel();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Tunnel.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Tunnel instance = new Tunnel();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint1 method, of class Tunnel.
     */
    @Test
    public void testGetPoint1() {
        System.out.println("getPoint1");
        Tunnel instance = new Tunnel();
        TrainDirection expResult = null;
        TrainDirection result = instance.getPoint1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint2 method, of class Tunnel.
     */
    @Test
    public void testGetPoint2() {
        System.out.println("getPoint2");
        Tunnel instance = new Tunnel();
        TrainDirection expResult = null;
        TrainDirection result = instance.getPoint2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Tunnel.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Tunnel instance = new Tunnel();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Tunnel.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Tunnel instance = new Tunnel();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Tunnel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tunnel instance = new Tunnel();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
