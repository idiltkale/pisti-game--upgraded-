import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static boolean isThereHuman = false;
    public static int howmany = 0;
    public static int tours = 0;
    public static boolean verbose = false;

    public static void main(String[] args) {
        System.out.println("♡♡♡♡♡ welcome ♡♡♡♡♡♡ welcome ♡♡♡♡♡♡ welcome");
        args = new String[]{"4", "1", "points.txt", "turtle", "H", "mosquito", "R", "crocodile", "E", "camel", "N", "true"};
        Top10 top10 = new Top10();

        try {
            if (args.length < 8 || args.length != Integer.valueOf(args[0]) * 2 + 4) {
                System.out.println("invalid numbers");
                System.exit(1);
            }
            if (!(args[args.length - 1].equals("true") || args[args.length - 1].equals("false"))) {
                System.out.println("please enter true for verbose mode, ");
                System.exit(1);
            }
            if (Collections.frequency(List.of(args), "H") > 1) {
                System.out.println("there can be only 1 human player");
                System.exit(4);
            }
            if (Integer.valueOf(args[0]) < 2 || Integer.valueOf(args[0]) > 4) {
                System.out.println("There should be 2-4 players");
                System.exit(1);
            }
        } catch (NumberFormatException ex) {
            System.out.println("please enter an integer as number of players");
            System.exit(1);
        }

        howmany = Integer.valueOf(args[0]);
        tours = Integer.valueOf(args[1]);
        if (args[args.length - 1].equals("true")) {
            verbose = true;
        }
        ArrayList<Players> players = new ArrayList<>();
        ArrayList<NoviceBot> nbs = new ArrayList<>();
        ArrayList<RegularBot> rbs = new ArrayList<>();
        ArrayList<ExpertBot> exs = new ArrayList<>();
        mePlay mp = null;
        boolean bool = true;
        for (int i = 4; i < args.length; i++) {
            if (args[i].equals("H") && bool == true) {
                mp = new mePlay(args[i - 1]);
                players.add(mp);
                isThereHuman = true;
            } else if (args[i].equals("N")) {
                NoviceBot nb = new NoviceBot(args[i - 1]);
                nbs.add(nb);
                players.add(nb);

            } else if (args[i].equals("R")) {
                RegularBot rb = new RegularBot(args[i - 1]);
                rbs.add(rb);
                players.add(rb);
            } else if (args[i].equals("E")) {
                ExpertBot ex = new ExpertBot(args[i - 1]);
                exs.add(ex);
                players.add(ex);

            }
        }
        Game game = new Game(players, exs, rbs, nbs, mp);
        game.Start(players, exs, rbs, nbs, mp, verbose, args);
        int tempScore = 0;
        String tempName = "";
        for (int i = 0; i < players.size(); i++) {
            top10.scores.add(new Top10.Score(players.get(i).getName(), players.get(i).getScore()));
            if (players.get(i).getScore() > tempScore) {
                tempScore = players.get(i).getScore();
                tempName = players.get(i).getName();
            }
        }
        System.out.println("🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️");
        System.out.println("Congrulations !! ");
        System.out.println(tempName + " Won!! Score is " + tempScore);
        System.out.println("🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️");
        try {
            top10.ReadTextAndSort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println();
            System.out.println("🥇🥈🥉Here is TOP10🥇🥈🥉");
            top10.writeTop10();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}