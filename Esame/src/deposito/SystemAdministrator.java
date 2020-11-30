/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import factories.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author cosimocorbisiero
 */
public class SystemAdministrator extends AbstractUtente {
    
    public SystemAdministrator(String username,String password,String nome,String email,int id){
        super(username,password,nome,email,id);
    }
    
    public Maintainer createMaintainer(String username, String password, String nome, String email) throws SQLException{
        
        MaintainerBuilder builder= new MaintainerBuilder();
        builder.reset(nome, username, password, email);
        Maintainer m=builder.getInstance();
        Comunicatore com=new Comunicatore();
        HashMap <String, Object> map= new HashMap<>();
        map.put("mid", m.getId());
        map.put("username", m.getUsername());
        map.put("pass", m.getPassword());
        map.put("nome", m.getNome());
        map.put("email", m.getEmail());
        try{
           com.apri(); 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        try{
          com.insertQuery("maintainer", map);  
        }catch(SQLException ex2){
          System.out.println(ex2.getMessage());
          return null;  
        }
        try{
           com.chiudi(); 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return m;
                 
    }
    
    
    public Maintainer modificaMaintainer(Maintainer man, String username, String password, String nome,
            String email, Set<String> skill, Set<Procedure> procedure) throws SQLException{
        
        man.setEmail(email);
        man.setNome(nome);
        man.setPassword(password);
        man.setProcedure(procedure);
        man.setSkill(skill);
        man.setUsername(username);
        Comunicatore com= new Comunicatore(); 
        HashMap <String, Object> value= new HashMap<> ();
        value.put("username", man.getUsername());
        value.put("pass", man.getPassword());
        value.put("nome", man.getNome());
        value.put("email", man.getEmail());
        HashMap <String,Object> chiavi= new HashMap <>();
        chiavi.put("mid", man.getId());
        try{
        com.apri();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        try{
          com.updateQuery("maintainer", value, chiavi);  
        }catch(SQLException ex2){
            System.out.println(ex2.getMessage());  
            return null;
        }
        try{
           com.chiudi(); 
        }catch(SQLException ex3){
            System.out.println(ex3.getMessage());
        }
        
        Iterator iter= skill.iterator();
        HashMap <String, Object> skills=new HashMap<>();
        String sk;
        while(iter.hasNext()){
            sk = (String) iter.next();
            skills.put("mid",man.getId());
            skills.put("competenza", sk);
            try{
            com.apri();
            }catch(SQLException ex4){
                System.out.println(ex4.getMessage());
            }
            try{
                com.insertQuery("maintainer_competenze", skills);
            }catch(SQLException ex5){
                System.out.println(ex5.getMessage());  
                return null;
            }
            try{
                com.chiudi();
            }catch(SQLException ex6){
                System.out.println(ex6.getMessage());
            }
            skills.clear();
        }
        Iterator iterpro= procedure.iterator();
        HashMap <String, Object> procedures=new HashMap<>();
        Procedure pr;
        while(iterpro.hasNext()){
            pr = (Procedure) iterpro.next();
            procedures.put("mid",man.getId());
            procedures.put("nomefile", pr.getNomefile());
            try{
                com.apri();
            }catch(SQLException ex7){
                System.out.println(ex7.getMessage());
            }
            try{
                com.insertQuery("maintainer_procedura", procedures);
            }catch(SQLException ex8){
                System.out.println(ex8.getMessage());  
                return null;
            }   
            try{
                com.chiudi();
            }catch(SQLException ex9){
                System.out.println(ex9.getMessage());
            }
            
            skills.clear();
        }
        return man;
    }
    
    public void cancellaMaintainer (Maintainer man) throws SQLException{
        Comunicatore com=new Comunicatore();
        ResultSet s;
        HashMap <String,Object> chiavi=new HashMap<>();
        chiavi.put("mid",man.getId());
        try{
        com.apri();
        com.deleteQuery("maintainer_procedura", chiavi);
        com.chiudi();
        com.apri();
        com.deleteQuery("maintainer_competenze", chiavi);
        com.chiudi();
        com.apri();
        com.deleteQuery("maintainer", chiavi);
        com.chiudi();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    public Planner createPlanner(String username, String password, String nome, String email) throws SQLException{
        PlannerBuilder builder= new PlannerBuilder();
        builder.reset(nome, username, password, email);
        Planner p=builder.getResult();
        Comunicatore com= new Comunicatore();
        
        HashMap <String,Object> map= new HashMap<>();
        map.put("pid", p.getId());
        map.put("username", p.getUsername());
        map.put("pass", p.getPassword());//dobbiamo inserire l'hash della password
        map.put("nome", p.getNome());
        map.put("email",p.getEmail());
        try{
          com.apri();  
        }catch(SQLException ex){
            System.out.println(ex.getMessage());  
        }
        try{
            com.insertQuery("planner" , map);
        }catch(SQLException ex2){
            System.out.println(ex2.getMessage());  
            return null;
        }
        try{
            com.chiudi();   
        }catch(SQLException ex3){
            System.out.println(ex3.getMessage());
        }
        return p;
       
    }
    
    public Planner modificaPlanner(Planner pln,String username, String password, String nome, String email) throws SQLException{
        pln.setNome(nome);
        pln.setUsername(username);
        pln.setPassword(password);
        pln.setEmail(email);
        Comunicatore com=new Comunicatore();
        
        HashMap <String,Object> value=new HashMap <> ();
        value.put("username", pln.getUsername());
        value.put("pass", pln.getPassword());
        value.put("nome",pln.getNome());
        value.put("email", pln.getEmail());
        HashMap <String,Object> chiavi= new HashMap<>();
        chiavi.put("pid", pln.getId());
        try{
            com.apri();   
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        try{
          com.updateQuery("planner", value, chiavi);     
        }catch(SQLException ex2){
            System.out.println(ex2.getMessage());
            return null;
        }
        try{
            com.chiudi();   
        }catch(SQLException ex3){
            System.out.println(ex3.getMessage());
        }
        return pln;
        
    }
    public void cancellaPlanner(Planner pln) throws SQLException{
        Comunicatore com= new Comunicatore();
        HashMap <String,Object> map= new HashMap <>();
        map.put("pid", pln.getId());
        try{
            com.apri();
            com.deleteQuery("planner", map);
            com.chiudi();     
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public String toString() {
        return super.toString() + "SystemAdministrator{" + '}';
        
    }
    
    
    
    
}
