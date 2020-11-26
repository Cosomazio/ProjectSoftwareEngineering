/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.SystemAdministrator;

/**
 *
 * @author franc
 */
public class SaFactory extends UtenteFactory{
   public SystemAdministrator build(String nome,String username,String password, String email){
       IdUtente generator= IdUtente.getInstance();
       id=generator.getNextId();
       SystemAdministrator s= new SystemAdministrator(username,password,nome,email,id);
       return s;
   } 
}
