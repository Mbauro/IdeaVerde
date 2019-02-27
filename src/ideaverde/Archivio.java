/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Archivio implements Observer {

    static List<Prenotazione> listaDiPrenotazioni = new ArrayList();
    
    private List<OrdineCliente> archivioOrdini;
    private List<OrdineIngrosso> listaDiOrdiniIngrosso;

    public Archivio() {
        this.archivioOrdini = new ArrayList();
        this.listaDiOrdiniIngrosso = new ArrayList();
        
    }

    public List<OrdineCliente> getArchivioOrdini() {
        return archivioOrdini;
    }

    public List<OrdineIngrosso> getListaDiOrdiniIngrosso() {
        return listaDiOrdiniIngrosso;
    }

   
   
    
    
    
    public void update(Observable pianta,Object o){
        
        Pianta p=(Pianta)pianta;
        int quantita=(int)o;
        
        OrdineCliente ordine=null;
        
        System.out.println("PrIMa");
        
        for (Prenotazione io: Archivio.listaDiPrenotazioni){
            System.out.println(io.getListaRigheDiPrenotazione().toString());
        }
        
        
        for (Prenotazione prenotazione: Archivio.listaDiPrenotazioni){
            
            System.out.println("Prenotazione di : "+prenotazione.getCliente().getCognome());
            
            for(int i=0;i<prenotazione.getListaRigheDiPrenotazione().size();i++){
                //System.out.println(object.getListaRigheDiPrenotazione().get(i).toString());
                
                if(prenotazione.getListaRigheDiPrenotazione().get(i).getPianta()==p){
                    
                    if(quantita>prenotazione.getListaRigheDiPrenotazione().get(i).getQuantita()){
                        
                        if(ordine==null){
                            
                            ordine=IdeaVerde.creaNuovoOrdine(prenotazione.getCliente());
                            //Set del subtotale della riga di prenotazione
                            prenotazione.getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            //aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.creaRigaDiOrdine(prenotazione.getListaRigheDiPrenotazione().get(i).getTipo(),prenotazione.getListaRigheDiPrenotazione().get(i).getVarieta(),prenotazione.getListaRigheDiPrenotazione().get(i).getQuantita(), p);
                            //copio semplicemente il subtotale dalla riga di prenotazione
                            ordine.getListaRigheDiOrdine().get(i).setSubTotale(prenotazione.getListaRigheDiPrenotazione().get(i).getSubTotale());
                            //rimuovo la riga di prenotazione poichè è stata consegnata
                            prenotazione.getListaRigheDiPrenotazione().remove(i);
                            
                        }else{
                            //set del subtotale della riga di prenotazione
                            prenotazione.getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            ////aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.creaRigaDiOrdine(prenotazione.getListaRigheDiPrenotazione().get(i).getTipo(),prenotazione.getListaRigheDiPrenotazione().get(i).getVarieta(),prenotazione.getListaRigheDiPrenotazione().get(i).getQuantita(), p);
                            
                            //Aggiorno l'attributo subtotale della riga usando il subtotale della riga di prenotazione
                            ordine.getListaRigheDiOrdine().get(i).setSubTotale(prenotazione.getListaRigheDiPrenotazione().get(i).getSubTotale());
                            //Rimuovo dalla lista la merce partita dal vivaio
                            prenotazione.getListaRigheDiPrenotazione().remove(i);
                            
                            
                        }
                        ordine.insertPagamento("CartaDiCredito");
                        ordine.insertSpedizone("Corriere");
                        

                        System.out.println("Totale non scontato = "+ordine.getTotale()+"€");
                        System.out.println("Totale scontato = "+ordine.getTotaleScontato()+"€");
                    }
                }   
            }
        }
        
        if(ordine!=null){
            
            IdeaVerde.confermaOrdine(ordine,ordine.getCliente(),IdeaVerde.getArchivio());
        }
        
        for (Prenotazione object: Archivio.listaDiPrenotazioni){
            System.out.println("Prenotazione di : "+object.getCliente().getCognome());
            for(RigaDiOrdine object1: object.getListaRigheDiPrenotazione()){
                System.out.println(object1.toString());
            }
    
        }
        System.out.println("DOPO");
        for (Prenotazione io: Archivio.listaDiPrenotazioni){
            System.out.println(io.getListaRigheDiPrenotazione().toString());
        }
    }
    
    
    
}
