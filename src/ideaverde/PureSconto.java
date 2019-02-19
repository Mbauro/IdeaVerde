/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.sconto.*;
import ideaverde.pagamento.*;

public class PureSconto {
    
    
    
    
    public Sconto selectScontoTessera(Ordine o){
        
        int punti = o.getC().getTessera().getPunti();
        if(punti >1000 && punti < 2000){
            return new ScontoSilver();
            
        }
        else if(punti > 2000){
            return new ScontoGold();

        }
        return null;
        
    }
    
    public Sconto selectScontoPagamento(Ordine o){
    
        Pagamento p = o.getPagamento();
        
        if(p instanceof PagamentoContante){

            return new ScontoContante();
            
        }
        else if(p instanceof PagamentoCartaDiCredito){
            return new ScontoCartaDiCredito();
        }
        
        return null; 
    }
    

    
}
