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
public class PlannerBuilder extends UtenteBuilder{
    private Planner result;
    
    public void reset(String nome, String username, String password, String email){
        IdUtente generatore=IdUtente.getInstance();
        int id= generatore.getNextId();
        
        this.result=new Planner(nome,username,password,email,id);
        
    }
    
    public Planner getResult(){
        return this.result;
    }
}
