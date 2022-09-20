/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import safeinsurance.entites.Assurances;
import safeinsurance.services.AssurancesService;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Adminstrateur
 */
public class AssuranceController implements Initializable {

    @FXML
    private TextField id_cin;
    @FXML
    private TextField id_immatricule;
    @FXML
    private TextField id_type;
    @FXML
    private TextField id_montant;
    @FXML
    private TableView<Assurances> tab_assurance;
    @FXML
    private TableColumn<Assurances, String> col_assurance;
    @FXML
    private TableColumn<Assurances, Integer> col_cin;
    @FXML
    private TableColumn<Assurances, String> col_immatricule;
    @FXML
    private TableColumn<Assurances, String> col_type;
    @FXML
    private TableColumn<Assurances, Float> col_montant;
    @FXML
    private TextField id_assurancee;

    int index = -1;
    Connection cnx = null;
    PreparedStatement st;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Ajouter(ActionEvent event) {

        if (conditiondesaisie()) {
            String id_assurance = id_assurancee.getText();
            int cin_client = Integer.parseInt(id_cin.getText());
            String immatricule_voiture = id_immatricule.getText();
            String type = (id_type.getText());
            float montant = Integer.parseInt(id_montant.getText());

            AssurancesService cs = new AssurancesService();
            cs.ajouterassurance(new Assurances(id_assurance, immatricule_voiture, type, cin_client, montant));
            show();
            JOptionPane.showMessageDialog(null, "Assurance ajouté avecc succès");
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {

        try {
            cnx = MyConnection.getInstance().getCnx();

            String value1 = id_assurancee.getText();
            int value2 = Integer.parseInt(id_cin.getText());
            String value3 = id_immatricule.getText();
            String value4 = id_type.getText();
            float value5 = Float.parseFloat(id_montant.getText());

            String sql = "UPDATE assurances SET cin_client= '" + value2 + "',immatricule_voiture= '" + value3 + "',type= '" + value4
                    + "',montant= '" + value5
                    + "' WHERE id_assurance='" + value1 + "' ";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Assurance modifié");
            show();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {

        String query = "DELETE FROM assurances WHERE id_assurance=" + id_assurancee.getText() + "";
        executeQuery(query);
        PreparedStatement ps;
        String A = id_assurancee.getText();
        String yy = "DELETE FROM assurances WHERE id_assurance ='" + A + "'";
        ps = cnx.prepareStatement(yy);
        ps.execute();
        show();
        System.out.println("Matfassa5ch ");
        JOptionPane.showMessageDialog(null, "Vehicule supprimer avec succes");
        clear();

    }

    @FXML
    private void Get_data(MouseEvent event) {
        index = tab_assurance.getSelectionModel().getSelectedIndex();
        if (index <= - 1) {
            return;
        }
        id_assurancee.setText(String.valueOf(col_assurance.getCellData(index)));
        id_cin.setText(String.valueOf(col_cin.getCellData(index)));
        id_immatricule.setText(String.valueOf(col_immatricule.getCellData(index)));
        id_type.setText(String.valueOf(col_type.getCellData(index)));
        id_montant.setText(String.valueOf(col_montant.getCellData(index)));

    }

    private boolean conditiondesaisie() {

        String number = "[0-9]+";
        Pattern x = Pattern.compile(number);
        String string = "[A-Z || a-z]+";
        String regex = number + string + number;

        Pattern y = Pattern.compile(regex);
        if (id_assurancee.getText().equals("")) {
            showMessageDialog(null, "Assurance text field cannot be blank.");
        } else if (id_cin.getText().equals("")) {
            showMessageDialog(null, "Cin text field cannot be blank.");
        } else if (id_immatricule.getText().equals("")) {
            showMessageDialog(null, "Immatricule text field cannot be blank.");
        } else if (id_type.getText().equals("")) {
            showMessageDialog(null, "type Carburant text field cannot be blank.");
        } else if (id_montant.getText().equals("")) {
            showMessageDialog(null, "Montant text field cannot be blank.");
        } else if (!x.matcher(id_cin.getText()).matches()) {
            showMessageDialog(null, "Cin Client contains only number.");
        } else if (!x.matcher(id_montant.getText()).matches()) {
            showMessageDialog(null, "Montant contains only number.");
        } //        
        else {
            return true;
        }
        return false;
    }

    private void show() {

        AssurancesService assurancesservice = new AssurancesService();
        ArrayList arrayList = (ArrayList) assurancesservice.afficherassurance();

        ObservableList observableList = FXCollections.observableArrayList(arrayList);

        tab_assurance.setItems(observableList);
        col_assurance.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin_client"));
        col_immatricule.setCellValueFactory(new PropertyValueFactory<>("immatricule_voiture"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));

    }

    private void executeQuery(String query) {
        cnx = MyConnection.getInstance().getCnx();
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeQuery(query);
        } catch (SQLException ex) {
        }
    }

    private void clear() {
        id_assurancee.clear();
        id_cin.clear();
        id_immatricule.clear();
        id_type.clear();
        id_montant.clear();
    }

//    private String nom, prenom, immatricule, 
//    private int cin, tel, num_Permis;
//    private String email, 


}