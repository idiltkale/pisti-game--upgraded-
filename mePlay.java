public class mePlay extends Players {
    // private ArrayList<String> cards = new ArrayList<>();
    private boolean bool2 = true;
    int i = 0;

    public mePlay(String name) {
        super();
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }


    public void PlayForMe(int choose) {
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
    public void WhenWin(String cardNum) {
        super.WhenWin(cardNum);
    }

    @Override
    public void play(String cardNum) {
        super.play(cardNum);
    }
}


