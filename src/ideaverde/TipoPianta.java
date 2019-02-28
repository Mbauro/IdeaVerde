/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mauro
 */
public class TipoPianta {
    
    private String tipo;
    private String descrizione;
    private String varieta;
    
    //LISTA DELLE PIANTE CORRISPONDENTI A QUESTO TIPO
    private List<Pianta> listaPiante = new ArrayList();

    public TipoPianta(String tipo, String descrizione, String varietà) {
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.varieta = varietà;
    }

    @Override
    public String toString() {
        return "TipoPianta = "  + tipo + ", descrizione = " + descrizione + ", variet\u00e0 = " + varieta;
    }
    
    public void inserisciPianta(int eta,int quantita){
        Pianta p=new Pianta(eta,quantita);
        this.getListaPiante().add(p);
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getVarietà() {
        return varieta;
    }

    public List<Pianta> getListaPiante() {
        return listaPiante;
    }
    
    public void setQuantitàPianta(int età, int quantità){
        
       for(Pianta object: this.getListaPiante()){
           if(object.getEtàPianta() == età){
               
               if(object.getQuantitàDisponibile() < quantità){
                   System.err.println("Quantità NON DISPONIBILE");
               }
               else{
                   object.setQuantitàDisponibile(object.getQuantitàDisponibile()-quantità);
                   
               }
           }
               
        }
    }
    
}
