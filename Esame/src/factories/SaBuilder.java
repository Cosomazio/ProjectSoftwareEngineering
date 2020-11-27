/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.AbstractUtente;
import deposito.SystemAdministrator;

/**
 *
 * @author franc
 */
public class SaBuilder extends UtenteBuilder{
    private SystemAdministrator result;
    
    public void  reset( String nome, String username, String password, String email){
        IdUtente generatore= IdUtente.getInstance();
        int id= generatore.getNextId();
        this.result= new SystemAdministrator( nome,username,password, email,id);
    }
    
    public SystemAdministrator getResult(){
        return this.result;
    }
}
