import java.util.ArrayList;

public abstract class Players {
    private ArrayList<String> cards;
    private ArrayList<String> inventory;
    private ArrayList<String> MistiInventory;
    private int score;
    private String name;
    public static ArrayList<String> Board;
    private String onBoard;
    private static boolean bool2 = true;
    public Points pt = new Points();
    public boolean misti;
    public Players(String name) {
        this.cards = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.MistiInventory=new ArrayList<>();
        this.name=name;
    }

    public ArrayList<String> getMistiInventory() {return MistiInventory;}
    public void setMistiInventory(ArrayList<String> mistiInventory) {MistiInventory = mistiInventory;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    public String getOnBoard() {return onBoard;}
    public void setOnBoard(String onBoard) {this.onBoard = onBoard;}
    public boolean isBool2() {return bool2;}public void setBool2(boolean bool2) {this.bool2 = bool2;}
    public ArrayList<String> list = new ArrayList<>();
    static {Board = new ArrayList<>();}
    public static ArrayList<String> getBoard() {return Board;}
    public static void setBoard(ArrayList<String> board) {Players.Board = board;}
    public ArrayList<String> getInventory() {return inventory;}
    public void setInventory(ArrayList<String> inventory) {this.inventory = inventory;}
    public  ArrayList<String> getCards() {return cards;}
    public void setCards(ArrayList<String> cards) {this.cards = cards;}

    public void WhenWin(String cardNum, boolean misti,String[] args) {
        Board.add(cardNum);
        getCards().remove(cardNum);
        int tempBoardSize = Board.size();
        if(misti==false){
            for (int j = 0; j < Board.size(); j++) {
                getInventory().add(Board.get(j));
            }
        }
        if(misti==true){
            for (int j = 0; j < Board.size(); j++) {
                getMistiInventory().add(Board.get(j));
            }
        }
        for (int j = 0; j < tempBoardSize; j++) {
            Board.remove(0);
        }
        score = pt.getTotalPointCards(getInventory(),args) + (pt.getTotalPointCards(getMistiInventory(),args)*5);
    }
    public void play(String cardNum,String[] args) {
        int size = Board.size();
        if (size != 0) onBoard = Board.get(size - 1);

      //  for (int i = Board.size() - 1; i >= 0; i--) {
            if (bool2) {
                for (int j = 3; j >=0; j--) {
                    Counter.CountForComp(Board.get(j));
                }
            }
            bool2 = false;
         //   break;
        //}

        if (cardNum.charAt(1) == 'J') {
            System.out.println("     joker  !!!");
            WhenWin(cardNum,false,args);
                Counter.CountForComp(cardNum);
        } else if (onBoard != null && cardNum.charAt(1) == onBoard.charAt(1)) {
            if (Board.size() == 1) {
                System.out.println("  PİŞTİ  !! ");
                WhenWin(cardNum,true,args);
                //  pişti sayacı ekle
            } else WhenWin(cardNum,false,args);
             Counter.CountForComp(cardNum);

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
           // if(ExpertBot.exbool==true)
                Counter.CountForComp(cardNum);
        }
    }

}
