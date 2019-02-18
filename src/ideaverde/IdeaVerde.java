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
        if(listaClienti.add(c)){
            System.out.println("Cliente registrato nel sistema.");
        }
        else{
            System.out.println("Non è possibile registrare l'utente.");
        }
        
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
    
        TipoPianta tipoPianta = new TipoPianta(tipo,descrizione,varietà);
        listaTipoPiante.add(tipoPianta);
    }
    
    public static Ordine creaNuovoOrdine(){
        Ordine o = new Ordine();
        return o;
        
    }
    
    public static float calcolaTotale(Ordine o){
        float totale = o.getTotale();
        return totale;
    }
    
    public static void confermaOrdine(Ordine o, Cliente c, Archivio a){
         c.getListaDiOrdini().add(o);
         o.setC(c);
         a.getArchivioOrdini().add(o);
         
         
         
    }
    
    public static void aggiungiPianta(Ordine o, String tipo, String varietà, int quantità, Pianta pianta){
        
        o.creaRigaDiOrdine(tipo, varietà, quantità, pianta);
         
    }
    
    public void setPagamento(String tipoPagamento, Ordine o){
        
    }
    
    public void setSpedizione(String tipoSpedizione,Ordine o){
        o.setSpedizione(tipoSpedizione);
    }
    
    public static Pianta selezionaPianta(String tipo, String varietà, int età, int quantità){
        
        TipoPianta tipoPianta = null;
        
        //Seleziona il tipo di pianta dalla listaTipoPiante in base al tipo ed alla varietà
        for(TipoPianta object: getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo) && object.getVarietà().equalsIgnoreCase(varietà)){
                tipoPianta = object;
                Pianta pianta = tipoPianta.getPianta(età);
                
                
                tipoPianta.setQuantitàPianta(età, quantità);
                return pianta;
            }
            
        }
        if(tipoPianta == null){
            System.err.println("Tipo Pianta non trovato");
            
        }
        return null;
    }
    
    

    public static List<Cliente> getListaClienti() {
        return listaClienti;
    }

    public static List<Tessera> getListaTessere() {
        return listaTessere;
    }

    public static List<TipoPianta> getListaTipoPiante() {
        return listaTipoPiante;
    }
    
    public static Archivio getArchivio(){
        Archivio archivio = new Archivio();
        return archivio;
    }
    
    

         
}
