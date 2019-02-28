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
    
    //LISTA DELLE PRENOTAZIONI
    private List<Prenotazione> listaDiPrenotazioni = new ArrayList();
    //LISTA DEGLI ORDINI
    private List<Ordine> listaOrdini;
    
    public Archivio() {
        //this.archivioOrdini = new ArrayList();
        //this.listaDiOrdiniIngrosso = new ArrayList();
        this.listaOrdini=new ArrayList();
    }

    /*public List<OrdineCliente> getArchivioOrdini() {
        return archivioOrdini;
    }*/

    /*public List<OrdineIngrosso> getListaDiOrdiniIngrosso() {
        return listaDiOrdiniIngrosso;
    }*/

    public List<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public List<Prenotazione> getListaDiPrenotazioni() {
        return listaDiPrenotazioni;
    }
    
    
    

    // Metodo UPDATE che verrà chiamato da notifyObservers che è presente in pianta.
    public void update(Observable pianta,Object o){
        
        Pianta p=(Pianta)pianta;
        int quantita=(int)o;
        
        OrdineCliente ordine=null;
        
        System.out.println("PrIMa");
        
        for (Prenotazione io: this.listaDiPrenotazioni){
            System.out.println(io.getListaRigheDiPrenotazione().toString());
        }
        
        
        for (Prenotazione prenotazione: this.listaDiPrenotazioni){
            
            System.out.println("Prenotazione di : "+prenotazione.getCliente().getCognome());
            
            for(int i=0;i<prenotazione.getListaRigheDiPrenotazione().size();i++){
                //System.out.println(object.getListaRigheDiPrenotazione().get(i).toString());
                
                if(prenotazione.getListaRigheDiPrenotazione().get(i).getPianta()==p){
                    
                    if(p.getQuantitàDisponibile()>prenotazione.getListaRigheDiPrenotazione().get(i).getQuantita()){
                        
                        if(ordine==null){
                            
                            ordine=IdeaVerde.creaNuovoOrdine(prenotazione.getCliente());
                            //Set del subtotale della riga di prenotazione
                            prenotazione.getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            //aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.getListaRigheDiOrdine().add(prenotazione.getListaRigheDiPrenotazione().get(i));
                           
                            //rimuovo la riga di prenotazione poichè è stata consegnata
                            prenotazione.getListaRigheDiPrenotazione().remove(i);
                            
                        }else{
                            //set del subtotale della riga di prenotazione
                            prenotazione.getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            ////aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.getListaRigheDiOrdine().add(prenotazione.getListaRigheDiPrenotazione().get(i));
                           
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
        
        for (Prenotazione object: this.listaDiPrenotazioni){
            System.out.println("Prenotazione di : "+object.getCliente().getCognome());
            for(RigaDiOrdine object1: object.getListaRigheDiPrenotazione()){
                System.out.println(object1.toString());
            }
    
        }
        System.out.println("DOPO");
        for (Prenotazione prenotazione: this.listaDiPrenotazioni){
            System.out.println(prenotazione.getListaRigheDiPrenotazione().toString());
        }
        p.deleteObserver(this);
    }
    
    }
