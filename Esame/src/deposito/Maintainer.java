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
    
    
}
