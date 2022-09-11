/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import safeinsurance.entities.Employés2;
import safeinsurance.services.EmployésService;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author okba
 */
public class Ajouter_employésController_2 implements Initializable {
    
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtFonction;
    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtCIN;
    @FXML
    private TextField txtTel;
    
    
    private Button ibtn;
//Connection cnx=MyConnection.getInstance().getCnx();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void Ajouter (ActionEvent event) throws IOException{
       String nom = txtNom.getText();
       String prenom = txtPrenom.getText();
       String fonction = txtFonction.getText();
       String matricule = txtMatricule.getText();
       int cin = Integer.parseInt(txtCIN.getText());
       int tel = Integer.parseInt(txtTel.getText());
       Employés2 E = new Employés2 (nom, prenom, fonction, matricule,cin,tel);
       EmployésService es = new EmployésService();
       es.ajouterEmployés2(E);
       JOptionPane.showMessageDialog(null, "Employés ajouté avecc succès");


   try {
     
  
       FXMLLoader loader = new FXMLLoader(getClass().getResource("./Afficher_employés.fxml"));
            Parent root = loader.load();
            Afficher_employésController_2 ac = loader.getController();
//            ac.setList(es.afficherEmployé().toString());
//            ac.setResNom(nom);
//            ac.setResPrenom(prenom);
//            ac.setResFonction(fonction);
//            ac.setResMatricule(matricule);
//            ac.setResCIN(cin);
//            ac.setResTel(tel);
            
            
            
            txtNom.getScene().setRoot(root);


              }  
 catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
//        Produit p=new Produit(libelle.getText(), Float.valueOf(prix.getText()));
//        ProduitService produitService=new ProduitService();
//        produitService.insert(p);
//        FXMLLoader loader =new FXMLLoader(getClass().getResource("./List.fxml"));
//        Parent root;
//        root=loader.load();
//        ajouter.getScene().setRoot(root);
//        /*/
//        Parent root=FXMLLoader.load(getClass().getResource("./List.fxml"));
//        Scene scene =new  Scene(root);
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();
//        //*/
//        new Alert(Alert.AlertType.INFORMATION, "sucess").show();
//    }
    }

 