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
    
    public Maintainer createMaintainer(String username, String password, String nome, String email){
        
        MaintainerBuilder builder= new MaintainerBuilder();
        builder.reset(nome, username, password, email);
        return builder.getInstance();
                 
    }
    
    
    public Maintainer modificaMaintainer(Maintainer man, String username, String password, String nome,
            String email, Set<String> skill, Set<Procedure> procedure){
        
        man.setEmail(email);
        man.setNome(nome);
        man.setPassword(password);
        man.setProcedure(procedure);
        man.setSkill(skill);
        man.setUsername(username);
        
        return man;
    }
    
    public void cancellaMaintainer (Maintainer man){
        
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
        com.apri();
        com.insertQuery("planner" , map);
        com.chiudi();
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
        com.apri();
        com.updateQuery("planner", value, chiavi);
        com.chiudi();
        return pln;
        
    }
    public void cancellaPlanner(Planner pln) throws SQLException{
        Comunicatore com= new Comunicatore();
        HashMap <String,Object> map= new HashMap <>();
        map.put("pid", pln.getId());
        com.apri();
        com.deleteQuery("planner", map);
        com.chiudi();
    }
    
    @Override
    public String toString() {
        return super.toString() + "SystemAdministrator{" + '}';
        
    }
    
    
    
    
}
