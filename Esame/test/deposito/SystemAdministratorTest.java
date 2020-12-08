/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
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
     * 
     */
    
    @Test
    public void testCreateMaintainer() {
        
        Boolean flag=false;
        Comunicatore com=Comunicatore.getInstance();
        System.out.println("createMaintainer");
        String username = "paperino";
        String password = "1234";
        String nome = "papera";
        String email = "ciccio@ciccio.com";
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        Maintainer result = instance.createMaintainer(username, password, nome, email);
        Maintainer expResult;
        if(result==null){
            fail("Errore nell'inserimeto del maintainer");
        }else{
            HashMap<String, Object> map=new HashMap<>();
            map.put("mid",result.getId());
            try{
                com.apri();
                ResultSet rs= com.selectionQuery("maintainer", null, map);
                com.chiudi();
                while(rs.next()){
                    String n=rs.getString("nome");
                    String p=rs.getString("pass");
                    String e=rs.getString("email");
                    String u=rs.getString("username");
                    int i=rs.getInt("mid");
                    expResult=new Maintainer(u,p,n,e,i);
                    if(expResult.toString().equals(result.toString())){
                        flag=true;
                    }
                }
                
                instance.cancellaMaintainer(result);
                
            }catch(SQLException ex){
                fail(ex.getMessage());
            }
            assertTrue(flag);
            
        
        }
        
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificaMaintainer method, of class SystemAdministrator.
     * 
     */
    
    @Test
    public void testModificaMaintainer(){
        Comunicatore com=Comunicatore.getInstance();
        Boolean flag=false;
        System.out.println("modificaMaintainer");
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        Maintainer rs =instance.createMaintainer("paperino", "1234", "papera", "ciccio@ciccio.com");
        Maintainer man = new Maintainer("paperino","1234","papera","ciccio@ciccio.com",rs.getId());
        HashMap <String,Object> map=new HashMap<>();
        map.put("mid",rs.getId());
        String username = "nicola";
        String password = "5678";
        String nome = "luigi";
        String email = "luigi@luigi.com";
        /*Set<String> skill = new HashSet <> ();
        skill.add("pippo");
        skill.add("paperino");
        skill.add("cornuto");
        Set<Procedure> procedure = new HashSet<> ();
        File p=null;
        procedure.add(new Procedure(p,null,"pippo"));
        procedure.add(new Procedure(p,null,"paperino"));
        procedure.add(new Procedure(p,null,"cornuto"));
        */
        Maintainer expResult;
        Maintainer result = instance.modificaMaintainer(man, username, password, nome, email,null,null);
        if (result==null){
            fail("Errore nella modifica del maintainer");
        }else{
            try{
                com.apri();
                ResultSet res=com.selectionQuery("maintainer", null, map);
                com.chiudi();
                while(res.next()){
                    String n=res.getString("nome");
                    String p=res.getString("pass");
                    String e=res.getString("email");
                    String u=res.getString("username");
                    int i=res.getInt("mid");
                    expResult=new Maintainer(u,p,n,e,i);
                    if(expResult.toString().equals(result.toString())){
                        flag=true;
                    }
                }
                instance.cancellaMaintainer(man);
              
            }catch(SQLException ex){
                fail(ex.getMessage());
            }
            assertTrue(flag);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaMaintainer method, of class SystemAdministrator.
     * 
     */
    
    @Test
    public void testCancellaMaintainer() {
        System.out.println("cancellaMaintainer");
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        Maintainer rs=instance.createMaintainer("paperino","1234","papera","ciccio@ciccio.com");
        Maintainer man = new Maintainer("paperino","1234","papera","ciccio@ciccio.com",rs.getId());
        instance.cancellaMaintainer(man);
        Comunicatore com=Comunicatore.getInstance();
        try{
        com.apri();
        HashMap < String, Object> map= new HashMap <> ();
        map.put("mid", rs.getId());
        ArrayList <String> a=new ArrayList<>();
        a.add("mid");
        
        ResultSet res=com.selectionQuery("maintainer", a, map);
        com.chiudi();
        if (res.next() != false){
            fail("Erroe nella cancellazione del maintaimer");
        }
        
        }catch(SQLException ex){
            fail(ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of createPlanner method, of class SystemAdministrator.
     * 
     */
    
    @Test
    public void testCreatePlanner() {
        System.out.println("createPlanner");
        Boolean flag=false;
        Comunicatore com=Comunicatore.getInstance();
        String username = "ciccio";
        String password = "1234";
        String nome = "Luca";
        String email = "ciccio@ciccio.com";
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        HashMap <String, Object> map=new HashMap<>();
        Planner result = instance.createPlanner(username, password, nome, email);
        if(result==null){
            fail("Errore nell'inserimento del Planner");
        }else{
        map.put("pid", result.getId());
       
        try{
            com.apri();
            ResultSet rs=com.selectionQuery("planner", null, map);
            com.chiudi();
            while(rs.next()){
                String u=rs.getString("username");
                String p=rs.getString("pass");
                String n=rs.getString("nome");
                String e=rs.getString("email");
                int i=rs.getInt("pid");
            Planner expResult =new Planner(u,p,n,e,i);
            if(expResult.toString().equals(result.toString())){
                flag=true;
            }
            
            }
            instance.cancellaPlanner(result);
           
        }catch(SQLException ex){
            fail(ex.getMessage());
        }
        assertTrue(flag);
        
    }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificaPlanner method, of class SystemAdministrator.
     * @
     */
    
    @Test
    public void testModificaPlanner() {
        System.out.println("modificaPlanner");
        Comunicatore com= Comunicatore.getInstance();
        Boolean flag=false;
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        Planner pln = instance.createPlanner("ciccio","1234","Luigi","ciccio@ciccio.com");
        String username = "napoli98";
        String password = "1357";
        String nome = "francesco";
        String email = "nicoladinari@gmail.com";
        HashMap <String,Object> map=new HashMap<>();
        map.put("pid",pln.getId());
        
        Planner result = instance.modificaPlanner(pln, username, password, nome, email);
        if(result==null){
            fail("Errore nella modifica del planner");
        }else{
            try{
            com.apri();
            ResultSet rs=com.selectionQuery("planner", null, map);
            while(rs.next()){
                String u=rs.getString("username");
                String p=rs.getString("pass");
                String n=rs.getString("nome");
                String e=rs.getString("email");
                int i=rs.getInt("pid");
             Planner expResult = new Planner(u,p,n,e,i);
             if(expResult.toString().equals(result.toString())){
                flag=true;
            }   
            }
            instance.cancellaPlanner(result);
            }catch(SQLException ex){
                fail(ex.getMessage());
            }
        }
        assertTrue(flag);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaPlanner method, of class SystemAdministrator.
     * 
     */
    
    @Test
    public void testCancellaPlanner() {
        System.out.println("cancellaPlanner");
        SystemAdministrator instance = new SystemAdministrator("pippo","pass","nome","email",5);
        Planner pln = instance.createPlanner("ciccio","1234","Luigi","ciccio@ciccio.com");
        instance.cancellaPlanner(pln);
        Comunicatore com=Comunicatore.getInstance();
        try{
        com.apri();
        HashMap < String, Object> map= new HashMap <> ();
        map.put("pid", pln.getId());
        ResultSet rs=com.selectionQuery("planner", null, map);
        if (rs.next()!=false){
            fail("Erroe nella cancellazione del planner");
        }
        com.chiudi();
        }catch(SQLException ex){
            fail(ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of toString method, of class SystemAdministrator.
     */
    
    @Test
    public void testViewMaintainer() {
        Boolean flag = false;
        System.out.println("viewMaintainer");
        SystemAdministrator instance = new SystemAdministrator("test", "xxxx", "tentativo", "prova.test@gmail.com", 0);
        Maintainer man;
        ArrayList<Maintainer> archivio1 = instance.viewMaintainer();
        if(archivio1.isEmpty()){
            flag=true;
            //System.out.println("è andata bene");
        }
        man = instance.createMaintainer("tentativo", "12345", "di prova", "tenta.Prova@gmail.com");
        if(man == null){
            fail("ERRORE NELLA CREAZIONE");
        }
        ArrayList<Maintainer> archivio = instance.viewMaintainer();
        for(Maintainer m: archivio){
            if(m.equals(man))
                flag=true;
        }
        instance.cancellaMaintainer(man);
        
        assertEquals(flag, true);
    }
    
    
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
    @Test
    public void testViewPlanner(){
        System.out.println("viewPlanner");
        SystemAdministrator instance = new SystemAdministrator("pippo", "xxxx", "cosimo", "coccocorb1@hot.com", 23);
        String username="giova";
        String password="nni";
        String nome="giovanni";
        String email="gio@vanni.it";
        Planner plan=null;
        boolean flag=false;
        ArrayList<Maintainer> archivio1 = instance.viewMaintainer();
        if(archivio1.isEmpty()){
            flag=true;
        }
        
        plan=instance.createPlanner(username, password, nome, email);
        if(plan==null){
            fail("ERRORE NELLA CREAZIONE");
        }
        
        ArrayList<Planner> planners=instance.viewPlanner();
        if(planners==null){
            fail("ERRORE NELLA VIEW");
        }
        for(Planner p: planners){
            if(p.equals(plan) ){
                flag=true;
            }
        }
        if(instance.cancellaPlanner(plan)== null){
            fail("ERRORE NELLA CANCELLAZIONE DEL PLANNER");
        }
        assertEquals(flag, true);
        
        
        
    }

}
