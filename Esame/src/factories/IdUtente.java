/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

/**
 *
 * @author franc
 */
public class IdUtente {
    private static IdUtente instance;
    
    public synchronized static IdUtente getInstance(){
        if (instance == null)
            instance = new IdUtente();
        
        return instance;
    }
    
    private int id;
    
    private IdUtente(){}
    
    public synchronized int getId(){
        return ++id;
    }
}
