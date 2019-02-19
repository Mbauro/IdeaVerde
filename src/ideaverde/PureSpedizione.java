/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.spedizione.*;

public class PureSpedizione {
    
    
    
    
    public Spedizione selectSpedizione(String tipoSpedizione, OrdineCliente ordine){
        //Il costo tot del ritiro in sede è di 0 euro
        if(tipoSpedizione.equalsIgnoreCase("RitiroInSede")){
            
            return new RitiroInSede();
        }
        else if(tipoSpedizione.equalsIgnoreCase("Corriere")){
            //La spedizione con corriere è di 1 euro a pianta fino a 50 piante.
            //Dopo 50 piante rimane 50€
            int i = 0;
            int numero_piante = 0;
            for(RigaDiOrdine object: ordine.getListaRigheDiOrdine()){
                numero_piante += object.getQuantità();
            }
            //System.out.println("Numero piante: "+numero_piante);
            String indirizzo = ordine.getC().getIndirizzo();
            SpedizioneCorriere spedizione = new SpedizioneCorriere();
            spedizione.setIndirizzo_di_consegna(indirizzo);
            if(numero_piante < 50 && numero_piante > 0){
                spedizione.setPrezzo(numero_piante);
                return spedizione;
            }
            else if(numero_piante > 50){
                spedizione.setPrezzo(50);
                return spedizione;
            }
        }
        return null;
    }
    
}
