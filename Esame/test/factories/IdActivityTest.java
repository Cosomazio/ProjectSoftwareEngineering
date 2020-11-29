/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

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
public class IdActivityTest {
    class IdActivityGetIstanceRunner implements Runnable { 
        private int i=0;
        private int n=100;
        public IdActivityGetIstanceRunner(int n){
            this.n=n;
        }
        public IdActivityGetIstanceRunner(){
            
        }
        @Override
        public void run() { 
            i = 0;
            IdActivity res=null;
            while (i<n) { 
                if (res!=null){
                    if (res!=IdActivity.getInstance() ){
                        fail("collisione");
                    }
                }else{
                    res=IdActivity.getInstance();
                }
            } 
        } 
    }
    class IdActivityGetIdRunner implements Runnable { 
        private int i=0;
        private int n=100;
        public IdActivityGetIdRunner(int n){
            this.n=n;
        }
        public IdActivityGetIdRunner(){
            
        }
        @Override
        public void run() { 
            i = 0;
            IdActivity res=null;
            while (i<n) { 
                if (res!=null){
                    if (res!=IdActivity.getInstance() ){
                        fail("collisione");
                    }
                }else{
                    res=IdActivity.getInstance();
                }
            } 
        } 
    }
    public IdActivityTest() {
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
     * Test of getIstance method, of class IdActivity.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
        IdActivity expResult = IdActivity.getInstance();
        IdActivity result = IdActivity.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        IdActivityGetIstanceRunner r= new IdActivityGetIstanceRunner(100000);
        Thread t1 = new Thread (r); 
        Thread t2 = new Thread (r);
        Thread t3 = new Thread (r);
        t1.start();
        t2.start();
        t3.start();
        
    }

    /**
     * Test of getId method, of class IdActivity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        IdActivity instance=IdActivity.getInstance();
        int expResult = instance.getId();
        int result = instance.getId();
        assertEquals(expResult+1, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
