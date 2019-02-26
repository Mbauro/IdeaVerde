/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde.sconto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author mauro
 */
public class ScontoSilver extends ScontoTessera {
    
   

    public ScontoSilver(){
        
        this.percentualeSconto = leggiPercentualeDaFile();
    }
    
    public int getPercentualeSconto(){
        
        return this.percentualeSconto;
    }

    public void setPercentualeSconto(int percentualeSconto) {
        this.percentualeSconto = percentualeSconto;
    }
    
    
    
    public int leggiPercentualeDaFile(){
        int percentuale=0;
        try{
            //LA PRIMA RIGA DEL FILE CORRISPONDE ALLA PERCENTUALE DI SCONTO SILVER
            String line="";
            line = Files.readAllLines(Paths.get("src\\ideaverde\\sconti.txt")).get(0);
            System.out.println(line);
             percentuale = Integer.parseInt(line);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return percentuale;
    }
    
   
}
