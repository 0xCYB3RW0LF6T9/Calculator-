/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculator.pkg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author CYB3R_W0LF
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField display;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    boolean stat = true;

    @FXML
    private void number(ActionEvent event) {
        if (stat == true) {
            display.setText("");
            stat = false; }

        String oldText = display.getText();
        String newText = ((Button) event.getSource()).getText();
        String p = oldText + newText;
        display.setText(p);

    }

    @FXML
    private void AC(ActionEvent event) {
        display.setText("");
        stat = true;
    }

    @FXML
    private void C(ActionEvent event) {
        String old = display.getText();
       if(old.equals(""))
       {
           return;
       }
        
        String sub = old.substring(0, old.length() - 1);
        display.setText(sub);

    }

    String operator = "";
    double n1 = 0;

    @FXML
    private void operation(ActionEvent event) {
        n1 = Double.parseDouble(display.getText());
        operator = ((Button) event.getSource()).getText();
        display.setText("");

    }

    private void rem(ActionEvent event) {
        

    }

    @FXML
    private void dot(ActionEvent event) {
        String oldText = display.getText();
        if (oldText.contains(".")) {
            return;
        }
        display.setText(oldText + ".");

    }

    @FXML
    private void off(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void result(ActionEvent event) {
        double n2;
        n2 = Double.parseDouble(display.getText());
        if (operator.equals("+")) {
            display.setText("" + (n1 + n2));
        }

        if (operator.equals("-")) {
            display.setText("" + (n1 - n2));
        }

        if (operator.equals("X")) {
            display.setText("" + (n1 * n2));
        }

        if (operator.equals("/")) {
            display.setText("" + (n1 / n2));
        }
        if (operator.equals("%")) {
            double res=n1*n2;
            display.setText("" + (res/100));
        }
        stat = true;

    }

}
