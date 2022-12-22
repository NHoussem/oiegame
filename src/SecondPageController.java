import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.lang.model.element.Element;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.synth.SynthScrollBarUI;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import codes.*;

public class SecondPageController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Label l2=new Label();
    private Boolean corrct;
    private String CorrectAns;

    @FXML
    private ImageView BackButton;
    @FXML
    private TextField NomSignin;

    @FXML
    private Button DisplayButton;

    @FXML
    private TextField NomField;

    @FXML
    private TextField NomPartieField;
    @FXML
    private Text Nompartieexist;

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button SubmitButton;
    @FXML
    private Button SubmitButtonSingin;
    @FXML
    private ScrollPane DisplayScroll;
    @FXML
    private TextField SavedGametext;
    
    @FXML
    private VBox VboxTeste;
    @FXML
    void BackFirstPage(MouseEvent event) throws IOException {
        if(SignInButton.isVisible()){
            root = FXMLLoader.load(getClass().getResource("Firstpage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (NomField.isVisible() || (NomSignin.isVisible() || (DisplayScroll.isVisible()) )){
            NomField.setVisible(false);
            NomPartieField.setVisible(false);
            SubmitButton.setVisible(false);
            SignUpButton.setVisible(true);
            DisplayButton.setVisible(true);
            SignInButton.setVisible(true);
            NomSignin.setVisible(false);
            DisplayScroll.setVisible(false);
            SubmitButtonSingin.setVisible(false);
            this.Nompartieexist.setVisible(false);


        }
    }

    @FXML
    void DisplayData(ActionEvent event) {

    }

    @FXML
    void Signup(ActionEvent event) {
        SignUpButton.setVisible(false);
        DisplayButton.setVisible(false);
        SignInButton.setVisible(false);
        NomField.setVisible(true);
        NomPartieField.setVisible(true);
        SubmitButton.setVisible(true);
        

    }

    @FXML
    void SignIn(ActionEvent event) {
        SignUpButton.setVisible(false);
        DisplayButton.setVisible(false);
        SignInButton.setVisible(false);
        NomSignin.setVisible(true);
        SubmitButtonSingin.setVisible(true);

    }
    public void Handlerplateau(ThirdPageController thirdp,Game g2){
        
                    Pane root=thirdp.GetPane();
                    StackPane pane= new StackPane();
                    pane.setVisible(false);
                    int[][] plateu = {
                        
                            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                            { 35, 36, 37, 38, 39, 40, 41, 42, 43, 10 },
                            { 34, 63, 64, 65, 66, 67, 68, 69, 44, 11 },
                            { 33, 62, 83, 84, 85, 86, 87, 70, 45, 12 },
                            { 32, 61, 82, 95, 96, 97, 88, 71, 46, 13 },
                            { 31, 60, 81, 94, 99, 98, 89, 72, 47, 14 },
                            { 30, 59, 80, 93, 92, 91, 90, 73, 48, 15 },
                            { 29, 58, 79, 78, 77, 76, 75, 74, 49, 16 },
                            { 28, 57, 56, 55, 54, 53, 52, 51, 50, 17 },
                            { 27, 26, 25, 24, 23, 22, 21, 20, 19, 18 }
                    };
                    List<Integer> listplat=new ArrayList<>();
                    for (int y = 0; y < 10; y++) {
                        for (int x = 0; x < 10; x++) {
                            listplat.add(plateu[y][x]);
                        }}
                    int cord=listplat.indexOf(g2.getPartie().getJoueur().getCorr_place()-1);
                    for (int y = 0; y < 10; y++) {
                        for (int x = 0; x < 10; x++) {
                            Circle circle = new Circle(50 / 2);
                            circle.setCenterX(50 / 2);
                            circle.setCenterY(50 / 2);
                            circle.setTranslateX(x * (50 + 25) + 50 / 2);
                            circle.setTranslateY(y * (50 + 15) + 50 / 2);
                            int current = plateu[y][x];
                            int mob = g2.getPartie().getPlateau().getcases(current).getCaseId();
                            switch (mob) {
                                case 0:
                                    circle.setFill(Color.GREEN);
                                    break;
                                case 1:
                                    circle.setFill(Color.BLUE);
                                    break;
                                case 2:
                                    circle.setFill(Color.YELLOW);
                                    break;
                                case 3:
                                    circle.setFill(Color.BLACK);
                                    break;
                                case 4:
                                    circle.setFill(Color.RED);
                                    break;
                                case 5:
                                    circle.setFill(Color.WHITE);
                                    break;
                                case 6:
                                    circle.setFill(Color.ORANGE);
                                    break;
                                case 7:
                                    circle.setFill((Color.PINK));
                                    break;
                                
                                case 10:
                                    break;
                                default:
                                    break;
                            }
                            Label label = new Label(Integer.toString(plateu[y][x]+1));
                            label.setTranslateX(x * (50 + 25) + 44 );
                            label.setTranslateY(y * (50 + 15) + 42 );
                            root.getChildren().add(circle);
                            root.getChildren().add(label);
                        }
                    }
                    l2=new Label("X");
                    l2.setVisible(false);
                    l2.setTranslateX(((cord% 10))* (50 + 25) + 39);
                    l2.setTranslateY(((cord / 10))* (50 + 15) + 34);
                    l2.setStyle("-fx-font: 32 arial;");
                    l2.setVisible(true);
                    root.getChildren().add(l2);
                    Line line = new Line(25, 82.5, 687, 82.5);
                    line.setStrokeWidth(4);
                    Line line2 = new Line(687, 82.5, 687, 602.5);
                    line2.setStrokeWidth(4);
                    Line line3 = new Line(687, 602.5, 87.5, 602.5);
                    line3.setStrokeWidth(4);
                    Line line4 = new Line(87.5, 602.5, 87.5, 147.5);
                    line4.setStrokeWidth(4);
                    Line line5 = new Line(87.5, 147.5, 610, 147.5);
                    line5.setStrokeWidth(4);
                    Line line6 = new Line(610, 147.5, 610, 537.5);
                    line6.setStrokeWidth(4);
                    Line line7 = new Line(610, 537.5, 162.5, 537.5);
                    line7.setStrokeWidth(4);
                    Line line8 = new Line(162.5, 537.5, 162.5, 215);
                    line8.setStrokeWidth(4);
                    Line line9 = new Line(162.5, 215, 535, 215);
                    line9.setStrokeWidth(4);
                    Line line10 = new Line(535, 215, 535, 472.5);
                    line10.setStrokeWidth(4);
                    Line line11 = new Line(535, 472.5, 237.5, 472.5);
                    line11.setStrokeWidth(4);
                    Line line12 = new Line(237.5, 472.5, 237.5, 280);
                    line12.setStrokeWidth(4);
                    Line line13 = new Line(237.5, 280, 460, 280);
                    line13.setStrokeWidth(4);
                    Line line14 = new Line(460, 280, 460, 407.5);
                    line14.setStrokeWidth(4);
                    Line line15 = new Line(460, 407.5, 312.5, 407.5);
                    line15.setStrokeWidth(4);
                    Line line16 = new Line(312.5, 407.5, 312.5, 342.5);
                    line16.setStrokeWidth(4);
                    Line line17 = new Line(312.5, 342.5, 385, 342.5);
                    line17.setStrokeWidth(4);
                    ArrayList<Circle> list = new ArrayList<Circle>();
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            Circle cer = new Circle(25);
                            cer.setCenterX(50 / 2);
                            cer.setCenterY(50 / 2);
                            cer.setId(Integer.toString(plateu[i][j]+1));

                            cer.setTranslateX(j * (50 + 25) + 50 / 2);
                            cer.setTranslateY(i * (50 + 15) + 50 / 2);
                            if(g2.getPartie().getJoueur().getCorr_place() == 100){
                                cer.setDisable(true);
                            }
                            cer.setFill(Color.TRANSPARENT);
                            cer.setOnMouseEntered(e -> cer.setFill(Color.rgb(200, 200, 50, 0.7)));
                            cer.setOnMouseExited(e -> cer.setFill(Color.TRANSPARENT));
                            int k = i;
                            int l = j;
                            cer.setOnMouseClicked(e -> {
                                    thirdp.getBtnLanceDes().setDisable(false);
                                    Boolean CorrCercl=false;
                                    CorrCercl=g2.getPartie().getJoueur().AtteindreCase(Integer.parseInt(cer.getId()));
                                    if (CorrCercl==true){
                                        l2.setVisible(false);
                                        l2=new Label("X");
                                        l2.setTranslateX(l * (50 + 25) + 39);
                                        l2.setTranslateY(k * (50 + 15) + 34);
                                        l2.setStyle("-fx-font: 32 arial;");
                                        l2.setVisible(true);
                                        root.getChildren().add(l2);
                                        CaseImage teste = new CaseImage(2);
                                        CaseDef testdef = new CaseDef(1);
                                        CaseFin testefin = new CaseFin(99);
                                        Case bn =g2.getPartie().getPlateau().getcases(plateu[k][l]);
                                        if (bn.getClass()==teste.getClass()){
                                            Boolean AlrdExsite=false;
                                            AlrdExsite=g2.getPartie().VeriExsicas(Integer.parseInt(cer.getId()));
                                            if(AlrdExsite==true){
                                               g2.getPartie().getPlateau().NewimgTocase(((CaseImage)bn));
                                            }
                                            else{
                                                g2.getPartie().addCaseImg(Integer.parseInt(cer.getId()));
                                            }
                                            try{
                                                thirdp.getBtnLanceDes().setDisable(true);
                                                Parent root1;
                                                FXMLLoader loader = new FXMLLoader(getClass().getResource("WindowImage.fxml"));
                                                root1= loader.load();
                                                WindowimgController newwind = loader.getController();
                                                this.CorrectAns=((CaseImage)bn).getTab_img().getCorrid();
                                                corrct=(newwind.getId()==((CaseImage)bn).getTab_img().getCorrid());
                                                newwind.Set(((CaseImage)bn).getTab_img().getTabimg(0), ((CaseImage)bn).getTab_img().getTabimg(1), ((CaseImage)bn).getTab_img().getTabimg(2), ((CaseImage)bn).getTab_img().getTabimg(3),((CaseImage)bn).getTab_img().getMot());
                                                newwind.SetCorrectAns(CorrectAns);
                                                Stage newWindow = new Stage();
                                                Scene secondScene = new Scene(root1,700,700);
                                                newWindow.setTitle("Second Stage");
                                                newWindow.setResizable(false);
                                                newWindow.setScene(secondScene);
                                                newWindow.showAndWait();
                                                if (newwind.isReponse()==true){
                                                    bn.Action(g2.getPartie().getJoueur());
                                                }
                                                else{
                                                    thirdp.getBtnLanceDes().setDisable(false);
                                                }
                                                
                                            }
                                            catch (IOException e1) {
                                            // TODO Auto-generated catch block
                                                e1.printStackTrace();
                                            }
                                            
                                        }else if(bn.getClass()==testdef.getClass()){
                                            Pane root2;
                                                FXMLLoader loader = new FXMLLoader(getClass().getResource("Windowdef.fxml"));
                                                try {
                                                    root2= loader.load();
                                                    thirdp.getBtnLanceDes().setDisable(true);
                                                    WindowdefController newwind = loader.getController();
                                                    newwind.chrgement();
                                                    // System.out.println();
                                                    Stage newWindow = new Stage();
                                                    Scene secondScene = new Scene(root2,700,700);
                                                    newWindow.setTitle("Second Stage");
                                                    newWindow.setScene(secondScene);
                                                    newWindow.setResizable(false);
                                                    newWindow.showAndWait();
                                                    if(newwind.isReponse()){
                                                        bn.Action(g2.getPartie().getJoueur());
                                                    }else{
                                                        g2.getPartie().getJoueur().setScore_act(-10);
                                                        thirdp.getBtnLanceDes().setDisable(false);
                                                    }
                                                } catch (IOException e1) {
                                                    e1.printStackTrace();
                                                }
                                        }
                                        else if (bn.getClass()==testefin.getClass()){
                                            pane.setPrefWidth(766);
                                            pane.setPrefHeight(184);
                                            pane.setStyle("-fx-background-color: black;");
                                            pane.setLayoutX(0);
                                            pane.setLayoutY(233);
                                            Text txt=new Text();
                                            Text txt2 = new Text();
                                            txt.setText("You won "); 
                                            txt2.setText("Game score :"+g2.getGame_Score()+" Player name: "+g2.getNom_joueur());                          
                                            txt.setStyle("-fx-font: 50 arial;");
                                            txt2.setStyle("-fx-font: 20 arial;");
                                            // txt.setTextAlignment(TextAlignment.CENTER);
                                            txt.setFill(Color.WHITE);
                                            txt2.setFill(Color.WHITE);
                                            // txt.setTextAlignment(TextAlignment.CENTER);
                                            StackPane.setAlignment(txt2,Pos.BOTTOM_LEFT);
                                            pane.getChildren().addAll(txt,txt2);
                                            pane.setVisible(true);  
                                            root.getChildren().add(pane);
                                            thirdp.getDesPane().setDisable(true);
                                            thirdp.GetPane().setDisable(true);
                                           

                                        }
                                        else{
                                            bn.Action(g2.getPartie().getJoueur());
                                    }
                                    
                                        thirdp.Setscore(g2);

                                    }
                                    else{
                                        Alert a1 = new Alert(AlertType.WARNING);
                                        a1.setContentText("Case erronée!! vous devez deplacer au case numero "+g2.getPartie().getJoueur().getCorr_place());
                                        a1.showAndWait();
                                    }
                                    Boolean ScoreBatu=false;
                                    ScoreBatu=g2.getPartie().getJoueur().BestScoreMAJ();
                                    if(ScoreBatu==true){
                                        thirdp.Stext();
                                    }
                            });

                            list.add(cer);
                        }
                    }
                    root.getChildren().addAll(list);
                    root.getChildren().add(line);
                    root.getChildren().add(line2);
                    root.getChildren().add(line3);
                    root.getChildren().add(line4);
                    root.getChildren().add(line5);
                    root.getChildren().add(line6);
                    root.getChildren().add(line7);
                    root.getChildren().add(line8);
                    root.getChildren().add(line9);
                    root.getChildren().add(line10);
                    root.getChildren().add(line11);
                    root.getChildren().add(line12);
                    root.getChildren().add(line13);
                    root.getChildren().add(line14);
                    root.getChildren().add(line15);
                    root.getChildren().add(line16);
                    root.getChildren().add(line17);
                    thirdp.GetPane().getChildren().add(thirdp.getPane2());
                    thirdp.getPane2().setVisible(false);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game g1=new Game();
        SubmitButton.setOnAction(event->{
            try {
                g1.New_game(NomField.getText(), NomPartieField.getText());
                g1.Rep_Scorejou(g1.getPartie().getJoueur().getNom());
                g1.reprendre();
                g1.Game_scoreMaj();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        SubmitButtonSingin.setOnAction(event->{
            g1.reprendre_partie(NomSignin.getText());
            g1.Game_scoreMaj();
        });
        DisplayButton.setOnAction(event->{
            int argY=0;
            String stri;
            g1.reprendre();
            g1.Game_scoreMaj();
            DisplayScroll.setVisible(true);
            VboxTeste.setVisible(true);
            SavedGametext.setVisible(true);
            DisplayScroll.setMinSize(500, 40);
            for (Partie partie : g1.getPartieList()){
                g1.reprendre();
                stri=Integer.toString(argY);
                Button but1= new Button();
                but1.setId("but"+stri);
                but1.setMinSize(500, 40);
                but1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent arg0) {
                        g1.reprendre_partie(but1.getText());
                        g1.Rep_Scorejou(g1.getPartie().getJoueur().getNom());
                        String nomjo=g1.getPartie().getJoueur().getNom();
                        String scoreAct=Integer.toString(g1.getPartie().getJoueur().getScore_act());
                        String nompa=g1.getPartie().getNomPartie();
                        String bestScr=Integer.toString(g1.getPartie().getJoueur().getBest_score());
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ThirdPage.fxml"));
                        root= loader.load();
                        ThirdPageController thirdPageController = loader.getController();
                        if(g1.getPartie().getJoueur().getCorr_place() == 100){
                            thirdPageController.getBtnLanceDes().setDisable(true);
                            thirdPageController.GetPane().setDisable(true);
                            thirdPageController.getDesPane().setDisable(true);
                            thirdPageController.getPane2().setVisible(false);
                        }
                        Handlerplateau(thirdPageController, g1);
                        thirdPageController.SetNomJou(nomjo,scoreAct,bestScr,nompa,g1);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                    }
                });
                but1.setStyle("-fx-font-size:20");
                but1.setText(partie.getNomPartie());
                // Displaygird.add(but1,0, argY);
                // Displaygird.setVgap(20);
                argY+=1;
                VboxTeste.getChildren().addAll(but1);
            }
        });
        SubmitButtonSingin.setOnAction(event->{
            g1.reprendre_partie(NomSignin.getText());
            g1.Rep_Scorejou(g1.getPartie().getJoueur().getNom());
            g1.Game_scoreMaj();
            String nomjo=g1.getPartie().getJoueur().getNom();
            String scoreAct=Integer.toString(g1.getPartie().getJoueur().getScore_act());
            String nompa=g1.getPartie().getNomPartie();
            String bestScr=Integer.toString(g1.getPartie().getJoueur().getBest_score());
            // System.out.println(nomjo);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThirdPage.fxml"));
            try {
                root= loader.load();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ThirdPageController thirdPageController = loader.getController();
            Handlerplateau(thirdPageController, g1);
            thirdPageController.SetNomJou(nomjo,scoreAct,bestScr,nompa,g1);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        SubmitButton.setOnAction(event->{
            Boolean exis=false;
            try {
                exis=g1.New_game(NomField.getText(), NomPartieField.getText());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if(exis==false){
                int best_score=0;
                        best_score=g1.Rep_Scorejou(g1.getPartie().getJoueur().getNom());
                        g1.getPartie().getJoueur().setBest_score(best_score);
                        g1.Game_scoreMaj();
                        String nomjo=g1.getPartie().getJoueur().getNom();
                        String scoreAct=Integer.toString(g1.getPartie().getJoueur().getScore_act());
                        String nompa=g1.getPartie().getNomPartie();
                        String bestScr=Integer.toString(g1.getPartie().getJoueur().getBest_score());
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ThirdPage.fxml"));
                        root= loader.load();
                        ThirdPageController third = loader.getController();
                        ThirdPageController thirdPageController = loader.getController();
                        Handlerplateau(thirdPageController, g1);
                        thirdPageController.SetNomJou(nomjo,scoreAct,bestScr,nompa,g1);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    this.Nompartieexist.setText("Nom de partie deja existant");
                }
        });
    }

    public Boolean getCorrct() {
        return corrct;
    }

}
