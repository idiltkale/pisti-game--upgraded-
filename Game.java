import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game(ArrayList<Players> players,ArrayList<ExpertBot> exs,ArrayList<RegularBot> rbs,ArrayList<NoviceBot> nbs,mePlay mp) {
    }
    public void print(Dealer dl, boolean verbose,mePlay mp){
        if(verbose==true) dl.PrintOurcards();
        else if(verbose==false) dl.PrintMyCards(mp);
    }

    public void Start(ArrayList<Players> players, ArrayList<ExpertBot> exs,ArrayList<RegularBot> rbs,ArrayList<NoviceBot> nbs,mePlay mp,boolean verbose,String[] args){
        Scanner sc = new Scanner(System.in);
        for(int k=0;k<Main.tours;k++){
            Cards cards = new Cards();
            Points pt = new Points();
            Dealer dl = new Dealer(cards,players);

            cards.shuffleCards();
            System.out.println("♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡");
            cards.cutCards();
            int choose = 0;
            dl.dealCards();
            print(dl,verbose,mp);

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
                    if(Main.isThereHuman==true) mp.PlayForMe(choose,args);
                    print(dl,verbose,mp);
                    for(int i=1;i<4;i++){
                        if(exs.size()>=i) {
                            exs.get(i-1).PlayExpertBot(args);
                            print(dl,verbose,mp);
                            System.out.println("♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡");
                        }
                        if(nbs.size()>=i){
                            nbs.get(i-1).PlayNoviceBot(args);
                            print(dl,verbose,mp);
                            System.out.println("♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡");
                        }
                        if(rbs.size()>=i) {
                            rbs.get(i-1).PlayRegularBot(args);
                            print(dl,verbose,mp);
                            System.out.println("♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡");
                        }
                    }
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

