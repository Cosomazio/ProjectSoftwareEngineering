/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.io.File;
import java.util.Set;

/**
 *
 * @author cosimocorbisiero
 */
public class Procedure {
    private File smp;
    private Set<String> competenze;

    public Procedure(File smp, Set<String> competenze) {
        this.smp = smp;
        this.competenze = competenze;
    }

    public Procedure(){
        
    }
    
    public File getSmp() {
        return smp;
    }

    public void setSmp(File smp) {
        this.smp = smp;
    }

    public Set<String> getCompetenze() {
        return competenze;
    }

    public void setCompetenze(Set<String> competenze) {
        this.competenze = competenze;
    }
    
    
}
