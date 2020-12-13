/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

//import java.time.OffsetTime;
import java.sql.*;
import java.util.*;
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
    
    @Test
    public void testAssegnaMan() {
        
        SystemAdministrator sy=new SystemAdministrator("admin","admin","ADMIN","admin@admin.it",100);
        System.out.println("assegnaMan");
        Maintainer man = sy.createMaintainer("Giacomo", "pass", "Giacomo", "prova@email.it");
        if(man == null){
            fail("Errore nella creazione del Maintainer");
        }
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        List<String> competenze = new ArrayList();
        Procedure procedura = new Procedure();
        AbstractActivity act = instance.createActivity(sito1, "elettrico", "provaDescrizione", 50, materiali, 50,competenze, Boolean.TRUE, procedura, "s","Planned");
        if(act==null){
            fail("Errore nella creazione dell'Attività");
        }
        int giorno=1;
        String orario="o8_9";
        int i=instance.assegnaMan(man, act,giorno,orario);
        if(i==-1){
            fail("Assegnazione non effettuata");
        }
        sy.cancellaMaintainer(man);
        instance.deleteActivity(act);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
    
     
   
    @Test
    public void testCreateActivity() {
        
        System.out.println("createActivity");
        String tipoAttivita="Planned";
        Sito sito = new Sito("ufficio","area");
        String tipologia = "elettrico";
        String descrizione = "prova di descizione";
        int tempo = 70;
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        int week = 50;
        Boolean interrompibile = true;
        Procedure procedura = new Procedure();
        ArrayList<String> array=new ArrayList<>();
        HashMap<String,Object> mappa = new HashMap<>();
        Comunicatore com = Comunicatore.getInstance();
        List<String> competenze = new ArrayList();
        try {
            

                AbstractActivity act =instance.createActivity(sito, tipologia, descrizione, tempo, materiali, week, competenze,interrompibile, procedura, "",tipoAttivita);
                array.add("aid");
                mappa.put("aid", act.getId());
                com.apri();
                ResultSet rs = com.selectionQuery("attivita", array, mappa);
                com.chiudi();
                if(rs.next() == false){
                    throw new SQLException("Impossibile eseguire inserimento, si è verificato un errore nell'operazione");
                }
                else {
                    instance.deleteActivity(act);
                }
            
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        
    }

    /**
     * Test of modifyActivity method, of class Planner.
     */
    
    @Test
    public void testModifyActivity() {
        boolean flag=false;
         
        System.out.println("modifyActivity");
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        Sito sito = new Sito("ufficio2","area");
        String tipologia = "Meccanico";
        String tipoAttivita= "Planned";
        String descrizione = "descrizione cambiata";
        int tempo = 90;
        materiali.add("Chiodi di garofano");
        int week = 52;
        Boolean interrompibile = false;
        List<String> competenze = new ArrayList();
        Comunicatore com = Comunicatore.getInstance();
        ResultSet rs;
        
        AbstractActivity act = instance.createActivity(sito, tipologia, descrizione, tempo, materiali, week,competenze, interrompibile, procedura, "",tipoAttivita);
        if(act == null)
            fail("ERRORE ATTIVITA NON CREATA");
        
        instance.modifyActivity(act, "NOTE MODIFICATE");
        
        HashMap<String,Object> mappa = new HashMap<>();
        mappa.put("aid", act.getId());
        ArrayList<String> array=new ArrayList<>();
        array.add("wnotes");
        
        try{
            com.apri();
            rs = com.selectionQuery("attivita", array, mappa);
            com.chiudi();
            
            if(rs.next()==false){
                flag=false;
            }
            else{
                if(rs.getString("wnotes").equals(act.getWnotes()))
                    flag=true;
            }
            
            instance.deleteActivity(act);
            assertTrue(flag);
            
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of deleteActivity method, of class Planner.
     */
 
    @Test
    public void testDeleteActivity() {
       System.out.println("deleteActivity");
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        Sito sito = new Sito("ufficio2","area");
        String tipologia = "Meccanico";
        String descrizione = "descrizione cambiata";
        int tempo = 90;
        materiali.add("Chiodi di garofano");
        int week = 52;
        String tipoAttivita="Planned";
        Boolean interrompibile = false;
        List<String> competenze = new ArrayList();
        
        
        Comunicatore com = Comunicatore.getInstance();
        try {
            
            AbstractActivity act =instance.createActivity(sito1, tipologia, descrizione, tempo, materiali, week,competenze ,interrompibile, procedura,"", tipoAttivita);
            if(act == null){
                
            }
            ArrayList<String> array=new ArrayList<>();
            array.add("aid");
            HashMap<String,Object> mappa = new HashMap<>();
            mappa.put("aid", act.getId());
            com.apri();
            ResultSet rs = com.selectionQuery("attivita", array, mappa);
            com.chiudi();
            if(rs.next()==false){
                throw new SQLException("Attività non presente quindi non è stato possibile cancellare");
            }
            else{
                AbstractActivity act2 = instance.deleteActivity(act);
                assertTrue("Cancellazione Avvenuta con successo", act.equals(act2));
            }
            
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
        Procedure procedura=new Procedure("smp", "nomefile");
        List<String> competenze = new ArrayList();
        AbstractActivity plact=instance.createActivity(sito,tipologia,descrizione,tempo,materiali,week,competenze,interrompibile,procedura,"","Planned");
        
        List<AbstractActivity> res=instance.viewActivities();
        AbstractActivity plact2=instance.createActivity(sito,tipologia,descrizione+"new",tempo,materiali,week,competenze,interrompibile,procedura,"","Planned");
        instance.deleteActivity(plact);
        instance.deleteActivity(plact2);
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
     * Test of maintainerAval method, of class Planner.
     */
   
    @Test
    public void testMaintainerAval() {
        System.out.println("Verifica disponibilità");
        SystemAdministrator sy=new SystemAdministrator("admin","admin","ADMIN","admin@admin.it",100);
        Maintainer man = sy.createMaintainer("man", "pass", "Paolo", "paoloman@email.it");
        HashMap mappa = new HashMap();
        mappa = instance.maintainerAval(man, 2);
        if(mappa == null){
            fail("ERRORE NELLA MAPPA DI MAINTAINERAVAL");
        }
        System.out.println(mappa.toString());
        sy.cancellaMaintainer(man);
        
    }

    /**
     * Test of maintainerAvalPerc method, of class Planner.
     */
    
    @Test
    public void testMaintainerAvalPerc() {
       System.out.println("maintainerAvalPerc");
       Boolean flag=false;
      Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        Sito sito = new Sito("ufficio2","area");
        String tipologia = "Meccanico";
        String descrizione = "descrizione cambiata";
        List<String> competenze = new ArrayList();
        int tempo = 40;
        materiali.add("Chiodi di garofano");
        int week = 52;
        String tipoAttivita="Planned";
        Boolean interrompibile = false;
       SystemAdministrator admin=new SystemAdministrator("username","pass","admin","email",4);
       Maintainer man=admin.createMaintainer("man", "pass", "man", "ciccio@ciccio.com");
       AbstractActivity act =instance.createActivity(sito1, tipologia, descrizione, tempo, materiali, week, competenze,interrompibile, procedura,"" ,tipoAttivita);
            
       HashMap<String,String> map=new HashMap<>();
       
       int i=instance.assegnaMan(man, act, 2, "o8_9");
       
        
        ArrayList<Integer> l=instance.maintainerAvalPerc(man);
        if(l==null){
            fail("Errore nella realizzazione delle percentuali");
        }
        int s=l.get(1);
        try{
        Comunicatore com=Comunicatore.getInstance();
        
        //maintainer ,giorno
        HashMap <String,Object> m=new HashMap<>();
        m.put("giorno", 2);
        m.put("maintainer", man.getId());
        com.apri();
        ResultSet rs=com.selectionQuery("orari", null, m);
        com.chiudi();
        int j;
        
        int media=0;
        while(rs.next()){
            j=(100*(rs.getInt("o8_9")))/60;
            map.put("o8_9", Integer.toString(j));
            j=(100*(rs.getInt("o9_10")))/60;
            map.put("o9_10", Integer.toString(j));
            j=(100*(rs.getInt("o10_11")))/60;
            map.put("o10_11", Integer.toString(j));
            j=(100*(rs.getInt("o11_12")))/60;
            map.put("o11_12", Integer.toString(j));
            j=(100*(rs.getInt("o14_15")))/60;
            map.put("o14_15", Integer.toString(j));
            j=(100*(rs.getInt("o15_16")))/60;
            map.put("o15_16", Integer.toString(j));
            j=(100*(rs.getInt("o16_17")))/60;
            map.put("o16_17", Integer.toString(j));
            for(String str : map.values()){
            media+=Integer.parseInt(str);
            }
             media=media/map.size();
            if(s==media){
            flag=true;
            }
        }
        
        
        }catch(SQLException ex){
            fail(ex.getMessage());
        }
        admin.cancellaMaintainer(man);
        instance.deleteActivity(act);
        assertTrue(flag);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
   
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
    
    
    
    @Test
    public void testViewMaintainer(){
        System.out.println("viewMaintainer");
        Boolean flag = false;
        
        Planner instance=new Planner("prova", "pass", "planner", "prova@1", 0);
        ArrayList<Maintainer> archivio = instance.viewMaintainer();
        if(archivio == null)
            fail("ERRORE NELLA VIEW");
        if(archivio.isEmpty())
            flag=true;
        
        SystemAdministrator util=new SystemAdministrator("admin", "password", "nome", "email", 0);
        Maintainer man = util.createMaintainer("username", "password", "nome", "email");
        
        if(man == null)
            fail("ERRORE NELLA CREAZIONE");
        archivio=instance.viewMaintainer();
        
        for(Maintainer m:archivio){
            if(m.equals(man))
                flag=true;
        }
        util.cancellaMaintainer(man);
        assertTrue(flag);
    }
    
    @Test
    public void testViewEwo(){
        boolean flag=true;
        System.out.println("viewEwo");
        
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        Sito sito = new Sito("ufficio2","area");
        String tipologia = "Meccanico";
        String tipoAttivita= "Ewo";
        String descrizione = "descrizione cambiata";
        int tempo = 90;
        materiali.add("Chiodi di garofano");
        int week = 52;
        Boolean interrompibile = false;
        List<String> competenze = new ArrayList();
        ArrayList<EwoActivity> archivio = instance.viewEwo();
        if(!archivio.isEmpty())
            fail("CREAZIONI SPURIE");
        
        AbstractActivity ewo = instance.createActivity(sito, tipologia, descrizione, tempo, materiali, week, competenze,Boolean.TRUE, procedura,"d" ,tipoAttivita);
        
        archivio = instance.viewEwo();
        
        for(EwoActivity e:archivio){
            if(e.compareTo(ewo)==0)
                flag=true;
        }
        instance.deleteActivity(ewo);
        
       assertTrue(flag);
        
    }
    
    @Test
    public void testAssegnaManEWO(){
        System.out.println("assegnaManEWO");
        
        SystemAdministrator sy=new SystemAdministrator("admin","admin","ADMIN","admin@admin.it",100);
        System.out.println("assegnaMan");
        Maintainer man = sy.createMaintainer("Giacomo", "pass", "Giacomo", "prova@email.it");
        if(man == null){
            fail("Errore nella creazione del Maintainer");
        }
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        List<String> competenze = new ArrayList();
        EwoActivity act = (EwoActivity) instance.createActivity(sito1, "elettrico", "provaDescrizione", 50, materiali, 50,competenze, Boolean.TRUE, procedura, "s","Ewo");
        if(act==null){
            fail("Errore nella creazione dell'Attività");
        }
        int giorno=1;
        String orario="o8_9";
        int i=instance.assegnaManEWO(man, act, giorno, orario);
        if(i==-1){
            fail("Assegnazione non effettuata");
        }
        
        Comunicatore com=Comunicatore.getInstance();
        ArrayList<String> colonne=new ArrayList<>();
        colonne.add("manstate");
        colonne.add("genstate");
        colonne.add("depstate");
        
        HashMap<String,Object> dove=new HashMap<>();
        dove.put("aid",act.getId());
        try {
            com.apri();
            ResultSet set= com.selectionQuery("attivita", colonne, dove);
            com.chiudi();
            while (set.next()) {
                String manS= set.getString("manstate");
                String genS= set.getString("genstate");
                String depS= set.getString("depstate");
                
                //System.out.println("aa"+manS+"bb"+genS+"cc"+depS+"dd");
                assertEquals(act.getManStatus().getString(), manS);
                assertEquals(act.getGeneralStatus().getString(), genS);
                assertEquals(act.getAreaStatus().getString(), depS);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        sy.cancellaMaintainer(man);
        instance.deleteActivity(act);
    }
}
