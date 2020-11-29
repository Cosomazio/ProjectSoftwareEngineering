/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

/**
 *
 * @author tomma
 */
public class IdActivity {
    private static IdActivity istanza=null;
    private static int id=0;
    
    public synchronized static IdActivity getInstance(){
        if (istanza == null) {
            istanza = new IdActivity();
        }
        return istanza;
    }

    
    private IdActivity(){}
    public synchronized int getId() {
        return ++id;
    }
    
}
