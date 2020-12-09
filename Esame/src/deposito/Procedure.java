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
    private String nomefile;
    private File smp;
    private Set<String> competenze;

    public Procedure(File smp,String nomefile) {
        this.smp = smp;
        this.nomefile=nomefile;
    }

    public Procedure(){
        
    }
    
    public String getNomefile() {
        return nomefile;
    }

    public void setNomefile(String nomefile) {
        this.nomefile = nomefile;
    }
    
    public File getSmp() {
        return smp;
    }

    public void setSmp(File smp) {
        this.smp = smp;
    }    
}
