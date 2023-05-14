import java.util.ArrayList;
import java.util.Collections;

public class Cards {
    private static final String[] suits = {"C", "H", "D", "S"};
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static ArrayList<String> deck = new ArrayList<>();
    private static final int cardnumber = 52;
    public Cards() {
        setCards();
    }

    public String[] getSuits() {return suits;}
    public String[] getRanks() {return ranks;}
    public void setDeck(ArrayList<String> deck) {this.deck = deck;}
    public static ArrayList<String> getDeck() {return deck;}

    public void shuffleCards() {
        Collections.shuffle(deck);
        System.out.println("        🎲 Cards are shuffled 🎲");
    }

    public void setCards() {
        for (int i = 0; i < cardnumber; i++) {
            String suit = suits[i / 13];
            String rank = ranks[i % 13];
            deck.add(suit + rank);
        }
    }

    public void Display() {
        for (String s : deck) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void cutCards() {
        int decksize = deck.size();
        int cutpoint = (int) (Math.random() * decksize);
        ArrayList<String> temp = new ArrayList<>(decksize);
        for (int i = 0; i < decksize; i++) {
            temp.add(deck.get((i + cutpoint) % decksize));
        }
        Collections.copy(deck, temp);
    }
}
