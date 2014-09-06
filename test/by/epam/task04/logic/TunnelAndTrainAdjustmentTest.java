/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task04.logic;

import by.epam.task04.entity.Train;
import by.epam.task04.entity.TrainDirection;
import by.epam.task04.entity.Tunnel;
import java.util.HashMap;
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
public class TunnelAndTrainAdjustmentTest {
    
    public TunnelAndTrainAdjustmentTest() {
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
     * Test of addTunnel method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testAddTunnel() throws Exception {
        System.out.println("addTunnel");
        Tunnel tunnel = null;
        TunnelAndTrainAdjustment.addTunnel(tunnel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAllTunnels method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testAddAllTunnels() {
        System.out.println("addAllTunnels");
        HashMap<Integer, Tunnel> tunnels = null;
        TunnelAndTrainAdjustment.addAllTunnels(tunnels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTunnel method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testGetTunnel() {
        System.out.println("getTunnel");
        TrainDirection from = null;
        TrainDirection to = null;
        Tunnel expResult = null;
        Tunnel result = TunnelAndTrainAdjustment.getTunnel(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminateTunnelPhaser method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testTerminateTunnelPhaser() {
        System.out.println("terminateTunnelPhaser");
        Tunnel tunnel = null;
        TunnelAndTrainAdjustment.terminateTunnelPhaser(tunnel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterTheTunnel method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testEnterTheTunnel() {
        System.out.println("enterTheTunnel");
        Train train = null;
        Tunnel tunnel = null;
        TunnelAndTrainAdjustment.enterTheTunnel(train, tunnel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitTunnel method, of class TunnelAndTrainAdjustment.
     */
    @Test
    public void testExitTunnel() {
        System.out.println("exitTunnel");
        Train train = null;
        Tunnel tunnel = null;
        TunnelAndTrainAdjustment.exitTunnel(train, tunnel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
