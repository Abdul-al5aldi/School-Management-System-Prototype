package University;

import static University.University.number_Of_Courses;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * This Class controls the functionalities of the User-Interface concerned with Dashboard tab, in the FXML file 'DBoard.fxml'.
 * The class shows the numbers of existing students, faculty members, sections and courses.
 * 
 * @author Team-3
 */
public class DBoardController implements Initializable {

    @FXML
    private Label numOfStu;

    @FXML
    private Label numOfFac;

    @FXML
    private Label numOfSec;

    @FXML
    private Label numOfCourses;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        numOfStu.setText(University.number_Of_Students + "");
        //numOfStu.setText(University.students.size() + "");

        numOfFac.setText(University.number_Of_Faculty + "");
        //numOfFac.setText(University.faculty.size() + "");

        //numOfSec.setText(00 + "");
        numOfSec.setText(University.number_Of_Sections + "");
        //numOfSec.setText(University.sections.size() + "");

        numOfCourses.setText(University.number_Of_Courses + "");

    }

}
