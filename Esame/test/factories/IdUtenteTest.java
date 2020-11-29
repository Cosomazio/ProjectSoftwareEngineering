/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomma
 */
public class IdUtenteTest {
    
    public IdUtenteTest() {
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
     * Test of getInstance method, of class IdUtente.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        IdUtente expResult = IdUtente.getInstance();
        IdUtente result = IdUtente.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNextId method, of class IdUtente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        IdUtente instance = IdUtente.getInstance();
        int expResult = instance.getId();
        int result = instance.getId();
        assertEquals(expResult+1, result);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
