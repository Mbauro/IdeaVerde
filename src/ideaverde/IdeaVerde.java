/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class IdeaVerde{

    static String username="admin";
    static String password="password";
    
    
    // CATALOGO
    static Catalogo catalogo = new Catalogo();
    
    //Archivio
    static Archivio archivio = new Archivio();
    
    //Lista di clienti     
    static List<Cliente> listaClienti = new ArrayList<Cliente>();
    
    //Lista di fornitori
    static List<Fornitore>listaFornitori = new ArrayList();
    
    //Metodo per controllare l'autenticazione del gestore    
    public static int checkPwd(String username,String pwd){
        
        if((username.equals(IdeaVerde.username))&&(pwd.equals(IdeaVerde.password))){
            return 1;
        }else{
            
            return 0;
                
            }
        
    }
    
    


        
    /****************Gestione Clienti*****************/
    public static void inserisciCliente(String nome,String cognome,String indirizzo,String email,String cellulare){
        Cliente cliente = new Cliente(nome,cognome,indirizzo,email,cellulare);
        if(listaClienti.add(cliente)){
            System.out.println("Cliente registrato nel sistema.");
            Tessera tessera = cliente.stampaTessera(nome,cognome,email);
            if(tessera != null){
                
            }
            else{
                System.out.println("Non è stato possibile creare la tessera associata al cliente");
            }
        }
        else{
            System.out.println("Non è possibile registrare l'utente.");
        }
        
    }
        
    
    
    public static Cliente ricercaCliente(String nomeCliente,String cognomeCliente, String email){
    
        
        for(int i = 0; i< listaClienti.size(); i++){
            if(nomeCliente.equals(listaClienti.get(i).getNome()) && cognomeCliente.equals(listaClienti.get(i).getCognome())&& email.equals(listaClienti.get(i).getEmail())){
                System.out.println("UTENTE TROVATO!");
                return listaClienti.get(i);
            }
           
        }
        System.out.println("Utente non trovato");
        return null;
    }
    
    
    public static void modificaCliente(String nome, String cognome, String email){
        
        Cliente c = ricercaCliente(nome,cognome,email);
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
    
    public static void eliminaCliente(String nome, String cognome, String email){
            
            Cliente c = ricercaCliente(nome,cognome,email);
            
            if(c != null){
                listaClienti.remove(c);
                System.out.println("Cliente Eliminato!");
            }
    }
    
    public static void inserisciTipoPianta(String tipo, String descrizione, String varietà){
    
        TipoPianta tipoPianta = new TipoPianta(tipo,descrizione,varietà);
        
        TipoPianta tmp = null;
        
        for(TipoPianta object: catalogo.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo) && object.getVarietà().equalsIgnoreCase(varietà)){
                tmp = object;
                System.err.println("Tipo di pianta già registrato nel sistema\n");
                break;
            }
        }
        if(tmp == null){
            catalogo.getListaTipoPiante().add(tipoPianta);
            System.out.println("Tipo di pianta inserito\n");
        }
    }
    
    
    
    /******************Gestione Ordini**********************/
    
    public static OrdineCliente creaNuovoOrdine(Cliente c){
        //OrdineCliente o = new OrdineCliente();
        //o.setC(c);
        return archivio.creaNuovoOrdine(c);
        
    }
    
    
    public static Pianta selezionaPianta(String tipo, String varietà, int età, int quantità){
        
        TipoPianta tipoPianta = null;
        
        //Seleziona il tipo di pianta dalla listaTipoPiante in base al tipo ed alla varietà
        for(TipoPianta object: catalogo.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo) && object.getVarietà().equalsIgnoreCase(varietà)){
                tipoPianta = object;
//                Pianta pianta = tipoPianta.getPianta(età);
                  for(Pianta object1: tipoPianta.getListaPiante()){
                      if(object1.getEtàPianta() == età){
                          
                          return object1;
                      }
                   }
                
                //return pianta;
            }
            
        }
        if(tipoPianta == null){
            System.err.println("Tipo Pianta non trovato");
            
        }
        return null;
    }
    
    
    public static void aggiungiPianta(OrdineCliente o, String tipo, String varietà, int quantità, Pianta pianta){
            
            int qua=-quantità;
            
            o.creaRigaDiOrdine(tipo, varietà, quantità, pianta);
            TipoPianta tp = null;

            for(TipoPianta object: catalogo.getListaTipoPiante()){
                if(object.getTipo().equalsIgnoreCase(tipo) && object.getVarietà().equalsIgnoreCase(varietà)){
                    tp = object;
                }
            }
            if(tp != null){
                tp.setQuantitaPianta(pianta.getEtàPianta(), qua);
            }
    }
    
    public static void stampaListaFornitori(){
        for(Fornitore object: listaFornitori){
            object.mio_toString();
        }
    }
    
    public static void setSpedizione(String tipoSpedizione,OrdineCliente ordine){
        ordine.insertSpedizone(tipoSpedizione);
    }
    
    public static void setQuantitaDisponibile(String tipo,String varieta,Pianta p,int quantita){
        if(quantita<0){
            System.err.println("Quantità non valida");
        }else{
            catalogo.setQuantitaDisponibile(tipo,varieta,p,quantita);
        }    
    }
    
    public static void setPagamento(String tipoPagamento, OrdineCliente ordine){
        
        ordine.insertPagamento(tipoPagamento);
    }
    
    public static float calcolaTotale(OrdineCliente o){
        float totale = o.getTotale();
        System.out.println("Totale non scontato: "+totale+" €");
        float totale_scontato = o.getTotaleScontato();
        System.out.println("Totale scontato: "+totale_scontato+" €");
        totale_scontato+=o.getSpedizione().getPrezzo();
        System.out.println("Totale scontato compreso di spese di spedizione = "+totale_scontato);
        o.getCliente().getTessera().setPunti((int)totale_scontato);
        o.setTotale(totale_scontato);
        return totale_scontato;
    }
     
    public static void confermaOrdine(OrdineCliente o, Cliente c){
        
        c.getListaDiOrdini().add(o);
        archivio.getListaOrdini().add(o);

    }
     
    /**************** GESTIONE PRENOTAZIONE*****************/
    public static Prenotazione creaPrenotazione(Cliente c){
        return archivio.creaPrenotazione(c);
        //Prenotazione prenotazione = new Prenotazione();
        //prenotazione.setCliente(c);
        //return prenotazione;
    }
    
    public static void effettuaPrenotazione(String tipo, String varietà,int quantità, Pianta p, Prenotazione prenotazione){
        
        p.addObserver(archivio);
        //Osservatore o = new Osservatore(p);
        
        //p.addObserver(o);
        
        prenotazione.creaRigaDiOrdine(tipo, varietà, quantità, p);
        
        
    }
    
    public static void confermaPrenotazione(Prenotazione p){
        
        archivio.getListaDiPrenotazioni().add(p);
    }
    
    /*********ORDINE ALL'INGROSSO************/
    public static OrdineIngrosso creaOrdineIngrosso(){
        
        return archivio.creaOrdineIngrosso();
        
    }
    
    public static void aggiungiPiantaOrdineIngrosso(OrdineIngrosso o, String tipo, String varieta, int eta, int quantita){
        
        o.creaRigaDiOrdine(tipo, varieta, quantita, eta);
        
    }
    
    public static int checkEmailFornitore(String email){
        Scanner myScanner=new Scanner(System.in);
        int controllo=0;
        for(Fornitore object: IdeaVerde.getListaFornitori()){
            if(email.equalsIgnoreCase(object.getEmailFornitore())){
                controllo=1;
            }
        }
        if(controllo==0){
            System.out.println("EMAILNONCORRETTA!!!Inserisci l'email del fornitore presso il quale vuoi effettuare l'ordine: ");
            email= myScanner.nextLine();
        }
        return controllo;
    }
    
    public static void confermaOrdineIngrosso(OrdineIngrosso o,String emailFornitore){
        
        IdeaVerde.getArchivio().getListaOrdini().add(o);
        o.setEmailFornitore(emailFornitore);
        o.inviaEmailFornitore(emailFornitore);
        
        
    
    }
    
    public static void eliminaPrenotazione(String nome,String cognome,String email){
        archivio.eliminaPrenotazione(nome,cognome,email);
        
    }
    
    public static void stampaPrenotazioni(){
        archivio.stampaPrenotazioni();
    }
    
    
    
    
    
    public static void setScontoContante(int newsconto){
        List<String> contenutoFile = leggiFileSconti();
        
        
        contenutoFile.set(3, Integer.toString(newsconto));
        
        stampaFileSconti(contenutoFile);
       
    }
    
    public static void setScontoCartaDiCredito(int newsconto){
        
        List<String> contenutoFile = leggiFileSconti();
        contenutoFile.set(2, Integer.toString(newsconto));
        stampaFileSconti(contenutoFile);

        
    }
    
    
    
    public static void setScontoSilver(int newsconto){
        
        List<String> contenutoFile = leggiFileSconti();
        contenutoFile.set(0, Integer.toString(newsconto));
        stampaFileSconti(contenutoFile);
    }
        
    
    
    public static void setScontoGold(int newsconto){
        
        List<String> contenutoFile = leggiFileSconti();
        contenutoFile.set(1, Integer.toString(newsconto));
        stampaFileSconti(contenutoFile);
        
        
    
        
    }
    
    private static List<String> leggiFileSconti(){
        
        List<String> contenutoFile = new ArrayList();
        try{
            File f = new File("src//ideaverde//sconti.txt");
            FileInputStream fs= new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String linea=null;
            while(true){
                linea=br.readLine();
                if(linea==null){
                    break;
                }else{
                    contenutoFile.add(linea);
                }
            }
            fs.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(contenutoFile.toString());
        return contenutoFile;
        
    }
    
    private static void stampaFileSconti(List<String> contenutoFile){
        
        try{
            File f = new File("src//ideaverde//sconti.txt");
            if(f.exists()){
                PrintWriter myprint = new PrintWriter(f);
                for(String object: contenutoFile){
                    myprint.println(object);
                }
                myprint.close();
            }else{
                
                System.out.println("ERRORE FILE SCONTI");
                
            }
            
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    
        
    }
    
    
    public static void stampaCatalogo(){
        catalogo.stampaCatalogo();
    }
    
    public static boolean checkTipoPianta(String tipo, String varieta){
        
        for(TipoPianta object: catalogo.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo)&&object.getVarietà().equalsIgnoreCase(varieta)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkEtaPianta(int eta,String tipo){
        
        for(TipoPianta object: catalogo.getListaTipoPiante()){
            if(object.getTipo().equalsIgnoreCase(tipo)){
                for(Pianta object1 : object.getListaPiante()){
                    if(object1.getEtàPianta()==eta){
                        return true;
                    }
                }
               
            }
        }
        return false;
    }
    
    public static void inserisciPianta(String tipo,String varieta,int eta,int quantita){
        catalogo.inserisciPianta(tipo, varieta, eta, quantita);
    }
    
    public static void inserisciFornitore(String nome,String email,String telefono){
        int controllo=0;
        for(Fornitore object: listaFornitori){
            if(object.getEmailFornitore().equalsIgnoreCase(email)){
                controllo=1;
            }
        }
        if(controllo==1){
            System.err.println("Il fornitore è gia registrato!!!");
        }else{
            Fornitore f=new Fornitore(nome,email,telefono);
            listaFornitori.add(f);
        }
    }
    
    /******************Liste*******************/
    
    public static List<Cliente> getListaClienti() {
        return listaClienti;
    }

    public static Archivio getArchivio(){
        return archivio;
    }

    public static List<Prenotazione> getListaDiPrenotazioni() {
        return archivio.getListaDiPrenotazioni();
    }

    public static Catalogo getCatalogo() {
        return catalogo;
    }

    public static List<Fornitore> getListaFornitori() {
        return listaFornitori;
    }
    
    


    
    

         
}
