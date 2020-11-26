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
public class PlannedFactory extends ActivityFactory{
    public PlannedActivity build(Sito sito, String tipologia, String descrizione, int tempo, 
            List<String> materiali, int week, Boolean interrompibile, Procedure procedura){
            IdActivity generatore = IdActivity.getIstance();
            int id= generatore.getId();
            PlannedActivity pa= new PlannedActivity(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura);
            return pa;
    }
}
