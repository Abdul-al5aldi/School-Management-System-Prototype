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
 * FXML Controller class - Add faculty window
 * This Class controls the functionalities of the User-Interface concerned with the window of adding a new Faculty Member,
 * in the FXML file 'addFacultyWindow.fxml'.
 * The class handles taking an input from user and making a new faculty based-on the input.
 * 
 * @author Team-3
 */
public class AddFacultyWindowController implements Initializable {

    public static boolean added = false;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField fullNameField;

    @FXML
    private JFXTextField userIDField;

    @FXML
    private JFXTextField departmentField;

    @FXML
    private Label msgLabel;


    @FXML
    void addAction(ActionEvent event) {

        added = false;
        if (fullNameField.getText().isEmpty() || userIDField.getText().isEmpty() || departmentField.getText().isEmpty()) {
            msgLabel.setVisible(true);
        } else {
            msgLabel.setVisible(false);


                Faculty f = new Faculty(fullNameField.getText(), userIDField.getText(), departmentField.getText());
                added = true;
                      
            ((Stage) msgLabel.getScene().getWindow()).close();

        try {
            University.readFaculty();
        } catch (Exception e) {
        }
        }
    }

    /*
    @FXML
    void addAction(ActionEvent event) {

        added = false;
        if (fullNameField.getText().isEmpty() || yearField.getText().isEmpty()) {
            msgLabel.setVisible(true);
        } else {
            msgLabel.setVisible(false);

            if (!majorField.getText().isEmpty()) {
                Student s = new Student(fullNameField.getText(), Integer.parseInt(yearField.getText()), majorField.getText());
                added = true;
            } else {
                Student s = new Student(fullNameField.getText(), Integer.parseInt(yearField.getText()), "undecided");
                added = true;
            }
            ((Stage) msgLabel.getScene().getWindow()).close();
        }
        try {
            University.readStudents();
        } catch (Exception e) {
        }
    }
    */
    
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
