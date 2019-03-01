/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coppo
 */
public class Catalogo {
    
    // LISTA DEI TIPI DI PIANTA
    List<TipoPianta> listaTipoPiante;
    
    
    public Catalogo(){
        listaTipoPiante = new ArrayList<TipoPianta>();
    }

    public List<TipoPianta> getListaTipoPiante() {
        return listaTipoPiante;
    }
    
    public void inserisciPianta(String tipo,String varieta,int eta,int quantita){
        
        TipoPianta tp=null;
        for(TipoPianta object: this.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo)&&object.getVarietà().equalsIgnoreCase(varieta)){
                tp=object;
            }
        }
        tp.inserisciPianta(eta, quantita);
       
    }
    
    public void stampaCatalogo(){
        for(TipoPianta object: this.getListaTipoPiante()){
            System.out.println(object.toString());
            for(Pianta object2: object.getListaPiante()){
                System.out.println(object2.toString());
            }
        }
    }
    
    public void setQuantitaDisponibile(String tipo,String varieta,Pianta p,int quantita){
        TipoPianta tp=null;
        for (TipoPianta object : this.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo)&&(object.getVarietà().equalsIgnoreCase(varieta))){
                tp=object;
            }
        }
        tp.setQuantitaPianta(p.getEtàPianta(), quantita);
    }
}
