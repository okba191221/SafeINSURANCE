/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import safeinsurance.entities.Employés2;
import safeinsurance.entities.Users;
import safeinsurance.entities.clients;
import safeinsurance.services.EmployésService;
import safeinsurance.services.loginservice;
import safeinsurance.services.registerservice;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class UserregisterController implements Initializable {

    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txttel;
    @FXML
    private TextField txtrole;
    @FXML
    private TextField txtfunction;
    @FXML
    private TextField txtmatricule;
    @FXML
    private TextField txtlogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnenrigister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clic(ActionEvent event) throws IOException {
        
        
                
  
       String nom = txtnom.getText();
       String prenom = txtprenom.getText();
//       String role = txtrole.getText();
           String fonction = txtfunction.getText();
            String matricule = txtmatricule.getText();
            int cin = Integer.parseInt(txtcin.getText());
              int tel = Integer.parseInt(txttel.getText());
        String login = txtlogin.getText();
         String mdp = txtpassword.getText();
             
      // clients c = new clients (cin,nom, prénom, tel,immatricule,num_permis,login,password,délivré_le);
      
     Employés2 E = new Employés2 (nom, prenom, fonction, matricule,cin,tel,login,mdp);
       EmployésService es = new EmployésService();
       es.ajouterEmployés2(E);
       
       

       //rs.registerservice (c);
       JOptionPane.showMessageDialog(null, "Employee ajouté avecc succès");
       try{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("./login.fxml")); 
          Parent root = loader.load();
            LoginController ac = loader.getController();											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                    }catch(IOException e){
            System.out.println(e.getMessage());
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
    private void ferme(ActionEvent event) {
          Platform.exit();
    }
    
}
