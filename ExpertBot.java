import java.util.Random;

public class ExpertBot extends Players {
    private String onBoard;
    public static boolean exbool = true;

    public ExpertBot(String name) {
        super(name);
    }
    @Override public String getOnBoard() {return onBoard;}
    @Override public void setOnBoard(String onBoard) {this.onBoard = onBoard;}
    public void PlayExpertBot() {
        System.out.println(getName() + " (expert) is playing... ");
        System.out.println();
        NoviceBot nb;
        Random rd = new Random();
        boolean bool = true;

        int size = Board.size();
        if(size!=0) onBoard= Board.get(size-1);
        else onBoard=null;
        int random = rd.nextInt(getCards().size())+1;
        String cardNum = null;
        if(onBoard!=null) {
            for (int i = 0; i < getCards().size(); i++) {
                if (getOnBoard().charAt(1) == getCards().get(i).charAt(1)) {
                    cardNum = getCards().get(i);
                    bool = false;
                    play(cardNum);
                    break;
                }
            }
        }
        if(bool==true){
            for(int k=0; k< getCards().size();k++) {
                String s = Counter.CheckCounts(getCards());
                if (s != null){
                    cardNum = s;
                    play(cardNum);
                    break;
                }
                else {
                    cardNum = null;
                }
            }
            Counter.play=null;
            if(cardNum==null) {
                cardNum = getCards().get(random - 1);
                play(cardNum);
            }
        }
    }
    @Override
    public void WhenWin(String cardNum,boolean misti) {
      super.WhenWin(cardNum,misti);
        System.out.println("            computer took all the cards");
    }
    @Override
    public void play(String cardNum) {
        exbool =false;
        super.play(cardNum);
        exbool = true;
    }
}