import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Players{
    private String onBoard;
    // private ArrayList<String> cards = new ArrayList<>();
    private boolean bool2 = true;
    private ArrayList<String> myWins = new ArrayList<>();
    int i = 0;

    public NoviceBot(Cards cd, ArrayList<String> cards, String name) {
        super(cd, cards, name);
    }
    public boolean isBool2() {return bool2;}
    public void setBool2(boolean bool2) {this.bool2 = bool2;}
    public ArrayList<String> getMyWins() {return myWins;}
    public void setMyWins(ArrayList<String> myWins) {this.myWins = myWins;}
    public String getOnBoard() {return onBoard;}
    public void setOnBoard(String onBoard) {this.onBoard = onBoard;}
    public void PlayNoviceBot(){
        Random rd = new Random();

        int size = getCd().getBoard().size();
        System.out.println(size);
       if(size!=0) onBoard= getCd().getBoard().get(size-1);

        int random = rd.nextInt(3)+1;
        String cardNum = null;
        if(onBoard!=null){
            for (int i = 0; i < getCards().size(); i++) {
                if(getOnBoard().charAt(1)==getCards().get(i).charAt(1)){
                    cardNum= getCards().get(i);
                    break;
                }
                else if (random == i+1) {
                    cardNum = getCards().get(i);
                }
            }
        }
        else if (random == i) {
            cardNum = getCards().get(i - 1);
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
