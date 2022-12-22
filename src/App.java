import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import codes.*;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url= new File("src/Firstpage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root,1100,700);
        stage.setOnCloseRequest(e->{
            e.consume();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You're about to logout!");
            alert.setContentText("Do you want to save before exiting?");
            
            if (alert.showAndWait().get() == ButtonType.OK){
                // System.out.println("You successfully logged out");
                stage.close();
            } 
        });
        stage.setTitle("OIE!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }
}
