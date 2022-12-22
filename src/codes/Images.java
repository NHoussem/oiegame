package codes;
import java.applet.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
public class  Images implements Serializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String mot;
    private boolean Clicked=false;
    private String Corrid;
    private String id;
    private Boolean correct=false;
    ArrayList<String> tabimg = new ArrayList<String>();//Arraylist qui contient des les pathes des images
    long mTime = System.currentTimeMillis();
    long end = mTime + 7000; // 5 seconds   

    public void ImporteImg(String img1){//Permet d'import les paths des images au tableau
        tabimg.add(img1);
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
    public String getId() {
        return this.id;
    }
    
    public void setId(String hh) {
        this.id = hh;
    }
    public void setCorrid(String corrid) {
        Corrid = corrid;
    }
    public Boolean getCorrect() {
        return correct;
    }
    public boolean isClicked() {
        return Clicked;
    }
    public String getTabimg(int indx) {
        return tabimg.get(indx);
    }
    
    public ArrayList<String> getTbimg() {
        return tabimg;
    }


    public String getCorrid() {
        return Corrid;
    }


    public String getMot() {
        return mot;
    }
    
    
    
    

    
}
