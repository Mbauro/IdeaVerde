/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mauro
 */
public class Ordine {
    
    private List<RigaDiOrdine> listaRigheDiOrdine;
    private Cliente c;
    private Pagamento pagamento = new Pagamento();
    private Spedizione spedizione = new Spedizione();
    private float totale = 0;

    public Ordine(List<RigaDiOrdine> listaRigheDiOrdine, Pagamento pagamento, Spedizione spedizione) {
        
        this.listaRigheDiOrdine = listaRigheDiOrdine;
        this.pagamento = pagamento;
        this.spedizione = spedizione;
    }

    public Ordine() {
        
        this.listaRigheDiOrdine = new ArrayList<RigaDiOrdine>();
    }
    
    
    
    public void creaRigaDiOrdine(String tipo, String varietà, int quantità, Pianta p){
        
        RigaDiOrdine r = new RigaDiOrdine(tipo,varietà,quantità,p);
        this.listaRigheDiOrdine.add(r);
        
                
    }
    
    public void creaPagamento(String tipoPagamento){
        
    }
    
    public float getTotale(){
        
        for(RigaDiOrdine object: this.listaRigheDiOrdine){
            this.totale += object.calcolaSubTotale();
        }
        return this.totale;
    }
    

    public List<RigaDiOrdine> getListaRigheDiOrdine() {
        return listaRigheDiOrdine;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Spedizione getSpedizione() {
        return spedizione;
    }

    
    public void setListaRigheDiOrdine(List<RigaDiOrdine> listaRigheDiOrdine) {
        this.listaRigheDiOrdine = listaRigheDiOrdine;
    }

    public void setPagamento(String pagamento) {
        this.pagamento.setTipoPagamento(pagamento);
    }

    public void setSpedizione(String spedizione) {
        this.spedizione.setTipoSpedizione(spedizione);
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public void setC(Cliente c) {
      this.c = c;
   }

    @Override
    public String toString() {
        return "Ordine{" + "listaRigheDiOrdine=" + listaRigheDiOrdine + ", c=" + c + ", pagamento=" + pagamento.toString() + ", spedizione=" + spedizione + ", totale=" + totale + '}';
    }
    
    
    
    

        
    
   
}

    