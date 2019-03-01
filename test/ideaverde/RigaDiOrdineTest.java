/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author coppo
 */
public class RigaDiOrdineTest {
    
    public RigaDiOrdineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    RigaDiOrdine ra,rb,rc;
    Pianta p1,p2,p3;
    @Before
    public void setUp() {
        p1=new Pianta(2,100); //10€
        p2=new Pianta(5,100); //15€
        p3=new Pianta(6,100); //25€
        ra=new RigaDiOrdine("limone","varieta",50,p1);
        rb=new RigaDiOrdine("limone","varieta",50,p2);
        rc=new RigaDiOrdine("limone","varieta",50,p3);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testCalcolaSubTotale() {
        System.out.println("calcolaSubTotale");
        ra.calcolaSubTotale();
        rb.calcolaSubTotale();
        rc.calcolaSubTotale();
        
        float expResultRa = 500.0F;
        float expResultRb = 750.0F;
        float expResultRc = 1250.0F;
        
        assertEquals(expResultRa, ra.getSubTotale(), 0.0);
        assertEquals(expResultRb, rb.getSubTotale(), 0.0);
        assertEquals(expResultRc, rc.getSubTotale(), 0.0);
                
    }


    
}
