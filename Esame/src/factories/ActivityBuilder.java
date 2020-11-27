/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import deposito.*;
import java.util.List;

/**
 *
 * @author tomma
 */
public abstract class ActivityBuilder {
    public Category categoria;
    public ActivityBuilder(){
        
    }
    public static AbstractActivity make(CategoryActivity categoria, Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura){
        ActivityBuilder factory = null;
        switch (categoria) {
            case EWO:
                factory = new EwoBuilder();
                break;
            case EXTRA:
                factory = new ExtraBuilder();
                break;
            case UNPLANNED:
                factory = new UnplannedBuilder();
                break;
            default:
                factory = new PlannedBuilder();
                break;
        }
        return factory.build(sito,tipologia,descrizione,tempo,materiali,
                week,interrompibile,procedura);
    }
    protected abstract AbstractActivity build( Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura);
}
