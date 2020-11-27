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
    public void modificaEWO(EwoActivity ewo, String descrizione,OffsetTime tempo,
            List<String> skills, List<String> materiali){
        
    }
    public void gestisciMateriali(InterfaceActivity act,List<String> materiali){
        
    }
    
    //sito non esiste
    public void createActivity(int id, Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura){
        
            String url="kandula.db.elephantsql.com";
            String user="figslypy";
            String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";

            try{
                //creo la connessione al DB
                Connection c= DriverManager.getConnection(url,user,pass);
                String insert="INSERT INTO Attivita(id,sito,tipologia,descrizione,"
                        +"tempo,materiali,week,interrompibile,procedura) VALUES";
                String query=insert+" ("+id+","+sito+","+tipologia+","+descrizione+","+tempo+","+materiali+
                        ","+week+","+interrompibile+","+procedura+")";
                PreparedStatement st = c.prepareStatement(query);
                ResultSet rs=st.executeQuery();
                st.close();
                rs.close();
                c.close();

            }catch(SQLException ex){
                System.out.println("ERRORE DATABASE MODIFICA");
            }
    }
    public void modifyActivity(AbstractActivity act, Sito sito,String tipologia, String descrizione, int tempo, 
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura){
        
        int idAct=act.getId();
        String url="kandula.db.elephantsql.com";
        String user="figslypy";
        String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";
        
        try{
            //creo la connessione al DB
            Connection c= DriverManager.getConnection(url,user,pass);
            
            String query= "UPDATE Attivita SET sito="+sito+",tipologia="+tipologia+",descrizione="+descrizione+",tempo="+tempo+",materiali="+materiali+
                    ",week="+week+",interrompibile="+interrompibile+",procedura="+procedura+" WHERE aid ="+idAct;
            PreparedStatement st = c.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            st.close();
            rs.close();
            c.close();
            
        }catch(SQLException ex){
            System.out.println("ERRORE DATABASE MODIFICA");
        }
        
        act.setDescrizione(descrizione);
        act.setId(idAct);
        act.setInterrompibile(interrompibile);
        act.setMateriali(materiali);
        act.setProcedura(procedura);
        act.setSito(sito);
        act.setTempo(tempo);
        act.setTipologia(tipologia);
        act.setWeek(week);
        
    }    
    public void deleteActivity(AbstractActivity act){
        int idAct=act.getId();
        String url="kandula.db.elephantsql.com";
        String user="figslypy";
        String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";
        
        try{
            //creo la connessione al DB
            Connection c= DriverManager.getConnection(url,user,pass);
            
            String query= "DELETE FROM Attivita WHERE aid ="+ idAct;
            
            PreparedStatement st = c.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            st.close();
            rs.close();
            c.close();
            
        }catch(SQLException ex){
            System.out.println("ERRORE DATABASE CANCELLAZIONE");
        }
    }
    
    //sito non esiste
    public void viewActivities(){
        String url="kandula.db.elephantsql.com";
        String user="figslypy";
        String pass="lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio";

        try{
            //creo la connessione al DB
            Connection c= DriverManager.getConnection(url,user,pass);
            String select="SELECT id,sito,tipologia,descrizione,"
                    +"tempo,materiali,week,interrompibile,procedura FROM attivita";
            String query=select;
            PreparedStatement st = c.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                
            }
            st.close();
            rs.close();
            c.close();

        }catch(SQLException ex){
            System.out.println("ERRORE DATABASE MODIFICA");
        }
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
