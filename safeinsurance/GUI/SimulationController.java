/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeinsurance.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SimulationController implements Initializable {

    @FXML
    private RadioButton rbutton;
    @FXML
    private RadioButton rbutton2;
    @FXML
    private RadioButton rbutton1;
    @FXML
    private Button Sm;
    @FXML
    private RadioButton rbutton3;
    @FXML
    private RadioButton rbutton21;
    @FXML
    private RadioButton rbutton11;
    @FXML
    private TextField myLabel;

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
    private void somme(ActionEvent event) {
int a;
int b;
int S;
        if (rbutton.isSelected()){
//           a= Integer.parseInt(rbutton.getText());
           a=40;
          
        }
        else if (rbutton2.isSelected()){
//            a = Integer.parseInt(rbutton2.getText());
        a=60;
        }
        else {
//            a = Integer.parseInt(rbutton1.getText());
            a=80;
        }
if (rbutton3.isSelected()){
//          b= Integer.parseInt(rbutton.getText());
          b=10;
        }
        else if (rbutton2.isSelected()){
//            b = Integer.parseInt(rbutton2.getText());
            b=50;
        }
        else {
//            b = Integer.parseInt(rbutton1.getText());
            b=100;
        }
        S = a + b; 
        String result = String.valueOf(S);
        
        myLabel.setText(result);
    }

    @FXML
    private void assurance_1(ActionEvent event) {
    }
    
}
