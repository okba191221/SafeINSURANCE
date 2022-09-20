/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import com.sun.org.apache.xpath.internal.operations.Variable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import static javax.swing.JOptionPane.showMessageDialog;
import safeinsurance.entities.Employés;
import safeinsurance.entities.mailmdp;
import safeinsurance.entities.variable;
import safeinsurance.tools.MyConnection;
import static sun.security.jgss.GSSUtil.login;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class SendmailController implements Initializable {

    @FXML
    private TextField idmail;
    @FXML
    private Button idsend;
    @FXML
    private Button idretour;

    Connection cnx = MyConnection.getInstance().getCnx();

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML

    private void Envoyermail(ActionEvent event) throws SQLException, IOException, MessagingException {
        String email = idmail.getText();
        if (this.isValidated()) {
            PreparedStatement ps;
            ResultSet rs;
            String query = "select * from employees WHERE login = ?";

            ps = cnx.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                Random rand = new Random(); //instance of random class
                int upperbound = 10000;
                int int_random = rand.nextInt(upperbound);
                PreparedStatement pss;
                ResultSet rss;
                String xx = rs.getString("matricule");
                String yy = "update   employees set  code ='" + int_random + "' where matricule = '" + xx + "' ";
                pss = cnx.prepareStatement(yy);
                pss.execute();

                //   String x = rs.getString("code");
                //ResetPasswordEmail a = new ResetPasswordEmail();
                //a.sendemailwelcom(email, int_random, rs.getString("nom"));
                mailmdp mail = new mailmdp();
                mail.setupServerProperties();
                mail.draftEmail(email, rs.getString("nom"), int_random);
                mail.sendEmail();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("confirmation");
                alert.setHeaderText("code");
                alert.setContentText("nous avons envoyé votre code par e-mail");
                if (alert.showAndWait().get() == ButtonType.OK) {

                }
                
                Stage stage = (Stage)idretour.getScene().getWindow();
                stage.close();
                variable.variable.setLogin(email);
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/CodeVerification.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.setTitle("code");

                stage.show();

            } else {
                showMessageDialog(null, "L'e-mail n'existe pas, réessayez !");

            }
        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage = (Stage) idretour.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private boolean isValidated() {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (idmail.getText().equals("")) {
            showMessageDialog(null, "le champ de texte de l'e-mail ne peut pas être vide");
            idmail.requestFocus();

        } else if (!pattern.matcher(idmail.getText()).matches()) {
            showMessageDialog(null, "E-mail invalide");
            idmail.requestFocus();
        } else {
            return true;
        }
        return false;
    }

}
