/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import factories.*;
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
            Procedure procedura,String tipoAttivita){ //tipoAttivita puo essere scelto solo da valori preimpostati quindi sull'interfaccia grafica da checkbox per esempio 
        
        int res;
        
        AbstractActivity attivita=null;
        attivita=this.tipoAttivita(attivita, id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura, tipoAttivita);
        Comunicatore com;    
        try {    
            com= new Comunicatore();
            com.apri();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("aid",attivita.getId());
            mappa.put("office",attivita.getSito().getOffice());
            mappa.put("area",attivita.getSito().getArea());
            mappa.put("tipologia",attivita.getTipologia());
            mappa.put("descrizione",attivita.getDescrizione());
            mappa.put("tempo",attivita.getTempo());
            mappa.put("week",attivita.getWeek());
            mappa.put("interrompibile",attivita.getInterrompibile());
            mappa.put("pianificazione",tipoAttivita);
        
            res= com.insertQuery("Attivita", mappa);
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
    }
    private AbstractActivity tipoAttivita(AbstractActivity attivita,int id, Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String tipoAttivita){
        
        if(tipoAttivita.equals("Planned")){
            PlannedBuilder builder= new PlannedBuilder();
            builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
            attivita = builder.getResult();
        }else if(tipoAttivita.equals("Unplanned")){
            UnplannedBuilder builder = new UnplannedBuilder();
            builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
            attivita=builder.getResult();
        }else if(tipoAttivita.equals("Extra")){
            ExtraBuilder builder = new ExtraBuilder();
            builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
            attivita=builder.getResult();
        }else{
            EwoBuilder builder = new EwoBuilder();
            builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
            attivita = builder.getResult();
        }
        return attivita;
    }
    public void modifyActivity(AbstractActivity act, Sito sito,String tipologia, String descrizione, int tempo, 
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura,String tipoAttivita){
        
        int res;
        AbstractActivity expResult = act;
        Comunicatore com;
        
        try {    
            com= new Comunicatore();
            com.apri();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("office",sito.getOffice());
            mappa.put("area",sito.getArea());
            mappa.put("tipologia",tipologia);
            mappa.put("descrizione",descrizione);
            mappa.put("tempo",tempo);
            mappa.put("week",week);
            mappa.put("interrompibile",interrompibile);
            mappa.put("pianificazione",tipoAttivita);
            HashMap<String,Object> mappa2= new HashMap<>();
            mappa2.put("aid",act.getId());
            
            res=com.updateQuery("Attivita", mappa,mappa2);
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
        //AbstractActivity result=
    }    
    public void deleteActivity(AbstractActivity act){
        Comunicatore com;
        try{
            com=new Comunicatore();
            com.apri();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("aid",act.getId());
            com.deleteQuery("Attivita", mappa);
            com.chiudi();
        }catch(SQLException ex){
            System.out.println("Non mi sono connesso al DB");
        }
    }
    
            /*
        smp deve essere binary ma è una stringa
        getCompetenze non implementato
    */
    private Procedure getProcedure(String nome){
        String tableProc="procedura";
        ArrayList<String> colonneProc=new ArrayList<>();
        HashMap<String,Object> doveProc=new HashMap<>();
        colonneProc.add("nomefile");
        colonneProc.add("smp");
        doveProc.put("nomefile",nome);
        Comunicatore com=null;
        Procedure proc=null;
        try {
            com=new Comunicatore();
            com.apri();
            ResultSet set= com.selectionQuery(tableProc, colonneProc, doveProc);
            while(set.next()){
                String nomefile=set.getString("nomefile");
                String smp=set.getString("smp");
                proc=new Procedure(null, null, nomefile);
            }
            
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
        return proc;
    }
    
    private List<String> getMateriali(int id){
        List<String> res=new ArrayList<>();
        String tableAttMat="attivita_materiale";
        ArrayList<String> colonneAttMat=new ArrayList<>();
        HashMap<String,Object> doveAttMat=new HashMap<>();
        
        colonneAttMat.add("maid");
        colonneAttMat.add("materiale");
        doveAttMat.put("maid", id);
        
        Comunicatore com=null;
        
        try {
            com=new Comunicatore();
            com.apri();
            ResultSet set= com.selectionQuery(tableAttMat, colonneAttMat, doveAttMat);
            while(set.next()){
                int maid=set.getInt("maid");
                String materiale=set.getString("materiale");
                res.add(materiale);
            }
            
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
        return res;
    }
    
    public ArrayList<AbstractActivity> viewActivities(){
        ArrayList<AbstractActivity> res=new ArrayList<>();
        String tableAtt="Attivita";
        ArrayList<String> colonneAtt= new ArrayList<>();
        HashMap<String,Object> doveAtt= null;
        
        colonneAtt.add("aid");
        colonneAtt.add("office");
        colonneAtt.add("area");
        colonneAtt.add("nomefile");
        colonneAtt.add("tipologia");
        colonneAtt.add("descrizione");
        colonneAtt.add("tempo");
        colonneAtt.add("week");
        colonneAtt.add("interrompibile");
        colonneAtt.add("ewoid");
        colonneAtt.add("pianificazione");
        
        Comunicatore com;
        try {
            com=new Comunicatore();
            com.apri();
            ResultSet set=com.selectionQuery(tableAtt, colonneAtt, doveAtt);
            while(set.next()){
                int id=set.getInt("id");
                String office=set.getString("office");
                String area=set.getString("area");
                Sito s=new Sito(office, area);
                String nomefile=set.getString("nomefile");
                String tipologia=set.getString("tipologia");
                String descrizione=set.getString("descrizione");
                int tempo=set.getInt("tempo");
                int week=set.getInt("week");
                boolean interrompibile=set.getBoolean("interrompibile");
                int ewoid=set.getInt("ewoid");
                String pianificazione=set.getString("pianificazione");
                List<String> materiali=getMateriali(id);
                Procedure procedura=getProcedure(nomefile);
                
                AbstractActivity attivita=null;
                AbstractActivity act=tipoAttivita(attivita, id, s, tipologia, 
                        descrizione, tempo, materiali, week, interrompibile, 
                        procedura, pianificazione);
                res.add(act);
            }
            
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
        ArrayList<AbstractActivity> a= new ArrayList<>();
        
        return a;
    }
    
    public void viewEWO() {
        
    }
    public ArrayList<AbstractActivity> sortedActivities(){
        Calendar c=Calendar.getInstance();
        java.util.Date d= new java.util.Date();
        c.setTime(d);
        System.out.println(Calendar.WEEK_OF_YEAR);
        ArrayList<AbstractActivity> activities = this.viewActivities();
        
        activities.stream()
                .filter(b->b.getWeek() == c.get(Calendar.WEEK_OF_YEAR));
        activities.stream()
                .sorted();
        return activities;
        
    }
    
    public HashMap maintainerAval(Maintainer man, int giorno){
        
        Comunicatore com;
        HashMap<Integer,Integer> map =new HashMap<>();
        HashMap<String,Object> mappadove =new HashMap<>();
        mappadove.put("maintainer",man.getId());
        mappadove.put("giorno", giorno);
        ArrayList<String> array =new ArrayList<>();
        try {    
            com= new Comunicatore();
            com.apri();
            int index;
            ResultSet rs= com.selectionQuery("orari", null, mappadove);
            while(rs.next()){
                
                map.put(index=rs.findColumn("o8_9"), rs.getInt(index));
                map.put(index=rs.findColumn("o9_10"), rs.getInt(index));
                map.put(index=rs.findColumn("o10_11"), rs.getInt(index));
                map.put(index=rs.findColumn("o11_12"), rs.getInt(index));
                map.put(index=rs.findColumn("o14_15"), rs.getInt(index));
                map.put(index=rs.findColumn("o15_16"), rs.getInt(index));
                map.put(index=rs.findColumn("o16_17"), rs.getInt(index));
            }
            
           
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println("Non mi sono connesso al DB");
        }
        
        
        return map;
    }
    
    public void maintainerAvalPerc(Maintainer man){
        
    }
    
    @Override
    public String toString() {
        return super.toString()+"Planner";
    }        
            
            
    
}
