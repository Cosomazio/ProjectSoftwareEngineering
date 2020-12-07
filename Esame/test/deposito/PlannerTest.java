/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

//import java.time.OffsetTime;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    */
    Planner instance = new Planner("ProvaUser","xxxx","UtenteProva","prova@prova.it",1);
    /*
    @Test
    public void testAssegnaMan() {
        System.out.println("assegnaMan");
        Maintainer man = new Maintainer("nicola","5678","luigi","ciccio.pasticcio@hot.com",1);
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        AbstractActivity act = new PlannedActivity(4,sito1,"elettrico","prova di descrizione",70,materiali,2,true,procedura);
        int giorno=1;
        String orario="o8_9";
        int i=instance.assegnaMan(man, act,giorno,orario);
        if(i==-1){
            fail("Assegnazione non effettuata");
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        ArrayList<String> array=new ArrayList<>();
        array.add("aid");
        HashMap<String,Object> mappa = new HashMap<>();
        mappa.put("aid", id);
        Comunicatore com = new Comunicatore();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("attivita", array, mappa);
            if(rs.next()!=false){
                throw new SQLException("Impossibile eseguire inserimento, elemento già presente");
            }
            instance.createActivity(sito,tipologia,descrizione,tempo,materiali,week,interrompibile,procedura,"Planned");
            com.chiudi();
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        
        
        
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
        
        Comunicatore com = new Comunicatore();
        HashMap<String,Object> mappa = new HashMap<>();
        mappa.put("aid", act.getId());
        instance.modifyActivity(act, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
        
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("attivita", null, mappa);
            while(rs.next()){
                Sito st=new Sito(rs.getString("office"),rs.getString("area"));
                AbstractActivity act2 = new PlannedActivity(rs.getInt("aid"),st,rs.getString("tipologia"),rs.getString("descrizione"),rs.getInt("tempo"),materiali,rs.getInt("week"),rs.getBoolean("interrompibile"),procedura);
                //assertEquals(act.toString(),act2.toString());
            }
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        

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
        ArrayList<String> array=new ArrayList<>();
        array.add("aid");
        HashMap<String,Object> mappa = new HashMap<>();
        mappa.put("aid", act.getId());
        instance.deleteActivity(act);
        
        Comunicatore com = new Comunicatore();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("attivita", array, mappa);
            if(rs.next()!=false){
                throw new SQLException("Cancellazione non effettuata");
            }
            com.chiudi();
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of viewActivities method, of class Planner.
     */
    
    @Test
    public void testViewActivities() {
        List<AbstractActivity> res1=instance.viewActivities();
        res1.forEach((act) -> {
            instance.deleteActivity(act);
        });
        
        System.out.println("viewActivities");
        Sito sito = new Sito("ufficio","area");
        String tipologia = "elettrico";
        String descrizione = "prova di descizione";
        int tempo = 70;
        List<String> materiali = new ArrayList();
        int week = 2;
        Boolean interrompibile = true;
        Procedure procedura=null;
        AbstractActivity plact=instance.createActivity(sito,tipologia,descrizione,tempo,materiali,week,interrompibile,procedura,"Planned");
        
        List<AbstractActivity> res=instance.viewActivities();
        AbstractActivity plact2=instance.createActivity(sito,tipologia,descrizione+"new",tempo,materiali,week,interrompibile,procedura,"Planned");
        
        assertEquals(plact2.getId(), plact.getId()+1);
        Boolean found=false;
        assertNotEquals(plact, null);
        assertEquals(res.size(), 1);
        assertEquals(res.get(0).compareTo(plact), 0);
    }
    
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
    /*
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
        Maintainer man = new Maintainer("paperino","1234","papera","ciccio@ciccio.com",1);
        
        ArrayList<HashMap> l=instance.maintainerAvalPerc(man);
        if(l==null){
            fail("Errore nella realizzazione delle percentuali");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
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
    
    
    @Test
    public void testSortedActivities(){
        System.out.println("sortedActivities");
        Planner instance= new Planner ("pippo", "xxxx", "cosimo", "coccocorb1@hot.com", 23);
        
        Calendar cal= Calendar.getInstance();
        java.util.Date date= new java.util.Date();
        cal.setTime(date);
        
        int cont=0;
        
        ArrayList<AbstractActivity> att=instance.sortedActivities();
        ArrayList<AbstractActivity> verify=instance.viewActivities();
        
        for(AbstractActivity a: verify){
            if(a.getWeek() == cal.get(Calendar.WEEK_OF_YEAR))
                cont++;
        }
        if(cont==0){
            if(!att.isEmpty())
                fail("NON PRENDO LA SETTIMANA CORRETTAMENTE");
        }
        for(AbstractActivity ac: att){
            if(ac.getWeek()!=cal.get(Calendar.WEEK_OF_YEAR))
                fail("LA SETTIMANA NON è CORRETTA");
        }
    }
}
