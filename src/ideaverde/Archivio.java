/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;

public class Archivio {
    
    private List<Ordine> archivioOrdini;

    public Archivio() {
        this.archivioOrdini = new ArrayList();
    }

    public List<Ordine> getArchivioOrdini() {
        return archivioOrdini;
    }
    
    
    
}
