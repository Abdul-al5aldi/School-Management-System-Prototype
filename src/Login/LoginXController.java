package Login;

import University.University;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 * This Class controls the functionalities of the User-Interface concerned with Login, in the FXML file 'loginX.fxml'.
 * 
 * @author Team-3
 */
public class LoginXController implements Initializable {

    @FXML
    private Label wrong;

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    void handleCancelButtonAction(ActionEvent event) {

    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {

        String name = userNameField.getText();
        String pass = passwordField.getText();

        try {
            if (loginValidation(name, pass)) {
                wrong.setVisible(false);
                System.out.println("Logged In . . .");
                closeStage();
                loadMain();

            } else {
                wrong.setVisible(true);
            }
        } catch (Exception ex) {

        }

    }

    private final static File loginFile = new File("data/login.txt");

    public static boolean loginValidation(String name, String pass) throws Exception {
        Scanner fscn = new Scanner(loginFile);

        while (fscn.hasNextLine()) {

            String nameFile = fscn.nextLine();

            if (name.equals(nameFile)) {
                String passFile = fscn.nextLine();
                return (passFile.equals(pass));
            }
            fscn.nextLine();
        }
        fscn.close();

        return false;
    }

    /////////////////////
    private void closeStage() {
        ((Stage) wrong.getScene().getWindow()).close();
    }

    void loadMain() {
        try {

            Stage stage = new Stage();
            URL url = new File("src/home.fxml").toURL();
            Parent root = FXMLLoader.load(url);

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Home");
            stage.getIcons().add(new Image("file:data/img/icon.png"));
            stage.show();

        } catch (Exception ex) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wrong.setVisible(false);
    }

}
