package Main;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class controller extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL url = new File("src/Login/loginX.fxml").toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:data/img/icon.png"));
        stage.show();
        stage.setTitle("Login");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
