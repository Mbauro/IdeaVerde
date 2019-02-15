/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import java.util.List;



public class RigaDiOrdine {
    
    private int quantità;
    private float subTotale;
    private String descrizione;
    private Pianta pianta;



    public RigaDiOrdine(String tipo, String varietà ,int quantità, Pianta p) {
        
        //this.pianta.setEtàPianta(età);
        this.quantità = quantità;
        this.descrizione = tipo+" "+varietà;
        this.pianta = p;
        
    }
    
    
    public float calcolaSubTotale(){
     //Vedere le regole di dominio per il calcolo del subtotale   
        if(this.pianta.getEtàPianta() <= 2){
            this.subTotale = 10 * this.quantità;
        }
        else if(this.pianta.getEtàPianta()>2 && this.pianta.getEtàPianta() <= 5){
            this.subTotale = 15 * this.quantità;
        }
        else{
            this.subTotale = 25 * this.quantità;
        }
        
        return this.subTotale;
        
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
    
   

    @Override
    public String toString() {
        return ""+"quantit\u00e0=" + quantità + ", subTotale=" + this.subTotale + ", descrizione=" + descrizione + "\n";
    }

 
           
    
            
            
}
