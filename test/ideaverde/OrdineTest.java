/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import ideaverde.spedizione.Spedizione;
import ideaverde.pagamento.Pagamento;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author mauro
 */
public class OrdineTest {
    
    public OrdineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    //Dichiaro gli oggetti che mi interessano
    //Tessera tessera = null;
    Cliente cliente = null;
    Pianta pianta = null;
    RigaDiOrdine r = null;
    Ordine ordine;
    Pagamento pagamento;
    
    @Before
    public void setUp() {
        //Istanzio gli oggetti necessari per i metodi da testare
        cliente =  new Cliente("Mauro","Labruna","mauro@email.it","Viale Doria","3334445567");
        cliente.getTessera().setPunti(1500);
        //(età,quantità_disponibile)
        pianta = new Pianta(2,100);
        //quantità desiderata = 50;
        r = new RigaDiOrdine("Limone","varietà1",50,pianta);
        
        ordine = new Ordine();

        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of creaRigaDiOrdine method, of class Ordine.
     */
    @Test
    public void testCreaRigaDiOrdine() {
        System.out.println("creaRigaDiOrdine");
        String tipo = "";
        String varietà = "";
        int quantità = 0;
        Pianta p = null;
        Ordine instance = new Ordine();
        instance.creaRigaDiOrdine(tipo, varietà, quantità, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotale method, of class Ordine.
     */
    @Test
    public void testGetTotale() {
        System.out.println("getTotale");
        
        float expResult = 500F;
        float result = ordine.getTotale();
        assertEquals(expResult, result, 0.0);
        
    }
    
    @Test
    public void CalcolaTotaleScontato(){
        
        
        //Sconto pagamento in contante = 15% del totale
        //ordine.creaPagamentoContante();
        ordine.creaPagamentoContante();
        ordine.getListaRigheDiOrdine().add(r);
        cliente.getListaDiOrdini().add(ordine);
        ordine.setC(cliente);
        
        ordine.getTotale();
        float expResult = 425.0F;
        float result = ordine.calcolaTotaleScontato();
        assertEquals(expResult,result,0.0);
        
        //Sconto pagamento carta di credito = 0% del totale
        ordine.creaPagamentoCartaDiCredito();
        assertEquals(500,ordine.calcolaTotaleScontato(),0.0);
    }

    /**
     * Test of calcolaScontoTessera method, of class Ordine.
     */
    
//    @Ignore
//    @Test
    
//    public void testCalcolaScontoTessera() {
//        System.out.println("calcolaScontoTessera");
//        int punti = cliente.getTessera().getPunti();
//        System.out.println("Sconto tessera: "+ordine.calcolaScontoTessera()+" %");
//        assertEquals(5.0,ordine.calcolaScontoTessera(),0);
//        
//    }

    /**
     * Test of calcolaScontoPagamento method, of class Ordine.
     */
//    @Test
//    public void testCalcolaScontoPagamento() {
//        System.out.println("calcolaScontoPagamento");
//        
//        System.out.println(ordine.calcolaScontoPagamento());
//        //instance.calcolaScontoPagamento();
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }

    /**
     * Test of getListaRigheDiOrdine method, of class Ordine.
     */
//    @Test
    public void testGetListaRigheDiOrdine() {
        System.out.println("getListaRigheDiOrdine");
        Ordine instance = new Ordine();
        List<RigaDiOrdine> expResult = null;
        List<RigaDiOrdine> result = instance.getListaRigheDiOrdine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPagamento method, of class Ordine.
     */
    @Test
    public void testGetPagamento() {
        System.out.println("getPagamento");
        Ordine instance = new Ordine();
        Pagamento expResult = null;
        Pagamento result = instance.getPagamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpedizione method, of class Ordine.
     */
    @Test
    public void testGetSpedizione() {
        System.out.println("getSpedizione");
        Ordine instance = new Ordine();
        Spedizione expResult = null;
        Spedizione result = instance.getSpedizione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRigheDiOrdine method, of class Ordine.
     */
    @Test
    public void testSetListaRigheDiOrdine() {
        System.out.println("setListaRigheDiOrdine");
        List<RigaDiOrdine> listaRigheDiOrdine = null;
        Ordine instance = new Ordine();
        instance.setListaRigheDiOrdine(listaRigheDiOrdine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPagamento method, of class Ordine.
     */
//    @Test
//    public void testSetPagamento() {
//        System.out.println("setPagamento");
//        String pagamento = "";
//        Ordine instance = new Ordine();
//        instance.setPagamento(pagamento);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setSpedizione method, of class Ordine.
     */
    @Test
    public void testSetSpedizione() {
        System.out.println("setSpedizione");
        String spedizione = "";
        Ordine instance = new Ordine();
        instance.setSpedizione(spedizione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotale method, of class Ordine.
     */
    @Test
    public void testSetTotale() {
        System.out.println("setTotale");
        float totale = 0.0F;
        Ordine instance = new Ordine();
        instance.setTotale(totale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setC method, of class Ordine.
     */
    @Test
    public void testSetC() {
        System.out.println("setC");
        Cliente c = null;
        Ordine instance = new Ordine();
        instance.setC(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class Ordine.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Ordine instance = new Ordine();
        Cliente expResult = null;
        Cliente result = instance.getC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ordine.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ordine instance = new Ordine();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
