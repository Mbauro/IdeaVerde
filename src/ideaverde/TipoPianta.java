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
    private String varietà;
    private List<Pianta> listaPiante = new ArrayList();

    public TipoPianta(String tipo, String descrizione, String varietà) {
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.varietà = varietà;
    }

    @Override
    public String toString() {
        return "TipoPianta{" + "tipo=" + tipo + ", descrizione=" + descrizione + ", variet\u00e0=" + varietà + '}';
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getVarietà() {
        return varietà;
    }

    public List<Pianta> getListaPiante() {
        return listaPiante;
    }
    
    public void setQuantitàPianta(int età, int quantità){
        
       for(Pianta object: this.getListaPiante()){
           if(object.getEtàPianta() == età){
               if(object.getQuantitàDisponibile() < quantità){
                   System.err.println("Quantità della pianta non disponibile");
               }
               else{
                   object.setQuantitàDisponibile(object.getQuantitàDisponibile()-quantità);
                   
               }
           }
               
        }
    }
    
    public Pianta getPianta(int età){
        
        for(Pianta object: this.getListaPiante()){
            if(object.getEtàPianta() == età){
                Pianta p = object;
                return p;
            }
            
        }
        return null;
    }
    
    
    
    
    
    
}
