/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.sql.*;
import java.util.*;

/**
 *
 * @author franc
 */

public class Maintainer extends AbstractUtente{
    private Set<String> skill;
    private Set<Procedure> procedure;

    public Maintainer(String username, String password, String nome, String email, int id, Set<String> skill, Set<Procedure> procedure) {
        super(username, password, nome, email, id);
        this.skill = skill;
        this.procedure = procedure;
    }
    
    public Maintainer(String username, String password, String nome, String email, int id){
        super(username, password, nome, email, id);
    }

    public Set<String> getSkill() {
        return skill;
    }

    public void setSkill(Set<String> skill) {
        this.skill = skill;
    }

    public Set<Procedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(Set<Procedure> procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return super.toString() + "Maintainer{" +  "skill=" + skill + ", procedure=" + procedure + '}';
    }
    
    public int doneActivity(EwoActivity act){
        act.setAreaStatus(EwoActivity.AreaState.received);
        act.setManStatus(EwoActivity.MaintainerState.received);
        act.setGeneralStatus(EwoActivity.GeneralState.closed);
        int res=1;
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
    
    public List<EwoActivity> ewoAssegnate(){
        Comunicatore com = Comunicatore.getInstance();
        ArrayList<EwoActivity> archivio = new ArrayList<>();
        ArrayList<String> colonne = new ArrayList<>();
        colonne.add("pid");
        colonne.add("giorno");
        HashMap<String, Object> dove = new HashMap<>();
        dove.put("maintainer", this.getId());
        try {
            com.apri();
            ResultSet rs = com.selectionQuery("pianificazione", colonne, dove);
            com.chiudi();
            
            while(rs.next()){
                int id = rs.getInt("pid");
                dove.clear();
                dove.put("aid", id);
                com.apri();
                ResultSet set = com.selectionQuery("attivita", null, dove);
                com.chiudi();
                
                while(set.next()){
                    int ewoid=set.getInt("ewoid");
                    int aid=id;
                    Sito sito = new Sito(set.getString("office"), set.getString("area"));
                    String tipo = set.getString("tipologia");
                    String descrizione = set.getString("descrizione");
                    Integer tempo = set.getInt("tempo");
                    List<String> materiali = new ArrayList<>();
                    
                    colonne.clear();
                    colonne.add("materiale");
                    dove.clear();
                    dove.put("maid", aid);
                    
                    com.apri();
                    ResultSet mats = com.selectionQuery("attivita_materiale", colonne, dove);
                    com.chiudi();
                    
                    while(mats.next()){
                        materiali.add(mats.getString("materiale"));
                    }
                    
                    Integer week = set.getInt("week");
                    Boolean interrompibile = set.getBoolean("interrompibile");
                    Procedure p = new Procedure(set.getString("nomefile"), "nomefile");
                    String wnotes = set.getString("wnotes");
                    archivio.add(new EwoActivity(ewoid, aid, sito, tipo, descrizione, tempo, materiali, week, interrompibile, p, wnotes));
                    //non setta gli stati dell'EWO siccome, non sono necessari per la mera visualizzazione dell'attività nell'interfaccia
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return archivio;
    }
    
    
}
