import java.util.ArrayList;

public abstract class Players {
    private  ArrayList<String> cards;
    private String name;
    private static int whichBot;
    public ArrayList<String> list = new ArrayList<>();

    public Players(ArrayList<String> cards, String name) {
        this.cards = cards;
        this.name = name;
    }

    public ArrayList<String> getCards() {return cards;}
    public void setCards(ArrayList<String> cards) {this.cards = cards;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getWhichBot() {
        return whichBot;
    }

    public static void setWhichBot(int whichBot) {
        Players.whichBot = whichBot;
    }
}
