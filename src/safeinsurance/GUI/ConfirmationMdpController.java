/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.xml.bind.DatatypeConverter;
import safeinsurance.entities.Employés;
import safeinsurance.entities.variable;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class ConfirmationMdpController implements Initializable {

    @FXML
    private PasswordField IDnouveau;
    @FXML
    private PasswordField IDconfirmermdp;
    @FXML
    private Button IDconfirmer;
    @FXML
    private Button IDretour;
    Connection cnx = MyConnection.getInstance().getCnx();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirme(ActionEvent event) throws SQLException, IOException {
        if (this.isValidated()) {
            PreparedStatement ps;
            ResultSet rs;
            String query = "select * from employees WHERE login = ?";
            Employés e = new Employés();
            ps = cnx.prepareStatement(query);
            ps.setString(1, variable.variable.getLogin());

            rs = ps.executeQuery();

            if (rs.next()) {

                PreparedStatement pss;
                ResultSet rss;
                String xx = rs.getString("matricule");
                String x = IDnouveau.getText();
                Integer z = 0;
                String yy = "update   employees  set  mdp ='" + getHash(x.getBytes(), "SHA-1") + "' , code ='" + z + "' where matricule = '" + xx + "' ";
                pss = cnx.prepareStatement(yy);
                pss.execute();
                showMessageDialog(null, "mot de passe modifier avec succès.");
                Stage stage = (Stage) IDretour.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/login.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {

            }
        }
    }

    public static String getHash(byte[] inputBytes, String algorithme) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithme);
            messageDigest.update(inputBytes);
            byte[] digesteBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digesteBytes).toLowerCase();

        } catch (Exception e) {

        }
        return hashValue;
    }

    private boolean isValidated() {
//        String s = categorie.getSelectionModel().getSelectedItem().toString();

        if (IDnouveau.getText().equals("")) {

            showMessageDialog(null, "le champ mot de passe ne peut pas être vide.");
            IDnouveau.requestFocus();

        } else if (IDconfirmermdp.getText().equals("")) {

            showMessageDialog(null, "le champ de confirmation du mot de passe ne peut pas être vide");
            IDconfirmermdp.requestFocus();
        } else if (!IDnouveau.getText().equals(IDconfirmermdp.getText())) {

            showMessageDialog(null, "erreur de confirmation du mot de passe  ");
            IDnouveau.requestFocus();

        } else {
            return true;
        }
        return false;
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage = (Stage) IDretour.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/CodeVerification.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
