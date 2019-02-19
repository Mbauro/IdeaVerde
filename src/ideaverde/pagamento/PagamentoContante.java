/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.pagamento;


public class PagamentoContante extends Pagamento {

    public PagamentoContante() {
        
        this.tipoPagamento = "pagamento in contanti";
    }
    
        public String getTipoPagamento(){
        return this.tipoPagamento;
    }

    

}
