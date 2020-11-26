/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;
import deposito.AbstractActivity;
import deposito.Procedure;
import deposito.Sito;
import deposito.UnplannedActivity;
import java.util.List;
/**
 *
 * @author cosimocorbisiero
 */
public class UnplannedFactory extends ActivityFactory {
    public UnplannedActivity build(Sito sito, String tipologia, String descrizione, int tempo, 
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura){
            
        IdActivity generatore= IdActivity.getIstance();
        int id= generatore.getId();
        
        UnplannedActivity upa = new UnplannedActivity(id,sito,tipologia,descrizione,tempo,materiali,week,interrompibile,procedura);
        return upa;
    }

}