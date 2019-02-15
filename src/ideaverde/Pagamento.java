/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;


public class Pagamento {
    
    private float prezzoTotale;
    private String tipoPagamento;

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "prezzoTotale=" + prezzoTotale + ", tipoPagamento=" + tipoPagamento + '}';
    }
    
    
    
    
}
