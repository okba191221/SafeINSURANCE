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
import static safeinsurance.GUI.RegisterController.getHash;
import safeinsurance.entities.Employés2;
import safeinsurance.entities.Users;
import safeinsurance.entities.clients;
import safeinsurance.services.EmployésService;
import safeinsurance.services.loginservice;
import safeinsurance.services.registerservice;
import safeinsurance.tools.MyConnection;

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
    private TextField txtfunction;
    @FXML
    private TextField txtmatricule;
    @FXML
    private TextField txtlogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnenrigister;
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
    
    
    
    
    
    
    @FXML
    private void clic(ActionEvent event) throws IOException, SQLException {
        
        
          if (conditiondesaisie()) {       
  
       String nom = txtnom.getText();
       String prenom = txtprenom.getText();
         String password = txtpassword.getText();
           String fonction = txtfunction.getText();
            String matricule = txtmatricule.getText();
            int cin = Integer.parseInt(txtcin.getText());
              int tel = Integer.parseInt(txttel.getText());
        String login = txtlogin.getText();
        // String mdp = txtpassword.getText();
        String mdp=getHash(password.getBytes(), "SHA-1");
             
      // clients c = new clients (cin,nom, prénom, tel,immatricule,num_permis,login,password,délivré_le);
      
     Employés2 E = new Employés2 (nom, prenom, fonction, matricule,cin,tel,login,mdp);
       EmployésService es = new EmployésService();
       es.ajouterEmployés2(E);
       
        Stage ps = new Stage();

       //rs.registerservice (c);
       JOptionPane.showMessageDialog(null, "Employee ajouté avecc succès");
       try{
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); 
          Scene scene = new Scene(root,800,480);
         // Parent root = loader.load();
         ps.setScene(scene);
          
           // LoginController ac = loader.getController();											 
           // Scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                    }catch(IOException e){
            System.out.println(e.getMessage());
        }
       ps.show();
        
          }  
        
    }
    
      public boolean isAlreadyRegistered() throws SQLException{
        Connection cnx;
       
        cnx = MyConnection.getInstance().getCnx();
        boolean emailExist;
        emailExist = false;
        String sql= "SELECT * FROM employees WHERE login=?";
         try{
             
            st=cnx.prepareStatement(sql);
            st.setString(1, txtlogin.getText());
            rs = st.executeQuery();
            if(rs.next()){
                emailExist= true;
            }
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex);
         }    
        return emailExist;
    }
    
    
    
    
    
    
    
    
    
    private boolean conditiondesaisie() throws SQLException {

        String number = "[0-9]+";
        Pattern x = Pattern.compile(number);
        String regex = "^(.+)@(.+)$";
        Pattern y = Pattern.compile(regex);
        if (txtcin.getText().equals("")) {
            showMessageDialog(null, "le champ de texte cin ne peut pas être vide.");
        } else if (txtnom.getText().equals("")) {
            showMessageDialog(null, "le champ de texte nom ne peut pas être vide");
        } else if (txtprenom.getText().equals("")) {
            showMessageDialog(null, "le champ de texte prenom ne peut pas être vide.");
        } else if (txttel.getText().equals("")) {
            showMessageDialog(null, "le champ de texte tel ne peut pas être vide.");
        } 
        else if (txtfunction.getText().equals("")) {
            showMessageDialog(null, "le champ de texte fonction ne peut pas être vide.");
        } else if (txtmatricule.getText().equals("")) {
            showMessageDialog(null, "le champ de texte matricule ne peut pas être vide.");
        } else if (txtlogin.getText().equals("")) {
            showMessageDialog(null, "le champ de texte login ne peut pas être vide.");
        } else if (txtpassword.getText().equals("")) {
            showMessageDialog(null, "le champ de texte password ne peut pas être vide");
        } else if (!x.matcher(txtcin.getText()).matches()) {
            showMessageDialog(null, "cin ne contient qu'un nombre.");
        } else if (txtcin.getText().length() < 8 || txtcin.getText().length() > 8) {
            showMessageDialog(null, "cin ne contient que 8 chiffres.");
        } else if (txttel.getText().length() < 8 || txttel.getText().length() > 8) {
            showMessageDialog(null, "tel ne contient que 8 chiffres.");
        } else if (!x.matcher(txttel.getText()).matches()) {
            showMessageDialog(null, "tel ne contient qu'un nombre.");
        } //else if (!x.matcher(txtmatricule.getText()).matches()) {
           // showMessageDialog(null, "Matricule contains only number."); }
        else if (!y.matcher(txtlogin.getText()).matches()) {
            showMessageDialog(null, "verifier votre email");
        } 
        else
            if(isAlreadyRegistered()){
                JOptionPane.showMessageDialog(null, "L'email de l'utilisateur exist déja ");
                txtlogin.requestFocus();
            }
        else{
           
                return true;
            }
        return false;
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

    @FXML
    private void ferme(ActionEvent event) {
          Platform.exit();
    }
    
}
