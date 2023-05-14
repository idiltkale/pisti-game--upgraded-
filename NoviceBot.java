import java.util.Random;

public class NoviceBot extends Players {
    private String onBoard;
    int i = 0;

    public NoviceBot(String name) {
        super(name+" Novice Bot");
    }
    @Override
    public String getOnBoard() {
        return onBoard;
    }
    @Override
    public void setOnBoard(String onBoard) {
        this.onBoard = onBoard;
    }
    public void PlayNoviceBot(String [] args) {
        System.out.println( getName()+ " is playing... ");
        System.out.println();
        Random rd = new Random();
        int size = Board.size();
        if (size != 0) onBoard = Board.get(size - 1);
        else onBoard = null;

        int random = rd.nextInt(getCards().size()) + 1;
        String cardNum = null;
        if (onBoard != null) {
            for (int i = 0; i < getCards().size(); i++) {
                if (getOnBoard().charAt(1) == getCards().get(i).charAt(1)) {
                    cardNum = getCards().get(i);
                    break;
                } else if (random == i + 1) {
                    cardNum = getCards().get(i);
                }
            }
        } else {
            cardNum = getCards().get(random - 1);
        }
        play(cardNum,args);
    }
    @Override
    public void WhenWin(String cardNum,boolean misti,String [] args) {
        super.WhenWin(cardNum,misti,args);
    }

    @Override
    public void play(String cardNum,String [] args) {
        super.play(cardNum,args);
    }
}
