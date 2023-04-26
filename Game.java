import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public void Start(){
        Scanner sc = new Scanner(System.in);
        Cards cards = new Cards();
        ArrayList<Players> players = new ArrayList<>();
        mePlay mp = new mePlay("burakfitness");
        NoviceBot nb = new NoviceBot();
        ExpertBot ex = new ExpertBot();
        mePlay mp2 = new mePlay("lala");

        players.add(mp);
        players.add(ex);
        Dealer dl = new Dealer(cards,players);
        cards.Printer();
        System.out.println("************");
        cards.shuffleCards();
        cards.Display();
        cards.cutCards();
        //cards.Printer();
        System.out.println("************");
        int choose;
        dl.dealCards();
        dl.PrintOurcards();
        //cards.Printer();

        for (int i = 0; i < 6; i++) {
            for (int a = 0; a < 4; a++) {
                while (true) {
                    System.out.print("The card you choose👉 :");
                    try {
                        choose = sc.nextInt();
                        if (choose > 4 || choose < 0) {
                            System.out.println("Out of index❌");
                            continue;
                        }
                        if (mp.getCards().get(choose-1) == null) {
                            System.out.println("Please choose another card 😥");
                            continue;
                        }

                        break;
                    } catch (Exception e) {
                        System.out.println("Please choose a card between 1-4🔢");
                        sc.nextLine();
                    }

                }

                mp.PlayForMe(choose);
                dl.PrintOurcards();
                Counter.printcounter();
                ex.PlayExpertBot();
                dl.PrintOurcards();

            }
            if (i != 5) {
                System.out.println("                Cards are dealing🎲...");
                System.out.println("                        ♡");
                dl.dealCards();
                dl.PrintOurcards();
            } else System.out.println("                 The game is over🔚❌");
        }

    }
    }

