/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.List;

/**
 *
 * @author Luigi
 */
public class EwoActivity extends UnplannedActivity{
    
    public EwoActivity(int id, Sito sito, String tipologia, String descrizione, int tempo, List<String> materiali, int week, Boolean interrompibile, Procedure procedura) {
        super(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
    }
    
}
