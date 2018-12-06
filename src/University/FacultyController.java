package University;

import com.jfoenix.controls.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class - Faculty This Class controls the functionalities of
 * the User-Interface concerned with Faculty tab, in the FXML file
 * 'Faculty.fxml'. The Class shows a table of the available faculty members with
 * their information. Provides buttons for adding new faculty member.
 *
 * @author Team-3
 */
public class FacultyController implements Initializable {

    @FXML
    private TableView<Faculty> facTable;

    @FXML
    private TableColumn<Faculty, String> name;

    @FXML
    private TableColumn<Faculty, String> department;

    @FXML
    private TableColumn<Faculty, String> id;

    @FXML
    private TableColumn<Faculty, String> classes;

    @FXML
    private JFXTextField searchField;

    @FXML
    void addAction(ActionEvent event) {

        try {
            URL url = new File("src/University/addFacultyWindow.fxml").toURL();
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

            if (AddFacultyWindowController.added) {
                facTable.getItems().add(University.faculty.get(University.faculty.size() - 1));
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // set up the columns:
        name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        facTable.getItems().clear();
        // load data
        facTable.setItems(getFaculty());

    }

    public ObservableList<Faculty> getFaculty() {

        ObservableList<Faculty> list = FXCollections.observableArrayList();

        for (Faculty f : University.faculty) {

            if (!facTable.getItems().contains(f)) {
                list.add(f);
            }
        }

        return list;
    }

}
