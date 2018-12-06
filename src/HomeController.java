
import University.University;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class - Home
 * This Class controls the functionalities of the User-Interface concerned with Home menu stage, in the FXML file 'Home.fxml'.
 * The Class handles opening a new window for every tab such as dashboard, students, etc...
 * 
 * @author Team-3
 */
public class HomeController implements Initializable {

    @FXML
    private Button db_btn;

    @FXML
    private Button stu_btn;

    @FXML
    private Button fac_btn;

    @FXML
    private Button cur_btn;

    @FXML
    private Button sec_btn;

    @FXML
    private Button set_btn;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == db_btn) {
            loadStage("University/DBoard.fxml");
        } else if (mouseEvent.getSource() == stu_btn) {
            loadStage("University/Students.fxml");
        } else if (mouseEvent.getSource() == fac_btn) {
            loadStage("University/Faculty.fxml");
        } else if (mouseEvent.getSource() == sec_btn) {
            loadStage("University/Sections.fxml");
        }
    }

    private void loadStage(String fxml) {
        try {

            URL url = new File("src/" + fxml).toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);

            String title;

            switch (fxml) {
                case "University/DBoard.fxml":
                    title = "Dashboard";
                    break;
                case "University/Students.fxml":
                    title = "Students";
                    break;
                case "University/Faculty.fxml":
                    title = "Faculty";
                    break;
                case "University/Sections.fxml":
                    title = "Sections";
                    break;
                default:
                    title = "X";
            }
            stage.setTitle(title);
            stage.getIcons().add(new Image("file:data/img/icon.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            University.readCourses();
            University.readSections();
            University.readFaculty();
            University.readStudents();
        } catch (Exception ex) {
            System.out.println("Error in " + getClass().getName());
            System.out.println(ex.getMessage());
        }
    }

}
