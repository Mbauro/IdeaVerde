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
    private List<Prenotazione> listaDiPrenotazioni;
    //LISTA DEGLI ORDINI
    private List<Ordine> listaOrdini;
    

    
    public Archivio() {
        
        this.listaDiPrenotazioni=new ArrayList();
        this.listaOrdini=new ArrayList();
    }


    public List<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public List<Prenotazione> getListaDiPrenotazioni() {
        return listaDiPrenotazioni;
    }
    
    public OrdineCliente creaNuovoOrdine(Cliente c){
        OrdineCliente ordine=new OrdineCliente();
        ordine.setC(c);
        return ordine;
    }
    
    public Prenotazione creaPrenotazione(Cliente c){
        Prenotazione prenotazione= new Prenotazione();
        prenotazione.setCliente(c);
        return prenotazione;
    }

    public OrdineIngrosso creaOrdineIngrosso(){
        OrdineIngrosso ordine = new OrdineIngrosso();
        return ordine;
    }
    
    // Metodo UPDATE che verrà chiamato da notifyObservers che è presente in pianta.
    public void update(Observable pianta,Object o){
        
        System.out.println("STO CONTROLLANDO LE PRENOTAZIONI...............");
        
        Pianta p=(Pianta)pianta;
                
        OrdineCliente ordine=null;
        
        
        
        
        for (int j=0;j<this.listaDiPrenotazioni.size();j++){
            
            
            
            for(int i=0;i<this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().size();i++){
                //System.out.println(object.getListaRigheDiPrenotazione().get(i).toString());
                
                if(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getPianta()==p){
                   
                    if(p.getQuantitàDisponibile()>this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getQuantita()){
                        
                        if(ordine==null){
                            
                            ordine=IdeaVerde.creaNuovoOrdine(this.listaDiPrenotazioni.get(j).getCliente());
                            //Set del subtotale della riga di prenotazione
                            System.out.println("Ho creato un oedine per "+this.listaDiPrenotazioni.get(j).getCliente().getCognome());
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            //aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.getListaRigheDiOrdine().add(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i));
                            System.out.println("Sto spedendo "+this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i)+"a "+this.listaDiPrenotazioni.get(j).getCliente().getCognome());
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getPianta().setQuantitaUpdate(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getPianta().getQuantitàDisponibile()-this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getQuantita());
                           
                            //rimuovo la riga di prenotazione poichè è stata consegnata
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().remove(i);
                            
                            //Cancello la prenotazione se non contiene righe di ordine
                            if(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().isEmpty()){
                                this.listaDiPrenotazioni.remove(j);
                                if(this.listaDiPrenotazioni.isEmpty()){
                                    break;
                                }
                            }
                            
                        }else{
                            //set del subtotale della riga di prenotazione
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).calcolaSubTotale();
                            ////aggiungo la riga di ordine all'ordine dato che adesso può essere consegnata la quantità
                            ordine.getListaRigheDiOrdine().add(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i));
                            System.out.println("Sto spedendo "+this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i)+"a "+this.listaDiPrenotazioni.get(j).getCliente().getCognome());
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getPianta().setQuantitaUpdate(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getPianta().getQuantitàDisponibile()-this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().get(i).getQuantita());
                           
                            //Rimuovo dalla lista la merce partita dal vivaio
                            this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().remove(i);
                            //Cancello la prenotazione se non contiene righe di ordine
                            if(this.listaDiPrenotazioni.get(j).getListaRigheDiPrenotazione().isEmpty()){
                                this.listaDiPrenotazioni.remove(j);
                                if(this.listaDiPrenotazioni.isEmpty()){
                                    break;
                                }
                            }
                            
                            
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
            
            IdeaVerde.confermaOrdine(ordine,ordine.getCliente());
        }
        


        p.deleteObserver(this);
    }
    
    public void eliminaPrenotazione(String nome,String cognome,String email){
        int controllo=0;
        for(int i=0;i<listaDiPrenotazioni.size();i++){
            Prenotazione object=listaDiPrenotazioni.get(i);
            if(object.getCliente().getNome().equalsIgnoreCase(nome)&&object.getCliente().getCognome().equalsIgnoreCase(cognome)&&object.getCliente().getEmail().equalsIgnoreCase(email)){
                controllo=1;
            }
            if (controllo==1){
                listaDiPrenotazioni.remove(i);
                break;
            }
        }
        if (controllo==0){
            System.err.println("NON CORRISPONDE NESSUNA PRENOTAZIONE A QUESTO CLIENTE");
        }
        
    }
    
    public void stampaPrenotazioni(){
        if(listaDiPrenotazioni.isEmpty()){
            System.err.println("LISTA DI PRENOTAZIONI VUOTA");
        }else{
            for(Prenotazione object:this.listaDiPrenotazioni){
                System.out.println(object.toString());
            }
        }
    }
    
}
