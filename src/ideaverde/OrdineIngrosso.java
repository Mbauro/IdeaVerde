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

    public OrdineIngrosso() {
        
        this.listaRigheDiOrdine = new ArrayList();
        
    }
    
     public void creaRigaDiOrdine(String tipo, String varieta, int quantita, int eta){
         System.out.println(eta+""+quantita);
         RigaDiOrdine r = new RigaDiOrdine(tipo,varieta,quantita,eta);
         System.out.println(r);
         this.listaRigheDiOrdine.add(r);
     }
     
     public void inviaEmailFornitore(OrdineIngrosso o, String emailFornitore){
         
          // Recipient's email ID needs to be mentioned.
      String to = emailFornitore;

      // Sender's email ID needs to be mentioned
      String from = "ideaverdect@gmail.com";

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
               return new javax.mail.PasswordAuthentication("ideaverdect@gmail.com", "ideaverdeCT2019"); //username and password
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
         message.setText(o.getListaRigheDiOrdine().toString());
         
         Transport.send(message);
         System.out.println("Ordine inviato correttamente tramite email");
      } catch (MessagingException mex) {
            mex.printStackTrace();
      }
         
         
     }
     
     public void stampaOrdineIngrosso(OrdineIngrosso o, String email){
               
        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        
          
      
        try{
            File f = new File(timeStamp+".txt");
            if(f.exists()){
                                
            }else if(f.createNewFile()){
                PrintWriter myprint = new PrintWriter(f);
                for(RigaDiOrdine object: o.getListaRigheDiOrdine()){
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
    
    
    
    
    
}
