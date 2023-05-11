import java.util.ArrayList;
import java.util.Scanner;

public class Game {
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
        int choose = 0;
        dl.dealCards();
        dl.PrintOurcards();
        //cards.Printer();

        while(true) {
            for (int a = 0; a < 4; a++) {
                while (true&& Main.isThereHuman==true) {
                    System.out.print("The card you choose :");
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
                if(Main.isThereHuman==true) mp.PlayForMe(choose);
                dl.PrintOurcards();
                Counter.printcounter();
                for(int i=1;i<4;i++){
                    if(exs.size()>=i) {
                        exs.get(i-1).PlayExpertBot();
                        dl.PrintOurcards();
                        Counter.printcounter();
                    }
                    if(nbs.size()>=i){
                        nbs.get(i-1).PlayNoviceBot();
                        dl.PrintOurcards();
                        Counter.printcounter();
                    }
                   // if(nbs.size()>=i) exs.get(i-1).PlayExpertBot();
                }
            }
            if(Cards.getDeck().size()!=0) {
                System.out.println("                Cards are dealing🎲...");
                System.out.println("                        ♡");
                dl.dealCards();
                dl.PrintOurcards();
            }
            else break;
        }
        System.out.println("                 The game is over🔚");
    }
    }

