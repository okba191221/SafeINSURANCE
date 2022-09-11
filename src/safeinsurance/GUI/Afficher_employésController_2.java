/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.S;
import javax.swing.JOptionPane;
import safeinsurance.entities.Employés2;
import safeinsurance.services.EmployésService;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author okba
 */
public class Afficher_employésController_2 implements Initializable {

    @FXML
    private TextField resNom;
    @FXML
    private TextField resPrenom;
    @FXML
    private TextField resFonction;
    @FXML
    private TextField resMatricule;
    @FXML
    private TextField resCIN;
    @FXML
    private TextField resTel;


    @FXML
    private TableView<Employés2> listeEmployés;
    @FXML
    private TableColumn<Employés2, String> resLname;
    @FXML
    private TableColumn<Employés2, String> resName;
    @FXML
    private TableColumn<Employés2, String> resFct;
    @FXML
    private TableColumn<Employés2, String> resMat;
    @FXML
    private TableColumn<Employés2, Integer> resId;
    @FXML
    private TableColumn<Employés2, Integer> resMob;
    
    int index = -1;



    /**
     * Initializes the controller class.
     * @param 
     */

    
// public void setResNom(String resNom) {
//        this.resNom.setText(resNom);
//    }
//
//    public void setResPrenom(String resPrenom) {
//        this.resPrenom.setText(resPrenom); 
//    }
//
//    public void setResFonction(String resFonction) {
//        this.resFonction.setText(resFonction); 
//    }
//
//    public void setResMatricule(String resMatricule) {
//        this.resMatricule.setText(resMatricule); 
//    }
//
//    public void setResCIN(int resCIN) {
//        this.resCIN.setText(String.valueOf(resCIN));
//    }
//
//    public void setResTel(int resTel) {
//        this.resTel.setText(String.valueOf(resTel));
//    }


    
  
//    void getSelected(MouseEvent e){
//    index = listeEmployés.getSelectionModel().getSelectedIndex();
//      if (index <= -1) {
//          return;
//      }
//      
//      resNom.setText(resLname.getCellData(index).toString());
//      resPrenom.setText(resName.getCellData(index).toString());
//      resFonction.setText(resFct.getCellData(index).toString());
//      resMatricule.setText(resMat.getCellData(index).toString());
//      resCIN.setText(resId.getCellData(index).toString());
//      resTel.setText(resMob.getCellData(index).toString());
//      
//}

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
            index = listeEmployés.getSelectionModel().getSelectedIndex();
      if (index <= -1) {
          return;
    }
      resNom.setText(resLname.getCellData(index).toString());
      resPrenom.setText(resName.getCellData(index).toString());
      resFonction.setText(resFct.getCellData(index).toString());
      resMatricule.setText(resMat.getCellData(index).toString());
      resCIN.setText(resId.getCellData(index).toString());
      resTel.setText(resMob.getCellData(index).toString());
}
    
       @FXML
    private void Edit(ActionEvent eventt) {
        
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            String value1 = resNom.getText();
            String value2 = resPrenom.getText();
            String value3 = resFonction.getText();
            String value4 = resMatricule.getText();
            int value5 = Integer.parseInt(resCIN.getText());
            int value6 = Integer.parseInt(resTel.getText());
//                String sql = "UPDATE employees SET nom='"+value1+"',prenom= '"+value2+"',fonction= '"+value3+"',matricule= '"+value4+"',cin= '"+value5+"',tel= '"+value6+"'";             
                String sql = "UPDATE employees SET nom='"+value1+"',prenom= '"+value2+"',fonction= '"+value3+"',matricule= '"+value4+"',cin= '"+value5+"',tel= '"+value6+"' WHERE matricule='"+value4+"' "; 
//            String sql ="update employees set nom ,prenom,fonction,matricule,cin,tel) values('"+value1+"','"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6 +"')";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.execute();
            JOptionPane.showMessageDialog(null, "Employé modifié");
            updatetable ();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        }
    
    public void delete(ActionEvent event){
        Connection cnx = MyConnection.getInstance().getCnx();
        String sql = "delete from employees where matricule= ?";
        try{
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setString(1, resMatricule.getText());
        ste.execute();
        JOptionPane.showMessageDialog(null, "employé supprimé");
        updatetable();

            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
//            System.out.println(ex.getMessage());
        }
    }
    
    
        public void updatetable() {
        EmployésService EmployésService=new EmployésService();
        ArrayList arrayList= (ArrayList) EmployésService.afficherEmployé();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listeEmployés.setItems(observableList); 
        resLname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        resName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        resFct.setCellValueFactory(new PropertyValueFactory<>("fonction"));
        resMat.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        resId.setCellValueFactory(new PropertyValueFactory<>("cin"));
        resMob.setCellValueFactory(new PropertyValueFactory<>("tel"));  
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatetable();
//        EmployésService EmployésService=new EmployésService();
//        ArrayList arrayList= (ArrayList) EmployésService.afficherEmployé();
//        ObservableList observableList = FXCollections.observableArrayList(arrayList);
//        listeEmployés.setItems(observableList); 
//        resLname.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        resName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//        resFct.setCellValueFactory(new PropertyValueFactory<>("fonction"));
//        resMat.setCellValueFactory(new PropertyValueFactory<>("matricule"));
//        resId.setCellValueFactory(new PropertyValueFactory<>("cin"));
//        resMob.setCellValueFactory(new PropertyValueFactory<>("tel"));  
        

        
    } 
}
    
    /**
     *
     * @param 
     */

//    @FXML
//    private void res(TableColumn.CellEditEvent<S, T> event) {
//    }
//    }    
//
//    public void setList(String list) {
//        this.list.setText(list);
//    }
//
//    public void setResNom(String resNom) {
//        this.resNom.setText(resNom);
//    }
//
//    public void setResPrenom(String resPrenom) {
//        this.resPrenom.setText(resPrenom); 
//    }
//
//    public void setResFonction(String resFonction) {
//        this.resFonction.setText(resFonction); 
//    }
//
//    public void setResMatricule(String resMatricule) {
//        this.resMatricule.setText(resMatricule); 
//    }
//
//    public void setResCIN(int resCIN) {
//        this.resCIN.setText(String.valueOf(resCIN));
//    }
//
//    public void setResTel(int resTel) {
//        this.resTel.setText(String.valueOf(resTel));
//    }
//
//    
//  
    
    

    
    
//    @FXML
//    private void res(TableColumn.CellEditEvent<S, T> event) {
//    }

//    @FXML
//    private void res(TableColumn.CellEditEvent<S, T> event) {
//    }


    


    
    
    

    
    
