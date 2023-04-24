import java.util.ArrayList;

public abstract class Players {
    private String onBoard;
    private Cards cd;
    // private ArrayList<String> cards = new ArrayList<>();
    private boolean bool2 = true;
    private ArrayList<String> myWins = new ArrayList<>();
    int i = 0;
    private  ArrayList<String> cards;
    private String name;
    private static int whichBot;
    public ArrayList<String> list = new ArrayList<>();

    public Players(Cards cd,ArrayList<String> cards, String name) {
        this.cd=cd;
        this.cards = cards;
        this.name = name;
    }
    public ArrayList<String> getCards() {return cards;}
    public void setCards(ArrayList<String> cards) {this.cards = cards;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public static int getWhichBot() {return whichBot;}
    public static void setWhichBot(int whichBot) {Players.whichBot = whichBot;}
    public void setCd(Cards cd) {this.cd = cd;}
    public Cards getCd() {return cd;}
    public boolean isBool2() {return bool2;}
    public void setBool2(boolean bool2) {this.bool2 = bool2;}
    public ArrayList<String> getMyWins() {return myWins;}
    public void setMyWins(ArrayList<String> myWins) {this.myWins = myWins;}
    public String getOnBoard() {return onBoard;}
    public void setOnBoard(String onBoard) {this.onBoard = onBoard;}


    public void WhenIwin(String cardNum) {
        cd.getBoard().add(cardNum);
        getCards().remove(cardNum);
        // System.out.println(cd.getBoard().size());
        int tempGetBoard= cd.getBoard().size();
        for (int i = 0; i < cd.getBoard().size(); i++) {
            getMyWins().add(cd.getBoard().get(i));
        }
        for (int j = 0; j < tempGetBoard; j++) {
            cd.getBoard().remove(0);
        }
        //  System.out.println(cd.getBoard().size());
    }

    public void play(String cardNum) {

        if (onBoard == null) {
            onBoard = cardNum;
        }

        int size = cd.getBoard().size();
        if(size!=0)onBoard= cd.getBoard().get(size-1);

        for (int i = cd.getBoard().size() - 1; i >= 0; i--) {
            if (bool2 == true) {
                Counter.CountForComp(cd.getBoard().get(0));
                Counter.CountForComp(cd.getBoard().get(1));
                Counter.CountForComp(cd.getBoard().get(2));
                Counter.CountForComp(cd.getBoard().get(3));
            }
            bool2 = false;
            break;
        }

        if (cardNum.charAt(1) == 'J') {
          //  System.out.println("                  You have joker!!");
            WhenIwin(cardNum);
            //   Counter.CountForComp(cardNum);
        } else if (cardNum.charAt(1) == onBoard.charAt(1)) {
            if (cd.getBoard().size() == 1) {
               // System.out.println(" you just made  PİŞTİ!!!!PİŞTİ!!!!PİŞTİ!!!PİŞTİ!!!  ");
                //  mpisti++;
                cd.getBoard().remove(0);
            } else WhenIwin(cardNum);

             Counter.CountForComp(cardNum);
        } else {
            for (int i = (cd.getBoard().size() - 1); i >= 0; i--) {
                if (cd.getBoard().get(0) == null) {
                    cd.getBoard().set(0, cardNum);
                    break;
                }
                if (cd.getBoard().get(i) != null) {
                    cd.getBoard().add(cardNum);
                    break;
                }
            }
            getCards().remove(cardNum);
            Counter.CountForComp(cardNum);
        }
        int k = 3;
        int l = 0;
        for (int a = 0; a < getCards().size(); a++) {
            if (cardNum.equals(getCards().get(a))) {
                if (a != 3) {
                    for (int i = 0; i < k; i++) {
                        getCards().set(l, getCards().get(l + 1));
                        l++;
                    }
                }
                getCards().remove(3);
            }
            k--;
            l++;
        }
    }
}
