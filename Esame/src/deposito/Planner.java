/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import factories.PlannedBuilder;
import java.sql.*;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
            /*
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
            */
        PlannedBuilder builder= new PlannedBuilder();
        builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
        PlannedActivity attivita = builder.getResult();
        Comunicatore com;    
        try {    
            com= new Comunicatore();
            HashMap<String,String> mappa= new HashMap<>();
            mappa.put("aid",""+attivita.getId());
            mappa.put("office",""+attivita.getSito().getOffice());
            mappa.put("area",""+attivita.getSito().getArea());
            mappa.put("tipologia",""+attivita.getTipologia());
            mappa.put("descrizione",""+attivita.getDescrizione());
            mappa.put("tempo",""+attivita.getTempo());
            mappa.put("week",""+attivita.getWeek());
            mappa.put("interrompibile",""+attivita.getInterrompibile());
            mappa.put("pianificazione","Planned");
        
            com.insertQuery("Attivita", mappa);
            
           
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
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
    
    @Override
    public String toString() {
        return super.toString()+"Planner";
    }        
            
            
    
}
