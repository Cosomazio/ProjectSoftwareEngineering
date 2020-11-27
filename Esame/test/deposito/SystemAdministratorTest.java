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
 * @author Luigi
 */
public class SystemAdministratorTest {
    
    public SystemAdministratorTest() {
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
     * Test of createMaintainer method, of class SystemAdministrator.
     */
    @Test
    public void testCreateMaintainer() {
        System.out.println("createMaintainer");
        String username = "";
        String password = "";
        String nome = "";
        String email = "";
        SystemAdministrator instance = null;
        Maintainer expResult = null;
        Maintainer result = instance.createMaintainer(username, password, nome, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaMaintainer method, of class SystemAdministrator.
     */
    @Test
    public void testModificaMaintainer() {
        System.out.println("modificaMaintainer");
        Maintainer man = null;
        String username = "";
        String password = "";
        String nome = "";
        String email = "";
        Set<String> skill = null;
        Set<Procedure> procedure = null;
        SystemAdministrator instance = null;
        Maintainer expResult = null;
        Maintainer result = instance.modificaMaintainer(man, username, password, nome, email, skill, procedure);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaMaintainer method, of class SystemAdministrator.
     */
    @Test
    public void testCancellaMaintainer() {
        System.out.println("cancellaMaintainer");
        Maintainer man = null;
        SystemAdministrator instance = null;
        instance.cancellaMaintainer(man);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPlanner method, of class SystemAdministrator.
     */
    //@Test
/*public void testCreatePlanner() {
        System.out.println("createPlanner");
        String username = "";
        String password = "";
        String nome = "";
        String email = "";
        SystemAdministrator instance = null;
        Planner expResult = null;
        Planner result = instance.createPlanner(username, password, nome, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of modificaPlanner method, of class SystemAdministrator.
     */
/*    @Test
    public void testModificaPlanner() {
        System.out.println("modificaPlanner");
        Planner pln = null;
        String username = "";
        String password = "";
        String nome = "";
        String email = "";
        SystemAdministrator instance = null;
        Planner expResult = null;
        Planner result = instance.modificaPlanner(pln, username, password, nome, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of cancellaPlanner method, of class SystemAdministrator.
     */
/*    @Test
    public void testCancellaPlanner() {
        System.out.println("cancellaPlanner");
        Planner pln = null;
        SystemAdministrator instance = null;
        instance.cancellaPlanner(pln);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/    
    /**
     * Test of toString method, of class SystemAdministrator.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SystemAdministrator instance = new SystemAdministrator("pippo", "xxxx", "cosimo", "coccocorb1@hot.com", 23);
        String username="pippo";
        String password="xxxx";
        String nome="cosimo";
        String email="coccocorb1@hot.com";
        int id=23;
                
        String expResult = "AbstractUtente{" + "username=" + username + ", password=" + password + ", nome=" + nome + ", email=" + email + ", id=" + id + '}' + "SystemAdministrator{" + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
