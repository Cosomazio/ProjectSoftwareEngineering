/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import java.sql.*;
import java.time.*;
import java.util.*;
/**
 *
 * @author tomma
 */
public class Planner extends AbstractUtente {
    public Planner(String username,String password,String nome,String email,int id){
        super(username,password,nome,email,id);
    }
    public void assegnaMan(Maintainer man, InterfaceActivity act){
        
    }
    public void planActivity(InterfaceActivity act){
        
    }
    public void creaEwo(int id, Sito sito ,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura){
        
    }
    public void modificaEWO(EWO ewo, String descrizione,OffsetTime tempo,
            List<String> skills, List<String> materiali){
        
    }
    public void gestisciMateriali(InterfaceActivity act,List<String> materiali){
        
    }
    public void createActivity(int id, Sito sito,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura){
        
    }
    public void modifyActivity(AbstractActivity act,int id, Sito sito,String tipologia, String descrizione, int tempo, 
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura){
        
        int idAct=act.getId();
        String url="kandula.db.elephantsql.com";
        String user="figslypy";
        String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";
        
        try{
            //creo la connessione al DB
            Connection c= DriverManager.getConnection(url,user,pass);
            
            String query= "UPDATE Attivita SET id="+id+",sito="+sito+",tipologia="+tipologia+",descrizione="+descrizione+",tempo="+tempo+",materiali="+materiali+
                    ",week="+week+",interrompibile="+interrompibile+",procedura="+procedura+" WHERE id="+idAct;
            PreparedStatement st = c.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            st.close();
            rs.close();
            c.close();
            
        }catch(SQLException ex){
            System.out.println("ERRORE DATABASE");
        }
    }    
    public void deleteActivity(InterfaceActivity act){
        
    }
    public void viewActivties(){
        
    }
    public void viewEWO() {
        
    }
    public void sortedActivities(){
        
    }
    public void maintainerAval(Maintainer man, int giorno){
        
    }
    
    public void maintainerAvalPerc(Maintainer man){
        
    }
    
            
            
            
    
}
