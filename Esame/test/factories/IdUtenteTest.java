/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomma
 */


public class IdUtenteTest {
    
    public IdUtenteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class IdUtente.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        IdUtente expResult = IdUtente.getInstance();
        IdUtente result = IdUtente.getInstance();
        assertEquals(expResult, result);
        
        int n=1000,parallelThreads=3;
        final IdUtente[] value = new IdUtente[n];
        
        Runnable[] run=new Runnable[parallelThreads];
        Thread[] t=new Thread[parallelThreads];
        
        for (int i=0;i<parallelThreads;i++){
            run[i] = new Runnable() {
                @Override
                public void run(){
                    int k=0;
                    while(k<n){
                        value[k] = IdUtente.getInstance();
                        k++;
                    }
                }
            };
            t[i]=new Thread(run[i]);
            t[i].start();  
        }
        for (int i=0;i<parallelThreads;i++){
            try {
                if(t[i].isAlive()==true){
                    t[i].join();
                }
                
            } catch (InterruptedException ex) {
                fail("errore");
            }
        }
        int i=0;
        while (i<n) { 
            if (value[i]!=null){
                if (value[i]!=IdUtente.getInstance() ){
                    fail("errore");
                }
            }else{
                fail("errore");
            }
            i++;
        } 
        
    }

    /**
     * Test of getNextId method, of class IdUtente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        IdUtente instance = IdUtente.getInstance();
        int expResult = instance.getId();
        int result = instance.getId();
        assertEquals(expResult+1, result);
        
        int n=1000,parallelThreads=3;
        final Integer[][] value = new Integer[parallelThreads][n];
        
        Runnable[] run=new Runnable[parallelThreads];
        Thread[] t=new Thread[parallelThreads];
        
        for (int i=0;i<parallelThreads;i++){
            final int val=i;
            run[i] = new Runnable() {
                @Override
                public void run(){
                    int k=0;
                    while(k<n){
                        value[val][k] = instance.getId();
                        k++;
                    }
                }
            };
            t[i]=new Thread(run[i]);
            t[i].start();  
        }
        for (int i=0;i<parallelThreads;i++){
            try {
                if(t[i].isAlive()==true){
                    t[i].join();
                }
                
            } catch (InterruptedException ex) {
                fail("errore");
            }
        }
        
        for(int i=0;i<parallelThreads;i++) {
            for (int k=0;k<n-1;k++){
                if(value[i][k]>value[i][k+1]){
                    fail("errore");
                }
            }
        } 
        
    }
    
}
