/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.List;

/**
 *
 * @author cosimocorbisiero
 */
public class PlannedActivity extends AbstractActivity{
    
    public PlannedActivity(int id, Sito sito, String tipologia, String descrizione, int tempo, List<String> materiali, int week, Boolean interrompibile, Procedure procedura,String wNotes) {
        super(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
    }

    @Override
    public String toString() {
        return super.toString()+"Planned";
    }
    
    
    
    
}
