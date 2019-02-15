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
    
    @Before
    public void setUp() {
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
        Cliente c = new Cliente("Mauro","Labruna","Via Doria","mauro@mauro.ir","333454656");
        IdeaVerde.inserisciCliente(c);
        assertEquals(c.getNome(),"Mauro");
        assertEquals(c.getCognome(),"Labruna");
        assertEquals(c.getIndirizzo(),"Via Doria");
        assertEquals(c.getEmail(),"mauro@mauro.ir");
        assertEquals(c.getCellulare(),"333454656");

        
    }

    /**
     * Test of ricercaCliente method, of class IdeaVerde.
     */
    @Test
    public void testRicercaCliente() {
        
        System.out.println("ricercaCliente");
        //Cliente esiste
        String nomeCliente = "Mauro";
        String cognomeCliente = "Labruna";
        Cliente expResult = IdeaVerde.listaClienti.get(0);
        
        Cliente result = IdeaVerde.ricercaCliente(nomeCliente, cognomeCliente);
        assertEquals(expResult, result);
        
        //Cliente non esiste
        nomeCliente = "Franco";
        result = IdeaVerde.ricercaCliente(nomeCliente, cognomeCliente);
        assertEquals(null, result);
    }

    /**
     * Test of modificaCliente method, of class IdeaVerde.
     */
    @Test
    public void testModificaCliente() {
        System.out.println("modificaCliente");
        String nome = "Mauro";
        String cognome = "Labruna";
        Cliente c = new Cliente("Mauro","Labruna","Viale Doria","mauro@live.it","333214567");
        IdeaVerde.listaClienti.add(c);
        
                     
        String input1 = "1";
        String input2 = "mauro@email.it";
        
        String stringa = input1 +System.lineSeparator()+ input2 + System.lineSeparator();
        
        
        ByteArrayInputStream in = new ByteArrayInputStream(stringa.getBytes());
        System.setIn(in);      
        IdeaVerde.modificaCliente("Mauro","Labruna");
        
        assertEquals(IdeaVerde.listaClienti.get(0).getEmail(),input2);
        
        
        
        
            
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of eliminaCliente method, of class IdeaVerde.
     */
    @Test
    public void testEliminaCliente() {
        System.out.println("eliminaCliente");
        
        
        Cliente c = new Cliente("NuovoNome","NuovoCognome","Viale Doria","mauro@live.it","333214567");
        IdeaVerde.listaClienti.add(c);
        
        IdeaVerde.eliminaCliente("NuovoNome", "NuovoCognome");
        
        assertEquals(IdeaVerde.listaClienti.contains(c),false);
        
        
    }

    /**
     * Test of inserisciTipoPianta method, of class IdeaVerde.
     */
    @Test
    public void testInserisciTipoPianta() {
        System.out.println("inserisciTipoPianta");
        String tipo = "tipo1";
        String descrizione = "descrizione1";
        String varietà = "varietà1";
        IdeaVerde.inserisciTipoPianta(tipo, descrizione, varietà);
        
        assertEquals(IdeaVerde.listaTipoPiante.get(0).getTipo(),tipo);
        assertEquals(IdeaVerde.listaTipoPiante.get(0).getDescrizione(),descrizione);
        assertEquals(IdeaVerde.listaTipoPiante.get(0).getVarietà(),varietà);
        
    }

      
}
