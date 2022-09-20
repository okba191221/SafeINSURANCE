/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;




import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Elife-Kef-002
 */
public class EmailSend {

    //SETUP MAIL SERVER PROPERTIES
    //DRAFT AN EMAIL
    //SEND EMAIL
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String args[]) throws AddressException, MessagingException, IOException, javax.mail.MessagingException {
        EmailSend mail = new EmailSend();
        mail.setupServerProperties();
   
        mail.sendEmail();
    }

    public void sendEmail() throws MessagingException, NoSuchProviderException, javax.mail.MessagingException {
        String fromUser = "hajer.elaayeb@esprit.tn";  //Enter sender email id
          String fromUserPassword = "E08097281";  //Enter sender gmail password , this will be authenticated by gmail smtp server
     String emailHost = "smtp.gmail.com";
      Transport transport = newSession.getTransport("smtp");
       transport.connect(emailHost, fromUser, fromUserPassword);
       transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
      transport.close();
        System.out.println("Email successfully sent!!!");
    }

    public MimeMessage draftEmail(String email) throws AddressException, MessagingException, IOException, javax.mail.MessagingException {
        String[] emailReceipients = {email};  //Enter list of email recepients
        String emailSubject = "Email de comfirmation par hajer";

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

        textBodyPart.setText("bonjour MR verifier votre platforme ");

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
