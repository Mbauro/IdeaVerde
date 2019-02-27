/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author mauro
 */
public class Pianta extends Observable {
    
    List<Observer> osservatori = new ArrayList();
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
    

    public void setQuantitàDisponibile(int quantitaDisponibile) {
        this.quantitàDisponibile = quantitaDisponibile;
        setChanged();
        notifyObservers(quantitaDisponibile);
    }

    @Override
    public String toString() {
        return "[Pianta]" + " Et\u00e0Pianta = " + etaPianta + ", quantit\u00e0 disponibile in vivaio = " + quantitàDisponibile;
    }
    

   


    
    
    
}
