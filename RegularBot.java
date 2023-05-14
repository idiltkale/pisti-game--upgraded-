import java.util.Random;

public class RegularBot extends Players implements Play {
    private String onBoard;
    int i = 0;

    public RegularBot(String name) {
        super(name + " Regular Bot");
    }
    @Override
    public String getOnBoard() {
        return onBoard;
    }
    @Override
    public void setOnBoard(String onBoard) {
        this.onBoard = onBoard;
    }

    public void PlayRegularBot(String [] args){
        Points pt = new Points();
        int score = pt.getTotalPointCards(Players.Board,args);
        System.out.println(getName() + " is playing... ");
        System.out.println();
        Random rd = new Random();
        int size = Board.size();
        if (size != 0) onBoard = Board.get(size - 1);
        else onBoard = null;
        int random = rd.nextInt(getCards().size()) + 1;
        String cardNum = null;

        if(score>0){
            for (int i = 0; i < getCards().size(); i++) {
                if (getOnBoard().charAt(1) == getCards().get(i).charAt(1)) {
                    cardNum = getCards().get(i);
                    break;
                }
                else if(getCards().get(i).charAt(1)== 'J'){
                    cardNum=getCards().get(i);
                }
                else if (random == i + 1) {
                    cardNum = getCards().get(i);

                }
            }
            play(cardNum,args);
        }
        else{
            for (int i = 0; i < getCards().size(); i++) {
                if(getCards().get(i).charAt(1)!='J'){
                    while(getCards().get(random-1).charAt(1)=='J' ){
                        random = rd.nextInt(getCards().size()) + 1;
                    }
                }
           }
            cardNum=getCards().get(random-1);
            play(cardNum,args);
        }

    }

    @Override
    public void play(int choose) {

    }
}
