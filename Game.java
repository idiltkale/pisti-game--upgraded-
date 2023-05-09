import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public String txt;
    public String name1;
    public String diff1;
    public String name2;
    public String diff2;
    public String name3;
    public String diff3;
    public String name4;
    public String diff4;
    public boolean bool;

    public Game(ArrayList<Players> players, ArrayList<ExpertBot> exs,ArrayList<NoviceBot> nbs,mePlay mp) {


    }

    public void Start(ArrayList<Players> players, ArrayList<ExpertBot> exs,ArrayList<NoviceBot> nbs,mePlay mp){



        Scanner sc = new Scanner(System.in);
        Cards cards = new Cards();

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

        while(Cards.getDeck()!=null) {
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
                exs.get(0).PlayExpertBot();
                dl.PrintOurcards();

            }
            System.out.println("                Cards are dealing🎲...");
            System.out.println("                        ♡");
            dl.dealCards();
            dl.PrintOurcards();
        }
        System.out.println("                 The game is over🔚❌");
    }
    }

