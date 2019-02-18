/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import ideaverde.pagamento.Pagamento;
import ideaverde.pagamento.PagamentoContante;
import ideaverde.pagamento.PagamentoCartaDiCredito;

/**
 *
 * @author mauro
 */
public class PurePagamento {
    
    private Pagamento pagamento;
    
    public Pagamento selectPagamento(String tipoPagamento){
        if(tipoPagamento.equalsIgnoreCase("Contante")){
            this.pagamento = new PagamentoContante();
            return this.pagamento;
        }
        else if(tipoPagamento.equalsIgnoreCase("CartaDiCredito")){
            this.pagamento = new PagamentoCartaDiCredito();
            return this.pagamento;
        }
        return null;
    }
    
}
