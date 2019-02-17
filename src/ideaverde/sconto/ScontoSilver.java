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
public class ScontoSilver extends ScontoTessera {
    
   

    public ScontoSilver() {
        
        this.percentualeSconto = 5;
    }
    
    public int getPercentualeSconto(){
        
        return this.percentualeSconto;
    }
   
}
