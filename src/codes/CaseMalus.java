package codes;
public class CaseMalus extends Case {
    public CaseMalus(int e_num_case) {
        super("Rouge", e_num_case,-10,4);
    }
    public void Action(Joueur joueur){
        joueur.setScore_act(-10);
        joueur.Deplacer(-2);
    }
}
