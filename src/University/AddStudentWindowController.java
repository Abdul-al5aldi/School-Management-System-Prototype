/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class AddStudentWindowController implements Initializable {

    //
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField fullNameField;

    @FXML
    private JFXTextField yearField;

    @FXML
    private JFXTextField majorField;

    @FXML
    private Label msgLabel;

    @FXML
    void addAction(ActionEvent event) {

        if (fullNameField.getText().isEmpty() || yearField.getText().isEmpty()) {
            msgLabel.setVisible(true);
        } else {
            msgLabel.setVisible(false);

            // Student s = new Student (fullName.getText(), year.getText());
            if (!majorField.getText().isEmpty()) {
                //s.setMajor(majorField.getText());
            }
            ((Stage) msgLabel.getScene().getWindow()).close();

        }
    }

    @FXML
    void cancelAction(ActionEvent event) {

        ((Stage) msgLabel.getScene().getWindow()).close();

    }

    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgLabel.setVisible(false);
    }

}
