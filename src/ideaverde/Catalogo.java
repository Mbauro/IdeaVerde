/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coppo
 */
public class Catalogo {
    
    List<TipoPianta> listaTipoPiante;
    
    public Catalogo(){
        listaTipoPiante = new ArrayList<TipoPianta>();
    }

    public List<TipoPianta> getListaTipoPiante() {
        return listaTipoPiante;
    }
    
    
}
