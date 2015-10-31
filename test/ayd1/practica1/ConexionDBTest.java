/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayd1.practica1;

import javax.sql.rowset.CachedRowSet;
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
public class ConexionDBTest {
    
    public ConexionDBTest() {
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
     * Test of Function method, of class ConexionDB.
     */
    @Test
    public void testFunction() {
        System.out.println("Function");
        String sql = "";
        ConexionDB instance = new ConexionDB();
       Object resultado = null;
        Object esperado = instance.Function(sql);
        assertEquals(resultado, esperado);
        
    }

   
}
