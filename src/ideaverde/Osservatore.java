/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import static ideaverde.IdeaVerde.listaDiPrenotazioni;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author coppo
 */
public class Osservatore implements Observer{
    
    Pianta p;
 
    public Osservatore(Pianta pianta){
        p = pianta;
        p.addObserver(this);
    }
    
    
    
    public void update(Observable pianta,Object o){
        
        Pianta p=(Pianta)pianta;
        int quantita=(int)o;
        
        OrdineCliente ordine=null;
        
        System.out.println("PrIMa");
        
        for (Prenotazione io: listaDiPrenotazioni){
            System.out.println(io.getListaRigheDiPrenotazione().toString());
        }
        List<RigaDiOrdine> r=new ArrayList();
        List<Prenotazione> pr= new ArrayList();
        for (Prenotazione object: listaDiPrenotazioni){
            System.out.println("Prenotazione di : "+object.getCliente().getCognome());
            for(int i=0;i<object.getListaRigheDiPrenotazione().size();i++){
                System.out.println(object.getListaRigheDiPrenotazione().get(i).toString());
                if(object.getListaRigheDiPrenotazione().get(i).getPianta()==p){
                    if(quantita>object.getListaRigheDiPrenotazione().get(i).getQuantita()){
                        if(ordine==null){
                            
                            ordine=IdeaVerde.creaNuovoOrdine(object.getCliente());
                            ordine.creaRigaDiOrdine(object.getListaRigheDiPrenotazione().get(i).getTipo(),object.getListaRigheDiPrenotazione().get(i).getVarieta(),object.getListaRigheDiPrenotazione().get(i).getQuantita(), p);
                            object.getListaRigheDiPrenotazione().remove(i);
                            //Prenotazione object2=object;
                            
                            //object.getListaRigheDiPrenotazione().remove(object1);
                        }else{
                            ordine.creaRigaDiOrdine(object.getListaRigheDiPrenotazione().get(i).getTipo(),object.getListaRigheDiPrenotazione().get(i).getVarieta(),object.getListaRigheDiPrenotazione().get(i).getQuantita(), p);
                            
                            object.getListaRigheDiPrenotazione().remove(i);
                            
                            //Prenotazione object2=object;
                            //object.getListaRigheDiPrenotazione().remove(object1);
                        }
                    
                    }
                }   
            }
        }
        
        if(ordine!=null){
            
            IdeaVerde.confermaOrdine(ordine,ordine.getCliente(),IdeaVerde.getArchivio());
        }
        
        for (Prenotazione object: listaDiPrenotazioni){
            System.out.println("Prenotazione di : "+object.getCliente().getCognome());
            for(RigaDiOrdine object1: object.getListaRigheDiPrenotazione()){
                System.out.println(object1.toString());
            }
    
        }
        System.out.println("DOPO");
        for (Prenotazione io: listaDiPrenotazioni){
            System.out.println(io.getListaRigheDiPrenotazione().toString());
        }
    }
    
}
