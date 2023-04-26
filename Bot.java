import java.util.ArrayList;
import java.util.Random;

public abstract class Bot extends Players{
    ArrayList<String> cardsBot = new ArrayList<>();
    public Bot(String name) {
        super(name);
    }
    public int RandomChoice(){
        Random rd= new Random();
        int random = rd.nextInt(3)+1;
        return random;
    }

}
