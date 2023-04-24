import java.util.ArrayList;

public class Dealer {
    private Cards cards;

    boolean didDealBoard = true;
    private ArrayList<Players> players;
    public static int k = 0;

    public Dealer(Cards cards,ArrayList<Players> players) {
        this.cards = cards;
        this.players = players;
    }
    public Cards getCards() {return cards;}
    public void setCards(Cards cards) {this.cards = cards;}

    public void dealCards() {
        if (didDealBoard) {
            for (int i = 0; i < 4; i++) {
                cards.getBoard().add( cards.getDeck().remove(0));
            }
            didDealBoard = false;
        }
        int numCardsPerPlayer = getCards().getDeck().size() / cards.howmanyplayers;


            for (int k = 0; k <= numCardsPerPlayer; k++) {
                for (Players player : players) {
                    for (int j = 0; j < 4; j++) {
                      //  player.getCards().getMycards().add(cards.getDeck().remove(0));
                        player.getCards().add(cards.getDeck().remove(0));

                    }

                }
                k += 4;
                break;
            }
    }
    public void PrintOurcards(){
        int i=1;
        for(Players s: players){
            for(int k=0;k<s.getCards().size();k++){
                System.out.println( i+". players cards: " + s.getCards().get(k));
            }
            System.out.println();
            i++;
        }
        System.out.println();
        for (int j = cards.getBoard().size()-1; j >= 0; j--) {
            System.out.println("                      "+ cards.getBoard().get(j));
            //break;

        }
    }
}
