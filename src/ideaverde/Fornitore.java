/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

/**
 *
 * @author coppo
 */
public class Fornitore {
    
    private String nomeFornitore;
    private String emailFornitore;
    private String telefono;
    
    public Fornitore(String nomeFornitore,String emailFornitore, String telefono){
        this.nomeFornitore=nomeFornitore;
        this.emailFornitore=emailFornitore;
        this.telefono=telefono;
        
    }

    public String getNomeFornitore() {
        return nomeFornitore;
    }

    public String getEmailFornitore() {
        return emailFornitore;
    }

    public String getTelefono() {
        return telefono;
    }

    
    public void mio_toString() {
        System.out.println("Nome Fornitore = " + nomeFornitore + ",Email Fornitore = " + emailFornitore + ",Telefono = " + telefono);
    }
    
    
}
