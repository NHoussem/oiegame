import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import codes.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstpageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView ExitButton;
    @FXML
    private AnchorPane ScenePanne;
    @FXML
    void Exit(MouseEvent event) {
        stage = (Stage) ScenePanne.getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK){
			// System.out.println("You successfully logged out");
			stage.close();
		} 
    }

    @FXML
    void Start(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Secondpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

