/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.sconto.*;
import ideaverde.pagamento.*;
import java.io.IOException;
import java.util.*;


public class CalcolaSconto {
    //SCONTO
    private Sconto sconto;
    
    
    
    
    public List<Sconto> calcolaSconti(OrdineCliente o){
        List<Sconto>sconti=new ArrayList();
        Sconto s1,s2;
        
        s1=selectScontoTessera(o);
        s2=selectScontoPagamento(o);
        sconti.add(s1);
        sconti.add(s2);
        if(sconti!=null){
            return sconti;
        }else{
            return null;
        }
    }
    
    private Sconto selectScontoTessera(OrdineCliente o){
        
        int punti = o.getCliente().getTessera().getPunti();
        if(punti >1000 && punti <= 2000){
                this.sconto=new ScontoSilver();
                return this.sconto;
            
            
        }
        else if(punti > 2000){
            this.sconto=new ScontoGold();
            return this.sconto;
        }
        return null;
        
    }
    
    private Sconto selectScontoPagamento(OrdineCliente o){
    
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
