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
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Elife-Kef-007
 */
public class ConsulterUserController implements Initializable {

    @FXML
    private Button CE_id;
    @FXML
    private Button CC_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulterEmployés(ActionEvent event) {
        try {
     
  
       FXMLLoader loader = new FXMLLoader(getClass().getResource("./Afficher_employés.fxml"));
            Parent root = loader.load();
            Afficher_employésController ac = loader.getController();

            
            
            
            CE_id.getScene().setRoot(root);


              }  
 catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    private void consulterClients(ActionEvent event) {
         try {
     
  
       FXMLLoader loader = new FXMLLoader(getClass().getResource("./gestionaire client.fxml"));
            Parent root = loader.load();
            GestionaireClientController ac = loader.getController();

            
            
            
            CC_id.getScene().setRoot(root);


              }  
 catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
