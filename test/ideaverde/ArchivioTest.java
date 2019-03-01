/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.Observable;
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
public class ArchivioTest {
    
    public ArchivioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Prenotazione p;
    Pianta pianta;
    TipoPianta tp;
    Cliente c;
    Tessera t;
    @Before
    public void setUp() {
        c=new Cliente("nino","coppolino","via c","info@e.it","332456328");
        pianta=new Pianta(2,1300);
        p=new Prenotazione();
        p.setCliente(c);
        p.creaRigaDiOrdine("limone", "varieta", 2000, pianta);
        t=c.stampaTessera("nino","coppolino", "info@e.it");
        t.setPunti(1500);
    }
    
    @After
    public void tearDown() {
    }





    /**
     * Test of update method, of class Archivio.
     */
    @Test
    public void testUpdate() {
        
        System.out.println("update");
        //Observable pianta = null;
        //Object o = null;
        Archivio instance = new Archivio();
        instance.getListaDiPrenotazioni().add(p);
        pianta.setQuantitàDisponibile(pianta.getQuantitàDisponibile()+1000);
        instance.update(pianta, 1001);
        System.out.println("Test: "+instance.getListaDiPrenotazioni());
        assertEquals(true,instance.getListaDiPrenotazioni().isEmpty());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
