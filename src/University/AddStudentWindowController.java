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
 * FXML Controller class - Add student window This Class controls the
 * functionalities of the User-Interface concerned with the window of adding a
 * new Student Member, in the FXML file 'addStudentWindow.fxml'. The class
 * handles taking an input from user and making a new student based-on the
 * input.
 *
 * @author Team-3
 */
public class AddStudentWindowController implements Initializable {

    public static boolean added = false;

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

    @FXML
    void cancelAction(ActionEvent event) {

        ((Stage) msgLabel.getScene().getWindow()).close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgLabel.setVisible(false);
    }

}
