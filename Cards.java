import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cards {
   Scanner scanner = new Scanner(System.in);

   private static String[] suits = { "♦", "♥", "♠", "♣" };
   private static String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
   private ArrayList<Integer> deckk = new ArrayList<Integer>();
   private ArrayList<String> deck = new ArrayList<>();
   private ArrayList<String> board = new ArrayList<>();
   int howmanyplayers = scanner.nextInt();

   //public Cards(ArrayList<Integer> deckk,String[] suits, String[]ranks, ArrayList<String> deck, ArrayList<String> mycards, ArrayList<String>cmpcards){
   public Cards(){
      this.suits=suits;
      this.deckk=deckk;
      this.ranks = ranks;
      this.deck = deck;
   }

   public ArrayList<String> getBoard() {return board;}
   public void setBoard(ArrayList<String> board) {this.board = board;}
   public String[] getSuits(){return suits;}
   public String[] getRanks(){return ranks;}
   public ArrayList<String> getDeck(){return deck;}
   public void setSuits(String[] suits){this.suits=suits;}
   public void setDeck(ArrayList<String> deck){this.deck=deck;}
   public static void setRanks(String[] ranks) {Cards.ranks = ranks;}
   public ArrayList<Integer> getDeckk() {return deckk;}
   public void setDeckk(ArrayList<Integer> deckk) {this.deckk = deckk;}
   public void Define(){
      for(int i =0; i<52; i++){
         deckk.add(i);
      }
   }

   public void Shuffle() {
      Collections.shuffle(deckk);
      System.out.println("            ♡ Cards are shuffled ♡");
   }

   public void Display() {
      for (int i = 0; i < deckk.size(); i++) {
         String suit = suits[deckk.get(i) / 13];
         String rank = ranks[deckk.get(i) % 13];
         deck.add(suit+rank+suit);
         deck.set(i,suit+rank+suit);
      }
      System.out.println();
      /*for(int i=0; i<deck.size();i++){
         System.out.println(deck.get(i));
      }*/
   }
   public void Printer(){
      for(int i=0; i<deck.size();i++){
         System.out.println(deck.get(i));
      }
   }
   public void PrintDeck(){
      for (int i = 0; i < deck.size(); i++) {
         System.out.println(deck.get(i));
      }
   }
}
