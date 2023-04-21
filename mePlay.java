import java.util.ArrayList;

public class mePlay extends Players implements Play {
    private String onBoard;
    private Cards cd;
   // private ArrayList<String> cards = new ArrayList<>();
    private boolean bool2 = true;
    private ArrayList<String> myWins = new ArrayList<>();
    int i = 0;

    public mePlay(Cards cd, ArrayList<String> cards) {
        super(cards, "idil");
        this.cd = cd;
    }

    public void setCd(Cards cd) {
        this.cd = cd;
    }

    public Cards getCd() {
        return cd;
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }

    public ArrayList<String> getMyWins() {
        return myWins;
    }

    public void setMyWins(ArrayList<String> myWins) {
        this.myWins = myWins;
    }

    public String getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(String onBoard) {
        this.onBoard = onBoard;
    }


    public void WhenIwin(String cardNum) {
        cd.getBoard().add(cardNum);
        getCards().remove(cardNum);
        System.out.println(cd.getBoard().size());
        int a=0;
        for (int i = 0; i < cd.getBoard().size(); i++) {
            getMyWins().add(cd.getBoard().get(i));
            a++;
        }
        for (int j = 0; j < a; j++) {
            cd.getBoard().remove(0);
        }
        System.out.println(cd.getBoard().size());

    }

    @Override
    public void play(int choose) {
        for (int i = cd.getBoard().size() - 1; i >= 0; i--) {
            if (cd.getBoard().size() != 0) onBoard = cd.getBoard().get(i);
            if (bool2 == true) {
                //counter ekle
            }
            bool2 = false;
            break;
        }

        String cardNum = null;

        for (int i = 1; i < 5; i++) {
            System.out.println(getCards().size());
            if (choose == i) {
                cardNum = getCards().get(i - 1);
            }
        }

        if (onBoard == null) {
            onBoard = cardNum;
        }

        if (cardNum.charAt(1) == 'J') {
            System.out.println("                  You have joker!!");
            WhenIwin(cardNum);
            //   Counter.CountForComp(cardNum);
        } else if (cardNum.charAt(1) == onBoard.charAt(1)) {
            if (cd.getBoard().size() == 1) {
                System.out.println(" you just made  PİŞTİ!!!!PİŞTİ!!!!PİŞTİ!!!PİŞTİ!!!  ");
                //  mpisti++;
                cd.getBoard().remove(0);
            } else WhenIwin(cardNum);

            //  Counter.CountForComp(cardNum);
        } else {
            for (int i = (cd.getBoard().size() - 1); i >= 0; i--) {
                if (cd.getBoard().get(0) == null) {
                    cd.getBoard().set(0, cardNum);
                    break;
                }
                if (cd.getBoard().get(i) != null) {
                    cd.getBoard().add(cardNum);
                    break;
                }
            }
            getCards().remove(cardNum);
            // Counter.CountForComp(cardNum);
        }
        int k = 3;
        int l = 0;
        for (int a = 0; a < cd.getMycards().size(); a++) {
            if (cardNum.equals(cd.getMycards().get(a))) {
                if (a != 3) {
                    for (int i = 0; i < k; i++) {
                        cd.getMycards().set(l, cd.getMycards().get(l + 1));
                        l++;
                    }
                }
                cd.getMycards().remove(3);
            }
            k--;
            l++;

        }
    }
}


