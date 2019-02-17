/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.fabbrica;

import ideaverde.pagamento.*;
import ideaverde.sconto.*;


/**
 *
 * @author mauro
 */
public class FabbricaContanti extends Fabbrica {
    
        public Pagamento createPagamento(){
        
        Pagamento p = new PagamentoContante();
        return p;
    }
    
    public Sconto createSconto(){
        Sconto s = new ScontoContante();
        return s;
    }
    
}
