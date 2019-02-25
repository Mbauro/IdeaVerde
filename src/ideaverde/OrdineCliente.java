/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;
import ideaverde.spedizione.Spedizione;
import ideaverde.pagamento.*;
import ideaverde.sconto.*;
import ideaverde.spedizione.RitiroInSede;
import ideaverde.spedizione.SpedizioneCorriere;

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
    private PureSconto sconto;



    public OrdineCliente() {
        
        this.listaRigheDiOrdine = new ArrayList<RigaDiOrdine>();
        //this.listaSconti = new ArrayList();
        
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
    
    public void insertPagamento(String tipoPagamento){
        
        if(tipoPagamento.equalsIgnoreCase("Contanti")){
            this.pagamento = new PagamentoContante();
          
        }
        else if(tipoPagamento.equalsIgnoreCase("CartaDiCredito")){
            this.pagamento = new PagamentoCartaDiCredito();
            
        }
                
    }
    
    public float getTotaleScontato(){
        
        
        this.sconto=new PureSconto();
        Sconto st,sp;
        st=this.sconto.selectScontoTessera(this);
        sp=this.sconto.selectScontoPagamento(this);
        float totale_scontato = 0;
          
        
        if(st==null){
            totale_scontato=this.totale;
        }else{
            totale_scontato= this.totale-(this.totale*st.getPercentualeSconto()/100);
        }
        totale_scontato-=(totale_scontato*sp.getPercentualeSconto()/100);
        
           
        
        return totale_scontato;
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
    
    
   
    public void insertSpedizone(String tipoSpedizione){
       
        //Il costo tot del ritiro in sede è di 0 euro
        if(tipoSpedizione.equalsIgnoreCase("RitiroInSede")){
            
            this.spedizione = new RitiroInSede();
        }
        else if(tipoSpedizione.equalsIgnoreCase("Corriere")){
            //La spedizione con corriere è di 1 euro a pianta fino a 50 piante.
            //Dopo 50 piante rimane 50€
            int i = 0;
            int numero_piante = 0;
            for(RigaDiOrdine object: this.getListaRigheDiOrdine()){
                numero_piante += object.getQuantita();
            }
            //System.out.println("Numero piante: "+numero_piante);
            String indirizzo = this.getC().getIndirizzo();
            SpedizioneCorriere spedizione = new SpedizioneCorriere();
            spedizione.setIndirizzo_di_consegna(indirizzo);
            if(numero_piante < 50 && numero_piante > 0){
                spedizione.setPrezzo(numero_piante);
                this.spedizione=spedizione;
            }
            else if(numero_piante > 50){
                spedizione.setPrezzo(50);
                this.spedizione= spedizione;
            }
        }
            
    }
    
    
    
    
    

        
    
   
}

    