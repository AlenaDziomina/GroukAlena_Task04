/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;

import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import by.epam.task04.logic.TunnelPhaser;
import java.util.concurrent.Phaser;
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
public class TunnelPhaserTest {
    
    public TunnelPhaserTest() {
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
     * Test of getDirect method, of class TunnelPhaser.
     */
    @Test
    public void testGetDirect() {
        System.out.println("getDirect");
        TunnelPhaser instance = new TunnelPhaser();
        TrainDirection expResult = null;
        TrainDirection result = instance.getDirect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTunnel method, of class TunnelPhaser.
     */
    @Test
    public void testGetTunnel() {
        System.out.println("getTunnel");
        TunnelPhaser instance = new TunnelPhaser();
        Tunnel expResult = null;
        Tunnel result = instance.getTunnel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhaser method, of class TunnelPhaser.
     */
    @Test
    public void testGetPhaser() {
        System.out.println("getPhaser");
        TunnelPhaser instance = new TunnelPhaser();
        Phaser expResult = null;
        Phaser result = instance.getPhaser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class TunnelPhaser.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TunnelPhaser instance = new TunnelPhaser();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
