import java.util.ArrayList;

public class Players {
    private ArrayList<String> cards;
    private ArrayList<String> inventory;
    private String name;
    public static ArrayList<String> Board;
    private String onBoard;
    private static boolean bool2 = true;

    public String getOnBoard() {return onBoard;}
    public void setOnBoard(String onBoard) {this.onBoard = onBoard;}public boolean isBool2() {return bool2;}public void setBool2(boolean bool2) {this.bool2 = bool2;}
    public ArrayList<String> list = new ArrayList<>();
    static {
        Board = new ArrayList<>();
    }
    public static ArrayList<String> getBoard() {return Board;}
    public static void setBoard(ArrayList<String> board) {Players.Board = board;}
    public ArrayList<String> getInventory() {return inventory;}
    public void setInventory(ArrayList<String> inventory) {this.inventory = inventory;}

    public void WhenWin(String cardNum) {
        Board.add(cardNum);
        getCards().remove(cardNum);
        int tempBoardSize = Board.size();
        System.out.println("Cards on the table  " +Board.size());
        for (int j = 0; j < Board.size(); j++) {
            getInventory().add(Board.get(j));
        }
        for (int j = 0; j < tempBoardSize; j++) {
            Board.remove(0);
        }
    }

    public void play(String cardNum) {

        int size = Board.size();
        if (size != 0) onBoard = Board.get(size - 1);
        System.out.println("ONBOARD     " + onBoard);

      //  for (int i = Board.size() - 1; i >= 0; i--) {
            if (bool2) {
                for (int j = 3; j >=0; j--) {
                    Counter.CountForComp(Board.get(j));
                }
            }
            bool2 = false;
         //   break;
        //}

        if (cardNum.charAt(2) == 'J') {
            System.out.println("          joker var");
            WhenWin(cardNum);
            if(ExpertBot.exbool==true) Counter.CountForComp(cardNum);
        } else if (onBoard != null && cardNum.charAt(2) == onBoard.charAt(2)) {
            if (Board.size() == 1) {
                System.out.println("PİŞTİ!! ");
                //  pişti sayacı ekle
                Board.remove(0);
                getCards().remove(cardNum);
            } else WhenWin(cardNum);
            if(ExpertBot.exbool==true) Counter.CountForComp(cardNum);

        } else {
            if (Board.size() == 0) {
                Board.add(cardNum);
            } else {
                for (int i = (Board.size() - 1); i >= 0; i--) {
                    if (Board.get(i) != null) {
                        Board.add(cardNum);
                        break;
                    }
                }
            }
            getCards().remove(cardNum);
            if(ExpertBot.exbool==true) Counter.CountForComp(cardNum);
        }
    }

    public Players(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public ArrayList<String> getCards() {
        return cards;
    }
    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
