import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Points {
    static boolean wildcardControl = false;
    static char wildcardSuit = 0;
    static int wildcardPoints = 0;
    static boolean cardControl = false;
    static char wildcardFace = 0;
    static int cardpoints = 0;
    boolean didGetPoints;
    int getTotalPointCards;

    public int getTotalPointCards(ArrayList<String> list) {

        int i = 0;
        getTotalPointCards = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("points.txt"))) {
            String line;
            while (i < list.size()) {
                didGetPoints = false;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        String card = parts[0];
                        int points = Integer.parseInt(parts[1]);
                        processCard(card, points);
                    }
                    String card = parts[0];
                    if (wildcardControl && wildcardSuit == list.get(i).charAt(0)) {
                        getTotalPointCards += processCard(list.get(i), wildcardPoints);
                        didGetPoints = true;
                        break;
                    } else if (cardControl && wildcardFace == list.get(i).charAt(1)) {
                        getTotalPointCards += processCard(list.get(i), cardpoints);
                        didGetPoints = true;
                        break;
                    } else if (!wildcardControl && !cardControl && list.get(i).equals(card)) {
                        int points = Integer.parseInt(parts[1]);
                        getTotalPointCards += processCard(list.get(i), points);
                        didGetPoints = true;
                        break;
                    }


                }
                if (didGetPoints == false) {
                    getTotalPointCards += processCard(list.get(i), 1);
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTotalPointCards;
    }


    public static int processCard(String card, int points) {
        char suit = card.charAt(0);
        char cardface = card.charAt(1);

        if (cardface == '*') {
            wildcardControl = true;
            wildcardSuit = suit;
            wildcardPoints = points;
        }
        if (suit == '*') {
            cardControl = true;
            wildcardFace = cardface;
            cardpoints = points;
        }

        int cardPoints;
        if (wildcardControl && wildcardSuit == card.charAt(0)) {
            cardPoints = wildcardPoints;
        }
        else if (cardControl && wildcardFace == card.charAt(1)) {
            cardPoints = cardpoints;
        } else {
            switch (suit) {
                case 'S':
                    cardPoints = points;
                    break;
                case 'C':
                    cardPoints = points;
                    break;
                case 'H':
                    cardPoints = points;
                    break;
                case 'D':
                    cardPoints = points;
                    break;
                default:
                    cardPoints = 1;
                    break;
            }
        }
        return cardPoints;
    }
}
