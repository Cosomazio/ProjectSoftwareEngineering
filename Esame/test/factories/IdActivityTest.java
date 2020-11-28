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
public class IdActivityTest {
    
    public IdActivityTest() {
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
     * Test of getIstance method, of class IdActivity.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
        IdActivity expResult = IdActivity.getIstance();
        IdActivity result = IdActivity.getIstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getId method, of class IdActivity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = IdActivity.getId();
        int result = IdActivity.getId();
        assertEquals(expResult+1, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
