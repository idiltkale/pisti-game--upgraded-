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
        mePlay mp = new mePlay(cd,card2);
        players.add(new mePlay(cd,card2));
        players.add(new NoviceBot(card));
        //players.add(new NoviceBot(card2));
        Dealer dl = new Dealer(cd,players);
       // mePlay mp = new mePlay("BurakİdilKadir");
       /* cd.Define();
        cd.Shuffle();
        cd.Display();*/
        cd.Define();
        cd.Printer();
        System.out.println("************");
        cd.Shuffle();
        cd.Display();
        cd.Printer();
        System.out.println("************");
        dl.dealCards();
        dl.PrintOurcards();
        cd.Printer();
        int a = scanner.nextInt();
        mp.play(a);
        dl.PrintOurcards();
    }
}