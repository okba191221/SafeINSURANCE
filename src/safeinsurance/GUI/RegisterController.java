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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.xml.bind.DatatypeConverter;
import safeinsurance.entities.Employés;
import safeinsurance.entities.clients;
import safeinsurance.services.EmployésService;
import safeinsurance.services.registerservice;
import safeinsurance.tools.MyConnection;

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
    private TextField txtimmatricule;
    @FXML
    private TextField txtnum_permis;
  
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
PreparedStatement st;
    ResultSet rs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
   
    
    
    
     private boolean conditiondesaisie() throws SQLException {
        //String s = client.getSelectionModel().getSelectedItem().toString();
        String number = "[0-9]+";

        Pattern x = Pattern.compile(number);
        String regex = "^(.+)@(.+)$";
        Pattern y = Pattern.compile(regex);

        // control saisie email
       
//            resPrenom.requestFocus();
        if (txtcin.getText().equals("")) {
            showMessageDialog(null, "le champ de texte cin ne peut pas être vide.");
        } else if (txtnom.getText().equals("")) {
            showMessageDialog(null, "le champ de texte nom ne peut pas être vide.");
        } else if (txtprénom.getText().equals("")) {
            showMessageDialog(null, "le champ de texte prenom ne peut pas être vide");
        } else if (txttel.getText().equals("")) {
            showMessageDialog(null, "le champ de texte tel ne peut pas être vide.");
        } else if (txtfonction.getText().equals("")) {
            showMessageDialog(null, "le champ de texte fonction ne peut pas être vide.");
        } else if (txtemail.getText().equals("")) {
            showMessageDialog(null, "le champ de texte email ne peut pas être vide.");
        } else if (txtnum_permis.getText().equals("")) {
            showMessageDialog(null, "le champ de texte num-permis ne peut pas être vide.");
        } else if (txtdélivré_le.getText().equals("")) {
            showMessageDialog(null, "le champ de texte delivré-le ne peut pas être vide.");
        } 
        //else if (txtimmatricule.getText().equals("")) {
           // showMessageDialog(null, "immatricule text field cannot be blank.");
     //   }
     else if (txtpassword.getText().equals("")) {
            showMessageDialog(null, "le champ de texte mot de passe ne peut pas être vide.");
        } else if (!x.matcher(txtcin.getText()).matches()) {
            showMessageDialog(null, "cin ne contient qu'un nombre.");
        } else if (txtcin.getText().length() < 8 || txtcin.getText().length() > 8) {
            showMessageDialog(null, "cin ne contient que 8 chiffres.");
        } else if (txttel.getText().length() < 8 || txttel.getText().length() > 8) {
            showMessageDialog(null, "tel ne contient que 8 numéros.");
        } else if (!x.matcher(txttel.getText()).matches()) {
            showMessageDialog(null, "tel ne contient que le numéro.");
        } else if (!x.matcher(txtnum_permis.getText()).matches()) {
            showMessageDialog(null, "numero permis ne contient qu'un nombre.");
        }  else if (!y.matcher(txtemail.getText()).matches()) {
            showMessageDialog(null, "verifier votre mail.");}
        
        
        else if(isAlreadyRegistered()){
                JOptionPane.showMessageDialog(null, "L'email de l'utilisateur exist déja ");
                txtemail.requestFocus();
            }
        
     else {
            return true;
        }
        return false;
    }
     
   
    @FXML
         private void add(ActionEvent event) throws SQLException {
           
         if (conditiondesaisie()) {
               String password = txtpassword.getText();
            String immatricule = null; 
            int cin = Integer.parseInt(txtcin.getText());
//            String immatricule = txtimmatricule.getText();
            String nom = txtnom.getText();
            String prenom = txtprénom.getText();
            int tel = Integer.parseInt(txttel.getText());
            Date Délivré_le = Date.valueOf(txtdélivré_le.getText());
           // String mdp = txtpassword.getText();
           String mdp=getHash(password.getBytes(), "SHA-1");
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

         
            public boolean isAlreadyRegistered() throws SQLException{
        Connection cnx;
       
        cnx = MyConnection.getInstance().getCnx();
        boolean emailExist;
        emailExist = false;
        String sql= "SELECT * FROM clients WHERE email=?";
         try{
             
            st=cnx.prepareStatement(sql);
            st.setString(1, txtemail.getText());
            rs = st.executeQuery();
            if(rs.next()){
                emailExist= true;
            }
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex);
         }    
        return emailExist;
    }
         
         
         

    @FXML
    private void ferme(ActionEvent event) {
        Platform.exit();
    }

    
    
    @FXML
    private void retour(ActionEvent event) {
        Stage ps = new Stage();	
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml")); 
            Scene scene = new Scene(root,800,480);											 
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            ps.setScene(scene);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
	
	ps.show(); 
    }
  
 

        
    

    
    
}
