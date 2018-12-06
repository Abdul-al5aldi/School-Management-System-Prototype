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
 * FXML Controller class - Add section window
 * This Class controls the functionalities of the User-Interface concerned with the window of adding a new Section,
 * in the FXML file 'addSectionWindow.fxml'.
 * The class handles taking an input from user and making a new Section based-on the input.
 * 
 * @author Team-3
 */
public class AddSectionWindowController implements Initializable {

    public static boolean added = false;

    @FXML
    private JFXTextField courseNameField;

    @FXML
    private JFXTextField locationField;

    @FXML
    private JFXTextField maxNumberField;

    @FXML
    private Label msgLabel;

    @FXML
    void addAction(ActionEvent event) {

        added = false;
        if (courseNameField.getText().isEmpty() || locationField.getText().isEmpty() || maxNumberField.getText().isEmpty()) {
            msgLabel.setVisible(true);
        } else {
            msgLabel.setVisible(false);

            int n = Integer.parseInt(maxNumberField.getText());
            Section sec = new Section(courseNameField.getText(), locationField.getText(), n);
            added = true;

            ((Stage) msgLabel.getScene().getWindow()).close();

            try {
                University.readSections();
            } catch (Exception e) {
            }
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
