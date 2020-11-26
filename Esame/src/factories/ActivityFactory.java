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
public abstract class ActivityFactory {
    public Category categoria;
    public ActivityFactory(){
        
    }
    public AbstractActivity make(CategoryActivity categoria, Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura){
        ActivityFactory factory = null;
        switch (categoria) {
            case EWO:
                factory = new EwoFactory();
                break;
            case EXTRA:
                factory = new ExtraFactory();
                break;
            case UNPLANNED:
                factory = new UnplannedFactory();
                break;
            default:
                factory = new PlannedFactory();
                break;
        }
        return factory.build(sito,tipologia,descrizione,tempo,materiali,
                week,interrompibile,procedura);
    }
    protected abstract AbstractActivity build( Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura);
}
