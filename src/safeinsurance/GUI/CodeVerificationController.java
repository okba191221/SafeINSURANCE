/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import static javax.swing.JOptionPane.showMessageDialog;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class CodeVerificationController implements Initializable {

    @FXML
    private TextField IDcode;
    @FXML
    private Button IDretour;
    Connection cnx = MyConnection.getInstance().getCnx();
    @FXML
    private Button txtret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void verifier(ActionEvent event) throws SQLException, IOException {

        if (this.isValidated()) {

            PreparedStatement ps;
            ResultSet rs;
            String query = "select * from employees WHERE code = ?";

            ps = cnx.prepareStatement(query);
            ps.setString(1, IDcode.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("confirmation");
                alert.setHeaderText("code");
                alert.setContentText("code valide");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    Stage stage = (Stage) IDcode.getScene().getWindow();
                    stage.close();

                    Parent root = FXMLLoader.load(getClass().getResource("../GUI/ConfirmationMdp.fxml"));

                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("changer mot de passe");
                    // stage.getIcons().add(new Image("/img/mm.png"));
                    stage.show();

                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("confirmation");
                alert.setHeaderText("code");
                alert.setContentText("code invalide try again");
                if (alert.showAndWait().get() == ButtonType.OK) {

                }
            }
        }

    }

    private boolean isValidated() {
//        String s = categorie.getSelectionModel().getSelectedItem().toString();
        String number = "[0-9]+";
        Pattern x = Pattern.compile(number);
        if (IDcode.getText().equals("")) {

            showMessageDialog(null, "le champ de texte du code ne peut pas être vide.");
            IDcode.requestFocus();

        } else if (!x.matcher(IDcode.getText()).matches()) {
            showMessageDialog(null, "le code ne contient que des chiffres.");
            IDcode.requestFocus();

        } else {
            return true;
        }
        return false;
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage = (Stage) IDretour.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Sendmail.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
