public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cards cd = new Cards();
        Dealer dl = new Dealer();
       /* cd.Define();
        cd.Shuffle();
        cd.Display();*/
        cd.Define();
        cd.Shuffle();
        cd.Display();
        cd.Printer();
        dl.dealCards();
    }
}