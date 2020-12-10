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
    
    public abstract void reset(Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura,String wNotes);
    
}
