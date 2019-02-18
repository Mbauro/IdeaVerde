/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.pagamento.*;
import ideaverde.sconto.*;
import ideaverde.consegna.*;

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
    private Consegna consegna;
    private float totale = 0;
    private List<Sconto> listaSconti;

    public Ordine(List<RigaDiOrdine> listaRigheDiOrdine) {
        
        this.listaRigheDiOrdine = listaRigheDiOrdine;

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


    
    public void setListaRigheDiOrdine(List<RigaDiOrdine> listaRigheDiOrdine) {
        this.listaRigheDiOrdine = listaRigheDiOrdine;
    }


    public void setConsegna(String spedizione) {
        //this.spedizione.setTipoSpedizione(spedizione);
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
        return "Ordine{" + "listaRigheDiOrdine=" + listaRigheDiOrdine + ", c=" + c + ", totale=" + totale + ", pagamento=" + this.pagamento.toString() + '}';
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

    