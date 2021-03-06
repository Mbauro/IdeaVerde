/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.sconto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author mauro
 */
public class ScontoCartaDiCredito extends ScontoPagamento {

    public ScontoCartaDiCredito() {
       
        this.percentualeSconto = leggiPercentualeDaFile();
    }
    
    @Override
    public int getPercentualeSconto(){
        return this.percentualeSconto;
    }

    public void setPercentualeSconto(int percentualeSconto) {
        this.percentualeSconto = percentualeSconto;
    }
    
    
    
    public int leggiPercentualeDaFile(){
        int percentuale=0;
        try{
            //LA TERZA RIGA DEL FILE CORRISPONDE ALLA PERCENTUALE DI SCONTO CARTA DI CREDITO
            String line="";
            line = Files.readAllLines(Paths.get("src\\ideaverde\\sconti.txt")).get(2);
            
             percentuale = Integer.parseInt(line);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return percentuale;
    }
}
