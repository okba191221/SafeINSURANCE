/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import safeinsurance.entites.Assurances;
import safeinsurance.entites.EmailSend;
import safeinsurance.services.RechercheService;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Adminstrateur
 */
public class RechercheController implements Initializable {

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
    private TableColumn<Assurances, Float> col_mantant;
    @FXML
    private TextField txt_cin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    Connection cnx = null;
    PreparedStatement st;
    ResultSet rs;

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
    private AnchorPane rootPanne;

    @FXML
    private void Recherche(ActionEvent event) throws IOException, MessagingException, SQLException {

        show();

    }

    private void show() {
        RechercheService vehiculeservice = new RechercheService();
        ArrayList arrayList = (ArrayList) vehiculeservice.afficherassurancee();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tab_assurance.setItems(observableList);

        col_assurance.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin_client"));
        col_immatricule.setCellValueFactory(new PropertyValueFactory<>("immatricule_voiture"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_mantant.setCellValueFactory(new PropertyValueFactory<>("montant"));

    }

    @FXML
    private void Send(ActionEvent event) throws com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, MessagingException, AddressException, IOException {
        EmailSend mail = new EmailSend();
        mail.setupServerProperties();
        mail.draftEmail("lamis.messaoudi@esprit.tn");
        mail.sendEmail();
    }

}
