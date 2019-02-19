/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.ArrayList;
import java.util.List;


public class OrdineIngrosso extends Ordine {

    public OrdineIngrosso() {
        
        this.listaRigheDiOrdine = new ArrayList();
        
    }
    
     public void creaRigaDiOrdine(String tipo, String varieta, int quantita, int eta){
         System.out.println(eta+""+quantita);
         RigaDiOrdine r = new RigaDiOrdine(tipo,varieta,quantita,eta);
         System.out.println(r);
         this.listaRigheDiOrdine.add(r);
     }

    public List<RigaDiOrdine> getListaRigheDiOrdine() {
        return listaRigheDiOrdine;
    }
    
    
    
    
    
}
