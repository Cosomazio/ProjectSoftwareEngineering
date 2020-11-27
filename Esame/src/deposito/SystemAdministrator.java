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
    public Planner createPlanner(String username, String password, String nome, String email){
        PlannerBuilder builder= new PlannerBuilder();
        builder.reset(nome, username, password, email);
        return builder.getResult();
    }
    
    public Planner modificaPlanner(Planner pln,String username, String password, String nome, String email){
        pln.setNome(nome);
        pln.setUsername(username);
        pln.setPassword(password);
        pln.setEmail(email);
        return pln;
    }
    public void cancellaPlanner(Planner pln){
        
            String url="kandula.db.elephantsql.com";
            String user="figslypy";
            String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";

            try{
                //creo la connessione al DB
                Connection c= DriverManager.getConnection(url,user,pass);
                String query="Delete from planner where pid="+ pln.getId();
                
                PreparedStatement st = c.prepareStatement(query);
                ResultSet rs=st.executeQuery();
                st.close();
                rs.close();
                c.close();

            }catch(SQLException ex){
                System.out.println("ERRORE DATABASE MODIFICA");
            }
    }
    
    @Override
    public String toString() {
        return super.toString() + "SystemAdministrator{" + '}';
        
    }
    
    
    
    
}
