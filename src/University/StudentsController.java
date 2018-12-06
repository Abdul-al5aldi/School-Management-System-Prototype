package University;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class - Students
 * This Class controls the functionalities of the User-Interface concerned with Students tab, in the FXML file 'Students.fxml'.
 * The Class shows a table of the available students with their information.
 * Provides buttons for adding new student.
 * 
 * @author Team-3
 */
public class StudentsController implements Initializable {

    @FXML
    private TableView<Student> stuTable;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> major;

    @FXML
    private TableColumn<Student, Long> id;

    @FXML
    private TableColumn<Student, String> advisorName;

    @FXML
    private JFXTextField searchField;

    @FXML
    void addAction(ActionEvent event) {

        try {
            URL url = new File("src/University/addStudentWindow.fxml").toURL();
            Parent root = FXMLLoader.load(url);

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(((Stage) searchField.getScene().getWindow()));
            dialog.setScene(new Scene(root));
            dialog.getIcons().add(new Image("file:data/img/icon.png"));
            dialog.show();

        } catch (Exception e) {

        }

    }

    @FXML
    void refreshAction(ActionEvent event) {

        try {

            if (AddStudentWindowController.added) {
                stuTable.getItems().add(University.students.get(University.students.size() - 1));
            }

        } catch (Exception e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // set up the columns:
        name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        major.setCellValueFactory(new PropertyValueFactory<>("major"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        advisorName.setCellValueFactory(new PropertyValueFactory<>("advisorId"));

        // load data
        stuTable.setItems(getStudents());

    }

    public ObservableList<Student> getStudents() {

        ObservableList<Student> s = FXCollections.observableArrayList();

        for (Student stu : University.students) {

            if (!stuTable.getItems().contains(stu)) {
                s.add(stu);
            }
        }

        return s;
    }

}
