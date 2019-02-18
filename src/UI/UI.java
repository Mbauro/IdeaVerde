/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ideaverde.*;
import java.util.Scanner;

/**
 *
 * @author mauro
 */
public class UI {
    
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  
    
    public static void main(String[] args){
        
        TipoPianta tp1 = new TipoPianta("Limone","giallo","varietà1");
        TipoPianta tp2 = new TipoPianta("Arancia","arancione","varietà1");
        Pianta limone = new Pianta(2,1000);
        Pianta arancia = new Pianta(5,400);
        Pianta limone2 = new Pianta(10,550);
        tp1.getListaPiante().add(limone);
        tp1.getListaPiante().add(limone2);
        tp2.getListaPiante().add(arancia);
        IdeaVerde.getListaTipoPiante().add(tp1);
        IdeaVerde.getListaTipoPiante().add(tp2);
        
        Archivio archivio = IdeaVerde.getArchivio();
        
        
        System.out.println("***********SOFTWARE IDEAVERDE************");
        int scelta;
        Scanner myScanner = new Scanner(System.in);
        do{
        System.out.println("Seleziona l'operazione che vuoi fare");
        
        
        
        System.out.println("1.Inserisci Cliente\n"
                         + "2.Modifica Cliente\n"
                         + "3.Elimina Cliente\n"
                         + "4.Crea un nuovo ordine\n"
                         + "5.Stampa Lista Clienti\n"
                         + "0.Esci Dal software");
        
        scelta = myScanner.nextInt();
        myScanner.nextLine();
        
        clearScreen();
        
        switch(scelta){
            
            case 1: {
                System.out.println("Inserisci il nome del cliente: ");
                String nomeCliente = myScanner.nextLine();
        
                System.out.println("Inserisci il cognome del cliente: ");
                String cognomeCliente = myScanner.nextLine();

                System.out.println("Inserisci l'email del cliente: ");
           
                String emailCliente = myScanner.nextLine();
                System.out.println("Inserisci il indirizzo del cliente: ");
                String indirizzoCliente = myScanner.nextLine();
                System.out.println("Inserisci il cellulare del cliente: ");
                String cellulareCliente = myScanner.nextLine();

                Cliente c = new Cliente(nomeCliente,cognomeCliente,indirizzoCliente,emailCliente,cellulareCliente);


                IdeaVerde.inserisciCliente(c);
               
                break;
            }
            case 2:{
                
                System.out.println("Inserisci il nome del cliente da modificare");
                String nomeCliente = myScanner.nextLine();
                
                System.out.println("Inserisci il cognome del cliente da modificare");
                String cognomeCliente = myScanner.nextLine();
                                
                IdeaVerde.modificaCliente(nomeCliente, cognomeCliente);
                break;
            }
            case 3:{
                    System.out.println("Inserisci il nome del cliente da eliminare");
                    String nomeCliente = myScanner.nextLine();
                
                    System.out.println("Inserisci il cognome del cliente da eliminare");
                    String cognomeCliente = myScanner.nextLine();
                    IdeaVerde.eliminaCliente(nomeCliente, cognomeCliente);
                
                break;
            }
                
            case 4:{
                             
               System.out.println("Inserisci il nome del cliente che vuole effettuare l'ordine");
               String nomeCliente = myScanner.nextLine();
                
               System.out.println("Inserisci il cognome del cliente che vuole effettuare l'ordine");
               String cognomeCliente = myScanner.nextLine();
                
               Cliente c = IdeaVerde.ricercaCliente(nomeCliente, cognomeCliente);
                
               if(c!= null){
                    Ordine ordine = IdeaVerde.creaNuovoOrdine();
                    String continuare = "s";

                do{
                //Stampa l'elenco delle tipi di pianta e delle piante ad essi associati
                for(TipoPianta object: IdeaVerde.getListaTipoPiante()){
                    System.out.println(object.toString());
                    for(Pianta object2: object.getListaPiante()){
                        System.out.println(object2.toString());
                    }
                }
                    
                    System.out.println("Inserisci il tipo: ");
                    String tipo = myScanner.nextLine();

                    System.out.println("Inserisci la varietà: ");
                    String varietà = myScanner.nextLine();

                    System.out.println("Inserisci l'età della pianta da ordinare");
                    int età = myScanner.nextInt();

                    System.out.println("Inserisci la quantità di piante da ordinare");
                    int quantità = myScanner.nextInt();
                    
                    try{
                    Pianta p = IdeaVerde.selezionaPianta(tipo,varietà,età,quantità);
                    if(p.getQuantitàDisponibile() < quantità){
                        System.err.println("Non è possibile inserire la pianta. Quantità non disponibile");
                    }
                    else{
                            
                    IdeaVerde.aggiungiPianta(ordine, tipo, varietà, quantità, p);
                    System.out.println("Pianta aggiunta nell'ordine");
                    }
                    }catch(NullPointerException e){
                        //Tipo Pianta non trovato
                    }
                    System.out.println("Vuoi aggiungere altre piante? s/n");


                    myScanner.nextLine();
                    continuare = myScanner.nextLine();

                }while(!continuare.equalsIgnoreCase("n"));
               
                float totale = IdeaVerde.calcolaTotale(ordine);
                   //Stampa righe di ordine
                   for(RigaDiOrdine object: ordine.getListaRigheDiOrdine()){
                      System.out.println(object.toString());
                   }
                   System.out.println("Totale Ordine: "+totale+" €");
                   
                   System.out.println("Seleziona il tipo di pagamento\n1.Contanti\n2.Carta di credito\n");
                   scelta = myScanner.nextInt();
                   switch(scelta){
                       case 1:{
                           IdeaVerde.setPagamento("Contanti", ordine);
                           break;
                       }
                       case 2:{
                           IdeaVerde.setPagamento("CartaDiCredito", ordine);
                           break;
                       }
                   }
                   
                   System.out.println("Seleziona la modalità di consegna\n1.Ritiro in sede\n2.Corriere espresso\n");
                   scelta = myScanner.nextInt();
                   switch(scelta){
                       case 1:{
                           IdeaVerde.setSpedizione("RitiroInSede", ordine);
                           break;
                       }
                       case 2:{
                           IdeaVerde.setSpedizione("Corriere", ordine);
                           break;
                       }
                   }
                   
                   IdeaVerde.confermaOrdine(ordine, c, archivio);
                   
                                
                   for(Ordine object: archivio.getArchivioOrdini()){
                       System.out.println(object.toString());
                   }
                    for(Ordine object: c.getListaDiOrdini()){
                       System.out.println(object.toString());
                   }
               }
               
               
               break;
            
            }
                
                
                
                
            case 5:{
                System.out.println("*********LISTA CLIENTI***********\n");
                if(IdeaVerde.getListaClienti().isEmpty()){
                    System.out.println("Lista Vuota\n");
                }
                else{
                    for(Cliente object: IdeaVerde.getListaClienti()){
                        System.out.println(object);
                    }
                }
                break;
            }
        }
        
        }while(scelta != 0);
        
    }
    
}
