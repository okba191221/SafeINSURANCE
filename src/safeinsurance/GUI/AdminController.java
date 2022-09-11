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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class AdminController implements Initializable {
        Connection cnx = MyConnection.getInstance().getCnx();
    public ResultSet result;

    @FXML
    private TextField txtlogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnadmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private Parent fxml;
    @FXML
    private void admin(ActionEvent event) throws SQLException {
        
        String login = txtlogin.getText();
        String password = txtpassword.getText();
        System.out.println(login);
        System.out.println(password);
        String sql = "select * from admin where login=? and mdp=?";

        PreparedStatement st = cnx.prepareStatement(sql);
        st.setString(1, login);
        st.setString(2, password);
        result = st.executeQuery();
        if (result.next()) {

            Stage register = new Stage();
            try {
                fxml = FXMLLoader.load(getClass().getResource("consulter user.fxml"));

                Scene scene = new Scene(fxml);
                register.setScene(scene);
                register.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result.getString("login"));

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "login or password incorrecte", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
        
        
        
        
    }

    @FXML
    private void retour(ActionEvent event) {
          Stage ps = new Stage();	
        try{
            Parent root = FXMLLoader.load(getClass().getResource("pagetest.fxml")); 
            Scene scene = new Scene(root,800,480);											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            ps.setScene(scene);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
	
	ps.show();
        
    }

    @FXML
    private void ferm(ActionEvent event) {
           Platform.exit();
    }
    
}
