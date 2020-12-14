/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import factories.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cosimocorbisiero
 */
public class SystemAdministrator extends AbstractUtente {
    
    public SystemAdministrator(String username,String password,String nome,String email,int id){
        super(username,password,nome,email,id);
    }
    //creazione del maintainer; Se va in errore ritorna null,  altrimenti il maintainer creato
    public Maintainer createMaintainer(String username, String password, String nome, String email){
        
        MaintainerBuilder builder= new MaintainerBuilder();
        builder.reset(nome, username, password, email);
        Maintainer m=builder.getInstance();
        Comunicatore com=Comunicatore.getInstance();
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
            return null;
        }
        try{
          com.insertQuery("maintainer", map); 
          com.chiudi();
          int i = this.inserisciOrari(m.getId());
          if(i==-1){
              System.out.println("Errore nell'inserimento degli orari nel DB");
              return null;
          }
        }catch(SQLException ex2){
          System.out.println(ex2.getMessage());
          return null;  
        }
       
        
        return m;
                 
    }
    //crea la tabella orari per l'apposito maintainer, ritorna 1 se va a buon fine altrimenti -1
    private int inserisciOrari(int id){
        HashMap<String,Object> mappa = new HashMap<>();
        Comunicatore com = Comunicatore.getInstance();
        
        try {
            
        
        for(int i = 1 ;i<=5;i++){
            mappa.put("o8_9", 60);
            mappa.put("o9_10", 60);
            mappa.put("o10_11", 60);
            mappa.put("o11_12", 60);
            mappa.put("o14_15", 60);
            mappa.put("o15_16", 60);
            mappa.put("o16_17", 60);
            mappa.put("maintainer", id);
            mappa.put("giorno", i);
            
            com.apri();
            com.insertQuery("orari", mappa);
            mappa.clear();
            com.chiudi();
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
            }   
        return 1;
    }
    //modifica il maintainer; ritorna null se va in errore altrimenti ritorna il maintainer modificato 
    public Maintainer modificaMaintainer(Maintainer man, String username, String password, String nome,
            String email, Set<String> skill, Set<Procedure> procedure){
        
        man.setEmail(email);
        man.setNome(nome);
        man.setPassword(password);
        man.setProcedure(procedure);
        //le skill del maintainer sono modificate nel metodo addskill
        man.setUsername(username);
        
        int l=modificaTabellaMaintainer(man);
        if (l==-1){
            System.out.println("Errore nella modifica del maintainer");
            return null;
        }
        
        man=addSkill(man,skill);
        if (man==null){
            System.out.println("Errore nell'inserimento delle competenze");
            return null;
        }
        
        int f=inserisciProcedura(man,procedure);
        
        if (f==-1){
            System.out.println("Errore nell'inserimento della procedura");
            return null;
        }
        
        return man;
    }
    //modifica il maintainer nel DB ritorna 1 se va a buon fine altrimenti -1
    private int modificaTabellaMaintainer (Maintainer man){
        Comunicatore com= Comunicatore.getInstance(); 
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
            return -1;
        }
        try{
          com.updateQuery("maintainer", value, chiavi);  
        }catch(SQLException ex2){
            System.out.println(ex2.getMessage());  
            return -1;
        }
        try{
           com.chiudi(); 
        }catch(SQLException ex3){
            System.out.println(ex3.getMessage());
            return -1;
        }
        return 1;
    }
    
    //inserisce le competenze per l'apposito Maintainer, restituisce il maintainer modificato se va a buon fine altirmenti null
    public Maintainer addSkill(Maintainer man, Set<String> skill){
        if(skill==null){
            skill=new HashSet<>();
            man.setSkill(null);
        }else{
        man.setSkill(skill);
        }
        
        
        Comunicatore com=Comunicatore.getInstance();
        Iterator iter= skill.iterator();
        HashMap <String, Object> skills=new HashMap<>();
        String sk;
        while(iter.hasNext()){
            sk = (String) iter.next();
            skills.put("mid",man.getId());
            skills.put("competenza", sk);
            try{
            com.apri();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                return null;
            }
            try{
                com.insertQuery("maintainer_competenze", skills);
            }catch(SQLException ex2){
                System.out.println(ex2.getMessage());  
                return null;
            }
            try{
                com.chiudi();
            }catch(SQLException ex3){
                System.out.println(ex3.getMessage());
                return null;
            }
            skills.clear();
        }
        return man;
    }
    
    /**
     * Cancella le skill associate ad un manutentore
     * @param man il manutentore che voglio modificare
     * @param skill le skill da cancellare
     * @return il manutentore modificato se va a buon fine altrimenti null
     */
    public Maintainer deleteSkill(Maintainer man,Set<String> skill){
        Set<String> skillman=new HashSet<>();
        skillman=man.getSkill();
        for (String arr1 : skill) {
            skillman.remove((String) arr1);
        }
        man.setSkill(skillman);
        Iterator iter=skill.iterator();
        Comunicatore com=Comunicatore.getInstance();
        HashMap <String, Object> map=new HashMap<>();
        String sk;
        while(iter.hasNext()){
            sk= (String) iter.next();
            map.put("mid",man.getId());
            map.put("competenza", sk);
            try{
                com.apri();
                com.deleteQuery("maintainer_competenze", map);
                com.chiudi();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }
        
        return man;
    }
    //Restituisce un ArrayList<String> con tutte le skill associate al maintainer se va in errore restituisce null
    public ArrayList<String> viewSkillMan(Maintainer man){
        ArrayList<String> arr=new ArrayList<>();
        HashMap<String,Object> map=new HashMap<>();
        map.put("mid",man.getId());
        Comunicatore com=Comunicatore.getInstance();
        try{
            com.apri();
            ResultSet rs=com.selectionQuery("maintainer_competenze", null, map);
            com.chiudi();
            while (rs.next()){
                arr.add(rs.getString("competenza"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
               
        return arr;
    }
    //inserisce la procedura per l'apposito Maintainer, restiuisce 1 se va a buon fine altrimenti -1
    private int inserisciProcedura(Maintainer man, Set<Procedure> procedure){
        if(procedure==null)
            procedure=new HashSet<Procedure>();
        Comunicatore com=Comunicatore.getInstance();
        Iterator iterpro= procedure.iterator();
        HashMap <String, Object> procedures=new HashMap<>();
        Procedure pr;
        while(iterpro.hasNext()){
            pr = (Procedure) iterpro.next();
            procedures.put("mid",man.getId());
            procedures.put("nomefile", pr.getNomefile());
            try{
                com.apri();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                return -1;
            }
            try{
                com.insertQuery("maintainer_procedura", procedures);
            }catch(SQLException ex1){
                System.out.println(ex1.getMessage());  
                return -1;
            }   
            try{
                com.chiudi();
            }catch(SQLException ex2){
                System.out.println(ex2.getMessage());
                return -1;
            }
            procedures.clear();
        }
        return 1;
    }
    //Cancella il mainteiner, restituisce il maintainer cancellato se è andato a buon fine altrimenti null
    public Maintainer cancellaMaintainer (Maintainer man){
        Comunicatore com=Comunicatore.getInstance();
        ResultSet s;
        HashMap <String,Object> chiavi=new HashMap<>();
        HashMap <String,Object> chiaviora=new HashMap<>();
        chiavi.put("mid",man.getId());
        chiaviora.put("maintainer", man.getId());
        try{
        com.apri();
        com.deleteQuery("maintainer_procedura", chiavi);
        com.chiudi();
        com.apri();
        com.deleteQuery("maintainer_competenze", chiavi);
        com.chiudi();
        com.apri();
        com.deleteQuery("pianificazione", chiaviora);
        com.chiudi();
        com.apri();
        com.deleteQuery("orari", chiaviora);
        com.chiudi();
        com.apri();
        com.deleteQuery("maintainer", chiavi);
        com.chiudi();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return man;
    }
    //Crea il planner, restituisce il planner se andata a buon fine altrimenti null;
    public Planner createPlanner(String username, String password, String nome, String email){
        PlannerBuilder builder= new PlannerBuilder();
        builder.reset(nome, username, password, email);
        Planner p=builder.getResult();
        Comunicatore com= Comunicatore.getInstance();
        
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
            return null;
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
            return null;
        }
        return p;
       
    }
    //Modifica il planner passatoci come parametro, restituisce il planner se è andato a buon fine altrimenti null
    public Planner modificaPlanner(Planner pln,String username, String password, String nome, String email){
        pln.setNome(nome);
        pln.setUsername(username);
        pln.setPassword(password);
        pln.setEmail(email);
        Comunicatore com=Comunicatore.getInstance();
        
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
            return null;
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
            return null;
        }
        return pln;
        
    }
    //cancella il planner passatoci come parametro, ritorna il planner cancellato se va a buon fine altrimenti null
    public Planner cancellaPlanner(Planner pln){
        Comunicatore com= Comunicatore.getInstance();
        HashMap <String,Object> map= new HashMap <>();
        map.put("pid", pln.getId());
        try{
            com.apri();
            com.deleteQuery("planner", map);
            com.chiudi();     
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return pln;
    }
    
    @Override
    public String toString() {
        return super.toString() + "SystemAdministrator{" + '}';
        
    }
    
    public ArrayList<Maintainer> viewMaintainer(){
        Comunicatore com = Comunicatore.getInstance();
        ArrayList<Maintainer> archivio= new ArrayList<>();
        Set<String> skill = new HashSet<>();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("Maintainer",null, null);
            com.chiudi();
            while(rs.next()){
                String nome = rs.getString("nome");
                String username = rs.getString("username");
                String password = rs.getString("pass");
                String email = rs.getString("email");
                int id = rs.getInt("mid");
                
                archivio.add(new Maintainer(username, password, nome, email, id));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return archivio;
        
    }
   
    //restituisce un arrayList di Planner altrimenti ritorna null
    public ArrayList<Planner> viewPlanner(){
        ArrayList<Planner> res=new ArrayList<>();
        String tablePlan="planner";
        HashMap <String,Object> dovePlan=null;
        ArrayList<String> colonnePlan= new ArrayList<>();
        colonnePlan.add("pid");
        colonnePlan.add("username");
        colonnePlan.add("pass");
        colonnePlan.add("nome");
        colonnePlan.add("email");
        
        Comunicatore com= Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet set= com.selectionQuery(tablePlan, colonnePlan, dovePlan);
            while(set.next()){
                int pid=set.getInt("pid");
                String username=set.getString("username");
                String password=set.getString("pass");
                String nome=set.getString("nome");
                String email=set.getString("email");
                Planner newPlan= new Planner(username, password, nome, email, pid);
                res.add(newPlan);
            }
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        
        return res;
    }
    /**
     * Aggiunge una lista di competenze nella tabella competenze
     * @param competenze
     * @return le competenze aggiunte o null se fallisce
     */
    public List<String> createCompetenze(List<String> competenze){
        Comunicatore com=Comunicatore.getInstance();
        int ret=0;
        String tableComp="competenze";
        
        for (String competenza: competenze){
            HashMap <String,Object> mapComp=new HashMap<>();
            mapComp.put("competenza", competenza);
            try {
                com.apri();
                ret = com.insertQuery(tableComp,mapComp);
                com.chiudi();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
        
        return competenze;
    }
    
    /**
     * Cancella una lista di competenze nella tabella competenze
     * @param competenze
     * @return le competenze rimosse o null se fallisce
     */
    public List<String> cancellaCompetenze(List<String> competenze){
        Comunicatore com=Comunicatore.getInstance();
        int ret=0;
        String tableComp="competenze";
        HashMap <String,Object> mapComp=new HashMap<>();
        
        for(String competenza: competenze){
            mapComp.put("competenza",competenza);
        }
        
        try {
            com.apri();
            ret=com.deleteQuery(tableComp, mapComp);
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return  competenze;
    }
    
    /**
     * Mostra la lista di competenze nella tabella competenze
     * @return la lista di competenze
     */
    public List<String> viewCompetenze(){
        Comunicatore com=Comunicatore.getInstance();
        String tableComp="competenze";
        ResultSet res;
        ArrayList<String> colonneComp= new ArrayList<>();
        HashMap<String, Object> doveComp=null;
        colonneComp.add("competenza");
        
        List<String> competenze=new ArrayList<>();
        try {
            com.apri();
            res=com.selectionQuery(tableComp, colonneComp, doveComp);
            com.chiudi();
            while(res.next()){
                competenze.add(res.getString("competenza"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return competenze;
    }
    
    
    
}
