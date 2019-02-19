/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.ArrayList;


public class OrdineIngrosso extends Ordine {

    public OrdineIngrosso() {
        
        this.listaRigheDiOrdine = new ArrayList();
        
    }
    
     public void creaRigaDiOrdine(String tipo, String varietà, int quantità, int età){
         
         RigaDiOrdine r = new RigaDiOrdine(tipo,varietà,quantità,età);
         this.listaRigheDiOrdine.add(r);
     }
    
    
    
}
