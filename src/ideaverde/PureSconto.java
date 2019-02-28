/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.sconto.*;
import ideaverde.pagamento.*;
import java.io.IOException;


public class PureSconto {
    //SCONTO
    private Sconto sconto;
    
    
    
    public Sconto selectScontoTessera(OrdineCliente o){
        
        int punti = o.getCliente().getTessera().getPunti();
        if(punti >1000 && punti < 2000){
                this.sconto=new ScontoSilver();
                return this.sconto;
            
            
        }
        else if(punti > 2000){
            this.sconto=new ScontoGold();
            return this.sconto;


        }
        return null;
        
    }
    
    public Sconto selectScontoPagamento(OrdineCliente o){
    
        Pagamento p = o.getPagamento();
        
        if(p instanceof PagamentoContante){
            this.sconto=new ScontoContante();
                return this.sconto;
            
            
        }
        else if(p instanceof PagamentoCartaDiCredito){
            this.sconto=new ScontoCartaDiCredito();
            return this.sconto;
            
        }
        
        return null; 
    }
    

    
}
