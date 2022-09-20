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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static safeinsurance.GUI.RegisterController.getHash;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class LoginController implements Initializable {

    Connection cnx = MyConnection.getInstance().getCnx();
    public ResultSet result;
    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button btncncter;
    @FXML
    private Hyperlink fp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Parent fxml;

    @FXML
    private void connecter(ActionEvent event) throws SQLException {
        String login = txtlogin.getText();
        String password = txtpassword.getText();

        System.out.println(login);
        System.out.println(password);

//    if ((txtlogin.getText().equals(true)&&txtpassword.getText().equals(true)))
// {       
        try {
            String sql = "select * from clients where email=? and mdp=?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, login);
            //st.setString(2, password);
            st.setString(2, getHash(password.getBytes(), "SHA-1"));
            result = st.executeQuery();
         if (result.next()) {

                Stage register = new Stage();
                try {
                    fxml = FXMLLoader.load(getClass().getResource("ConsulterOffre.fxml"));

                    Scene scene = new Scene(fxml);
                    register.setScene(scene);
                    register.show();
                    return ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(result.getString("email"));
            }
//         else {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "vous ne pouvez accéder à l'interface du client parceque le mdp et le login client ne sont pas conformes", javafx.scene.control.ButtonType.OK);
//            alert.showAndWait();
//        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            String sql = "select * from employees where login=? and mdp=?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, login);
            //st.setString(2, password);
            st.setString(2, getHash(password.getBytes(), "SHA-1"));
            result = st.executeQuery();
            if (result.next()) {

                Stage register = new Stage();
                try {
                    fxml = FXMLLoader.load(getClass().getResource("ConsulterOffre.fxml"));

                    Scene scene = new Scene(fxml);
                    register.setScene(scene);
                    register.show();
                    return ;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(result.getString("login"));
            }

//         else {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "vous ne pouvez pas accéder à l'interface de l'employé parce que le mdp et le login ne sont pas conformes", javafx.scene.control.ButtonType.OK);
//            alert.showAndWait();
//
//        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       
            String sql = "select * from admin where login=? and mdp=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, login);
            st.setString(2, password);
            // st.setString(2, getHash(password.getBytes(), "SHA-1"));
            result = st.executeQuery();
            if (result.next()) {

                Stage register = new Stage();
                try {
                    fxml = FXMLLoader.load(getClass().getResource("consulter user.fxml"));

                    Scene scene = new Scene(fxml);
                    register.setScene(scene);
                    register.show();
                           return ;

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(result.getString("login"));
            }

     else {
              Alert alert = new Alert(Alert.AlertType.ERROR, " email ou mot de passe incorrecte", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
//
        } 
            //catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
    
   
    }
    @FXML
    private void quitter(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void retour(ActionEvent event) {
        Stage ps = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
            Scene scene = new Scene(root, 800, 480);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            ps.setScene(scene);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ps.show();

    }

    @FXML
    private void showsendmailstage(ActionEvent event) throws IOException {
        Stage stage = (Stage) fp.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/sendmail.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle(" email send");

        stage.show();
    }

}
