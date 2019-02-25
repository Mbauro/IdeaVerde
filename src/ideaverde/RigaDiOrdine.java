/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import java.util.List;



public class RigaDiOrdine {
    
 
    private float subTotale;
    private String tipo;
    private Pianta pianta;
    private int eta;
    private int quantita;
    private String varieta;


    public RigaDiOrdine(String tipo, String varieta ,int quantita, Pianta p) {
        
        //this.pianta.setEtàPianta(età);
        this.quantita = quantita;
        this.tipo = tipo;
        this.pianta = p;
        this.varieta=varieta;
        //p.aggiornaQuantitàDisponibile(quantità);
        
    }

    public RigaDiOrdine(String tipo, String varieta, int quantita, int eta) {
        
        this.tipo =tipo;
        this.varieta=varieta;
        this.eta=eta;
        this.quantita=quantita;
        
    }

    public String getTipo() {
        return tipo;
    }

    public String getVarieta() {
        return varieta;
    }
    
    
    
    
    public float calcolaSubTotale(){
     //Vedere le regole di dominio per il calcolo del subtotale   
        if(this.pianta.getEtàPianta() <= 2){
            this.subTotale = 10 * this.quantita;
        }
        else if(this.pianta.getEtàPianta()>2 && this.pianta.getEtàPianta() <= 5){
            this.subTotale = 15 * this.quantita;
        }
        else{
            this.subTotale = 25 * this.quantita;
        }
        
        return this.subTotale;
        
    }

    public float getSubTotale() {
        return subTotale;
    }
    

    public void setQuantità(int quantità) {
        this.quantita = quantita;
    }

    

    public Pianta getPianta() {
        return pianta;
    }

    public int getEta() {
        return eta;
    }

    public int getQuantita() {
        return quantita;
    }
    
    
    
    
   

    @Override
    public String toString() {
        return ""+"quantit\u00e0 = " + quantita + ", subTotale = " + this.subTotale + ", tipo = " + tipo + ", varietà = "+varieta+"\n";
    }

    public String toStringIngrosso() {
        return ""+"quantit\u00e0 = " + quantita +  ", tipo = " + tipo + ", varieta = "+varieta+"\n";
    }
           
    
            
            
}
