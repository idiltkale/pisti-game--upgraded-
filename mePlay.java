import java.util.ArrayList;

public class mePlay extends Players {
    private String onBoard;
    private Cards cd;
   // private ArrayList<String> cards = new ArrayList<>();
    private boolean bool2 = true;
    private ArrayList<String> myWins = new ArrayList<>();
    int i = 0;

    public mePlay(Cards cd, ArrayList<String> cards, String name) {
        super(cd, cards, name);
    }
    public void setCd(Cards cd) {this.cd = cd;}
    public Cards getCd() {return cd;}
    public boolean isBool2() {return bool2;}
    public void setBool2(boolean bool2) {this.bool2 = bool2;}
    public ArrayList<String> getMyWins() {return myWins;}
    public void setMyWins(ArrayList<String> myWins) {this.myWins = myWins;}
    public String getOnBoard() {return onBoard;}
    public void setOnBoard(String onBoard) {this.onBoard = onBoard;}

    public void PlayForMe(int choose){
        String cardNum = null;
        for (int i = 1; i < 5; i++) { //düzenle
            // System.out.println(getCards().size());
            if (choose == i) {
                cardNum = getCards().get(i - 1);
            }
        }
        play(cardNum);
    }
    @Override
    public void WhenIwin(String cardNum) {
        super.WhenIwin(cardNum);
    }
    @Override
    public void play(String cardNum) {
        super.play(cardNum);
    }
}


