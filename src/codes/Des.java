package codes;
import java.io.Serializable;

public class Des implements Serializable {
    private int min =1;
    private int max =6;

    public int thrw_des (){//Fonction qui permet de lancer un des 
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    
}
