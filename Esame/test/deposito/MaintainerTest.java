/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.sql.*;
import java.util.*;
import org.junit.*;
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

    
    @Test
    public void testDoneActivity(){
        System.out.println("doneActivity");
        
        Sito sito1 = new Sito("ufficio","area");
        List<String> materiali = new ArrayList();
        materiali.add("Mattoni");
        Procedure procedura = new Procedure();
        Planner instance = new Planner("ProvaUser","xxxx","UtenteProva","prova@prova.it",1);
        SystemAdministrator sy=new SystemAdministrator("admin","admin","ADMIN","admin@admin.it",100);
        System.out.println("assegnaMan");
        Maintainer man = sy.createMaintainer("Giacomo", "pass", "Giacomo", "prova@email.it");
        List<String> competenze = new ArrayList();
        EwoActivity act = (EwoActivity) instance.createActivity(sito1, "elettrico", "provaDescrizione", 50, materiali, 50,competenze, Boolean.TRUE, procedura, "s","Ewo");
        String orario="o9_10";
        instance.assegnaManEWO(man, act, 2, orario);
        
        man.doneActivity(act);
        
        
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
                
                System.out.println("aa-"+manS+"-bb-"+genS+"-cc-"+depS+"-dd");
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
    
    @Test
    public void testEwoAssegnate(){
        Boolean flag = false;
        Calendar c = Calendar.getInstance();
        java.util.Date d = new java.util.Date();
        c.setTime(d);
        
        System.out.println("ewoAssegnate");
        
        Planner plan = new Planner("fittizio", "fittizio", "nome", "email", 0);
        SystemAdministrator sa = new SystemAdministrator("fittizio", "fittizio", "nome", "email", 0);
        Maintainer m = sa.createMaintainer("username", "password", "nome", "email");
        if (m == null)
            fail("EERORE NELLA CREAZIONE DEL MANUTENTORE");
        List<EwoActivity> archivio = m.ewoAssegnate();
        if(archivio ==null){
            fail("ERRORI DURANTE LA CHIAMATA AL DB");
        }
        if (!archivio.isEmpty()){
            fail("EWO SPURI IN PIANIFICAZIONE");
        }
        Sito s = new Sito("ufficio", "area");
        String tipologia = "elettrico";
        String descrizione = "prova di Descrizione";
        int tempo = 10;
        List<String> materiali = plan.listaMateriali();
        int week = 52;
        List<String> competenze = plan.listaCompetenze();
        Boolean interrompibile = true;
        Procedure procedura = new Procedure("smp", "nomefile");
        String wNotes="";
        String tipoattivita = "Ewo";
        
        AbstractActivity act = plan.createActivity(s, tipologia, descrizione, tempo, materiali, week, competenze, interrompibile, procedura, wNotes, tipoattivita);
        EwoActivity a = (EwoActivity) act;
        String orario = "o8_9";
        plan.assegnaManEWO(m, a, c.get(Calendar.DAY_OF_WEEK)-1, orario);
        
        archivio=m.ewoAssegnate();
        
        for(EwoActivity ewo : archivio){
            if(ewo.toString().equals(a.toString()));
                flag=true;
        }
        sa.cancellaMaintainer(m);
        plan.deleteActivity(act);
        
        assertTrue(flag);
        
        
    }
}
