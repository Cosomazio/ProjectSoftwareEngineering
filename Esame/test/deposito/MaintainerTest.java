/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franc
 */
public class MaintainerTest {
    
    public MaintainerTest() {
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
     * Test of getSkill method, of class Maintainer.
     */
    @Test
    public void testGetSkill() {
        System.out.println("getSkill");
        Maintainer instance = null;
        Set<String> expResult = null;
        Set<String> result = instance.getSkill();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSkill method, of class Maintainer.
     */
    @Test
    public void testSetSkill() {
        System.out.println("setSkill");
        Set<String> skill = null;
        Maintainer instance = null;
        instance.setSkill(skill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcedure method, of class Maintainer.
     */
    @Test
    public void testGetProcedure() {
        System.out.println("getProcedure");
        Maintainer instance = null;
        Set<Procedure> expResult = null;
        Set<Procedure> result = instance.getProcedure();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcedure method, of class Maintainer.
     */
    @Test
    public void testSetProcedure() {
        System.out.println("setProcedure");
        Set<Procedure> procedure = null;
        Maintainer instance = null;
        instance.setProcedure(procedure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Maintainer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Maintainer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
