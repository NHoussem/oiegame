package codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CaseDef extends CaseQst {

    private final int caseId=1;

    public CaseDef(int e_num_case) {
        super("Bleu", e_num_case,0);//a revoir
        
    }
    @Override
    public void Action(Joueur joueur){
        joueur.setCorr_place(4);
        joueur.setScore_act(20);
    }
    
    public void getDef(String nomf){//Permet d'ontenir une définition a partit d'un fichier

    }
    public int getCaseId() {
        return caseId;
    }
}