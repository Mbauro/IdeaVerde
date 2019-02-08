/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

/**
 *
 * @author mauro
 */
public class TipoPianta {
    
    private String tipo;
    private String descrizione;
    private String varietà;

    public TipoPianta(String tipo, String descrizione, String varietà) {
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.varietà = varietà;
    }

    @Override
    public String toString() {
        return "TipoPianta{" + "tipo=" + tipo + ", descrizione=" + descrizione + ", variet\u00e0=" + varietà + '}';
    }
    
    
    
}
