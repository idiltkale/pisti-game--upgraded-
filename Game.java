import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game(ArrayList<Players> players,ArrayList<ExpertBot> exs,ArrayList<RegularBot> rbs,ArrayList<NoviceBot> nbs,mePlay mp) {
    }
    public void print(Dealer dl, boolean verbose,mePlay mp){
        if(verbose==true) dl.PrintOurcards();
        else if(verbose==false) dl.PrintMyCards(mp);
    }

    public void Start(ArrayList<Players> players, ArrayList<ExpertBot> exs,ArrayList<RegularBot> rbs,ArrayList<NoviceBot> nbs,mePlay mp,boolean verbose){
        Scanner sc = new Scanner(System.in);

        for(int k=0;k<Main.tours;k++){
            Cards cards = new Cards();
            Points pt = new Points();
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
            print(dl,verbose,mp);
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
                    print(dl,verbose,mp);
                    Counter.printcounter();
                    for(int i=1;i<4;i++){
                        if(exs.size()>=i) {
                            exs.get(i-1).PlayExpertBot();
                            print(dl,verbose,mp);
                        }
                        if(nbs.size()>=i){
                            nbs.get(i-1).PlayNoviceBot();
                            print(dl,verbose,mp);
                        }
                        if(rbs.size()>=i) {
                            int puan = pt.getTotalPointCards(Players.Board);
                            System.out.println("PUAN     " + puan);
                            rbs.get(i-1).PlayRegularBot();
                            print(dl,verbose,mp);
                        }
                    }
                    Counter.printcounter();
                }
                if(Cards.getDeck().size()!=0) {
                    System.out.println("                Cards are dealing🎲...");
                    System.out.println("                        ♡");
                    dl.dealCards();
                    print(dl,verbose,mp);
                }
                else break;
            }
            System.out.println("                 The game is over🔚");
        }
    }
    }

