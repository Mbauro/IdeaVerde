/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.consegna;

/**
 *
 * @author mauro
 */
public class SpedizioneCorriere extends Consegna {
    
    
    private String indirizzo_di_consegna;

    public SpedizioneCorriere(int prezzo, String indirizzo_di_consegna) {
        this.prezzo = prezzo;
        this.indirizzo_di_consegna = indirizzo_di_consegna;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setIndirizzo_di_consegna(String indirizzo_di_consegna) {
        this.indirizzo_di_consegna = indirizzo_di_consegna;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getIndirizzo_di_consegna() {
        return indirizzo_di_consegna;
    }
    
    
    
    
    
}
