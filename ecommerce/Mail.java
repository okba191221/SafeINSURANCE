package ecommerce;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    //SETUP MAIL SERVER PROPERTIES
    //DRAFT AN EMAIL
    //SEND EMAIL
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String args[]) throws AddressException, MessagingException, IOException {
        Mail mail = new Mail();
        mail.setupServerProperties();
        mail.draftEmail("weslati.okba@esprit.tn", "okba", "assurance 1", "assurance 2", "assurance 3");
        mail.sendEmail();
    }

    public void sendEmail() throws MessagingException {
        String fromUser = "weslati.okba@esprit.tn";  //Enter sender email id
        String fromUserPassword = "E08093012";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    public MimeMessage draftEmail(String email, String nom, String a, String b, String c) throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {email};  //Enter list of email recepients
        String emailSubject = "Consultation devis en ligne";

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

        textBodyPart.setText("Merci " + nom + " pour la visite de notre site.\nCeci est un message automatique merci de ne pas répondre !\n" + "Votre consultation de devis est la suivante :\nAssurance basique : " + a+" dt"+ "\nAssurance dommage & collision : " + b +" dt"+"\nAssurance tout risque : " + c +" dt");

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
