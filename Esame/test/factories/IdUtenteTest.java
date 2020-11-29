/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.util.ArrayList;
import java.util.List;
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
    class IdUtenteGetIstanceRunner implements Runnable { 
        private int i=0;
        private int n=100;
        public IdUtenteGetIstanceRunner(int n){
            this.n=n;
        }
        public IdUtenteGetIstanceRunner(){
            
        }
        @Override
        public void run() { 
            i = 0;
            IdUtente res=null;
            while (i<n) { 
                IdUtente.getInstance();
                /*
                if (res!=null){
                    if (res!=IdUtente.getInstance() ){
                        fail("collisione");
                    }
                }else{
                    res=IdUtente.getInstance();
                }*/
            } 
        } 
    }
    class IdUtenteGetIdRunner implements Runnable { 
        private int i=0;
        private int n=100;
        private IdUtente instance;
        public IdUtenteGetIdRunner(int n,IdUtente instance){
            this.n=n;
            this.instance=instance;
        }
        public IdUtenteGetIdRunner(IdUtente instance){
            this.instance=instance;
        }
        @Override
        public void run() { 
            i = 0;
            IdUtente res=null;
            while (i<n) { 
                int val=instance.getId();
            } 
        } 
    }
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
        // TODO review the generated test code and remove the default call to fail.
        IdUtenteGetIstanceRunner r= new IdUtenteGetIstanceRunner(100000);
        Thread t1 = new Thread (r); 
        Thread t2 = new Thread (r);
        Thread t3 = new Thread (r);
        t1.start();
        t2.start();
        t3.start();
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
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
