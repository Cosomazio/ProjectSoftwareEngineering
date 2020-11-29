/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;
import deposito.PlannedActivity;
import deposito.Sito;
import deposito.Procedure;
import java.util.*;
/**
 *
 * @author cosimocorbisiero
 */
public class PlannedBuilder extends ActivityBuilder{
    private PlannedActivity result;
    
    public void reset(Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura){
        IdActivity generatore = IdActivity.getInstance();
        int id=generatore.getId();
        
        this.result=new PlannedActivity(id,sito,tipologia,descrizione,tempo,materiali,week, interrompibile, procedura);
        
    }
    
    public PlannedActivity getResult(){
        return this.result;
    }
}
