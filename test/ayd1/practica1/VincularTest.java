/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayd1.practica1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerssonmarcovinicio
 */
public class VincularTest {
    
    public VincularTest() {
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
     * Test of cargarSociosPrincipales method, of class Vincular.
     */
    @Test
    public void testCargarSociosPrincipales() {
        System.out.println("cargarSociosPrincipales");
        Vincular instance = new Vincular();
        instance.cargarSociosPrincipales();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarSociosSecundarios method, of class Vincular.
     */
    @Test
    public void testCargarSociosSecundarios() {
        System.out.println("cargarSociosSecundarios");
        Vincular instance = new Vincular();
        instance.cargarSociosSecundarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vincular method, of class Vincular.
     */
    @Test
    public void testVincular() {
        System.out.println("vincular");
        Vincular instance = new Vincular();
        instance.vincular();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Vincular.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Vincular.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
