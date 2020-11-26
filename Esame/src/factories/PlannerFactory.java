/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.Planner;

/**
 *
 * @author Luigi
 */
public class PlannerFactory extends UtenteFactory{
    
    protected Planner build(String nome, String username,String password,String email){
        IdUtente generator= IdUtente.getInstance();
        int id=generator.getNextId();
        Planner p=new Planner(nome,username,password,email,id);
        return p;
    }
}
