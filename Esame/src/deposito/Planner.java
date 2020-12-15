/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import factories.*;
import java.lang.reflect.*;
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
       //Se non c'è abbastanza tempo nell'orario scelto allora si va a prendere automaticamente il tempo restante nella casella dopo(si fa solo per due caselle vicine)
       Comunicatore com = Comunicatore.getInstance();
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
            
            array=this.disponibilitaAttuale(mappaWhere);
            if(array == null){
                return -1;
            }
            arr=this.modificaDisponibilita(array, tempoIntervento, orario);
            if(arr == null){
                return -1;
            }
            //IL CONTROLLO LO FACCIO SOLO PER DUE ORARI VICINO
            com.apri();
            com.insertQuery("pianificazione", tempMap);
            com.chiudi();
            this.aggiornaDisponibilita(arr, mappaWhere);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return 1;
    }
    
    
    /**
     * Assegna un manutentore ad una attività EWO, con i dovuti status associati
     * @param man Il manutentore che deve fare l'ewo
     * @param act L'attività da assegnare, ne modifico gli stati
     * @param giorno tra 1 e 5 indica la giornata (da lun a ven)
     * @param orario String che indica l'orario in formato "oxx_xx"
     * @return
     */
    public int assegnaManEWO(Maintainer man, EwoActivity act,int giorno,String orario){
        act.setManStatus(EwoActivity.MaintainerState.sent);
        act.setAreaStatus(EwoActivity.AreaState.sent);
        act.setGeneralStatus(EwoActivity.GeneralState.inProgress);
        int res=assegnaMan(man, act, giorno, orario);
        Comunicatore com=Comunicatore.getInstance();
        String tabAttivita="attivita";
        HashMap<String,Object> paramsAtt=new HashMap<>();
        paramsAtt.put("manstate", act.getManStatus().getString());
        paramsAtt.put("depstate", act.getAreaStatus().getString());
        paramsAtt.put("genstate", act.getGeneralStatus().getString());
        HashMap<String,Object> chiaviAtt=new HashMap<>();
        chiaviAtt.put("aid",act.getId());
        try {
            com.apri();
            com.updateQuery(tabAttivita, paramsAtt, chiaviAtt);
            com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        
        return res;
    }
    private ArrayList modificaDisponibilita(ArrayList<Integer> array,int tempoIntervento,String orario){
        int temp,i,j=0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr=this.sceltaOrario(orario);
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
            return null;
        }
        
        return array;
    }
    
    private ArrayList disponibilitaAttuale(HashMap<String,Object> mappa){
            Comunicatore com = Comunicatore.getInstance();
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
            com.chiudi();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
    }
        return array;
    }
    
    private void aggiornaDisponibilita(ArrayList<Integer> array,HashMap<String,Object> mappa){
        try {
            Comunicatore com = Comunicatore.getInstance();
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
    
    private ArrayList sceltaOrario(String orario){
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
    
    public ArrayList<EwoActivity> viewEwo(){
        //select all fromm attivita where ewoid is not null
        
        Comunicatore com = Comunicatore.getInstance();
        ArrayList<EwoActivity> archivio= new ArrayList<>();
        ResultSet rs;
        int ewoid, aid, tempo, week;
        Sito site;
        String tipologia, descrizione;
        Boolean interrompibile;
        Procedure procedura;
        String wNotes;
        try {
            com.apri();
            rs = com.selectionQuery("attivita", null, null);
            com.chiudi();
            while(rs.next()){
                ewoid=rs.getInt("ewoid");
                if(ewoid!=0){
                    aid=rs.getInt("aid");
                    site=new Sito(rs.getString("office"), rs.getString("area"));
                    procedura=this.getProcedure(rs.getString("nomefile"));
                    tipologia=rs.getString("tipologia");
                    descrizione=rs.getString("descrizione");
                    tempo=rs.getInt("tempo");
                    week=rs.getInt("week");
                    interrompibile=rs.getBoolean("interrompibile");
                    wNotes=rs.getString("wnotes");
                    String depstate = rs.getString("depstate");
                    String manstate = rs.getString("manstate");
                    String genstate = rs.getString("genstate");
                    EwoActivity res=new EwoActivity(ewoid, aid, site, tipologia, descrizione, tempo, this.getMateriali(aid), week, interrompibile, procedura,wNotes);
                        if(depstate!=null){
                        res.setAreaStatus(EwoActivity.AreaState.valueOf(depstate));
                        res.setManStatus(EwoActivity.MaintainerState.valueOf(manstate));
                        res.setGeneralStatus(EwoActivity.GeneralState.valueOf(genstate));
                    }
                    archivio.add(res);
                }
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return archivio;
    }
    
    /*Crea un attività e restituisce l'attività creata altrimenti ritorna null*/
    public AbstractActivity createActivity(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, List<String> competenze,Boolean interrompibile, 
            Procedure procedura,String wNotes,String tipoattivita){ //tipoAttivita puo essere scelto solo da valori preimpostati quindi sull'interfaccia grafica da checkbox per esempio 
        
        int res;
        
        AbstractActivity attivita=this.tipoAttivita(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura, wNotes,tipoattivita);
        //BISOGNA GESTIRE IL FATTO DEI MATERIALI
        Comunicatore com;    
        try {    
            com= Comunicatore.getInstance();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("aid",attivita.getId());
            mappa.put("office",attivita.getSito().getOffice());
            mappa.put("area",attivita.getSito().getArea());
            mappa.put("tipologia",attivita.getTipologia());
            mappa.put("descrizione",attivita.getDescrizione());
            mappa.put("tempo",attivita.getTempo());
            mappa.put("week",attivita.getWeek());
            mappa.put("interrompibile",attivita.getInterrompibile());
            mappa.put("pianificazione",tipoattivita);
            mappa.put("wnotes",wNotes);
            mappa.put("nomefile",attivita.getProcedura().getNomefile());
            if(tipoattivita.equals("Ewo")){
                EwoActivity a = (EwoActivity)attivita;
                mappa.put("ewoid",a.getEwoID());
            }
            com.apri();
            res= com.insertQuery("Attivita", mappa);
            com.chiudi();
            mappa.clear();
            for(int i = 0; i<attivita.getMateriali().size() ; i++){
                mappa.put("maid", attivita.getId());
                mappa.put("materiale",attivita.getMateriali().get(i));
                com.apri();
                com.insertQuery("attivita_materiale", mappa);
                com.chiudi();
            }
            mappa.clear();
            for(int i = 0; i<competenze.size();i++){
                mappa.put("attivita", attivita.getId());
                mappa.put("competenza",competenze.get(i));
                com.apri();
                com.insertQuery("attivita_competenze", mappa);
                com.chiudi();
            }            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        attivita.setCompetenze(competenze);
        return attivita;
    }
    private AbstractActivity vistaAttivita(int id,int ewoid,Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String tipoAttivita,String wNotes){
        AbstractActivity attivita = null;
        if(tipoAttivita.equals("Planned")){
            attivita=new PlannedActivity(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        }else if(tipoAttivita.equals("Unplanned")){
            attivita=new UnplannedActivity(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        }else if(tipoAttivita.equals("Extra")){
            attivita=new ExtraActivity(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        }else if(tipoAttivita.equals("Ewo")) {
            attivita=new EwoActivity(ewoid, id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        }
        return attivita;
    }
    
    
    /*--------------------------------------------*/
    /*Crea l'attività in base al suo tipo se non riesce a fare almeno una delle condizioni ritorna null*/
    private AbstractActivity tipoAttivita(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String wNotes,String tipoAttivita){
            AbstractActivity attivita = null;
            
        if(tipoAttivita.equals("Planned")){
            attivita = this.createPlanned(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
            return attivita;
        }else if(tipoAttivita.equals("Unplanned")){
            attivita = this.createUnplanned(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
            return attivita;
        }else if(tipoAttivita.equals("Extra")){
            attivita = this.createExtra(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
            return attivita;
        }else if(tipoAttivita.equals("Ewo")){
            attivita = this.createEWO(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
            return attivita;
        }else
            return attivita;
        
    }
    
    /*--------------------------------------------*/
    private PlannedActivity createPlanned(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String wNotes){
        
        PlannedBuilder builder = new PlannedBuilder();
        builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        PlannedActivity attivita = builder.getResult();
        return attivita;
    }
    private UnplannedActivity createUnplanned(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String wNotes){
        
        UnplannedBuilder builder = new UnplannedBuilder();
        builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        UnplannedActivity attivita = builder.getResult();
        return attivita;
    }
    private ExtraActivity createExtra(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String wNotes){
        
        ExtraBuilder builder = new ExtraBuilder();
        builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        ExtraActivity attivita = builder.getResult();
        return attivita;
    }
    private EwoActivity createEWO(Sito sito,String tipologia,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura,String wNotes){
        
        EwoBuilder builder = new EwoBuilder();
        builder.reset(sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        EwoActivity attivita = builder.getResult();
        return attivita;
    }
    
    /*--------------------------------------------*/
    
    /*Ritorna l'attività modificata oppure ritorna il valore null*/
    public AbstractActivity modifyActivity(AbstractActivity act, String wnotes){
        
        int res;
        Comunicatore com;
        
        try {    
            com= Comunicatore.getInstance();
            
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("wnotes", wnotes);
            
            HashMap<String,Object> mappa2= new HashMap<>();
            mappa2.put("aid",act.getId());
            
            com.apri();
            res=com.updateQuery("Attivita", mappa,mappa2);
            com.chiudi();
            act.setWnotes(wnotes);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return act;
        
    }    
    
    /*Ritorna l'attività eliminata oppure null*/
    public AbstractActivity deleteActivity(AbstractActivity act){
        Comunicatore com;
        int id = act.getId();
        try{
            com=Comunicatore.getInstance();
            com.apri();
            HashMap<String,Object> mappa= new HashMap<>();
            mappa.put("maid",id);
            com.deleteQuery("attivita_materiale", mappa);
            mappa.clear();
            mappa.put("attivita", id);
            com.deleteQuery("attivita_competenze", mappa);
            mappa.clear();
            mappa.put("aid",id);
            com.deleteQuery("Attivita", mappa);
            com.chiudi();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return act;
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
            com=Comunicatore.getInstance();
            com.apri();
            ResultSet set= com.selectionQuery(tableProc, colonneProc, doveProc);
            com.chiudi();
            while(set.next()){
                String nomefile=set.getString("nomefile");
                String smp=set.getString("smp");
                proc=new Procedure(smp, nomefile);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        return proc;
    }
    
    //restituisce i materiali di una certa attività
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
            com=Comunicatore.getInstance();
            com.apri();
            ResultSet set= com.selectionQuery(tableAttMat, colonneAttMat, doveAttMat);
            com.chiudi();
            while(set.next()){
                int maid=set.getInt("maid");
                String materiale=set.getString("materiale");
                res.add(materiale);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        return res;
    }
    //restituisce le competenze di una certa attività
    private List<String> getCompetenze(int id){
        List<String> res = new ArrayList<>();
        String table = "attivita_competenze";
        ArrayList<String> col = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        Comunicatore com=Comunicatore.getInstance();
        
        col.add("competenza");
        col.add("attivita");
        map.put("attivita", id);
        
        try{
            com.apri();
            ResultSet set = com.selectionQuery(table, col, map);
            com.chiudi();
            while(set.next()){
                int attivita=set.getInt("attivita");
                String skill = set.getString("competenza");
                res.add(skill);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
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
        colonneAtt.add("wnotes");
        
        Comunicatore com;
        try {
            com=Comunicatore.getInstance();
            com.apri();
            ResultSet set=com.selectionQuery(tableAtt, colonneAtt, doveAtt);
            com.chiudi();
            
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
                String wNotes=set.getString("wnotes");
                //com.chiudi();
                
                List<String> materiali=getMateriali(id);
                Procedure procedura=getProcedure(nomefile);
                List<String> competenze = getCompetenze(id);
                /*
                if(materiali==null ){
                    return null;
                }*/
                AbstractActivity act=vistaAttivita(id, ewoid, s, tipologia, 
                        descrizione, tempo, materiali, week, interrompibile, 
                        procedura, pianificazione,wNotes);
                act.setCompetenze(competenze);
                
                res.add(act);
                
                //com=new Comunicatore();
                //com.apri();
            }
            //com.chiudi();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
       
        return res;
    }
    
    // restituisce un null nel caso in cui non ci sia niente nella tabella attività.
    public ArrayList<AbstractActivity> sortedActivities(){
        Calendar c=Calendar.getInstance();
        java.util.Date d= new java.util.Date();
        c.setTime(d);
        ArrayList<AbstractActivity> activities = this.viewActivities();
        if(activities == null){
            return null;
        }
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
            com= Comunicatore.getInstance();
            int index;
            com.apri();
            ResultSet rs= com.selectionQuery("orari", null, mappadove);
            com.chiudi();
            while(rs.next()){
                
                map.put(index=rs.findColumn("o8_9"), rs.getInt(index));
                map.put(index=rs.findColumn("o9_10"), rs.getInt(index));
                map.put(index=rs.findColumn("o10_11"), rs.getInt(index));
                map.put(index=rs.findColumn("o11_12"), rs.getInt(index));
                map.put(index=rs.findColumn("o14_15"), rs.getInt(index));
                map.put(index=rs.findColumn("o15_16"), rs.getInt(index));
                map.put(index=rs.findColumn("o16_17"), rs.getInt(index));
            }

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        
        return map;
    }
    
    public ArrayList maintainerAvalPerc(Maintainer man){
        int j=0;
        ArrayList <Integer> array=new ArrayList<>();
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
        Comunicatore com=Comunicatore.getInstance();
        for (int i=1; i<=5;i++){
            HashMap <String,String> map=new HashMap<>();
            dove.put("giorno", i);
            dove.put("maintainer", man.getId());
            try{
                com.apri();
                
                result=com.selectionQuery("orari", colonne, dove);
                while(result.next()){
                    j=(100*(result.getInt("o8_9")))/60;
                    map.put("o8_9", Integer.toString(j));
                    j=(100*(result.getInt("o9_10")))/60;
                    map.put("o9_10", Integer.toString(j));
                    j=(100*(result.getInt("o10_11")))/60;
                    map.put("o10_11", Integer.toString(j));
                    j=(100*(result.getInt("o11_12")))/60;
                    map.put("o11_12", Integer.toString(j));
                    j=(100*(result.getInt("o14_15")))/60;
                    map.put("o14_15", Integer.toString(j));
                    j=(100*(result.getInt("o15_16")))/60;
                    map.put("o15_16", Integer.toString(j));
                    j=(100*(result.getInt("o16_17")))/60;
                    map.put("o16_17", Integer.toString(j));
                }
                
                array.add(this.dayPerc(map));
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
    /*
    private void stampaPercentuali(ArrayList<HashMap> a){
        int j=1;
        HashMap <String,Object> map=new HashMap<>();
        for (int i=0; i<a.size(); i++){
            map=a.get(i);
            System.out.println("Giorno"+j+"="+map.toString());
            j++;
        }
    }
    */
    @Override
    public String toString() {
        return super.toString()+"Planner";
    }        
            
    public ArrayList<Maintainer> viewMaintainer(){
        ArrayList<Maintainer> elenco=new ArrayList<>();
        Comunicatore com=Comunicatore.getInstance();
        String nome;
        String username;
        String pass;
        String email;
        int id;
        Set<String> s = new HashSet<>();
        try{
            com.apri();
            ResultSet rs=com.selectionQuery("Maintainer", null, null);
            com.chiudi();
            while(rs.next()){
                nome=rs.getString("nome");
                username=rs.getString("username");
                pass=rs.getString("pass");
                email=rs.getString("email");
                id=rs.getInt("mid");
                s=this.skillManutentore(id);
                elenco.add(new Maintainer(username,pass,nome,email,id,s,null));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        
        return elenco;
    }        
    

    private int dayPerc(HashMap<String,String> mappa){
        int media = 0;
        for(String str : mappa.keySet()){
            media+=Integer.parseInt(mappa.get(str));
        }
        return media/mappa.size();
    }
    
    //restituisce una mappa che contiene gli Ewo contenuti in pianificazione, con il corrispondente giorno
    public HashMap<EwoActivity,Integer> plannedEwo (){
        Comunicatore com = Comunicatore.getInstance();
        ArrayList<String> colonne = new ArrayList<>();
        colonne.add("pid");
        colonne.add("giorno");
        ArrayList<Integer> giorni = new ArrayList<>();
        ArrayList<EwoActivity> archivio;
        ArrayList<Integer> id = new ArrayList<>();
        HashMap<EwoActivity, Integer> res = new HashMap<>();
        try{
            com.apri();
            ResultSet set = com.selectionQuery("pianificazione", colonne, null);
            com.chiudi();
            
            while(set.next()){
                giorni.add(set.getInt("giorno"));
                id.add(set.getInt("pid"));
            }
            
            archivio=this.viewEwo();
            for(int i =0; i<giorni.size(); i++){
               for(int j=0; j<archivio.size(); j++){
                   if(archivio.get(j).getId()==id.get(i)){
                       res.put(archivio.get(j), giorni.get(i));
                   }
               }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return res;
    }
    
     private Set<String> skillManutentore(int id){
        Comunicatore com = Comunicatore.getInstance();
        Set<String> skill = new HashSet<>();
        HashMap<String,Object> dove = new HashMap<>();
        dove.put("mid", id);
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("maintainer_competenze", null, dove);
            com.chiudi();
            while(rs.next()){
                skill.add(rs.getString("competenza"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return skill;
    }
     
    //restituisce una lista contenente tutte le tipologie del database 
    public List<String> listaTipologia(){
        List<String> tipologie = new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("tipologia",null, null);
            com.chiudi();
            
            while(rs.next()){
                tipologie.add(rs.getString("tipologia"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
       return tipologie; 
    } 
    
    //restituisce una lista di tutti i materiali presenti nel database
    public List<String> listaMateriali(){
        List<String> materiali = new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("materiali", null, null);
            com.chiudi();
            while(rs.next()){
                materiali.add(rs.getString("materiale"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }
        return materiali;
    }
    
    //restituisce una lista di tutte le competenze presenti nella base di dati
    public List<String> listaCompetenze(){
        List<String> competenze = new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("competenze", null, null);
            com.chiudi();
            while(rs.next()){
                competenze.add(rs.getString("competenza"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return competenze;
    }
    
    //Restituisce tutti i siti contenuti nel database
    public List<String> listaSito(){
        List<String> sito = new ArrayList<>();
        Comunicatore com = Comunicatore.getInstance();
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("Sito", null, null);
            com.chiudi();
            while(rs.next()){
                sito.add(rs.getString("office")+"-"+rs.getString("area"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return sito;
    }
    
}