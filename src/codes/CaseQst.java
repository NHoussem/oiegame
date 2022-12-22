package codes;

import java.io.IOException;

abstract class CaseQst extends Case{

    private boolean parcouru=false;// pour indiquer si la case a été deja parcouru ou non
    public CaseQst(String couleur, int e_num_case,int pnt) {
        super(couleur, e_num_case,pnt,10);
    }
    public void Action(Joueur joueur){
        
    }
    public void ChangQst(){
        
    }

}
