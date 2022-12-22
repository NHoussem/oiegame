package codes;

import java.io.IOException;

public class CaseImage extends CaseQst {
    private final int caseId=7;
    int pas=2;
    Images tab_img=new Images();
    public CaseImage(int e_num_case) {
        super("Noire", e_num_case,10);
    }
    public void Action(Joueur joueur){
        joueur.setCorr_place(2);
        joueur.setScore_act(10);
        
    }
    public void Afficher_img(){
        
    }
    public int getCaseId() {
        return caseId;
    }
    public Images getTab_img() {
        return tab_img;
    }
    public void waittime(){
        while (tab_img.isClicked()==false){
            
        }
    }
    
    
}
