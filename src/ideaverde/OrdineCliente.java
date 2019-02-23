/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.spedizione.Spedizione;
import ideaverde.pagamento.*;
import ideaverde.sconto.*;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mauro
 */
public class OrdineCliente extends Ordine {
    
    
    private Cliente cliente;
    private Pagamento pagamento;
    private Spedizione spedizione;
    private float totale = 0;
    private List<Sconto> listaSconti;



    public OrdineCliente() {
        
        this.listaRigheDiOrdine = new ArrayList<RigaDiOrdine>();
        this.listaSconti = new ArrayList();
        
    }
    
    
    
    public void creaRigaDiOrdine(String tipo, String varietà, int quantità, Pianta p){
        
        RigaDiOrdine r = new RigaDiOrdine(tipo,varietà,quantità,p);
        this.listaRigheDiOrdine.add(r);
        //p.setQuantitàDisponibile(p.getQuantitàDisponibile() - quantità);
        
                
    }
    
    public void creaPagamento(String tipoPagamento){
        
    }
    
    public float getTotale(){
        
        for(RigaDiOrdine object: this.listaRigheDiOrdine){
            this.totale += object.getSubTotale();
        }
        return this.totale;
    }
    
    public float getTotaleScontato(){
        //Aggiunge gli sconti del cliente alla lista
        this.insertSconto();
       
        float totale_scontato = 0;
        
        for(Sconto object: this.getListaSconti()){
            if(object != null){
                totale_scontato += this.totale - (object.getPercentualeSconto()*this.totale/100);
            }
           
        }
        return totale_scontato;
    }

    public List<Sconto> getListaSconti() {
        return listaSconti;
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
      this.cliente = c;
   }

    public Cliente getC() {
        return cliente;
    }


    

    @Override
    public String toString() {
        return "Ordine{" + "listaRigheDiOrdine=" + listaRigheDiOrdine + ", c=" + cliente + ", totale=" + totale + ", pagamento=" + this.pagamento.getTipoPagamento() + ", spedizione=" + this.spedizione.toString() + '}';
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
    
    public void insertSpedizone(String tipoSpedizione){
        PureSpedizione s = new PureSpedizione();
        this.spedizione = s.selectSpedizione(tipoSpedizione, this);
    }
    
    
    
    
    

        
    
   
}

    