/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.spedizione;

/**
 *
 * @author mauro
 */
public class SpedizioneCorriere extends Spedizione {
    
    int prezzo=50;
    
    private String indirizzo_di_consegna;

    public int getPrezzo() {
        return prezzo;
    }

    
    
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setIndirizzo_di_consegna(String indirizzo_di_consegna) {
        this.indirizzo_di_consegna = indirizzo_di_consegna;
    }

    @Override
    public String toString() {
        return "SpedizioneCorriere{" + "indirizzo_di_consegna=" + indirizzo_di_consegna + ",prezzo= "+this.prezzo +'}';
    }


    
    
    
    
    
    
    
}
