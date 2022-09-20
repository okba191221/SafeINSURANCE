/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import ecommerce.Mail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class PagetestController implements Initializable {

    @FXML
    private TextField txt_assurance1;
    @FXML
    private TextField txt_assurance2;
    @FXML
    private TextField txt_assurance3;
    @FXML
    private TextField txt_assurance11;
    @FXML
    private TextField txt_assurance12;
    @FXML
    private TextField txt_assurance13;
    Session newSession = null;
    MimeMessage mimeMessage = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void send(ActionEvent event) throws MessagingException, AddressException, IOException {
        Mail mail = new Mail();
        mail.setupServerProperties();
//        mail.draftEmail("weslati.okba@esprit.tn", "E08093012", 500);
        mail.draftEmail(txt_assurance1.getText(), txt_assurance2.getText(),"sdds","dsds","dsds" );

        mail.sendEmail();
//          MailCnfirmation mail = new MailCnfirmation();
//                    mail.setupServerProperties();
//                    mail.draftEmail(txtemail.getText(), nom.getText(), prenom.getText(),Integer.valueOf(idperson.getText()),datereserv.getValue(), Time.valueOf(heurereservation.getText()) ,Integer.valueOf(numerotable.getText()));
//                    mail.sendEmail();
    }
}
