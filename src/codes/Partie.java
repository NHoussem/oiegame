package codes;
import java.io.Serializable;
import java.util.ArrayList;
public class Partie implements Serializable{
    private String nomPartie;
    private  final int nbEssai_max=150;
    private  int  nbr_essai=0;
    private ArrayList<Integer> tabCase_parcou = new ArrayList<Integer>();//contient num des cases deja parcouru
    private ArrayList<String> tabQST_app = new ArrayList<String>();//contient les questions deja apparent
    private Plateau plateau;//Plateau
    private Joueur joueur;//joueur

    public Partie(String nomPartie,Joueur joueur) {
        this.nomPartie = nomPartie;
        this.plateau=new Plateau();
        this.joueur=joueur;
    }
    public void incrNb_essai(){
        this.nbr_essai+=1;
    }
    public boolean Veri_perdu()//Permet de déterminer si le joueur a perdu ou non
    {
       if (this.nbr_essai==this.nbEssai_max){
           return true;
       }
       return false;
    }
    public int getNbr_essai() {
        return nbr_essai;
    }

    public void setNbr_essai(int nbr_essai) {
        if (this.tabCase_parcou.size()<150){
            this.nbr_essai = nbr_essai;
        }
        else{System.out.println("nombre max des essais est atteint");}
    }
    
    public void ajouter_numCase(int numCase){
        this.tabCase_parcou.add(numCase);
    }
    public void ajouter_qst(String qst){//Permet d'ajouter qst au tableau des qsts
        this.tabQST_app.add(qst);
    }
    public String getNomPartie() {
        return nomPartie;
    }
    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }
    public void Afficher(){
        System.out.println("partie name :"+this.getNomPartie());
        System.out.println("joueur score_act :"+this.joueur.getBest_score());
        System.out.println("joueur corr_place :"+this.joueur.getCorr_place());
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public Plateau getPlateau() {
        return plateau;
    }
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
    public void addCaseImg(int numcaseimg){//Permet d'ajouter une case image deja parcouru au tableau
        if(this.tabCase_parcou.contains(numcaseimg)){
        }
        else{
            this.tabCase_parcou.add(numcaseimg);
        }
    }
    public boolean VeriExsicas(int numcaseimg){//Permet de vérifier si une case deja parcouru ou non
        Boolean existe=false;
        if (this.tabCase_parcou.contains(numcaseimg)){
            existe=true;
        }
        return existe;
    }
    
    
}
