/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.fabbrica;

import ideaverde.pagamento.*;


/**
 *
 * @author mauro
 */
public class FactoryPagamentoContante extends FactoryPagamento {
    
        public Pagamento getPagamento(){
        
        return new PagamentoContante();
        
    }
    
}