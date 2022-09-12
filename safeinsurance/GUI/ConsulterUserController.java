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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    @FXML
    private AnchorPane retour;
    @FXML
    private Button CV_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulterEmployés(ActionEvent event) throws IOException {
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
    private void consulterClients(ActionEvent ev) throws IOException {
        Stage ps = new Stage();
         try {

             Parent root = FXMLLoader.load(getClass().getResource("./gestionaire client.fxml"));
                 

             Scene scene = new Scene(root,800,480);
             ps.setScene(scene);
                 ps.show();
											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            ps.setScene(scene); 
             
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("./gestionaire client.fxml"));
//            Parent root = loader.load();
//           GestionaireClientController ac = loader.getController();
//           CC_id.getScene().setRoot(root);
              }  
 catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
         
    }

    @FXML
    private void retour(ActionEvent event) {
                 Stage ps = new Stage();	
        try{
            Parent root = FXMLLoader.load(getClass().getResource("interface.fxml")); 
            Scene scene = new Scene(root,800,480);											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            ps.setScene(scene);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
	
	ps.show(); 
    }

    @FXML
    private void consulterVoitures(ActionEvent event) throws IOException  {
        try {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("./TableView.fxml"));
            Parent root = loader.load();
             TableViewController ac = loader.getController();
            CV_id.getScene().setRoot(root);
              }  
 catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
