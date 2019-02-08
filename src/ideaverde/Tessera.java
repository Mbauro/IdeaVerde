/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;


public class Tessera {
    
    private int numeroTessera;
    private int punti;
    private String nomeCliente;
    private String cognomeCliente;

    public Tessera(int numeroTessera, int punti, String nomeCliente, String cognomeCliente) {
        this.numeroTessera = numeroTessera;
        this.punti = punti;
        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
    }

    @Override
    public String toString() {
        return "Tessera{" + "numeroTessera=" + numeroTessera + ", punti=" + punti + ", nomeCliente=" + nomeCliente + ", cognomeCliente=" + cognomeCliente + '}';
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCognomeCliente() {
        return cognomeCliente;
    }
    
    
    
    
}
