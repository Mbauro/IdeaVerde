/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
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
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    Cliente c;
    @Before
    public void setUp() {
        c = new Cliente("Antonino","Coppolino","coppolinonino@gmail.com","via doria","3465874412");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNome method, of class Cliente.
     */
    
    @Test
    public void testStampaTessera() {
        System.out.println("stampaTessera");
        
        
        Tessera result = c.stampaTessera(c.getNome(),c.getCognome(),c.getEmail());
        assertEquals(c.getCognome(), result.getCognomeCliente());
        assertEquals(c.getNome(), result.getNomeCliente());
        assertEquals(c.getEmail(), result.getEmailCliente());
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }


    
}
