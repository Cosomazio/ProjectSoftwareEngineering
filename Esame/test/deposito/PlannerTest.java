/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

//import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cosimocorbisiero
 */
public class PlannerTest {
    
    public PlannerTest() {
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
     * Test of assegnaMan method, of class Planner.
     */
    /*
    @Test
    public void testAssegnaMan() {
        System.out.println("assegnaMan");
        Maintainer man = null;
        InterfaceActivity act = null;
        Planner instance = null;
        instance.assegnaMan(man, act);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of planActivity method, of class Planner.
     */
    /*
    @Test
    public void testPlanActivity() {
        System.out.println("planActivity");
        InterfaceActivity act = null;
        Planner instance = null;
        instance.planActivity(act);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creaEwo method, of class Planner.
     */
    /*
    @Test
    public void testCreaEwo() {
        System.out.println("creaEwo");
        int id = 0;
        Sito sito = null;
        String descrizione = "";
        int tempo = 0;
        List<String> materiali = null;
        int week = 0;
        Boolean interrompibile = null;
        Procedure procedura = null;
        Planner instance = null;
        instance.creaEwo(id, sito, descrizione, tempo, materiali, week, interrompibile, procedura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of modificaEWO method, of class Planner.
     */
    /*
    @Test
    public void testModificaEWO() {
        System.out.println("modificaEWO");
        EwoActivity ewo = null;
        String descrizione = "";
        OffsetTime tempo = null;
        List<String> skills = null;
        List<String> materiali = null;
        Planner instance = null;
        instance.modificaEWO(ewo, descrizione, tempo, skills, materiali);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of gestisciMateriali method, of class Planner.
     */
  /*
    @Test
    public void testGestisciMateriali() {
        System.out.println("gestisciMateriali");
        InterfaceActivity act = null;
        List<String> materiali = null;
        Planner instance = null;
        instance.gestisciMateriali(act, materiali);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createActivity method, of class Planner.
     */
    
    
    Planner instance = new Planner("ProvaUser","xxxx","UtenteProva","prova@prova.it",1);
   /*
    @Test
    public void testCreateActivity() {
        System.out.println("createActivity");
        int id = 1;
        Sito sito = new Sito("ufficio","area");
        String tipologia = "elettrico";
        String descrizione = "prova di descizione";
        int tempo = 70;
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        int week = 2;
        Boolean interrompibile = true;
        Procedure procedura = new Procedure();
        
        instance.createActivity(id,sito,tipologia,descrizione,tempo,materiali,week,interrompibile,procedura,"Planned");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modifyActivity method, of class Planner.
     */
    /*
    @Test
    public void testModifyActivity() {
        
        System.out.println("modifyActivity");
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        AbstractActivity act = new PlannedActivity(1,sito1,"elettrico","prova di descrizione",70,materiali,2,true,procedura);
        Sito sito = new Sito("ufficio2","area");
        String tipologia = "Meccanico";
        String descrizione = "descrizione cambiata";
        int tempo = 90;
        materiali.add("Chiodi di garofano");
        int week = 52;
        Boolean interrompibile = false;
        
        
        instance.modifyActivity(act, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,"Ewo");
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteActivity method, of class Planner.
     */
    /*
    @Test
    public void testDeleteActivity() {
        System.out.println("deleteActivity");
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        AbstractActivity act = new PlannedActivity(1,sito1,"elettrico","prova di descrizione",70,materiali,2,true,procedura);
        //Planner instance = null;
        instance.deleteActivity(act);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of viewActivities method, of class Planner.
     */
    /*
    @Test
    public void testViewActivities() {
        System.out.println("viewActivities");
        Planner instance = null;
        instance.viewActivities();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of viewEWO method, of class Planner.
     */
    /*
    @Test
    public void testViewEWO() {
        System.out.println("viewEWO");
        Planner instance = null;
        instance.viewEWO();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of sortedActivities method, of class Planner.
     */
    /*
    @Test
    public void testSortedActivities() {
        System.out.println("sortedActivities");
        Planner instance = null;
        instance.sortedActivities();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of maintainerAval method, of class Planner.
     */
    
    @Test
    public void testMaintainerAval() {
        System.out.println("Verifica disponibilità");
        Maintainer man=new Maintainer("peppe","pippo","mario","maiopeppe@hotmail.it",2);
        HashMap mappa = new HashMap();
        mappa = instance.maintainerAval(man, 2);
        System.out.println(mappa.toString());
        
        
    }

    /**
     * Test of maintainerAvalPerc method, of class Planner.
     */
    /*
    @Test
    public void testMaintainerAvalPerc() {
        System.out.println("maintainerAvalPerc");
        Maintainer man = null;
        Planner instance = null;
        instance.maintainerAvalPerc(man);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    @Test
    public void testToString() {
        System.out.println("toString");
        Planner instance = new Planner("pippo", "xxxx", "cosimo", "coccocorb1@hot.com", 23);
        String username="pippo";
        String password="xxxx";
        String nome="cosimo";
        String email="coccocorb1@hot.com";
        int id=23;
                
        String expResult = "AbstractUtente{" + "username=" + username + ", password=" + password + ", nome=" + nome + ", email=" + email + ", id=" + id + '}' + "Planner";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
