/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.awt.event.MouseEvent;
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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import safeinsurance.entites.Vehicule;
import safeinsurance.services.VehiculeService;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Adminstrateur
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<Vehicule> table;
    @FXML
    private TableColumn<Vehicule, String> idimmat;
    @FXML
    private TableColumn<Vehicule, String> idtype;
    @FXML
    private TableColumn<Vehicule, String> idmarque;
    @FXML
    private TableColumn<Vehicule, String> idcarburant;
    @FXML
    private TableColumn<Vehicule, Integer> idchf;
    @FXML
    private TableColumn<Vehicule, String> iddate;
    @FXML
    private TableColumn<Vehicule, Integer> idage;
    @FXML
    private TableColumn<Vehicule, Integer> idestimation;
    @FXML
    private TableColumn<Vehicule, String> idclasse;

    ObservableList<Vehicule> VehiculeList = FXCollections.observableArrayList();
    @FXML
    private TextField txtimmatricule;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtmarque;
    @FXML
    private TextField txtcarburant;
    @FXML
    private TextField txtchevfisc;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtestimation;
    @FXML
    private TextField txtclasse;
    @FXML
    private TextField txtdate;

    int index = -1;
    Connection cnx = null;
    PreparedStatement st;
    ResultSet rs;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        show();
        System.out.println("validation ");

    }

    public void affichagevehicule() {

        VehiculeService vehiculeservices = new VehiculeService();
        ArrayList arrayList = (ArrayList) vehiculeservices.affichervehicule();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);

        table.setItems(observableList);

        idimmat.setCellValueFactory(new PropertyValueFactory<>("immatricule"));
        idtype.setCellValueFactory(new PropertyValueFactory<>("type"));
        idmarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        idcarburant.setCellValueFactory(new PropertyValueFactory<>("type_carburant"));
        idchf.setCellValueFactory(new PropertyValueFactory<>("nb_chevaux_fiscaux"));
        iddate.setCellValueFactory(new PropertyValueFactory<>("date_circulation"));
        idestimation.setCellValueFactory(new PropertyValueFactory<>("estimation_rapprochée"));
        idage.setCellValueFactory(new PropertyValueFactory<>("date_circulation"));
        idclasse.setCellValueFactory(new PropertyValueFactory<>("classe"));

    }

    private void getSelected(MouseEvent event) {
//        index = table.getSelectionModel().getSelectedIndex();
//        if (index <= - 1) {
//            return;
//        }
//        txtimmatricule.setText(String.valueOf(idimmat.getCellData(index)));
//        txttype.setText(String.valueOf(idtype.getCellData(index)));
//        txtmarque.setText(String.valueOf(idmarque.getCellData(index)));
//        txtcarburant.setText(String.valueOf(idcarburant.getCellData(index)));
//        txtchevfisc.setText(String.valueOf(idchf.getCellData(index).toString()));
//        txtdate.setText(String.valueOf(iddate.getCellData(index)));
//        txtage.setText(String.valueOf(idage.getCellData(index).toString()));
//        txtestimation.setText(String.valueOf(idestimation.getCellData(index).toString()));
//        txtclasse.setText(String.valueOf(idclasse.getCellData(index)));
    }

    private boolean conditiondesaisie() {

        String number = "[0-9]+";
        Pattern x = Pattern.compile(number);
        String string = "[A-Z || a-z]+";
        String regex = number +string+ number ;
 
        Pattern y = Pattern.compile(regex);
        if (txtimmatricule.getText().equals("")) {
            showMessageDialog(null, "Immatricule text field cannot be blank.");
        } else if (txttype.getText().equals("")) {
            showMessageDialog(null, "Type text field cannot be blank.");
        } else if (txtmarque.getText().equals("")) {
            showMessageDialog(null, "Marque text field cannot be blank.");
        } else if (txtcarburant.getText().equals("")) {
            showMessageDialog(null, "type Carburant text field cannot be blank.");
        } else if (txtchevfisc.getText().equals("")) {
            showMessageDialog(null, "NB chevaux fiscaux text field cannot be blank.");
        } else if (txtdate.getText().equals("")) {
            showMessageDialog(null, "Date Circulation text field cannot be blank.");
        } else if (txtage.getText().equals("")) {
            showMessageDialog(null, "age text field cannot be blank.");
        } else if (txtestimation.getText().equals("")) {
            showMessageDialog(null, "Estimation text field cannot be blank.");
        } else if (txtclasse.getText().equals("")) {
            showMessageDialog(null, "Classe text field cannot be blank.");
        } else if (!x.matcher(txtchevfisc.getText()).matches()) {
            showMessageDialog(null, "NB chevaux fiscaux contains only number.");
        } else if (!x.matcher(txtage.getText()).matches()) {
            showMessageDialog(null, "age permis contains only number.");
        } else if (!y.matcher(txtimmatricule.getText()).matches()) {
            showMessageDialog(null, "Immatricule text field cannot be blank.");}
        //        
        else {
            return true;
        }
        return false;
    }

    @FXML
    private void saveEvent(ActionEvent event) {

        if (conditiondesaisie()) {
            String immatricule = txtimmatricule.getText();
            String type = txttype.getText();
            String marque = txtmarque.getText();
            String type_carburant = (txtcarburant.getText());
            int nb_chevaux_fiscaux = Integer.parseInt(txtchevfisc.getText());
            String date_circulation = txtdate.getText();
            int age = Integer.parseInt(txtage.getText());
            int estimation_rapprochée = Integer.parseInt(txtestimation.getText());
            String classe = txtclasse.getText();

            VehiculeService cs = new VehiculeService();
            cs.ajoutervehicule(new Vehicule(immatricule, type, marque, type_carburant, nb_chevaux_fiscaux, date_circulation, age, estimation_rapprochée, classe));
            show();
            JOptionPane.showMessageDialog(null, "Vehicule ajouté avecc succès");
        }

    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            cnx = MyConnection.getInstance().getCnx();

            String value1 = txtimmatricule.getText();
            String value2 = txttype.getText();
            String value3 = txtmarque.getText();
            String value4 = txtcarburant.getText();
            int value5 = Integer.parseInt(txtchevfisc.getText());
            String value6 = txtdate.getText();
            int value7 = Integer.parseInt(txtage.getText());
            int value8 = Integer.parseInt(txtestimation.getText());
            String value9 = txtclasse.getText();

            String sql = "UPDATE véhicules SET type= '" + value2 + "',marque= '" + value3 + "',type_carburant= '" + value4
                    + "',nb_chevaux_fiscaux= '" + value5 + "',date_circulation= '" + value6 + "',age= '" + value7
                    + "',estimation_rapprochée= '" + value8 + "',classe= '" + value9
                    + "' WHERE immatricule='" + value1 + "' ";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Vehicule modifié");
            show();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void deleteEvent(ActionEvent event) throws SQLException {
        String query = "DELETE FROM véhicules WHERE immatricule=" + txtimmatricule.getText() + "";
        executeQuery(query);
        PreparedStatement ps;
        String V = txtimmatricule.getText();
        String yy = "DELETE FROM véhicules WHERE immatricule ='" + V + "'";
        ps = cnx.prepareStatement(yy);
        ps.execute();
        show();
        System.out.println("Matfassa5ch ");
        JOptionPane.showMessageDialog(null, "Vehicule supprimer avec succes");
        clear();

    }

    private void clear() {
        txtimmatricule.clear();
        txttype.clear();
        txtmarque.clear();
        txtcarburant.clear();
        txtchevfisc.clear();
        txtdate.clear();
        txtage.clear();
        txtestimation.clear();
        txtclasse.clear();
        //   96142949
    }

    private void show() {
        VehiculeService vehiculeservice = new VehiculeService();
        ArrayList arrayList = (ArrayList) vehiculeservice.affichervehicule();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);

        idimmat.setCellValueFactory(new PropertyValueFactory<>("immatricule"));
        idtype.setCellValueFactory(new PropertyValueFactory<>("type"));
        idmarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        idcarburant.setCellValueFactory(new PropertyValueFactory<>("type_carburant"));
        idchf.setCellValueFactory(new PropertyValueFactory<>("nb_chevaux_fiscaux"));
        iddate.setCellValueFactory(new PropertyValueFactory<>("date_circulation"));
        idage.setCellValueFactory(new PropertyValueFactory<>("age"));
        idestimation.setCellValueFactory(new PropertyValueFactory<>("estimation_rapprochée"));
        idclasse.setCellValueFactory(new PropertyValueFactory<>("classe"));

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

    @FXML
    private void test(javafx.scene.input.MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= - 1) {
            return;
        }
        txtimmatricule.setText(String.valueOf(idimmat.getCellData(index)));
        txttype.setText(String.valueOf(idtype.getCellData(index)));
        txtmarque.setText(String.valueOf(idmarque.getCellData(index)));
        txtcarburant.setText(String.valueOf(idcarburant.getCellData(index)));
        txtchevfisc.setText(String.valueOf(idchf.getCellData(index)));
        txtdate.setText(String.valueOf(iddate.getCellData(index)));
        txtage.setText(String.valueOf(idage.getCellData(index)));
        txtestimation.setText(String.valueOf(idestimation.getCellData(index)));
        txtclasse.setText(String.valueOf(idclasse.getCellData(index)));
    }

}
