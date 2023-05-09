import java.util.ArrayList;

public class Dealer {
    private Cards cards;
    boolean didDealBoard = true;
    private ArrayList<Players> players;
    public static int k = 0;

    public static boolean forEx;
    public Dealer(Cards cards, ArrayList<Players> players) {
        this.cards = cards;
        this.players = players;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public void dealCards() {
        if (didDealBoard) {
            for (int i = 0; i < 4; i++) {
                Players.Board.add(Cards.getDeck().remove(0));
            }
            didDealBoard = false;
        }
        int numCardsPerPlayer = getCards().getDeck().size() / cards.howmanyplayers;

        for (int k = 0; k <= numCardsPerPlayer; k = +0) {
            for (Players player : players) {
                for (int j = 0; j < 4; j++) {
                    //  player.getCards().getMycards().add(cards.getDeck().remove(0));
                    player.getCards().add(cards.getDeck().remove(0));
                }
            }
            k += 4;
            break;
        }
        forEx = true;
    }

    public void PrintOurcards() {
        int i = 1;
        for (Players player : players) {
            System.out.println(i + ". Player 🎮🎮");
            for (int k = 0; k < player.getCards().size(); k++) {
                System.out.println(k + 1 + ". Cards" + player.getCards().get(k));
            }
            System.out.println();
            i++;
        }
        System.out.println();
        for (int j = Players.Board.size() - 1; j >= 0; j--) {
            System.out.println("               " + Players.Board.get(j));
        }
    }
}
