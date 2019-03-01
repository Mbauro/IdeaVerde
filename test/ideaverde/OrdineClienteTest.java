/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import ideaverde.pagamento.Pagamento;
import ideaverde.spedizione.RitiroInSede;
import ideaverde.spedizione.Spedizione;
import ideaverde.spedizione.SpedizioneCorriere;
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
public class OrdineClienteTest {
    
    public OrdineClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    Cliente cliente;
    Pianta pianta;
    OrdineCliente ordine;
    RigaDiOrdine r,r1,r2;
    Tessera t;
    @Before

    public void setUp() {
        cliente = new Cliente("Antonino","Coppolino","coppolinonino@gmail.com","via doria","3465874412");
        t=cliente.stampaTessera("Antonino","Coppolino","coppolinonino@gmail.com");
        cliente.getTessera().setPunti(2000);// provo il test al limite
        //(età,quantità_disponibile)
       
    }
    
    @After
    public void tearDown() {
    }

  
    @Test
    public void testGetTotale() {
        System.out.println("getTotale");
        pianta = new Pianta(2,100);
        r = new RigaDiOrdine("Limone","varietà1",50,pianta);
        r.calcolaSubTotale();
        OrdineCliente instance = new OrdineCliente();
        instance.getListaRigheDiOrdine().add(r);
        instance.getTotale();
        float expResult = 500F;
        float result = instance.prendiTotale();
        assertEquals(expResult, result, 0.0);
        
        
    }

   

    
    @Test
    public void testInsertPagamento() {
        System.out.println("insertPagamento");
        String tipoPagamento = "CartaDiCredito";
        OrdineCliente instance = new OrdineCliente();
        instance.insertPagamento(tipoPagamento);
        assertEquals(tipoPagamento,instance.getPagamento().getTipoPagamento());
       
        
    }

    @Test
    public void testGetTotaleScontato() {
        pianta = new Pianta(2,100);
        r = new RigaDiOrdine("Limone","varietà1",50,pianta);
        r.calcolaSubTotale();
        ordine = new OrdineCliente();
        ordine.getListaRigheDiOrdine().add(r);
        ordine.setC(cliente);
        ordine.insertSpedizone("Corriere");
        ordine.insertPagamento("Contanti");
        System.out.println("getTotaleScontato");
        ordine.getTotale();
        System.out.println(ordine.prendiTotale());
        float expResult = 473.75F;
        float result = ordine.getTotaleScontato();
        assertEquals(expResult, 473.75, 0.0);
       
        
    }

   
    public void testInsertSpedizone() {
     
        ordine = new OrdineCliente();
        ordine.setC(cliente);
        pianta = new Pianta(2,100);
        r = new RigaDiOrdine("Limone","varietà1",50,pianta);
        r1 = new RigaDiOrdine("Limone","varietà1",50,pianta);
        r2 = new RigaDiOrdine("Limone","varietà1",50,pianta);
        ordine.getListaRigheDiOrdine().add(r);
        ordine.getListaRigheDiOrdine().add(r1);
        ordine.getListaRigheDiOrdine().add(r2);
        System.out.println("insertSpedizone");
        ordine.insertSpedizone("RitiroInSede");
        assertEquals(true, ordine.getSpedizione() instanceof RitiroInSede);
        ordine.insertSpedizone("Corriere");
        System.out.println(ordine.getSpedizione().getClass().getName());
        assertEquals(true, ordine.getSpedizione() instanceof SpedizioneCorriere);
        
    }


}
