package codes;
public class CaseSaut extends Case{
    private final int max=100;
    private final int min=1;

    public CaseSaut(int e_num_case) {
        super("Orange", e_num_case,0,6);
    }

    @Override
    public void Action(Joueur joueur) {
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        joueur.SetCorrplace(random_int);
    }
    
}
