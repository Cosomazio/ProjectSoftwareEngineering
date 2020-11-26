/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import java.time.*;
import java.util.*;
/**
 *
 * @author tomma
 */
public class Planner extends AbstractUtente {
    public Planner(String username,String password,String nome,String email,int id){
        super(username,password,nome,email,id);
    }
    public void assegnaMan(Maintainer man, InterfaceActivity act){
        
    }
    public void planActivity(InterfaceActivity act){
        
    }
    public void creaEwo(int id, Sito sito ,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura){
        
    }
    public void modificaEWO(EWO ewo, String descrizione,OffsetTime tempo,
            List<String> skills, List<String> materiali){
        
    }
    public void gestisciMateriali(InterfaceActivity act,List<String> materiali){
        
    }
    public void createActivity(int id, Sito sito,String descrizione,int tempo,
            List<String> materiali, int week, Boolean interrompibile, 
            Procedure procedura){
        
    }
    public void modifyActivity(InterfaceActivity act){
        
    }
    public void deleteActivity(InterfaceActivity act){
        
    }
    public void viewActivties(){
        
    }
    public void viewEWO() {
        
    }
    public void sortedActivities(){
        
    }
    public void maintainerAval(Maintainer man, int giorno){
        
    }
    
    public void maintainerAvalPerc(Maintainer man){
        
    }
    
            
            
            
    
}
