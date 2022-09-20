/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.entities;

/**
 *
 * @author bouden
 */
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class mailmdp {
    
    
    
    
    
    
    
    
      Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String args[]) throws AddressException, MessagingException, IOException {
        mailmdp mail = new mailmdp();
        mail.setupServerProperties();
       
        mail.sendEmail();
    }

    public void sendEmail() throws MessagingException {
        String fromUser = "jihen.najlaoui@esprit.tn";  //Enter sender email id
        String fromUserPassword = "E12664709";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    public MimeMessage draftEmail(String email, String nom, int a) throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {email};  //Enter list of email recepients
        String emailSubject = "Récupération mot de passe oublier";

        mimeMessage = new MimeMessage(newSession);

        for (int i = 0; i < emailReceipients.length; i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
        mimeMessage.setFrom(new InternetAddress("motdepasseoublier"));
        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE 
        // CREATE MESSAGE BODY PARTS 
        // CREATE MESSAGE MULTIPART 
        // ADD MESSAGE BODY PARTS ----> MULTIPART 
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
        Multipart emailContent = new MimeMultipart();

        //Text body part
        MimeBodyPart textBodyPart = new MimeBodyPart();

        textBodyPart.setText("bnsr " + nom + " " + "votre code est " + a);

        //Attachment body part.
        //Attach body parts
        emailContent.addBodyPart(textBodyPart);

        //Attach multipart to message
        mimeMessage.setContent(emailContent);
        return mimeMessage;
    }

    public void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }

}
    /**
     * @param email
     * @param message
     * @param nom
     * @throws java.io.IOException
     */
  
		//authentication info
//                
//                
//                public void sendemailwelcom(String email , int message ,String nom ) throws IOException
//                {
//                    
//              
//		final String username = "52f5413667de19";
//		final String password = "d7479f407edec9";
//		String fromEmail = "Administrateur";
//		String toEmail = email;
//		
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.mailtrap.io");
//		properties.put("mail.smtp.port", "2525");
//		
//		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//                        @Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username,password);
//			}
//		});
//		//Start our mail message
//		MimeMessage msg = new MimeMessage(session);
//		try {
//			msg.setFrom(new InternetAddress(fromEmail));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			msg.setSubject("Mot de passe oublié");
//			
//			Multipart emailContent = new MimeMultipart();
//			
//			//Text body part
//			MimeBodyPart textBodyPart = new MimeBodyPart();
//                        
//			textBodyPart.setText("bnsr,"+ nom +" votre code est "+message);
//                        
//			textBodyPart.setDescription(username);
//			//Attachment body part.
//			
//			//Attach body parts
//			emailContent.addBodyPart(textBodyPart);
//		
//			
//			//Attach multipart to message
//			msg.setContent(emailContent);
//			
//			Transport.send(msg);
//			
//		}catch (MessagingException e) {
//		}
//              // TODO Auto-generated catch block
//              
//
//	}
//
//}


