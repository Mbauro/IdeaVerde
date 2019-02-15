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
    
    private int etàPianta;
    private int quantitàDisponibile;

    public Pianta(int etàPianta, int quantitàDisponibile) {
        this.etàPianta = etàPianta;
        this.quantitàDisponibile = quantitàDisponibile;
    }

    public int getEtàPianta() {
        return etàPianta;
    }

    public int getQuantitàDisponibile() {
        return quantitàDisponibile;
    }

    public void setEtàPianta(int etàPianta) {
        this.etàPianta = etàPianta;
    }

    public void setQuantitàDisponibile(int quantitàDisponibile) {
        this.quantitàDisponibile = quantitàDisponibile;
    }

    @Override
    public String toString() {
        return "Pianta{" + "et\u00e0Pianta=" + etàPianta + ", quantit\u00e0Disponibile=" + quantitàDisponibile + '}';
    }
    
    

   


    
    
    
}
