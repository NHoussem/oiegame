
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class WindowimgController implements Initializable{
    private String id;
    private Parent root;
    private String correctansw;
    private boolean reponse;
    @FXML
    private ImageView Image1;

    @FXML
    private ImageView Image2;

    @FXML
    private ImageView Image3;

    @FXML
    private ImageView Image4;

    @FXML
    private Button Submit;

    @FXML
    private Text Textimg;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Text resulttext;

    public void Set(String pathimg1,String pathimg2,String pathimg3,String pathimg4,String txt){
        File file = new File(pathimg1);
        Image img1 = new Image(file.toURI().toString());
        this.Image1.setImage(img1);
        file = new File(pathimg2);
        Image img2 = new Image(file.toURI().toString());
        this.Image2.setImage(img2);
        file = new File(pathimg3);
        Image img3 = new Image(file.toURI().toString());
        this.Image3.setImage(img3);
        file = new File(pathimg4);
        Image img4 = new Image(file.toURI().toString());
        this.Image4.setImage(img4);
        this.Textimg.setText(txt);
    }
    public void Settext(String txt){
        this.resulttext.setText(txt);
    }
    @FXML
    void giveid(ActionEvent event) {
    }
    
    public String getId() {
        return id;
    }
    public void SetCorrectAns(String corct){
        this.correctansw=corct;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
        button1.setOnAction(event->{
            this.id=button1.getId();
         });
        button2.setOnAction(event->{
            this.id=button2.getId();
        });
        button3.setOnAction(event->{
            this.id=button3.getId();
        });
        button4.setOnAction(event->{
            this.id=button4.getId();
        });
        Submit.setOnAction(event->{
            this.reponse=this.id.equals(this.correctansw);
            if (this.reponse){
                resulttext.setText("True");
            }
            else{
                resulttext.setText("False");
            }
            this.Submit.setDisable(true);
            
        });
         
    }
    public Button getSubmit() {
        return Submit;
    }
    public boolean isReponse() {
        return reponse;
    }
    

    
    
}

