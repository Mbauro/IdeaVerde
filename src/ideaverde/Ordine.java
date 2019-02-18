/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.pagamento.*;
import ideaverde.sconto.*;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mauro
 */
public class Ordine {
    
    private List<RigaDiOrdine> listaRigheDiOrdine;
    private Cliente c;
    private Pagamento pagamento;
    private Spedizione spedizione;
    private float totale = 0;
    private List<Sconto> listaSconti;

    public Ordine(List<RigaDiOrdine> listaRigheDiOrdine, Pagamento pagamento, Spedizione spedizione) {
        
        this.listaRigheDiOrdine = listaRigheDiOrdine;
        this.pagamento = pagamento;
        this.spedizione = spedizione;
    }

    public Ordine() {
        
        this.listaRigheDiOrdine = new ArrayList<RigaDiOrdine>();
        this.listaSconti = new ArrayList();
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


    public void setSpedizione(String spedizione) {
        this.spedizione.setTipoSpedizione(spedizione);
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public void setC(Cliente c) {
      this.c = c;
   }

    public Cliente getC() {
        return c;
    }
    

    @Override
    public String toString() {
        return "Ordine{" + "listaRigheDiOrdine=" + listaRigheDiOrdine + ", c=" + c + ", pagamento=" + pagamento.toString() + ", spedizione=" + spedizione + ", totale=" + totale + '}';
    }
    
    
    /*********************************/
    public void insertPagamento(String tipoPagamento){
        
        PurePagamento p = new PurePagamento();
        this.pagamento = p.selectPagamento(tipoPagamento);
    }
    
    private void insertSconto(){
        
        PureSconto s = new PureSconto();
        Sconto scontoTessera = s.selectScontoTessera(this);
        Sconto scontoPagamento = s.selectScontoPagamento(this);
        this.listaSconti.add(scontoTessera);
        this.listaSconti.add(scontoPagamento);        
    }
    
    
    
    
    

        
    
   
}

    