import java.util.ArrayList;

public class Dealer {
    private Cards cards;
    boolean didDealBoard = true;
    private ArrayList<Players> players;
    public static int k = 0;
    private int howmanyplayers = Main.howmany;
    int numCardsPerPlayer = getCards().getDeck().size() / howmanyplayers;
    int numberofrounds = numCardsPerPlayer / howmanyplayers;

    public static boolean forEx = true;
    public Dealer(Cards cards, ArrayList<Players> players) {
        this.cards = cards;
        this.players = players;
    }
    public Cards getCards() {return cards;}
    public void setCards(Cards cards) {this.cards = cards;}

    public void dealCards() {
        if (didDealBoard) {
            for (int i = 0; i < 4; i++) {
                Players.Board.add(cards.getDeck().remove(0));
            }
            didDealBoard = false;
        }
        for (int k = 0; k <= numberofrounds; k ++) {
            for(int i = 0 ; i<4 ; i++) {
                for (Players player : players) {
                    player.getCards().add(cards.getDeck().remove(0));
                }
            }
            break;
        }
        forEx=true;
    }
    public void PrintOurcards() {
        int i = 1;
        for (Players player : players) {
            System.out.print("♡ " + player.getName() + "'s cards:  ♡   ");
            System.out.println("score: "+ player.getScore());
            for (int k = 0; k < player.getCards().size(); k++) {
                System.out.print(" "+player.getCards().get(k) + " ");
            }
            System.out.println();
            System.out.println();
            i++;
        }
        System.out.println();
        for (int j = Players.Board.size() - 1; j >= 0; j--) {
            System.out.println("               " + Players.Board.get(j));
        }
    }
    public void PrintMyCards(mePlay mp){
        System.out.print("♡ " + mp.getName() + "'s cards:  ♡   ");
        System.out.println("score: "+ mp.getScore());
        for (int k = 0; k < mp.getCards().size(); k++) {
            System.out.print(" "+ mp.getCards().get(k) + " ");
        }
        System.out.println();
        System.out.println();
        for (int j = Players.Board.size() - 1; j >= 0; j--) {
            System.out.println("               " + Players.Board.get(j));
        }
    }
}