/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.Maintainer;

/**
 *
 * @author franc
 */
public class MaintainerBuilder extends UtenteBuilder {
    
    private Maintainer result;
    
    public void reset(String nome,String username, String password,String email){
        IdUtente generatore=IdUtente.getInstance();
        int id= generatore.getId();
        
        this.result = new Maintainer(nome, username, password, email, id);
    }
    
    public Maintainer getInstance(){
        return this.result;
    }
}
