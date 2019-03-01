/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.pagamento;


public class PagamentoCartaDiCredito extends Pagamento {

    public PagamentoCartaDiCredito() {
        super();
        this.tipoPagamento = "CartaDiCredito";
    }
    
    public Pagamento getPagamento(){
    
        return new PagamentoCartaDiCredito();
    }
    
    public String getTipoPagamento(){
        return this.tipoPagamento;
    }
    
    
    
}
