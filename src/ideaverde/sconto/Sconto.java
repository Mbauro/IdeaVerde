/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.sconto;
import ideaverde.*;

public abstract class Sconto {
    
    protected int percentualeSconto;
    
    public abstract int leggiPercentualeDaFile();
    
    public abstract void setPercentualeSconto(int newsconto);

  
    public abstract int getPercentualeSconto();
    
    
    
}
