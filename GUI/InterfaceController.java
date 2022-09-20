/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author okba
 */
public class InterfaceController implements Initializable {

    @FXML
    private MenuButton choiceRegistre;
    @FXML
    private Button loginBtn;
    @FXML
    private MenuItem RegClt;
    @FXML
    private Button cc_dev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    

    @FXML
    private void chooseRegistre(ActionEvent event)  {

        
    }

    @FXML
    private void RegistreClient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./register.fxml"));
            Parent root = loader.load();
            RegisterController ac = loader.getController();
            
            choiceRegistre.getScene().setRoot(root);

//            Afficher_employésController ac = loader.getController();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void RegistreEmployee(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./userregister.fxml"));
            Parent root = loader.load();
            UserregisterController ac = loader.getController();
            choiceRegistre.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void login_user(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./login.fxml"));
            Parent root = loader.load();
            LoginController ac = loader.getController();
            
            loginBtn.getScene().setRoot(root);

//            Afficher_employésController ac = loader.getController();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void consulterDevis(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./simulation.fxml"));
            Parent root = loader.load();
            SimulationController ac = loader.getController();
            cc_dev.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
