/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ideaverde.*;
import static java.lang.System.*;
import java.util.Scanner;
import ideaverde.IdeaVerde;
import ideaverde.sconto.ScontoSilver;


/**
 *
 * @author mauro
 */
public class UI {
    
        public static void main(String[] args){
            
        //ISTANZE UTILIZZATE PER SIMULARE IL SOFTWARE
        Fornitore f1 = new Fornitore("green garden","info@green.it","094183654");
        Fornitore f2 = new Fornitore("red garden","info@red.it","094183657");
        Fornitore f3 = new Fornitore("blue garden","info@blue.it","094183664");
        //Fornitore f4 = new Fornitore("yellow garden","redfish32@hotmail.it","094143654");
        
        TipoPianta tp1 = new TipoPianta("Limone","giallo","varieta");
        TipoPianta tp2 = new TipoPianta("Arancia","arancione","varieta");
        Pianta limone = new Pianta(2,1000);
        Pianta arancia = new Pianta(5,400);
        Pianta limone2 = new Pianta(10,550);
        tp1.getListaPiante().add(limone);
        tp1.getListaPiante().add(limone2);
        tp2.getListaPiante().add(arancia);
        IdeaVerde.getCatalogo().getListaTipoPiante().add(tp1);
        IdeaVerde.getCatalogo().getListaTipoPiante().add(tp2);
        IdeaVerde.getListaFornitori().add(f1);
        IdeaVerde.getListaFornitori().add(f2);
        IdeaVerde.getListaFornitori().add(f3);
        //IdeaVerde.getListaFornitori().add(f4);
        
        
        
        /*for(TipoPianta object: IdeaVerde.getCatalogo().getListaTipoPiante()){
            System.out.println(object.toString());
        }*/
        
        Archivio archivio = IdeaVerde.getArchivio();
        
        
        System.out.println("***********SOFTWARE IDEAVERDE************");
        int scelta;
        Scanner myScanner = new Scanner(System.in);
        do{
        System.out.println("Seleziona l'operazione che vuoi fare");
        
        
        
        System.out.println("1.Inserisci Cliente\n"
                         + "2.Modifica Cliente\n"
                         + "3.Elimina Cliente\n"
                         + "4.Inserisci nuovo tipo di pianta\n"
                         + "5.Crea un nuovo ordine\n"
                         + "6.Effettua Ordine all'Ingrosso\n"
                         + "7.Mostra ordini relativi ad un cliente\n"
                         + "8.Aggiorna quantita disponibile di una pianta\n"
                         + "9.Modifica scontistica (Questa operazione può essere fatta soltanto dal gestore)\n"
                         + "10.Inserisci nuova pianta di un tipo già presente in vivaio\n"
                         + "11.Cancella prenotazione\n"
                         + "12.Stampa Lista Clienti\n"
                         + "13.Stampa Lista Prenotazioni\n"
                         + "14.Inserisci un nuovo fornitore\n"
                         + "0.Esci Dal software");
        
        scelta = myScanner.nextInt();
        myScanner.nextLine();
        
                
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

                
                IdeaVerde.inserisciCliente(nomeCliente,cognomeCliente,indirizzoCliente,emailCliente,cellulareCliente);

                break;
            }
            case 2:{
                
                System.out.println("Inserisci il nome del cliente da modificare");
                String nomeCliente = myScanner.nextLine();
                
                System.out.println("Inserisci il cognome del cliente da modificare");
                String cognomeCliente = myScanner.nextLine();
                
                System.out.println("Inserisci l'email del cliente da modificare");
                String emailCliente = myScanner.nextLine();                
                // MODIFICA IL CLIENTE CORRISPONDENTE AI DATI INSERITI
                IdeaVerde.modificaCliente(nomeCliente, cognomeCliente,emailCliente);
                break;
            }
            case 3:{
                    
                    System.out.println("Inserisci il nome del cliente da eliminare");
                    String nomeCliente = myScanner.nextLine();
                
                    System.out.println("Inserisci il cognome del cliente da eliminare");
                    String cognomeCliente = myScanner.nextLine();
                    
                    System.out.println("Inserisci l'email cliente da eliminare");
                    String emailCliente = myScanner.nextLine();                    
                    //Cancellazione cliente corrispondente ai dati inseriti
                    
                    IdeaVerde.eliminaCliente(nomeCliente, cognomeCliente,emailCliente);
                
                break;
            }
            
            case 4:{
                System.out.println("Inserisci il tipo della pianta da inserire");
                String tipo = myScanner.nextLine();
                System.out.println("Inserisci la varietà della pianta da inserire");
                String varieta = myScanner.nextLine();
                System.out.println("Inserisci la descrizione della pianta da inserire");
                String descrizione = myScanner.nextLine();
                IdeaVerde.inserisciTipoPianta(tipo, descrizione, varieta);

                break;
            }
                
            case 5:{
                             
               System.out.println("Inserisci il nome del cliente che vuole effettuare l'ordine");
               String nomeCliente = myScanner.nextLine();
                
               System.out.println("Inserisci il cognome del cliente che vuole effettuare l'ordine");
               String cognomeCliente = myScanner.nextLine();
               
               System.out.println("Inserisci l'email del cliente che vuole effettuare l'ordine");
               String emailCliente = myScanner.nextLine(); 
               
                //Effettua la ricerca in base ai dati inseriti
               Cliente c = IdeaVerde.ricercaCliente(nomeCliente, cognomeCliente,emailCliente);
                
               if(c!= null){
                    OrdineCliente ordine = IdeaVerde.creaNuovoOrdine(c);
                    Prenotazione prenotazione = null;
                    String continuare = "s";

                do{
                //Stampa l'elenco delle tipi di pianta e delle piante ad essi associati
                    IdeaVerde.stampaCatalogo();
                    
                    System.out.println("Inserisci il tipo: ");
                    String tipo = myScanner.nextLine();

                    System.out.println("Inserisci la varietà: ");
                    String varietà = myScanner.nextLine();

                    System.out.println("Inserisci l'età della pianta da ordinare");
                    int età = myScanner.nextInt();

                    System.out.println("Inserisci la quantità di piante da ordinare");
                    int quantità = myScanner.nextInt();
                    
                    try{
                        Pianta pianta = IdeaVerde.selezionaPianta(tipo,varietà,età,quantità);
                        
                        // La quantità richiesta dal cliente non è disponibile
                        if(pianta.getQuantitàDisponibile() < quantità){
                            myScanner.nextLine();
                            System.err.println("Non è possibile inserire la pianta. Quantità non disponibile");
                            //myScanner.nextLine();

                            System.err.println("Vuoi effettuare una prenotazione per questo articolo? s/n");
                            String tmp = myScanner.nextLine();
                            
                            if(tmp.equalsIgnoreCase("s")){
                                if(prenotazione == null){
                                    prenotazione = IdeaVerde.creaPrenotazione(c);
                                
                                System.out.println("Prenotazione effettuata");
                                IdeaVerde.effettuaPrenotazione(tipo,varietà,quantità,pianta,prenotazione);
                                }
                                else{
                                    System.out.println("Prenotazione effettuata");
                                    IdeaVerde.effettuaPrenotazione(tipo,varietà,quantità,pianta,prenotazione);
                                }
                            }
                            
                        }
                        else{

                        IdeaVerde.aggiungiPianta(ordine, tipo, varietà, quantità, pianta);
                        System.out.println("Pianta aggiunta nell'ordine");
                        }
                        
                    }catch(NullPointerException e){
                        System.err.println("Pianta non trovata. Riprova l'inserimento");
                    }
                    myScanner.nextLine();
                    System.out.println("Vuoi aggiungere altre piante? s/n");
                    
                     //pulisce lo scanner
                    continuare = myScanner.nextLine();

                }while(!continuare.equalsIgnoreCase("n"));
                
                if(prenotazione!=null){
                    IdeaVerde.confermaPrenotazione(prenotazione);
                }
                
                if(ordine.getListaRigheDiOrdine().isEmpty()){
                    break;
                }
                //Stampa righe di ordine
                ordine.stampaRiepilogoOrdine();
                //Stampa il totale non scontato dell'ordine
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
                
                float totale_scontato=IdeaVerde.calcolaTotale(ordine);
                
                
                   
                IdeaVerde.confermaOrdine(ordine, c);
                   
                              
            }


            break;
            
            }
                
            case 6:{

                System.out.println("Crea ordine all'ingrosso");
                
                OrdineIngrosso ordine = IdeaVerde.creaOrdineIngrosso();
                
                String check = "s";
                
                do{
                    //Stampa l'elenco delle tipi di pianta e delle piante ad essi associati
                    IdeaVerde.stampaCatalogo();

                    System.out.println("Inserisci il tipo: ");
                    String tipo = myScanner.nextLine();

                    System.out.println("Inserisci la varietà: ");
                    String varieta = myScanner.nextLine();

                    System.out.println("Inserisci l'età della pianta da ordinare");
                    int eta = myScanner.nextInt();


                    System.out.println("Inserisci la quantità di piante da ordinare");
                    int quantita = myScanner.nextInt();
                    IdeaVerde.aggiungiPiantaOrdineIngrosso(ordine, tipo, varieta, eta, quantita);
                    myScanner.nextLine();
                    System.out.println("Vuoi continuare? s/n");
                    check = myScanner.nextLine();
                        
                }while(check.equalsIgnoreCase("s"));
                
                IdeaVerde.stampaListaFornitori();
                
                System.out.println("Inserisci l'email del fornitore presso il quale vuoi effettuare l'ordine: ");
                String email= myScanner.nextLine();
                int controllo=0;
                do{
                    controllo=IdeaVerde.checkEmailFornitore(email);
                    
                }while(controllo==0);         
                
                IdeaVerde.confermaOrdineIngrosso(ordine,email);
                    
                break;
                    
            
            }
            
            case 7:{
                System.out.println("Inserire le generalità del cliente del quale si vogliono visualizzare gli ordini");
                
                System.out.println("Inserisci il cognome del cliente: ");
                String cognome=myScanner.nextLine();
                
                System.out.println("Inserisci il nome del cliente: ");
                String nome=myScanner.nextLine();
                
                System.out.println("Inserisci l'email del cliente: ");
                String email=myScanner.nextLine();
                
                Cliente c=IdeaVerde.ricercaCliente(nome, cognome, email);
                
                c.stampaListaOrdini();
                
                
                break;
            }
                
            case 8:{
                String continuare = "s";
                do{
                    IdeaVerde.stampaCatalogo();

                    System.out.println("Inserisci il tipo: ");

                    String tipo = myScanner.nextLine();

                    System.out.println("Inserisci la varietà: ");
                    String varieta = myScanner.nextLine();

                    System.out.println("Inserisci l'età della pianta di cui aggiornare la quantità");
                    int eta = myScanner.nextInt();

                    System.out.println("Inserisci la quantità di piante arrivate dal fornitore");
                    int quantita = myScanner.nextInt();

                    try{

                        Pianta p= IdeaVerde.selezionaPianta(tipo, varieta, eta, quantita);
                        IdeaVerde.setQuantitaDisponibile(tipo, varieta, p, quantita);
                        
                    }catch(NullPointerException e){

                        System.err.println("Pianta non trovata. Riprova l'inserimento");
                    }
                    myScanner.nextLine();
                    System.out.println("Ci sono altre piante di cui bisogna aggiornare la quantità? (s/n)");
                    continuare=myScanner.nextLine();
                }while(continuare.equalsIgnoreCase("s"));
                break;
            }
            
            case 9:{
                
                System.out.println("ATTENZIONE!!! Per eseguire questa operazione è necessario autenticarsi come gestore");
                System.out.println("Inserisci username: ");
                String username = myScanner.nextLine();
                System.out.println("Inserisci password: ");
                String pwd = myScanner.nextLine();
                int check = IdeaVerde.checkPwd(username, pwd);
                if(check==0){
                    System.err.println("USERNAME O PASSWORD ERRATI");
                }else{
                    System.out.println("Autenticazione OK!!!!");
                    System.out.println("Quale sconto vuoi modificare?\n1.Sconto Tessera\n2.Sconto Pagamento");
                    int sceltasconto= myScanner.nextInt();
                    switch(sceltasconto){
                        
                        case 1:{
                            
                            System.out.println("Quale sconto vuoi modificare?\n1.Sconto Silver\n2.Sconto Gold");
                            sceltasconto=myScanner.nextInt();
                            switch(sceltasconto){
                                
                                case 1:{
                                    
                                    System.out.println("Inserisci la nuova percentuale di sconto che vuoi attribuire a sconto Silver");
                                    int new_sconto=myScanner.nextInt();
                                    IdeaVerde.setScontoSilver(new_sconto);
                                    
                                    break;
                                }    
                                case 2:{
                                    System.out.println("Inserisci la nuova percentuale di sconto che vuoi attribuire a sconto Gold");
                                    int new_sconto=myScanner.nextInt();
                                    IdeaVerde.setScontoGold(new_sconto);
                                    
                                    break;
                                }
                            }
                            
                            break;
                        }
                        case 2:
                            
                            System.out.println("Quale sconto vuoi modificare?\n1.Carta di credito\n2.Contanti");
                            sceltasconto=myScanner.nextInt();
                            switch(sceltasconto){
                                case 1:{
                                    
                                    System.out.println("Inserisci la nuova percentuale di sconto che vuoi attribuire a sconto carta di credito");
                                    int new_sconto=myScanner.nextInt();
                                    IdeaVerde.setScontoCartaDiCredito(new_sconto);
                                    
                                    break;
                                }
                                case 2:{
                                    
                                    System.out.println("Inserisci la nuova percentuale di sconto che vuoi attribuire a sconto contanti");
                                    int new_sconto=myScanner.nextInt();
                                    IdeaVerde.setScontoContante(new_sconto);
                                    
                                    break;
                                }
                            }
                            
                            break;
                        
                    }
                }
 
                
                break;
            }
            
            case 10:{
                IdeaVerde.stampaCatalogo();
                System.out.println("Inserisci il tipo di pianta: ");
                String tipo=myScanner.nextLine();
                System.out.println("Inserisci la varietà: ");
                String varieta = myScanner.nextLine();
                if(IdeaVerde.checkTipoPianta(tipo, varieta)){
                    System.out.println("Inserisci l'età della pianta: ");
                    int eta=myScanner.nextInt();
                    if(IdeaVerde.checkEtaPianta(eta, tipo)){
                        System.err.println("Pianta già presente");
                    }else{
                        System.out.println("Inserisci la quantita': ");
                        int quantita=myScanner.nextInt();
                        IdeaVerde.inserisciPianta(tipo,varieta,eta,quantita);
                    }
                }else{
                    System.err.println("TIPO O VARIETA' NON CORRETTI");
                }
                break;
                
            }
            
            case 11:{
                IdeaVerde.stampaPrenotazioni();
                if(IdeaVerde.getArchivio().getListaDiPrenotazioni().isEmpty()){
                    System.err.println("ATTUALMENTE NON SONO PRESENTI PRENOTAZIONI");
                }else{
                    IdeaVerde.stampaPrenotazioni();
                    
                    System.out.println("Inserire le generalità del cliente del quale si vuole eliminare la prenotazione");

                    System.out.println("Inserisci il cognome del cliente: ");
                    String cognome=myScanner.nextLine();

                    System.out.println("Inserisci il nome del cliente: ");
                    String nome=myScanner.nextLine();

                    System.out.println("Inserisci l'email del cliente: ");
                    String email=myScanner.nextLine();
                    
                    IdeaVerde.eliminaPrenotazione(cognome,nome,email);
                }
                break;
            }
            
            case 12:{
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
            
            case 13:{
                
                IdeaVerde.stampaPrenotazioni();
                break;
            }
            
            case 14:{
                
                System.out.println("INSERIMENTO FORNITORE");
                
                System.out.println("Inserisci nome fornitore");
                String nome=myScanner.nextLine();
                
                System.out.println("Inserisci email fornitore");
                String email=myScanner.nextLine();
                
                System.out.println("Inserisci telefono fornitore");
                String telefono=myScanner.nextLine();
                
                IdeaVerde.inserisciFornitore(nome,email,telefono);
            }
        }
        
        }while(scelta != 0);
        
    }
    
}
