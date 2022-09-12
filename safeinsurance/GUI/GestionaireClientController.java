/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import safeinsurance.entities.clients;
import safeinsurance.services.clientservices;
import safeinsurance.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GestionaireClientController implements Initializable {

    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtrole;
    @FXML
    private TextField txttel;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtmdp;
    @FXML
    private TextField txtimmatricule;
    @FXML
    private TextField txtdelivrele;
    @FXML
    private TextField txtnumpermis;
    @FXML
    private TextField txtemail;

    ResultSet rs;
    PreparedStatement pst;
    int index = -1;
    Connection cnx = null;
    @FXML
    private TableView<clients> table_client;
    @FXML
    private TableColumn<clients, Integer> cocin;
    @FXML
    private TableColumn<clients, String> conom;
    @FXML
    private TableColumn<clients, String> coprenom;
    @FXML
    private TableColumn<clients, Integer> cotel;
    @FXML
    private TableColumn<clients, String> corole;
    @FXML
    private TableColumn<clients, String> coemail;
    @FXML
    private TableColumn<clients, Integer> conp;
    @FXML
    private TableColumn<clients, Date> codate;
    @FXML
    private TableColumn<clients, String> coimmatricule;
    @FXML
    private TableColumn<clients, String> comdp;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
       
    }

    public void affichageclient() {
        clientservices clientservices = new clientservices();
        ArrayList arrayList = (ArrayList) clientservices.afficherclient();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table_client.setItems(observableList);
        cocin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        coimmatricule.setCellValueFactory(new PropertyValueFactory<>("immatricule"));
        conom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        coprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cotel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        codate.setCellValueFactory(new PropertyValueFactory<>("Délivré_le"));
        comdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        corole.setCellValueFactory(new PropertyValueFactory<>("role"));
        coemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        conp.setCellValueFactory(new PropertyValueFactory<>("Num_Permis"));

    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table_client.getSelectionModel().getSelectedIndex();
        if (index <= - 1) {
            return;
        }
        txtcin.setText(cocin.getCellData(index).toString());
        txtnom.setText(conom.getCellData(index));
        txtprenom.setText(coprenom.getCellData(index));
        txttel.setText(cotel.getCellData(index).toString());
        txtrole.setText(corole.getCellData(index));
        txtemail.setText(coemail.getCellData(index));
        txtnumpermis.setText(conp.getCellData(index).toString());
        txtdelivrele.setText(codate.getCellData(index).toString());
        txtimmatricule.setText(coimmatricule.getCellData(index));
        txtmdp.setText(comdp.getCellData(index));

    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        if (conditiondesaisie()) {
            int cin = Integer.parseInt(txtcin.getText());
            String immatricule = txtimmatricule.getText();
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            int tel = Integer.parseInt(txttel.getText());
            Date Délivré_le = Date.valueOf(txtdelivrele.getText());
            String mdp = txtmdp.getText();
            String role = txtrole.getText();
            String email = txtemail.getText();
            int num_Permis = Integer.parseInt(txtnumpermis.getText());
            clientservices cs = new clientservices();
            cs.ajouterclient(new clients(cin, nom, prenom, tel, mdp, role, email, immatricule, num_Permis, Délivré_le));
            show();
            JOptionPane.showMessageDialog(null, "client ajouté avecc succès");
        }

    }

    public void show() {
        clientservices clientservices = new clientservices();
        ArrayList arrayList = (ArrayList) clientservices.afficherclient();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table_client.setItems(observableList);
        cocin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        conom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        coprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cotel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        corole.setCellValueFactory(new PropertyValueFactory<>("role"));
        coemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        conp.setCellValueFactory(new PropertyValueFactory<>("Num_Permis"));
        codate.setCellValueFactory(new PropertyValueFactory<>("Délivré_le"));
        coimmatricule.setCellValueFactory(new PropertyValueFactory<>("Immatricule"));
        comdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
    }

    @FXML
    private void edit(ActionEvent event) {

        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            int value1 = Integer.parseInt(txtcin.getText());
            String value2 = txtimmatricule.getText();
            String value3 = txtnom.getText();
            String value4 = txtprenom.getText();
            int value5 = Integer.parseInt(txttel.getText());
            Date value6 = Date.valueOf(txtdelivrele.getText());
            String value7 = txtmdp.getText();
            String value8 = txtrole.getText();
            String value9 = txtemail.getText();
            int value10 = Integer.parseInt(txtnumpermis.getText());

//                String sql = "UPDATE employees SET nom='"+value1+"',prenom= '"+value2+"',fonction= '"+value3+"',matricule= '"+value4+"',cin= '"+value5+"',tel= '"+value6+"'";             
            String sql = "UPDATE clients SET immatricule= '" + value2 + "',nom= '" + value3 + "',prenom= '"
                    + value4 + "',tel= '" + value5 + "',Délivré_le= '" + value6 + "',mdp= '" + value7 + "',role= '" + value8
                    + "',email= '" + value9 + "',Num_Permis= '" + value10 + "' WHERE cin='" + value1 + "' ";
//            String sql ="update employees set nom ,prenom,fonction,matricule,cin,tel) values('"+value1+"','"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6 +"')";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.execute();
            JOptionPane.showMessageDialog(null, "client modifié");
            show();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        String query = "DELETE FROM clients WHERE cin =" + txtcin.getText() + "";
        executeQuery(query);
        PreparedStatement ps;
        Integer x = Integer.valueOf(txtcin.getText());
        String yy = "DELETE FROM clients WHERE cin ='" + x + "'";
        ps = cnx.prepareStatement(yy);
        ps.execute();
        show();
        JOptionPane.showMessageDialog(null, "Client supprimer avec succes");
        txtcin.clear();
        txtdelivrele.clear();
        txtimmatricule.clear();
        txtmdp.clear();
        txtnom.clear();
        txtrole.clear();
        txtprenom.clear();
        txtemail.clear();
        txttel.clear();
        txtnumpermis.clear();

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
        } else if (txtprenom.getText().equals("")) {
            showMessageDialog(null, "prenom text field cannot be blank.");
        } else if (txttel.getText().equals("")) {
            showMessageDialog(null, "telephone text field cannot be blank.");
        } else if (txtrole.getText().equals("")) {
            showMessageDialog(null, "role text field cannot be blank.");
        } else if (txtemail.getText().equals("")) {
            showMessageDialog(null, "email text field cannot be blank.");
        } else if (txtnumpermis.getText().equals("")) {
            showMessageDialog(null, "num_permis text field cannot be blank.");
        } else if (txtdelivrele.getText().equals("")) {
            showMessageDialog(null, "Délivré_le text field cannot be blank.");
        } else if (txtimmatricule.getText().equals("")) {
            showMessageDialog(null, "immatricule text field cannot be blank.");
        } else if (txtmdp.getText().equals("")) {
            showMessageDialog(null, "mot de passe text field cannot be blank.");
        } else if (!x.matcher(txtcin.getText()).matches()) {
            showMessageDialog(null, "cin contains only number.");
        } else if (txtcin.getText().length() < 8 || txtcin.getText().length() > 8) {
            showMessageDialog(null, "cin contains only 8 number.");
        } else if (txttel.getText().length() < 8 || txttel.getText().length() > 8) {
            showMessageDialog(null, "tel contains only 8 number.");
        } else if (!x.matcher(txttel.getText()).matches()) {
            showMessageDialog(null, "tel contains only number.");
        } else if (!x.matcher(txtnumpermis.getText()).matches()) {
            showMessageDialog(null, "numero permis contains only number.");
        }  else if (!y.matcher(txtemail.getText()).matches()) {
            showMessageDialog(null, "email text field cannot be blank.");}
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       

         
        
           
     
           

     else {
            return true;
        }
        return false;
    }
}
