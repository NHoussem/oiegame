import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import codes.Joueur;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.robot.Robot;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WindowdefController implements Initializable {

    public static int init;
    private String answ;
    private String real_answ;

    public String getReal_answ() {
        return real_answ;
    }

    public void setReal_answ(String real_answ) {
        this.real_answ = real_answ;
    }





    private boolean init2=true;
    private boolean reponse;

    @FXML
    private HBox defbox;

    public void setInit(boolean init2) {
        this.init2 = init2;
    }

    public static Map<String, String> dfg = new HashMap<String, String>();

    public static String getone="";

    @FXML
    private Text text_def;

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Button Submit;

    @FXML
    private Text secondline;

    @FXML
    private Text trfl;

    public Text getTrfl() {
        return trfl;
    }

    public void setTrfl(String trfl) {
        this.trfl.setText(trfl);
    }

    public void chrgement(){
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(WindowdefController.init == 0){
            try{
                File file=new File("src/def.txt");    //creates a new file instance  
                FileReader fr=new FileReader(file);   //reads the file  
                try (BufferedReader br = new BufferedReader(fr)) {
                    String line; 
                    while((line=br.readLine())!=null){
                        String[] ques_res = line.split("#", 2); 
                        WindowdefController.dfg.put(ques_res[1], ques_res[0]);
                    }
                }
            }catch(Exception e){e.printStackTrace();}
        }
        WindowdefController.init+=1;



        Iterator<Map.Entry<String, String>> it = dfg.entrySet().iterator();
        if(!it.hasNext()){
            return;
        }
        Map.Entry<String, String> out = it.next();

        if(out.getValue().length()>108){
                this.text_def.setText(out.getValue().split("&",2)[0]);
                this.secondline.setText(out.getValue().split("&",2)[1]);
            }else{
            this.text_def.setText(out.getValue());
            }
        this.real_answ = out.getKey();
        WindowdefController.dfg.remove(out.getKey());

        if(init2){
            for(int i=0;i<real_answ.length();i++){
                TextField tf = new TextField();
                defbox.getChildren().add(tf);
                tf.setOnKeyTyped(new EventHandler<Event>() {

                    

                    @Override
                    public void handle(Event arg0) {
                        
                        if(tf.getText().length() != 0 ){
                            WindowdefController.getone= WindowdefController.getone + tf.getText();
                            Robot robot = new Robot();
                            robot.keyPress(KeyCode.TAB);
                            robot.keyRelease(KeyCode.TAB);
                        }

                        Submit.setOnAction(event -> {
        



                        if(WindowdefController.getone.toLowerCase().equals(real_answ.toLowerCase())) {
                            reponse = true;
                            setTrfl("True");
                            
                        }else{
                            reponse = false;
                            setTrfl("False");
                        }
                        WindowdefController.getone="";
                    });  
                        
                    }
                });
            }
        }
            
    }

    public AnchorPane getAnchor() {
        return Anchor;
    }

    public void set(Node nd){
        
    }

    

    public String getAnsw() {
        return answ;
    }



    public void setAnsw(String answ) {
        this.answ = answ;
    }



    public Text getText_def() {
        return text_def;
    }

    public void setText_def(String text_def) {
        this.text_def.setText(text_def);
    }

    public boolean isReponse() {
        return reponse;
    }



    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }





}
