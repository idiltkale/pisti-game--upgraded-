import java.util.ArrayList;

public class Main {
    public static boolean isThereHuman=false;
   public static int howmany =0;
    public static void main(String[] args) {

        args = new String[]{"4", "idil.txt","Kadir","H","idil","E","burak","E","Cem","N","true"};

         howmany= Integer.valueOf(args[0]);

        ArrayList<Players> players = new ArrayList<>();
        ArrayList<NoviceBot> nbs = new ArrayList<>();
       // ArrayList<RegularBot> rbs = new ArrayList<>();
        ArrayList<ExpertBot> exs = new ArrayList<>();
        mePlay mp = null;
        boolean bool =true;
        for(int i=3;i< args.length;i++){
            if (args[i].equals("H") && bool==true) {
               mp = new mePlay(args[i-1]);
               players.add(mp);
               isThereHuman=true;
            }
            else if(args[i].equals("N")){
                NoviceBot nb = new NoviceBot(args[i-1]);
                nbs.add(nb);
                players.add(nb);

            }
           /* else if(args[3].equals("R")){
                RegularBot ex = new ExpertBot();
                players.add(ex);
            }*/
            else if(args[i].equals("E")){
                ExpertBot ex = new ExpertBot(args[i-1]);
                exs.add(ex);
                players.add(ex);
            }
        }
          Game game = new Game(players,exs,nbs,mp);
        game.Start(players,exs,nbs,mp);
    }
}