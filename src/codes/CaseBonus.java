package codes;
import java.util.function.Supplier;

public class CaseBonus extends Case {
    public CaseBonus(int e_num_case) {
        
        super("Vert", e_num_case,10,0);
    }
    public void Action(Joueur joueur){
        joueur.setScore_act(10);
        joueur.setCorr_place(2);
        System.out.println("case bonus");
    }

}
