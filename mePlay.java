public class mePlay extends Players {
    private boolean bool2 = true;
    int i = 0;

    public mePlay(String name) {
        super(name);
    }
    public boolean isBool2() {return bool2;}
    public void setBool2(boolean bool2) {this.bool2 = bool2;}

    public void PlayForMe(int choose,String [] args) {
        String cardNum = null;
        for (int i = 1; i < 5; i++) {
            if (choose == i) {
                cardNum = getCards().get(i - 1);
            }
        }
        play(cardNum,args);
    }
    @Override
    public void WhenWin(String cardNum,boolean misti,String [] args) {
        super.WhenWin(cardNum,misti,args);
    }

    @Override
    public void play(String cardNum,String[] args) {
        super.play(cardNum,args);
    }
}


