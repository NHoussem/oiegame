import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.xml.validation.Validator;
import codes.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;
import codes.*;

public class ThirdPageController implements Initializable{
    private Game g1;
    private StackPane pane2 = new StackPane();
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Text Affichage;
    @FXML
    private Text BestScore;
    @FXML
    private Button BtnLanceDes;
    @FXML
    private Text CurrentPosition;
    @FXML
    private Button ExitButton;
    @FXML
    private ImageView ImgDes1;
    @FXML
    private ImageView ImgDes2;
    @FXML
    private Text NomUtilisateur;
    @FXML
    private Text Nompartie;
    @FXML
    private Pane PlateauPane;
    @FXML
    private Text ResultDes;
    @FXML
    private Text ScoreActu;

    @FXML
    private Button buttonSave;
    
    @FXML
    private AnchorPane Anchroscene;
    @FXML
    private AnchorPane DesPane;
    @FXML
    private ToggleButton PauseButton;
    @FXML
    private Button BackButton;

    public void SetNomJou(String nomj,String ScoreAct,String BestSco,String nomp
    ,Game gm){
        NomUtilisateur.setText(nomj);
        ScoreActu.setText(ScoreAct);
        this.BestScore.setText(BestSco);
        Nompartie.setText(nomp);
        this.g1=gm;
        ScoreActu.setText(Integer.toString(gm.getPartie().getJoueur().getScore_act()));
        CurrentPosition.setText(Integer.toString(gm.getPartie().getJoueur().getCorr_place()));;
        if(g1.getPartie().getJoueur().getCorr_place() == 100){
            this.PlateauPane.setDisable(false);
            this.DesPane.setDisable(false);
            pane2.setVisible(false);
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbb");
        }
    }
    public void Setscore(Game gm){
        ScoreActu.setText(Integer.toString(gm.getPartie().getJoueur().getScore_act()));
        CurrentPosition.setText(Integer.toString(gm.getPartie().getJoueur().getCorr_place()));
        BestScore.setText((Integer.toString(gm.getPartie().getJoueur().getBest_score())));
        this.Affichage.setText("Vous devez deplacer au case numero "+gm.getPartie().getJoueur().getCorr_place());
    }
    public Pane GetPane(){
        return this.PlateauPane;
       }
    public void Stext(){
        this.Affichage.setText("Congratulation ! You beat ur best score ");
    }
    

    public StackPane getPane2() {
        return pane2;
    }
    public Button getBtnLanceDes() {
        return BtnLanceDes;
    }
    public void SetBestScore(String bstscore){
        this.BestScore.setText(bstscore);
    }
    

    public AnchorPane getDesPane() {
        return DesPane;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        
        
        BtnLanceDes.setOnAction(event->{
            this.g1.SetBestGamer(g1.getPartie().getJoueur());
            int valDes1=0,valDes2=0;
            valDes1=g1.getPartie().getJoueur().lancer_des();
            File file = new File("src/Image/Dice"+valDes1+".png");
            Image image = new Image(file.toURI().toString());
            ImgDes1.setImage(image);
            valDes2=g1.getPartie().getJoueur().lancer_des();
            file = new File("src/Image/Dice"+valDes2+".png");
            image = new Image(file.toURI().toString());
            ImgDes2.setImage(image);
            valDes2+=valDes1;
            g1.getPartie().getJoueur().setSome_des(valDes2);
            g1.getPartie().getJoueur().setCorr_place(valDes2);
            CurrentPosition.setText(Integer.toString(g1.getPartie().getJoueur().getCorr_place()));
            ResultDes.setText(Integer.toString(valDes2));
            Setscore(g1);
            BtnLanceDes.setDisable(true);
        });
        ExitButton.setOnAction(event->{
            Stage stage = (Stage)Anchroscene.getScene().getWindow();
            g1.sauvegarde();
            stage.close();

        });
        buttonSave.setOnAction(event->{
            g1.sauvegarde();
        });
        
        PauseButton.setOnAction(event -> {
            pane2.setVisible(false);
            if(this.PauseButton.isSelected()){
                this.PlateauPane.setDisable(true);
                this.DesPane.setDisable(true);
                Text txt=new Text();
                txt.setText("Game paused "); 
                txt.setStyle("-fx-font: 50 arial;");
                txt.setFill(Color.WHITE);
                pane2.setPrefWidth(766);
                pane2.setPrefHeight(184);
                pane2.setStyle("-fx-background-color: black;");
                pane2.setLayoutX(0);
                pane2.setLayoutY(233);
                pane2.getChildren().add(txt);
                pane2.setVisible(true);
            }
            else{
                this.PlateauPane.setDisable(false);
                this.DesPane.setDisable(false);
                pane2.setVisible(false);
            }
        });

        BackButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Secondpage.fxml"));
            try {
                root= loader.load();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            this.scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        
    }

}
