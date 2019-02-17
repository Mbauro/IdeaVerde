/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.sconto;

/**
 *
 * @author mauro
 */
public class ScontoCartaDiCredito extends ScontoPagamento {

    public ScontoCartaDiCredito() {
       
        this.percentualeSconto = 0;
    }
    
    @Override
    public int getPercentualeSconto(){
        return this.percentualeSconto;
    }
}
