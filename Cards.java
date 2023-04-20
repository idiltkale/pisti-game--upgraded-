import java.util.ArrayList;
import java.util.Collections;

public class Cards {

   private static String[] suits = { "♦", "♥", "♠", "♣" };
   private static String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
   private ArrayList<Integer> deckk = new ArrayList<Integer>();
   private ArrayList<String> deck = new ArrayList<>();
   private ArrayList<String> mycards = new ArrayList<>();
   private ArrayList<String> cmpcards = new ArrayList<>();
   private ArrayList<String> board = new ArrayList<>();

   //public Cards(ArrayList<Integer> deckk,String[] suits, String[]ranks, ArrayList<String> deck, ArrayList<String> mycards, ArrayList<String>cmpcards){
   public Cards(){
      this.suits=suits;
      this.deckk=deckk;
      this.ranks = ranks;
      this.deck = deck;
      this.mycards=mycards;
      this.cmpcards=cmpcards;
   }

   public ArrayList<String> getBoard() {return board;}
   public void setBoard(ArrayList<String> board) {this.board = board;}
   public String[] getSuits(){return suits;}
   public String[] getRanks(){return ranks;}
   public ArrayList<String> getDeck(){return deck;}
   public ArrayList<String> getMycards(){return mycards;}
   public ArrayList<String> getCmpcards(){return cmpcards;}
   public void setSuits(String[] suits){this.suits=suits;}
   public void setDeck(ArrayList<String> deck){this.deck=deck;}
   public static void setRanks(String[] ranks) {Cards.ranks = ranks;}
   public void setMycards(ArrayList<String> mycards) {this.mycards = mycards;}
   public void setCmpcards(ArrayList<String> cmpcards) {this.cmpcards = cmpcards;}
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
   public void PrintOurCards() {
      System.out.println();
      for (int i = 0; i < 4; i++) {
         System.out.println("              your " + (i + 1) + ". " + "card: " + mycards.get(i));
      }
      for (int i = 0; i < 4; i++) {
         System.out.println("              computer's " + (i + 1) + ". " + "card: " + cmpcards.get(i));

      }
      System.out.println();

      for (int i = 51; i >= 0; i--) {
         System.out.println("                      "+ board.get(i));
      }
      System.out.println("        ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡");
   }
   public void Printer(){
      for(int i=0; i<deck.size();i++){
         System.out.println(deck.get(i));
      }
   }
}
