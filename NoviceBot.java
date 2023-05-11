import java.util.Random;

public class NoviceBot extends Players {
    private String onBoard;
    private String name;
    int i = 0;

    public NoviceBot(String name) {
        super();
        this.name=name;
    }
    @Override
    public String getOnBoard() {
        return onBoard;
    }
    @Override
    public void setOnBoard(String onBoard) {
        this.onBoard = onBoard;
    }
    public void PlayNoviceBot() {
        System.out.println(name + " (novice) is playing... ");
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
        play(cardNum);
    }
    @Override
    public void WhenWin(String cardNum) {
        super.WhenWin(cardNum);
    }

    @Override
    public void play(String cardNum) {
        super.play(cardNum);
    }
}
