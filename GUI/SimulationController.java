/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import ecommerce.Mail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SimulationController implements Initializable {

    @FXML
    private Button Sm;
    @FXML
    private RadioButton rbutton21;
    @FXML
    private RadioButton rbutton11;
    @FXML
    private TextField myLabel;
    @FXML
    private ToggleGroup tgchoice_1;
    @FXML
    private ToggleGroup tgchoice_2;
    @FXML
    private RadioButton rbutton12;
    @FXML
    private RadioButton rbutton22;
    @FXML
    private RadioButton rbutton31;
    @FXML
    private ToggleGroup tgchoice_3;
    @FXML
    private RadioButton rbutton32;
    @FXML
    private RadioButton rbutton33;
    @FXML
    private RadioButton rbutton34;
    @FXML
    private RadioButton rbutton41;
    @FXML
    private ToggleGroup tgchoice_4;
    @FXML
    private RadioButton rbutton42;
    @FXML
    private RadioButton rbutton51;
    @FXML
    private ToggleGroup tgchoice_5;
    @FXML
    private RadioButton rbutton52;
    @FXML
    private RadioButton rbutton53;
    @FXML
    private RadioButton rbutton61;
    @FXML
    private RadioButton rbutton62;
    @FXML
    private RadioButton rbutton63;
    @FXML
    private RadioButton rbutton71;
    @FXML
    private RadioButton rbutton72;
    @FXML
    private RadioButton rbutton73;
    @FXML
    private RadioButton rbutton74;
    @FXML
    private RadioButton rbutton81;
    @FXML
    private RadioButton rbutton82;
    @FXML
    private RadioButton rbutton91;
    @FXML
    private RadioButton rbutton92;
    @FXML
    private RadioButton rbutton93;
    @FXML
    private RadioButton rbutton94;
    @FXML
    private RadioButton rbutton95;
    @FXML
    private RadioButton rbutton96;
    @FXML
    private RadioButton rbutton121;
    @FXML
    private RadioButton rbutton122;
    @FXML
    private RadioButton rbutton123;
    @FXML
    private RadioButton rbutton101;
    @FXML
    private RadioButton rbutton102;
    @FXML
    private RadioButton rbutton111;
    @FXML
    private RadioButton rbutton112;
    @FXML
    private RadioButton rbutton113;
    @FXML
    private RadioButton rbutton114;
    @FXML
    private RadioButton rbutton115;
    @FXML
    private ToggleGroup tgchoice_6;
    @FXML
    private ToggleGroup tgchoice_7;
    @FXML
    private ToggleGroup tgchoice_8;
    @FXML
    private ToggleGroup tgchoice_9;
    @FXML
    private ToggleGroup tgchoice_12;
    @FXML
    private ToggleGroup tgchoice_10;
    @FXML
    private ToggleGroup tgchoice_11;
    @FXML
    private TextField myLabel1;
    @FXML
    private TextField myLabel2;
    @FXML
    private TextField txt_nom_prenom;
    @FXML
    private TextField txt_mail;
    @FXML
    private TextField field_age;
    @FXML
    private TextField field_genre;
    @FXML
    private TextField field_job;
    @FXML
    private TextField field_add;
    @FXML
    private TextField field_permis;
    @FXML
    private TextField field_nbplaces;
    @FXML
    private TextField field_typeV;
    @FXML
    private TextField field_etat;
    @FXML
    private TextField field__valeur;
    @FXML
    private TextField field_histo;
    @FXML
    private TextField field_carb;
    @FXML
    private TextField field_chev;
    @FXML
    private RadioButton rbutton64;
    @FXML
    private ToggleGroup tgchoice_61;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void assurance(ActionEvent event) {
    }

    @FXML
    private void somme(ActionEvent event) throws MessagingException, AddressException, IOException {
int a=0,b,c,d,e,f,g,h,i,j,k,l;

int S;

        if (rbutton11.isSelected()){
//           a= Integer.parseInt(rbutton.getText());
           a=15;
          
        }
        else if (rbutton12.isSelected())  {
//            a = Integer.parseInt(rbutton2.getText());
        a=-15;
        }
        else {
    
        JOptionPane.showMessageDialog(null, "vous devez saisir votre âge !" );
        field_age.requestFocus();
        return;
            
        }
        
if (rbutton21.isSelected()){
//          b= Integer.parseInt(rbutton.getText());
          b=25;
        }
else if (rbutton22.isSelected()) {
//            b = Integer.parseInt(rbutton2.getText());
            b=12;
        }
        else {
JOptionPane.showMessageDialog(null, "vous devez saisir votre genre !" );
        field_genre.requestFocus();
        return;
        }
if (rbutton31.isSelected()){
    c=25;
}
    else if (rbutton32.isSelected()){
            c=50;
            }
    else if (rbutton33.isSelected()){
        c=100;
    }
    else if (rbutton34.isSelected()) {
        c=150;
}        
    else {
        JOptionPane.showMessageDialog(null, "vous devez saisir votre profession !" );
        field_job.requestFocus();
        return;
    }
        if (rbutton41.isSelected()){
           d=75;
          
        }
        else if (rbutton42.isSelected()) {
        d=37;
        }
        else {
        JOptionPane.showMessageDialog(null, "vous devez saisir votre lieu de résidence !" );
        field_add.requestFocus();
        return;
        }
        
if (rbutton51.isSelected()){
    e=75;
}
    else if (rbutton52.isSelected()){
            e=50;
            }
    else if (rbutton53.isSelected()) {
        e=25;
    }
    else{
        JOptionPane.showMessageDialog(null, "vous devez saisir votre date de permis !" );
        field_permis.requestFocus();
        return;
    }
    if (rbutton61.isSelected()){
    f=25;
}
    else if (rbutton62.isSelected()){
            f=50;
            }
    else if (rbutton63.isSelected()) {
        f=75;
    }
    else if (rbutton64.isSelected()) {
        f=150;
    }
    else {
        JOptionPane.showMessageDialog(null, "vous devez saisir le nombre de place de votre véhicule !" );
        field_nbplaces.requestFocus();
        return;
    }
    
    
    if (rbutton71.isSelected()){
    g=130;
}
    else if (rbutton72.isSelected()){
            g=60;
            }
    else if (rbutton73.isSelected()){
        g=200;
    }
    else if (rbutton74.isSelected()) {
        g=300;
}
    else{
        JOptionPane.showMessageDialog(null, "vous devez saisir le type de votre véhicule !" );
        field_typeV.requestFocus();
        return;
    }
    
if (rbutton81.isSelected()){

          h=200;
        }
else if (rbutton82.isSelected()) {
            h=60;
        }
else {
    JOptionPane.showMessageDialog(null, "vous devez saisir l'état de votre véhicule !" );
        field_etat.requestFocus();
        return;
}

if (rbutton91.isSelected()){
    i=125;
}
    else if (rbutton92.isSelected()){
            i=250;
            }
    else if (rbutton93.isSelected()){
        i=625;
    }
    else if (rbutton94.isSelected()){
        i=1000;
    }
    else if (rbutton95.isSelected()){
        i=2000;
    }
    else if (rbutton96.isSelected()) {
        i=4000;
}
    else {
        JOptionPane.showMessageDialog(null, "vous devez saisir une valeur rapprochée de votre véhicule !" );
        field__valeur.requestFocus();
        return;
    }

if (rbutton101.isSelected()){
          j=25;
        }
else if (rbutton102.isSelected()) {
            j=50;
        }
else {
    JOptionPane.showMessageDialog(null, "vous devez saisir le type de carburant de votre véhicule !" );
        field_carb.requestFocus();
        return;
}


if (rbutton111.isSelected()){
    k=30;
}
    else if (rbutton112.isSelected()){
            k=60;
            }
    else if (rbutton113.isSelected()){
        k=90;
    }
    else if (rbutton114.isSelected()){
        k=130;
    }
    else if (rbutton115.isSelected()) {
        k=180;
}
    else {
        JOptionPane.showMessageDialog(null, "vous devez saisir le nombre de chevaux fiscaux de votre véhicule !" );
        field_chev.requestFocus();
        return;
    }

    if (rbutton121.isSelected()){
    l=-30;
}
    else if (rbutton122.isSelected()){
            l=25;
            }
    else if (rbutton123.isSelected()) {
        l=75;
    }
    else {
        JOptionPane.showMessageDialog(null, "vous devez saisir votre historique d'accidents !" );
        field_histo.requestFocus();
        return;
    }

if (isValidated()){    
S = 150+ a + b + c +d+e+f+g+h+i+j+k+l;
String result = String.valueOf(S);
myLabel.setText("Assurance basique:"+ " "  +  result +" "+ "dinars");

int S1 = (int) (S*(1.5));
String result1 = String.valueOf(S1);
myLabel1.setText("Assurance dommage & collision:"+ " "  +  result1 +" " + "dinars");

int S2 = S*2;
String result2 = String.valueOf(S2);
myLabel2.setText("Assurance tout risque:"+ " "  +  result2+ " "+ "dinars");

        
//S = a + b + c +d +e +f+g+h+i+j;

        Mail mail = new Mail();
        mail.setupServerProperties();
//        mail.draftEmail("weslati.okba@esprit.tn", "E08093012", 500);
        mail.draftEmail( txt_mail.getText(),txt_nom_prenom.getText(),result,result1,result2);
        mail.sendEmail();
        JOptionPane.showMessageDialog(null, "Vous avez reçu le devis en ligne, veuillez consulter votre boite de réception !" );
        
    }
    }


private boolean isValidated() {
//        String s = categorie.getSelectionModel().getSelectedItem().toString();

        String regex = "^(.+)@(.+)$";
        Pattern y = Pattern.compile(regex);

        // control saisie email
        if (txt_nom_prenom.getText().equals("")) {
            showMessageDialog(null, "vous devez saisir votre nom & prenom");
            txt_nom_prenom.requestFocus();   
        } else if (txt_mail.getText().equals("")) {
            showMessageDialog(null, "vous devez saisir votre adresse email");
            txt_mail.requestFocus();
               } else if (!y.matcher(txt_mail.getText()).matches()) {
            showMessageDialog(null, "L'adresse eamil saisie est incorrecte ou inexistante ! ");
            txt_mail.requestFocus();           
//        } else if (rbutton112.isSelected()==false) {
//            showMessageDialog(null, "vous devez saisir votre âge !");
//            rbutton112.requestFocus(); 
        }
            else {
            return true;
        }
        return false;
    }    
    
}
