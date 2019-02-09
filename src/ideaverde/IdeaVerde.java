/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class IdeaVerde {



    static List<Cliente> listaClienti = new ArrayList<Cliente>();
    static List<Tessera> listaTessere = new ArrayList<Tessera>();
    static List<TipoPianta> listaTipoPiante = new ArrayList<TipoPianta>();
    
    
    
        //Metodi
    public static void inserisciCliente(Cliente c){
        listaClienti.add(c);
    }
    
    public static Cliente ricercaCliente(String nomeCliente,String cognomeCliente){
    
        
        for(int i = 0; i< listaClienti.size(); i++){
            if(nomeCliente.equals(listaClienti.get(i).getNome()) && cognomeCliente.equals(listaClienti.get(i).getCognome())){
                System.out.println("UTENTE TROVATO!");
                return listaClienti.get(i);
            }
           
        }
        System.out.println("Utente non trovato");
        return null;
    }
    
    public static void modificaCliente(String nome, String cognome){
        
        Cliente c = ricercaCliente(nome,cognome);
        if(c != null){
            System.out.println("Scegli il parametro da modificare: ");
            System.out.println("1.email\n2.indirizzo\n3.cellulare");
            Scanner myScanner = new Scanner(System.in);
            
            int scelta = myScanner.nextInt();
            myScanner.nextLine();
            switch(scelta){
                    case 1:
                        System.out.println("Inserisci la nuova email...\n");
                        String nuovaEmail = myScanner.nextLine();
                        
                        c.setEmail(nuovaEmail);
                        break;
                    
                    case 2:
                        System.out.println("Inserisci il nuovo indirizzo...\n");
                        String nuovoIndirizzo = myScanner.nextLine();
                        
                        c.setIndirizzo(nuovoIndirizzo);
                        break;
                    
                    case 3:
                        System.out.println("Inserisci il nuovo numero di cellulare...\n");
                        String nuovoCellulare = myScanner.nextLine();
                        
                        c.setCellulare(nuovoCellulare);
                        break;
            }
        }
   
        
    }
    public static void eliminaCliente(String nome, String cognome){
            
            Cliente c = ricercaCliente(nome,cognome);
            
            if(c != null){
                listaClienti.remove(c);
                System.out.println("Cliente Eliminato!");
                
                String nomeCliente = c.getNome();
                String cognomeCliente = c.getCognome();
                
                for(Tessera object: listaTessere){
                    if(nomeCliente.equals(object.getNomeCliente()) && cognomeCliente.equals(object.getCognomeCliente())){
                        
                       Tessera t = object;
                       listaTessere.remove(t);
                       System.out.println("Tessera associata al cliente eliminata");
                       break;
                    }
                }
                
            }
        }
    
    public static void inserisciTipoPianta(String tipo, String descrizione, String varietà){
    
        TipoPianta tp = new TipoPianta(tipo,descrizione,varietà);
        listaTipoPiante.add(tp);
    }

       
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente("Mauro","Labruna","Viale Doria","mauro@live.it","333214567");
        Cliente c2 = new Cliente("Luca","Rossi","Viale Doria","luca@live.com","3332134566");
        Cliente c3 = new Cliente("Giorgio","Bianco","Viale Doria","giorgio@live.it","323456789");
        Tessera t1 = new Tessera(50,"Mauro","Labruna");
        Tessera t2 = new Tessera(120,"Luca","Rossi");
        Tessera t3 = new Tessera(20,"Giorgio","Bianco");
        
        
        
        listaClienti.add(c1);
        listaClienti.add(c2);
        listaClienti.add(c3);
        
        listaTessere.add(t1);
        listaTessere.add(t2);
        listaTessere.add(t3);
        
        Scanner myScanner = new Scanner(System.in);
        /*RICERCA
        Cliente c = ricercaCliente("Mauro","Labruna");
        System.out.println(c.toString());
        
        Cliente cli = ricercaCliente("ioqjdoi","ewfrew");
        */
        
       /* //Modifica Cliente
        for(Cliente object: listaClienti ){
            System.out.println(object.toString());
        }
        
        modificaCliente("Mauro","Labruna");
        */
       
        //Elimina Cliente
        /*for(Cliente object: listaClienti ){
            System.out.println(object.toString());
        }
        for(Tessera object: listaTessere ){
            System.out.println(object.toString());
        }
        
        eliminaCliente("Mauro","Labruna");
        */
        
        /*********inserimento cliente
        
        
        
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
        
        Cliente c = new Cliente(nomeCliente,cognomeCliente,emailCliente,indirizzoCliente,cellulareCliente);
       
        
        inserisciCliente(c);
        
        listaTessere.add(c.stampaTessera(c.getNome(), c.getCognome()));
        *****************************/
        
        //Inserisci Tipo Pianta
        System.out.println("Inserisci il tipo della pianta");
        String tipo = myScanner.nextLine();
        System.out.println("Inserisci la descrizione della pianta");
        String descrizione = myScanner.nextLine();
        System.out.println("Inserisci la varietà della pianta");
        String varietà = myScanner.nextLine();
        
        inserisciTipoPianta(tipo,descrizione,varietà);
        
        System.out.println("LISTA CLIENTI: ");
        
        for(Cliente object: listaClienti ){
            System.out.println(object.toString());
        }
        
        for(Tessera object: listaTessere ){
            System.out.println(object.toString());
        }
        
        for(TipoPianta object: listaTipoPiante ){
            System.out.println(object.toString());
        }
        
        
        
    }
    
}
