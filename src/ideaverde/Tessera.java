/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;


public class Tessera {
    
    
    private int punti;
    private String nomeCliente;
    private String cognomeCliente;

    public Tessera(int punti, String nomeCliente, String cognomeCliente) {
        
        this.punti = punti;
        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
    }

    @Override
    public String toString() {
        return "Tessera{" + ", punti=" + punti + ", nomeCliente=" + nomeCliente + ", cognomeCliente=" + cognomeCliente + '}';
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCognomeCliente() {
        return cognomeCliente;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public int getPunti() {
        return punti;
    }
    
    
    
    
    
    
    
}
