import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cards {
    Scanner scanner = new Scanner(System.in);
    private static final String[] suits = {"♦️", "♥️", "♠️", "♣️"};
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private ArrayList<String> deck = new ArrayList<>();

    {
        System.out.println("How many players will be play🎮");
    }

    int howmanyplayers = scanner.nextInt();
    private static final int cardnumber = 52;

    //public Cards(ArrayList<Integer> deckk,String[] suits, String[]ranks, ArrayList<String> deck, ArrayList<String> mycards, ArrayList<String>cmpcards){
    public Cards() {
        setCards();
    }

    public String[] getSuits() {
        return suits;
    }

    public String[] getRanks() {
        return ranks;
    }

    public ArrayList<String> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
        System.out.println("            🎲 Cards are shuffled 🎲");
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
        int cutpoint = (int) (Math.random() * decksize); // randomly choose the cut point
        ArrayList<String> temp = new ArrayList<>(decksize);
        for (int i = 0; i < decksize; i++) {
            temp.add(deck.get((i + cutpoint) % decksize)); // shift the deck by cutpoint and wrap around
        }
        Collections.copy(deck, temp); // update the original deck with the cut cards
    }

    public void Printer() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }
    }
}
