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
    private String emailCliente;

    public Tessera(String nomeCliente, String cognomeCliente,int punti, String emailCliente) {
        
        this.punti = punti;
        //DATI CLIENTE PROPRIETARIO DELLA TESSERA
        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
        this.emailCliente= emailCliente;
    }

    @Override
    public String toString() {
        return "Tessera{" + ", punti=" + punti + ", nomeCliente=" + nomeCliente + ", cognomeCliente=" + cognomeCliente + '}';
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }
    
    

    public String getCognomeCliente() {
        return cognomeCliente;
    }

    public void setPunti(int punti) {
        this.punti += punti;
    }

    public int getPunti() {
        return punti;
    }
    
}
