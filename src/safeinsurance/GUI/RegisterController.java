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
import java.util.regex.Pattern;
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
import static javax.swing.JOptionPane.showMessageDialog;
import safeinsurance.entities.Employés;
import safeinsurance.entities.clients;
import safeinsurance.services.EmployésService;
import safeinsurance.services.registerservice;

/**
 * FXML Controller class
 *
 * @author Servicenfo
 */
public class RegisterController implements Initializable {

    @FXML
    private AnchorPane txtdate;
    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprénom;
    @FXML
    private TextField txttel;
    @FXML
    private TextField txtimmatricule;
    @FXML
    private TextField txtnum_permis;
    private TextField txtlogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btncancel;
    private DatePicker txtdélivré;
    @FXML
    private TextField txtdélivré_le;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtfonction;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     private boolean conditiondesaisie() {
        //String s = client.getSelectionModel().getSelectedItem().toString();
        String number = "[0-9]+";

        Pattern x = Pattern.compile(number);
        String regex = "^(.+)@(.+)$";
        Pattern y = Pattern.compile(regex);

        // control saisie email
       
//            resPrenom.requestFocus();
        if (txtcin.getText().equals("")) {
            showMessageDialog(null, "cin text field cannot be blank.");
        } else if (txtnom.getText().equals("")) {
            showMessageDialog(null, "nom text field cannot be blank.");
        } else if (txtprénom.getText().equals("")) {
            showMessageDialog(null, "prenom text field cannot be blank.");
        } else if (txttel.getText().equals("")) {
            showMessageDialog(null, "telephone text field cannot be blank.");
        } else if (txtfonction.getText().equals("")) {
            showMessageDialog(null, "role text field cannot be blank.");
        } else if (txtemail.getText().equals("")) {
            showMessageDialog(null, "email text field cannot be blank.");
        } else if (txtnum_permis.getText().equals("")) {
            showMessageDialog(null, "num_permis text field cannot be blank.");
        } else if (txtdélivré_le.getText().equals("")) {
            showMessageDialog(null, "Délivré_le text field cannot be blank.");
//        } else if (txtimmatricule.getText().equals("")) {
//            showMessageDialog(null, "immatricule text field cannot be blank.");
        } else if (txtpassword.getText().equals("")) {
            showMessageDialog(null, "mot de passe text field cannot be blank.");
        } else if (!x.matcher(txtcin.getText()).matches()) {
            showMessageDialog(null, "cin contains only number.");
        } else if (txtcin.getText().length() < 8 || txtcin.getText().length() > 8) {
            showMessageDialog(null, "cin contains only 8 number.");
        } else if (txttel.getText().length() < 8 || txttel.getText().length() > 8) {
            showMessageDialog(null, "tel contains only 8 number.");
        } else if (!x.matcher(txttel.getText()).matches()) {
            showMessageDialog(null, "tel contains only number.");
        } else if (!x.matcher(txtnum_permis.getText()).matches()) {
            showMessageDialog(null, "numero permis contains only number.");
        }  else if (!y.matcher(txtemail.getText()).matches()) {
            showMessageDialog(null, "email text field cannot be blank.");}
     else {
            return true;
        }
        return false;
    }
   
    @FXML
         private void add(ActionEvent event) throws IOException {
             
         if (conditiondesaisie()) {
            int cin = Integer.parseInt(txtcin.getText());
            String immatricule = null;
            String nom = txtnom.getText();
            String prenom = txtprénom.getText();
            int tel = Integer.parseInt(txttel.getText());
            Date Délivré_le = Date.valueOf(txtdélivré_le.getText());
            String mdp = txtpassword.getText();
            String fonction = txtfonction.getText();
            String email = txtemail.getText();
            int num_Permis = Integer.parseInt(txtnum_permis.getText());
            registerservice rs = new registerservice();
            rs.ajouterclient(new clients(cin, nom, prenom, tel, mdp,fonction, email, immatricule, num_Permis, Délivré_le));
             Stage ps = new Stage();
             JOptionPane.showMessageDialog(null, "vous etes inscrit avec succès");
               
        try{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); 
            Scene scene = new Scene(root,800,480);											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            ps.setScene(scene);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
	
	ps.show(); 
    
  
         
//            JOptionPane.showMessageDialog(null, "vous etes inscrit avec succès");
        

    }}


    @FXML
    private void ferme(ActionEvent event) {
        Platform.exit();
    }

    private void btncancel(ActionEvent event) {
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
    private void retour(ActionEvent event) {
    }
    
}
