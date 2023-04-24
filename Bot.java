import java.util.ArrayList;
import java.util.Random;

public abstract class Bot extends Players{
    ArrayList<String> cardsBot = new ArrayList<>();
    Cards cd;
    String name;
    public Bot(Cards cd, ArrayList<String> cards, String name) {
        super(cd, cards, name);
    }
    public int RandomChoice(){
        Random rd= new Random();
        int random = rd.nextInt(3)+1;
        return random;
    }

}
