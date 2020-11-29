/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;
import deposito.EwoActivity;
import deposito.Procedure;
import deposito.Sito;
import java.util.List;

/**
 *
 * @author cosimocorbisiero
 */
public class EwoBuilder extends ActivityBuilder {
    public static EwoBuilder istanza = null;
    private static int ewoid=0;
    private EwoActivity result;
    
    public static EwoBuilder getIstance(){
        if(istanza==null){
            istanza= new EwoBuilder();
        }
        return istanza;
    }
    
    public static int getId(){
        return ++ewoid;
    }
    
    @Override
    public void reset(Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura){
        IdActivity generatore = IdActivity.getIstance();
        int id = generatore.getId();
        this.result=new EwoActivity (EwoBuilder.getId(),id,sito,tipologia,descrizione,tempo,materiali,week,interrompibile,procedura);
       
    }
    
    public EwoActivity getResult(){
        return this.result;
    }
    
}
