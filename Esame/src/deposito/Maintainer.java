/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

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
    
    
    
}
