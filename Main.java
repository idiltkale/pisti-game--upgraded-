import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cards cd = new Cards();

        ArrayList<Players> players = new ArrayList<>();
        ArrayList<String> card = new ArrayList<>();
        ArrayList<String> card2 = new ArrayList<>();
        ArrayList<String> card3 = new ArrayList<>();
        ArrayList<String> card4 = new ArrayList<>();
        mePlay mp = new mePlay(cd,card2,"idil");
        NoviceBot nb = new NoviceBot(cd,card,"kadir");

        players.add(mp);
        players.add(nb);
       // players.add(new NoviceBot(cd,card3,"burak"));
       // players.add(new NoviceBot(card4));
        Dealer dl = new Dealer(cd,players);
        cd.Define();
        cd.Printer();
        System.out.println("************");
        cd.Shuffle();
        cd.Display();
      //  cd.Printer();
        System.out.println("************");
        dl.dealCards();
        dl.PrintOurcards();
      //  cd.Printer();
        int choose = scanner.nextInt();
        mp.PlayForMe(choose);
        dl.PrintOurcards();
        nb.PlayNoviceBot();
        dl.PrintOurcards();

    }
}