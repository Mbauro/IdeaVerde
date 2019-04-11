/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideaverde;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class OrdineIngrosso extends Ordine {

    //FORNITORE
    private String emailFornitore;
    
    public OrdineIngrosso() {
        
        this.listaRigheDiOrdine = new ArrayList();
        
    }
    
    public void creaRigaDiOrdine(String tipo, String varieta, int quantita, int eta){
         
         RigaDiOrdine r = new RigaDiOrdine(tipo,varieta,quantita,eta);
         this.listaRigheDiOrdine.add(r);
     }
     
    public void inviaEmailFornitore(String emailFornitore){
         
          // Recipient's email ID needs to be mentioned.
      String to = emailFornitore;

      // Sender's email ID needs to be mentioned
      String from = "ideaverdect@email.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties props = new java.util.Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.starttls.enable", "true"); 
    props.put("mail.smtp.auth", "true");
    
    Session session = javax.mail.Session.getInstance( props, 
         new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
               return new javax.mail.PasswordAuthentication("ideaverdect@email.com", "passwd"); //username and password
       }
         });
      

      // Get the default Session object.
    
      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
         // Set Subject: header field
         message.setSubject("Ordine ingrosso del "+timeStamp);

         // Now set the actual message
         for (RigaDiOrdine object: this.getListaRigheDiOrdine()){
            message.setText(object.toStringIngrosso());
         }
         
         
         Transport.send(message);
         System.out.println("Ordine inviato correttamente tramite email");
      } catch (MessagingException mex) {
            mex.printStackTrace();
      }
         
         
     }
     
    public void stampaOrdineIngrosso(String email){
               
        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        
          
      
        try{
            File f = new File(timeStamp+".txt");
            if(f.exists()){
                                
            }else if(f.createNewFile()){
                PrintWriter myprint = new PrintWriter(f);
                for(RigaDiOrdine object: this.getListaRigheDiOrdine()){
                    myprint.println(object.toStringIngrosso());
                }
                
                myprint.close();
            }
            
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
         
     }

    public List<RigaDiOrdine> getListaRigheDiOrdine() {
        return listaRigheDiOrdine;
    }

    public void setEmailFornitore(String emailFornitore) {
        this.emailFornitore = emailFornitore;
    }
    
    
}


