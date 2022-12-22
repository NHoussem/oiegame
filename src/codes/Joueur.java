package codes;
import java.io.Serializable;
import java.util.Scanner;
public class Joueur implements Serializable {
    private String nom;// indique le nom du joueur
    private int best_score ;// indique le meuilleure score atteint par ce joeur
    private int score_act;//indique le score courant du joueur
    private int some_des;//indique la somme des deux dés
    private int corr_place;// indique la place que doit le joeur
    private int place;// indique la place que le joueur a clicker pour la déplacer 
    private Des des = new Des();//des
    public Joueur(String nom)
    {
        this.nom = nom;
        this.score_act=0;
        this.best_score=0;
        this.place=1;
        this.corr_place=1;
        } 
    public int Deplacer(int depla)
    {// permet de deplacer le joueur selon les valeurs des deux des
        if(this.corr_place+depla>100){
            int recour=(this.corr_place+depla)-100;
            this.corr_place=100;
            this.corr_place-=recour;
        }
        else{
            this.corr_place+=depla;
        }
        
        return this.corr_place;
    }
    public void chng_score(int score)
    {//permet de donnez la valeur au score selon score
        this.score_act=score;
    }
    public void Afficher(){
        System.out.println("Nom: "+this.nom);
        System.out.println("best score: "+this.best_score);
        System.out.println("some_des: "+this.some_des);
        System.out.println("correcte place : "+this.corr_place);
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getBest_score() {
        return best_score;
    }
    public void setBest_score(int best_score) {
        this.best_score = best_score;
    }
    public int getScore_act() {
        return score_act;
    }
    public void setScore_act(int Bonus) {
        this.score_act+= Bonus;
    }
    public int getSome_des() {
        return some_des;
    }
    public void setSome_des(int some_des) {
        this.some_des = some_des;
    }
    public int getCorr_place() {
        return corr_place;
    }
    public void setCorr_place(int sm_des) {//Permet de set l'emplacement correct que doit le joueur  a le deplacer
        if(this.corr_place+sm_des>100){//DAns le cas si il dépasse la case fin
            int recour=(this.corr_place+sm_des)-100;
            this.corr_place=100;
            this.corr_place-=recour;
        }
        else{
            this.corr_place+=sm_des;
        }
    }
    public int lancer_2des(){//permet de lancer deux des
        this.some_des=des.thrw_des()+des.thrw_des();
        return this.some_des;
    }
    public int lancer_des(){//permet de lancer deux des
        int spme=des.thrw_des();
        return spme;
    }
    public void ActionCases(int caseVoulu){
        this.place=caseVoulu;
    }
    public Boolean AtteindreCase(int caseVoulu){//Permet a joueur de clicker sur la case qui veux l'atteindre
        Boolean Corrcplate=false;
        try{
            ActionCases(caseVoulu);
            if (this.corr_place!=this.place)throw new ClickExeption();
            else{
                Corrcplate=true;
            }
        }
        catch(ClickExeption e1){System.out.println("Case erronée!! vous devez deplacer au case numero " +this.corr_place);}
        return Corrcplate;
    }
    public boolean equals(Joueur j) {
        if (j.getNom()!=this.nom){
            return false;
        }
        else{ return true;}
    }
    public void SetCorrplace(int depl){
        this.corr_place=depl;
    }
    public Boolean BestScoreMAJ(){//Permet de mettre a jour le meilleur score du joueur dans le jeu
        Boolean batu=false;
        if (this.score_act>this.best_score){
            this.best_score=this.score_act;
            batu=true;
        }
        return batu;
    }
    public int getPlace() {
        return place;
    }
    
    
}
