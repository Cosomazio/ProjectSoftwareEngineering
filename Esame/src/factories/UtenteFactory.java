/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.*;

/**
 *
 * @author franc
 */
public abstract class UtenteFactory {
    
    public static AbstractUtente make(Category ut, String nome, String username, String password,String email){
         UtenteFactory factory = null;
         
        if (ut==Category.PLANNER){
            factory= new SaFactory();
        }
        if (ut == Category.MAINTAINER){
            factory = new MaintainerFactory();
        }
        if (ut == Category.SYSTEMADMINISTRATOR)
            factory = new SaFactory();
                    
        return factory.build(nome, username, password, email);
    }
    
    protected abstract AbstractUtente build(String nome, String username, String password, String email);
}
