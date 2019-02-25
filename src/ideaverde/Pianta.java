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

    public void addObserver(Observer o){
        this.osservatori.add(o);
    }
    
    public void setEtàPianta(int etàPianta) {
        this.etaPianta = etàPianta;
    }
    
    public void removeObserver(Observer o) {
        this.osservatori.remove(o);
    }

    public void setQuantitàDisponibile(int quantitàDisponibile) {
        this.quantitàDisponibile = quantitàDisponibile;
        for (Observer observer : this.osservatori) {
            observer.update(this,this.quantitàDisponibile);
        }
        
        
    }

    @Override
    public String toString() {
        return "Pianta{" + "et\u00e0Pianta=" + etaPianta + ", quantit\u00e0Disponibile=" + quantitàDisponibile + '}';
    }
    

   


    
    
    
}
