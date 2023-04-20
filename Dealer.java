public class Dealer {
    private Cards cards;
    public Dealer(){
        this.cards = cards;

    }
    public Cards getCards(){return cards;}
    public void setCards(Cards cards){this.cards=cards;}

    public void dealCards(){
        Cards cards = new Cards();
       /* cards.Define();
        cards.Shuffle();
        cards.Display();
        cards.Printer();*/
        for(int i=0;i<4;i++){
            cards.getMycards().add(cards.getDeck().get(0));
            cards.getDeck().remove(0);
            cards.getCmpcards().add(cards.getDeck().get(0));
            cards.getDeck().remove(0);
        }
        for(int i=0;i<4;i++){
            System.out.println("my cards: " + cards.getMycards().get(i));
           /* cards.getCmpcards().add(cards.getDeck().get(i));
            cards.getDeck().remove(i);
            System.out.println("cmpcards: " + cards.getCmpcards().get(i));*/
        }
        for(int i=0;i<4;i++){
            System.out.println("cmp cards: " + cards.getCmpcards().get(i));
        }
        cards.Printer();
    }
}
