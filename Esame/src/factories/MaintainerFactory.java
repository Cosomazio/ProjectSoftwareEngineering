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
public class MaintainerFactory extends UtenteFactory {
    @Override
    protected Maintainer build(String nome,String username, String password,String email){
        IdUtente generatore=IdUtente.getInstance();
        int id= generatore.getNextId();
        Maintainer m= new Maintainer(username,password,nome,email,id);
        return m;
    }
}
