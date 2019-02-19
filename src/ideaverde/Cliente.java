/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;


import java.util.List;
import java.util.ArrayList;


public class Cliente {
    
    private String nome;
    private String cognome;
    private String indirizzo;
    private String email;
    private String cellulare;
    private Tessera tessera;
    private List<OrdineCliente> listaDiOrdini;
    
    

    public Cliente(String nome, String cognome, String indirizzo, String email, String cellulare) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.cellulare = cellulare;
        this.listaDiOrdini = new ArrayList(); 
        this.stampaTessera(nome,cognome);
        
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public String getCellulare() {
        return cellulare;
    }

    public List<OrdineCliente> getListaDiOrdini() {
        return listaDiOrdini;
    }
    

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
    
    public Tessera stampaTessera(String nomeCliente, String cognomeCliente){
                
        
        tessera = new Tessera(0,nomeCliente, cognomeCliente);
        System.out.println("Tessera di: "+cognomeCliente + " "+ nomeCliente);
        
        
        return tessera;
        
    }

    public Tessera getTessera() {
        return tessera;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + ", email=" + email + ", cellulare=" + cellulare + '}';
    }
    
    
    
}
