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
public class RegistrarTest {
    
    public RegistrarTest() {
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
     * Test of consultarDPI method, of class Registrar.
     */
    @Test
    public void testConsultarDPI() {
        System.out.println("consultarDPI");
        Registrar instance = new Registrar();
        Boolean esperado = false;
        Boolean result = instance.consultarDPI();
        assertEquals(false, result);
   
    }

    /**
     * Test of main method, of class Registrar.
     */
    
    
}
