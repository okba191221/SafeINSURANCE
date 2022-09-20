/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.xml.crypto.Data;
import org.controlsfx.control.Notifications;
import safeinsurance.entites.EmailSend;
import safeinsurance.entites.rapport;
import safeinsurance.services.RaportService;
import safeinsurance.tools.MyConnection;

/**
 *
 * @author Jhon
 */
public class FXMLDocumentController implements Initializable {

    final FileChooser fc = new FileChooser();
    private File file;
    File xxx = null;
    @FXML
    private TextField txt_id_rapport;
    @FXML
    private TextField txt_id_constat;
    @FXML
    private TextField txt_mat_employee;
    @FXML
    private TextField txt_id_assurance;
    @FXML
    private TextField txt_piece_jointe;
    @FXML
    private TextField txt_date_rapport;

    @FXML
    private TableView<rapport> list;
    @FXML
    private TableColumn<rapport, String> date_rapport_list;

    @FXML
    private TableColumn<rapport, String> id_assurence_list;

    @FXML
    private TableColumn<rapport, String> id_constat_list;

    @FXML
    private TableColumn<rapport, String> id_rapport_list;

    @FXML
    private TableColumn<rapport, String> mat_employee_list;

    @FXML
    private TableColumn<rapport, String> piece_jointe_list;

    @FXML
    private Label label;

    int index = -1;
    Connection cnx = null;
    PreparedStatement st;
    ResultSet rs;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnmail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
        System.out.println("");
    }

    public void affichagerapport() {

        RaportService raportservice = new RaportService();
        ArrayList arrayList = (ArrayList) raportservice.afficherrapport();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);

        list.setItems(observableList);
        id_rapport_list.setCellValueFactory(new PropertyValueFactory<>("date_rapport_list"));
        id_constat_list.setCellValueFactory(new PropertyValueFactory<>("id_constat"));
        mat_employee_list.setCellValueFactory(new PropertyValueFactory<>("mat_employee"));
        id_assurence_list.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        piece_jointe_list.setCellValueFactory(new PropertyValueFactory<>("pieces_jointes"));
        date_rapport_list.setCellValueFactory(new PropertyValueFactory<>("id_rapport_list"));

    }

    private boolean conditiondesaisie() {

        if (txt_date_rapport.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (txt_id_assurance.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (txt_id_constat.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (txt_mat_employee.getText().equals("")) {
            showMessageDialog(null, " Carburant text field cannot be blank.");
        } else if (txt_piece_jointe.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (txt_id_rapport.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else {
            return true;
        }
        return false;
//        EmailDeBienvenue email = new EmailDeBienvenue();
//                email.setupServerProperties();
//                email.draftEmail(mail, IDnom.getText());
//                email.sendEmail();
//                System.out.println(mail);
    }

    @FXML
    void ajouter(ActionEvent event) {
        if (conditiondesaisie()) {
            String id_rapport = (txt_id_rapport.getText());
            String id_constat = txt_id_constat.getText();
            String mat_employee = (txt_mat_employee.getText());
            String id_assurance = txt_id_assurance.getText();
            String pieces_jointes = (txt_piece_jointe.getText());
            String date_rapport = (txt_date_rapport.getText());

            RaportService cs = new RaportService();
            cs.ajouterraport(new rapport(id_rapport, id_constat, mat_employee, id_assurance, pieces_jointes, date_rapport));
            show();
            JOptionPane.showMessageDialog(null, "Rapport ajouté avecc succès");
        }

    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = list.getSelectionModel().getSelectedIndex();
        if (index <= - 1) {
            return;
        }
        txt_id_rapport.setText(id_rapport_list.getCellData(index));
        txt_id_constat.setText(id_constat_list.getCellData(index));
        txt_mat_employee.setText(mat_employee_list.getCellData(index));
        txt_id_assurance.setText(id_assurence_list.getCellData(index));
        txt_piece_jointe.setText(piece_jointe_list.getCellData(index));
        txt_date_rapport.setText(date_rapport_list.getCellData(index));

    }

    @FXML
    void modifier(ActionEvent event) {
        try {
            cnx = MyConnection.getInstance().getCnx();

            String value1 = txt_id_rapport.getText();
            String value2 = txt_id_constat.getText();
            String value3 = txt_mat_employee.getText();
            String value4 = txt_id_assurance.getText();
            String value5 = txt_piece_jointe.getText();
            String value6 = txt_date_rapport.getText();

            String sql = "UPDATE rapport SET  id_constat= '" + value2 + "',mat_employee= '"
                    + value3 + "',id_assurance= '" + value4 + "',pieces_jointes  = '" + value5 + "',date_rapport = '" + value6
                    + "'WHERE id_rapport= '" + value1 + "' ";

            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.execute();

            JOptionPane.showMessageDialog(
                    null, "rapport modifié");
            show();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void supprimer(ActionEvent event) throws SQLException {

        String query = "DELETE FROM rapport WHERE id_constat  =" + txt_id_rapport.getText() + "";
        executeQuery(query);
        PreparedStatement ps;

        String R = txt_id_rapport.getText();
        String yy = "DELETE FROM rapport WHERE id_rapport ='" + R + "'";
        ps = cnx.prepareStatement(yy);
        ps.execute();
        show();
        JOptionPane.showMessageDialog(null, "rapport supprimer avec succes");
        txt_id_rapport.clear();
        txt_date_rapport.clear();
        txt_id_assurance.clear();
        txt_mat_employee.clear();
        txt_piece_jointe.clear();
        txt_id_constat.clear();

    }

    private void show() {
        RaportService rapportservice = new RaportService();
        ArrayList arrayList = (ArrayList) rapportservice.afficherrapport();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        list.setItems(observableList);

        id_rapport_list.setCellValueFactory(new PropertyValueFactory<>("id_rapport"));
        id_constat_list.setCellValueFactory(new PropertyValueFactory<>("id_constat"));
        mat_employee_list.setCellValueFactory(new PropertyValueFactory<>("mat_employee"));
        id_assurence_list.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        piece_jointe_list.setCellValueFactory(new PropertyValueFactory<>("pieces_jointes"));
        date_rapport_list.setCellValueFactory(new PropertyValueFactory<>("date_rapport"));

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
    private void upload(ActionEvent event) throws IOException {
        fc.setTitle("Uplode piece jointe");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("all file", "*.*"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter(" fichier document", "*.pdf", "*.docx"));;
        File file = fc.showOpenDialog(null);
        if (file != null) {

            String x = file.getAbsolutePath();
            String newpath = "uploads/constat/";
            File dir = new File(newpath);
            if (!dir.exists()) {
                // folder wa7dd ken barchaa mkdirs
                dir.mkdirs();
            }
            File sourceFile = null;
            File destinationFile = null;
            String extension = x.substring(x.lastIndexOf('.') + 1);
            sourceFile = new File(x);
            xxx = new File(newpath + randomStringforfile() + "." + extension);
            Files.copy(sourceFile.toPath(), xxx.toPath());
            //   System.out.println(destinationFile);
            System.out.println(xxx);
            txt_piece_jointe.appendText(file.getAbsolutePath() + "\n");
//            img.setImage(new Image(file.toURI().toString()));
        } else {
            System.out.println("file is invalide");
        }
    }

    public static String randomStringforfile() {
        //   String  randomString  =null;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 12;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();

        return randomString;
    }

    @FXML
    private void mail(ActionEvent event) throws SQLException, MessagingException, AddressException, IOException {
        EmailSend mail = new EmailSend();
        mail.setupServerProperties();
        mail.draftEmail("TALBI.Jihed@esprit.tn");
        mail.sendEmail();

    }
}
