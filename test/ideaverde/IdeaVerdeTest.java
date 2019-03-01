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
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author mauro
 */
public class IdeaVerdeTest {
    
    public IdeaVerdeTest() {
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
        //c=new Cliente("Nino","Coppolino","Via Doria","nino@nino.it","333454656");
        IdeaVerde.inserisciTipoPianta("tipo1", "descrizione1", "varieta1");
        IdeaVerde.inserisciCliente("Nino","Coppolino","Via Doria","nino@nino.it","333454656");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserisciCliente method, of class IdeaVerde.
     */
    @Test
    public void testInserisciCliente() {
        System.out.println("inserisciCliente");
        //c = new Cliente("Mauro","Labruna","Via Doria","mauro@mauro.it","3465874412");
        IdeaVerde.inserisciCliente("Mauro","Labruna","Via Doria","mauro@mauro.it","333454656");
        c=IdeaVerde.ricercaCliente("Mauro","Labruna" ,"mauro@mauro.it");
        assertEquals(c.getNome(),"Mauro");
        assertEquals(c.getCognome(),"Labruna");
        assertEquals(c.getIndirizzo(),"Via Doria");
        assertEquals(c.getEmail(),"mauro@mauro.it");
        assertEquals(c.getCellulare(),"333454656");

        
    }

    /**
     * Test of ricercaCliente method, of class IdeaVerde.
     */
    @Test
    public void testRicercaCliente() {
        
        System.out.println("ricercaCliente");
        //Cliente esiste
        String nomeCliente = "Nino";
        String cognomeCliente = "Coppolino";
        String email= "nino@nino.it";
        Cliente expResult = c;
        
        Cliente result = IdeaVerde.ricercaCliente(nomeCliente, cognomeCliente,email);
        assertEquals("Nino", result.getNome());
        assertEquals("Coppolino", result.getCognome());
        assertEquals("nino@nino.it", result.getEmail());
        assertEquals("Via Doria", result.getIndirizzo());
        assertEquals("333454656",result.getCellulare());
        
        System.out.println("Cliente non presente..");
        //Cliente non esiste
        
        Cliente result1 = IdeaVerde.ricercaCliente("iuuu", cognomeCliente,"emailacaso@info.it");
        assertEquals(null, result1);
    }

    /**
     * Test of modificaCliente method, of class IdeaVerde.
     */
    @Test
    public void testModificaCliente() {
        System.out.println("modificaCliente");
       
        
        //Modifica Email             
        String input1 = "1";
        String input2 = "mauro@email.it";
        
        String stringa = input1 +System.lineSeparator()+ input2 + System.lineSeparator();
        
        
        ByteArrayInputStream in = new ByteArrayInputStream(stringa.getBytes());
        System.setIn(in);      
        IdeaVerde.modificaCliente("Nino","Coppolino","nino@nino.it");
        
        assertEquals(IdeaVerde.listaClienti.get(0).getEmail(),input2);
        //Modifica indirizzo
        input1 = "2";
        input2 = "via peculio";
        stringa = input1 +System.lineSeparator()+ input2 + System.lineSeparator();
        
        ByteArrayInputStream in1 = new ByteArrayInputStream(stringa.getBytes());
        System.setIn(in1);      
        IdeaVerde.modificaCliente("Nino","Coppolino","mauro@email.it");
         assertEquals(IdeaVerde.listaClienti.get(0).getIndirizzo(),input2);
         
         //Modifica cellulare
        input1 = "3";
        input2 = "3405297785";
        stringa = input1 +System.lineSeparator()+ input2 + System.lineSeparator();
        
        ByteArrayInputStream in2 = new ByteArrayInputStream(stringa.getBytes());
        System.setIn(in2);      
        IdeaVerde.modificaCliente("Nino","Coppolino","mauro@email.it");
         assertEquals(IdeaVerde.listaClienti.get(0).getCellulare(),input2);
            
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of eliminaCliente method, of class IdeaVerde.
     */
    @Test
    public void testEliminaCliente() {
        System.out.println("eliminaCliente");
        
        
        Cliente tmp=IdeaVerde.ricercaCliente("Nino","Coppolino","nino@nino.it");
        
        IdeaVerde.eliminaCliente("Nino", "Coppolino","nino@nino.it");
        
        assertEquals(IdeaVerde.listaClienti.contains(tmp),false);
        
        
    }

    /**
     * Test of inserisciTipoPianta method, of class IdeaVerde.
     */
    @Test
    public void testInserisciTipoPianta() {
        System.out.println("inserisciTipoPianta");
        String tipo = "tipo1";
        String descrizione = "descrizione1";
        String varieta = "varieta1";
        
        
        assertEquals(IdeaVerde.getCatalogo().getListaTipoPiante().get(0).getTipo(),tipo);
        assertEquals(IdeaVerde.getCatalogo().getListaTipoPiante().get(0).getDescrizione(),descrizione);
        assertEquals(IdeaVerde.getCatalogo().getListaTipoPiante().get(0).getVarietà(),varieta);
        
    }

      
}
