/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;

public class Archivio {
    
    private List<OrdineCliente> archivioOrdini;
    private List<OrdineIngrosso> listaDiOrdiniIngrosso;

    public Archivio() {
        this.archivioOrdini = new ArrayList();
        this.listaDiOrdiniIngrosso = new ArrayList();
    }

    public List<OrdineCliente> getArchivioOrdini() {
        return archivioOrdini;
    }

    public List<OrdineIngrosso> getListaDiOrdiniIngrosso() {
        return listaDiOrdiniIngrosso;
    }
    
    
    
    
}
