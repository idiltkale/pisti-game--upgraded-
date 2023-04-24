import java.util.ArrayList;
import java.util.Random;

public class ExpertBot extends Players {
    public ExpertBot(Cards cd, ArrayList<String> cards, String name) {
        super(cd, cards, name);
    }

    public void PlayExpertBot(int index,String cardNum) {
        Random rd = new Random();
        for(int i=0; i< getCards().size();i++) {
            String s = Counter.CheckCounts(getCards().get(i));
            if (s != null){
                cardNum = s;
            }
            else {
                cardNum = null;
            }
        }
        if(cardNum==null) {
            String[] cmprandom = { getCards().get(0), getCards().get(1), getCards().get(2), getCards().get(3)};
            index = rd.nextInt(cmprandom.length);
            cardNum = cmprandom[index];
            while ((cardNum == null) || (cardNum.charAt(1) == 'J')) {
                index = rd.nextInt(cmprandom.length);
                cardNum = cmprandom[index];
            }
        }
        Counter.PlayThisCard=null;
        play(cardNum);
    }
    @Override
    public void WhenIwin(String cardNum) {
      /* super.WhenIwin(cardNum);
        System.out.println("            computer took all the cards");
        for (int k = (board.length - 1); k >= 0; k--) {
            if (board[k] != null) {
                board[k + 1] = cardNum;
                break;
            }
        }
        for(int y=0;y<cmpWins.length;y++) {
            if(cmpWins[y]==null&&board[i]!=null) {
                cmpWins[y]=board[i];
                if(i!=52) {
                    board[i]=null;
                    i++;
                }
                else{
                    i++;
                    break;
                }
            }
            else i=0;
        }*/
    }

    @Override
    public void play(String cardNum) {
        super.play(cardNum);
    }
}
