package codes;

import java.io.Serializable;

public abstract class Case implements Serializable{
    
    private String couleur;//couleur du case
    private int e_num_case;//num de case dans le tableau
    private int point;
    private final int caseId;//attribut qui va nous aider dans l'interface
    public Case(String couleur, int e_num_case,int pnt,int id) {
        this.couleur = couleur;
        this.e_num_case = e_num_case;
        this.point=pnt;
        this.caseId=id;
    }

    public void Action(Joueur joueur){
        
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getE_num_case() {
        return e_num_case;
    }

    public void setE_num_case(int e_num_case) {
        this.e_num_case = e_num_case;
    }
    public int getCaseId() {
        return caseId;
    }
      
}
