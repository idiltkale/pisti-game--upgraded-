import java.util.Random;

public class ExpertBot extends Players {
    private String onBoard;
    public static boolean exbool = true;
    private String name;

    public ExpertBot(String name) {
        super();
        this.name=name;
    }
    @Override public String getOnBoard() {return onBoard;}
    @Override public void setOnBoard(String onBoard) {this.onBoard = onBoard;}
    public void PlayExpertBot() {
        System.out.println(name + " (expert) is playing... ");
        NoviceBot nb;
        Random rd = new Random();
        boolean bool = true;

        int size = Board.size();
        if(size!=0) onBoard= Board.get(size-1);
        else onBoard=null;
        /* if(Dealer.forEx==true){

            for(int i=0;i<getCards().size();i++){
                counter.CountForComp(getCards().get(i));
                System.out.println(name + "KARTLARIM SAYILDI");
            }
            if(name.equals(first)) Dealer.forEx=false;
        }*/
        int random = rd.nextInt(getCards().size())+1;
        String cardNum = null;
        if(onBoard!=null) {
            for (int i = 0; i < getCards().size(); i++) {
                if (getOnBoard().charAt(2) == getCards().get(i).charAt(2)) {
                    cardNum = getCards().get(i);
                    bool = false;
                    System.out.println("     UYUŞTU  ");
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
                    System.out.println("     COUNTERLADI  ");
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
                System.out.println("     RANDOMLADI  ");
                play(cardNum);
            }
        }
    }
    @Override
    public void WhenWin(String cardNum) {
      super.WhenWin(cardNum);
        System.out.println("            computer took all the cards");
    }
    @Override
    public void play(String cardNum) {
        exbool =false;
        super.play(cardNum);
        exbool = true;
    }
}