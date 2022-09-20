/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import entite.Constat;
import entite.EmailSend;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import service.ConstatService;
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Adminstrateur
 */
public class ConstatController implements Initializable {

    final FileChooser fc = new FileChooser();
    private File file;
    File xxx = null;

    @FXML
    private TextField idconstat;
    @FXML
    private TextField idassurance;
    @FXML
    private TextField iddate;
    @FXML
    private TextField idlieu;
    @FXML
    private TextField idpiecejointe;
    @FXML
    private TableView<Constat> table;
    @FXML
    private TableColumn<Constat, Integer> colconstat;
    @FXML
    private TableColumn<Constat, String> colassurance;
    @FXML
    private TableColumn<Constat, String> coldate;
    @FXML
    private TableColumn<Constat, String> collieu;
    @FXML
    private TableColumn<Constat, String> colpiece;

    /**
     * Initializes the controller class.
     */
    int index = -1;
    Connection cnx = null;
    PreparedStatement st;
    ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("bienvenue hajer ");
        afficher();
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        if (conditiondesaisie()) {
            int id = Integer.parseInt(idconstat.getText());
            String assurance = idassurance.getText();
            String date = iddate.getText();
            String lieu = (idlieu.getText());
            String piece = idpiecejointe.getText();

            ConstatService cs = new ConstatService();
            cs.ajoutervehicule(new Constat(id, assurance, date, lieu, piece));
            afficher();
            JOptionPane.showMessageDialog(null, "Constat ajouté avecc succès");
            clear();
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {

        String query = "DELETE FROM constat WHERE id=" + idconstat.getText() + "";
        executeQuery(query);
        PreparedStatement ps;
        String C = idconstat.getText();
        String yy = "DELETE FROM constat WHERE id ='" + C + "'";
        ps = cnx.prepareStatement(yy);
        ps.execute();
        afficher();
        JOptionPane.showMessageDialog(null, "Constat supprimer avec succes");
        clear();

    }

    @FXML
    private void getselected(MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
        if (index <= - 1) {
            return;
        }
        idconstat.setText(String.valueOf(colconstat.getCellData(index)));
        idassurance.setText(String.valueOf(colassurance.getCellData(index)));
        iddate.setText(String.valueOf(coldate.getCellData(index)));
        idlieu.setText(String.valueOf(collieu.getCellData(index)));
        idpiecejointe.setText(String.valueOf(colpiece.getCellData(index)));

    }

    @FXML
    private void Modifier(ActionEvent event) {

        try {
            cnx = MyConnection.getInstance().getCnx();

            int value1 = Integer.parseInt(idconstat.getText());
            String value2 = idassurance.getText();
            String value3 = iddate.getText();
            String value4 = idlieu.getText();
            String value5 = idpiecejointe.getText();

            String sql = "UPDATE constat SET id_assurance= '" + value2 + "',date= '" + value3 + "',lieu= '" + value4
                    + "',piece_jointe= '" + value5
                    + "' WHERE id='" + value1 + "' ";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Constat modifié");
            afficher();
            clear();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    private void afficher() {
        ConstatService constatservice = new ConstatService();
        ArrayList arrayList = (ArrayList) constatservice.afficherconstat();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);

        colconstat.setCellValueFactory(new PropertyValueFactory<>("id"));
        colassurance.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        colpiece.setCellValueFactory(new PropertyValueFactory<>("piece_jointe"));

    }

    private boolean conditiondesaisie() {

        if (idconstat.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (idassurance.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (iddate.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        } else if (idlieu.getText().equals("")) {
            showMessageDialog(null, " Carburant text field cannot be blank.");
        } else if (idpiecejointe.getText().equals("")) {
            showMessageDialog(null, " text field cannot be blank.");
        }

        return false;
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
        idconstat.clear();
        idassurance.clear();
        iddate.clear();
        idlieu.clear();
        idpiecejointe.clear();

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
            idpiecejointe.appendText(file.getAbsolutePath() + "\n");
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
    private void email(ActionEvent event) throws MessagingException, IOException, javax.mail.MessagingException {
        EmailSend mail = new EmailSend();
        mail.setupServerProperties();
        mail.draftEmail("hajer.elaayeb@esprit.tn");
        mail.sendEmail();

    }

}
