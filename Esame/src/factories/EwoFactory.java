/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;
import deposito.EwoFactory;

/**
 *
 * @author cosimocorbisiero
 */
public class EwoFactory extends ActivityFactory {
    public static EwoFactory istanza = null;
    private static int id=0;
    
    public static EwoFactory getIstance(){
        if(istanza==null){
            istanza= new EwoFactory();
        }
        return istanza;
    }
    
    public static int getId(){
        return ++id;
    }
}
