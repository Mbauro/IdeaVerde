/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;


/**
 *
 * @author mauro
 */
public class Pianta {
    
    private int etaPianta;
    private int quantitàDisponibile;

    public Pianta(int etàPianta, int quantitàDisponibile) {
        this.etaPianta = etàPianta;
        this.quantitàDisponibile = quantitàDisponibile;
    }

    public int getEtàPianta() {
        return etaPianta;
    }

    public int getQuantitàDisponibile() {
        return quantitàDisponibile;
    }

    public void setEtàPianta(int etàPianta) {
        this.etaPianta = etàPianta;
    }

    public void setQuantitàDisponibile(int quantitàDisponibile) {
        this.quantitàDisponibile = quantitàDisponibile;
    }

    public void aggiornaQuantitàDisponibile(int quantità) {
        if(this.quantitàDisponibile < quantità){
            System.err.println("Quantità non disponibile");
        }
        else{
            this.setQuantitàDisponibile(this.quantitàDisponibile - quantità);
        }
    }

    @Override
    public String toString() {
        return "Pianta{" + "et\u00e0Pianta=" + etaPianta + ", quantit\u00e0Disponibile=" + quantitàDisponibile + '}';
    }
    

   


    
    
    
}
