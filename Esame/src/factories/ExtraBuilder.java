/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;
import deposito.ExtraActivity;
import deposito.Procedure;
import deposito.Sito;
import java.util.List;
/**
 *
 * @author cosimocorbisiero
 */
public class ExtraBuilder extends ActivityBuilder{
    private ExtraActivity result;
    
    public void reset(Sito sito,String tipologia,String descrizione, int tempo,List<String> materiali,int week,
            Boolean interrompibile, Procedure procedura){
        IdActivity generatore = IdActivity.getIstance();
        int id = generatore.getId();
        this.result = new ExtraActivity(id,sito,tipologia,tempo,materiali,week,interrompibile,procedura);
    }
    
    public ExtraActivity getResult(){
        return this.result;
    }

   
}
