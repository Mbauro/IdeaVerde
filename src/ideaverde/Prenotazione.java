/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import java.util.List;
import java.util.ArrayList;

public class Prenotazione {
    //CLIENTE
    private Cliente cliente;
    //LISTA RIGHE DI PRENOTAZIONE
    private List<RigaDiOrdine> listaRigheDiPrenotazione;

    public Prenotazione() {
        
        listaRigheDiPrenotazione = new ArrayList();
        
    }
    
    public void creaRigaDiOrdine(String tipo, String varietà, int quantità, Pianta p){
        
       RigaDiOrdine rigaDiPrenotazione = new RigaDiOrdine(tipo,varietà,quantità,p);
       rigaDiPrenotazione.calcolaSubTotale();
       this.listaRigheDiPrenotazione.add(rigaDiPrenotazione);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<RigaDiOrdine> getListaRigheDiPrenotazione() {
        return listaRigheDiPrenotazione;
    }
    

    @Override
    public String toString() {
        return "Prenotazione di: "+ cliente + " listaRigheDiPrenotazione=" + listaRigheDiPrenotazione;
    }
    
    
    
    
}
