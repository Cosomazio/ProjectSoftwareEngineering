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
import java.util.stream.Stream;
import utile.Ora;
/**
 *
 * @author tomma
 */
public class Planner extends AbstractUtente {
    public Planner(String username,String password,String nome,String email,int id){
        super(username,password,nome,email,id);
    }
    
    //il metodo è int solo per farmi restituire qualcosa per il test
    public int assegnaMan(Maintainer man, AbstractActivity act,int giorno,String orario){
       //Se non c'è abbastanza tempo nell'orario scelto allora si va a prendere automaticamente il tempo restante nella casella dopo
       Comunicatore com = new Comunicatore();
       HashMap<String,Object> mappaWhere = new HashMap<>();
       mappaWhere.put("maintainer", man.getId());
       mappaWhere.put("giorno", giorno);
       HashMap<String,Object> tempMap = new HashMap<>();
       tempMap.put("pid", act.getId());
       tempMap.put("giorno", giorno);
       tempMap.put("maintainer",man.getId());
       
       ArrayList<Integer> array = new ArrayList<>();
       ArrayList<Integer> arr = new ArrayList<>();
       int temp,i,j;
       int tempoIntervento = act.getTempo();
        try {
            com.apri();
            array=this.selezione(mappaWhere);
            array=this.tempo(array, tempoIntervento, orario);
            //IL CONTROLLO LO FACCIO SOLO PER DUE ORARI VICINO
            com.insertQuery("pianificazione", tempMap);
            this.aggiorna(array, mappaWhere);
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return 1;
    }
    private ArrayList tempo(ArrayList<Integer> array,int tempoIntervento,String orario){
        int temp,i,j=0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr=this.ora(orario);
        i=arr.get(0);
        j=arr.get(1);
        
        try{
            if(array.get(i) >= tempoIntervento){
                
                temp=array.get(i)-tempoIntervento;
                array.set(i, temp);
            }
            else if(array.get(i) < tempoIntervento && i == 6){
                throw new Exception("Impossibile assegnare attivita, scegli un altro giorno(NON C'È ABBASTANZA TEMPO)");
            }
            else if(array.get(i)<tempoIntervento && (array.get(i)+array.get(j)>=tempoIntervento)){
                tempoIntervento= tempoIntervento - array.get(i);
                array.set(i, 0);               
                temp=array.get(j)-tempoIntervento;
                array.set(j, temp);
            }
            else{
                throw new Exception("Impossibile assegnare attivita, scegli un altro giorno(NON C'È ABBASTANZA TEMPO)");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return array;
    }
    
    private ArrayList selezione(HashMap<String,Object> mappa){
            Comunicatore com = new Comunicatore();
            ArrayList<Integer> array = new ArrayList<>();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("orari" ,null, mappa);
            while(rs.next()){
                
                array.add(rs.getInt("o8_9"));
                array.add(rs.getInt("o9_10"));
                array.add(rs.getInt("o10_11"));
                array.add(rs.getInt("o11_12"));
                array.add(rs.getInt("o14_15"));
                array.add(rs.getInt("o15_16"));
                array.add(rs.getInt("o16_17"));

            }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        return array;
    }
    
    private void aggiorna(ArrayList<Integer> array,HashMap<String,Object> mappa){
        try {
            Comunicatore com = new Comunicatore();
            com.apri();
            HashMap<String,Object> mappaModifica = new HashMap<>();
            mappaModifica.put("o8_9", array.get(0));
            mappaModifica.put("o9_10", array.get(1));
            mappaModifica.put("o10_11", array.get(2));
            mappaModifica.put("o11_12", array.get(3));
            mappaModifica.put("o14_15", array.get(4));
            mappaModifica.put("o15_16", array.get(5));
            mappaModifica.put("o16_17", array.get(6));
            
            com.updateQuery("orari", mappaModifica, mappa);
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private ArrayList ora(String orario){
        int i=0,j=0;
        ArrayList<Integer> array = new ArrayList<>();
        
        
        HashMap<String,Ora> mappa  = new HashMap<>();
        mappa.put("o8_9",new Ora(0,1));
        mappa.put("o9_10",new Ora(1,2));
        mappa.put("o10_11",new Ora(2,3));
        mappa.put("o11_12",new Ora(3,4));
        mappa.put("o14_15",new Ora(4,5));
        mappa.put("o15_16",new Ora(5,6));
        mappa.put("o16_17",new Ora(6,0));
        array.add(mappa.get(orario).getI());
        array.add(mappa.get(orario).getJ());
        return array;
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
    public AbstractActivity createActivity(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String tipoAttivita){ //tipoAttivita puo essere scelto solo da valori preimpostati quindi sull'interfaccia grafica da checkbox per esempio 
        
        int res;
        
        AbstractActivity attivita=null;
        attivita=this.tipoAttivita(attivita, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura, tipoAttivita);
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
            System.out.println(ex.getMessage());
        }
        return attivita;
    }
    private AbstractActivity tipoAttivita(AbstractActivity attivita,Sito sito,String tipologia,String descrizione,int tempo,
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
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura){
        
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
            HashMap<String,Object> mappa2= new HashMap<>();
            mappa2.put("aid",act.getId());
            
            res=com.updateQuery("Attivita", mappa,mappa2);
            
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        //AbstractActivity result=
    }    
    public void deleteActivity(AbstractActivity act){
        Comunicatore com;
        int id = act.getId();
        try{
            com=new Comunicatore();
            com.apri();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("aid",id);
            com.deleteQuery("Attivita", mappa);
            mappa.clear();
            mappa.put("maid",id);
            com.deleteQuery("attivita_materiale", mappa);
            com.chiudi();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
            com.chiudi();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
                int id=set.getInt("aid");
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
                com.chiudi();
                
                List<String> materiali=getMateriali(id);
                Procedure procedura=getProcedure(nomefile);
                AbstractActivity attivita=null;
                AbstractActivity act=tipoAttivita(attivita, s, tipologia, 
                        descrizione, tempo, materiali, week, interrompibile, 
                        procedura, pianificazione);
                act.setId(id);
                //System.out.println("sdg"+act);
                res.add(act);
                com=new Comunicatore();
                com.apri();
            }
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        return res;
    }
    
    public void viewEWO() {
        
    }
    
    public ArrayList<AbstractActivity> sortedActivities(){
        Calendar c=Calendar.getInstance();
        java.util.Date d= new java.util.Date();
        c.setTime(d);
        ArrayList<AbstractActivity> activities = this.viewActivities();
        ArrayList<AbstractActivity> result=new ArrayList<>();
        
        Stream a=activities.stream()
                .filter(b->b.getWeek() == c.get(Calendar.WEEK_OF_YEAR))
                .sorted();
        Iterator<AbstractActivity> i=a.iterator();
        while (i.hasNext()){
            result.add(i.next());
        }
            
        return result;
        
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
            System.out.println(ex.getMessage());
        }
        
        
        return map;
    }
    
    public ArrayList maintainerAvalPerc(Maintainer man){
        int j=0;
        ArrayList <HashMap> array=new ArrayList<>();
        ArrayList <String> colonne=new ArrayList<>();
        HashMap <String,Object> dove= new HashMap<>();
        
        colonne.add("o8_9");
        colonne.add("o9_10");
        colonne.add("o10_11");
        colonne.add("o11_12");
        colonne.add("o14_15");
        colonne.add("o15_16");
        colonne.add("o16_17");
        ResultSet result;
        Comunicatore com= new Comunicatore();
        for (int i=0; i<5;i++){
            HashMap <String,String> map=new HashMap<>();
            dove.put("giorno", i);
            dove.put("maintainer", man.getId());
            try{
                com.apri();
                
                result=com.selectionQuery("orari", colonne, dove);
                while(result.next()){
                    j=(100*(result.getInt("o8_9")))/60;
                    map.put("o8_9", j+"%");
                    j=(100*(result.getInt("o9_10")))/60;
                    map.put("o9_10", j+"%" );
                    j=(100*(result.getInt("o10_11")))/60;
                    map.put("o10_11", j+"%" );
                    j=(100*(result.getInt("o11_12")))/60;
                    map.put("o11_12", j+"%" );
                    j=(100*(result.getInt("o14_15")))/60;
                    map.put("o14_15", j+"%" );
                    j=(100*(result.getInt("o15_16")))/60;
                    map.put("o15_16", j+"%" );
                    j=(100*(result.getInt("o16_17")))/60;
                    map.put("o16_17", j+"%" );
                }
                array.add(map);
                com.chiudi();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                return null;
            }
            dove.clear();
            
        }
        colonne.clear();
        //this.stampaPercentuali(array);
        if(array.isEmpty()){
            return null;
        }
        return array;
    }
    
    /*private void stampaPercentuali(ArrayList<HashMap> a){
        int j=1;
        HashMap <String,Object> map=new HashMap<>();
        for (int i=0; i<a.size(); i++){
            map=a.get(i);
            System.out.println("Giorno"+j+"="+map.toString());
            j++;
        }
    */
    
    @Override
    public String toString() {
        return super.toString()+"Planner";
    }        
            
            
    
}
