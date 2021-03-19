import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> playerHand;

    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<Card>();
    }


    public String getName() {
        return this.name;
    }

    public int getHandSize() {
        return this.playerHand.size();
    }

    public void addCardToHand(Card card) {
        this.playerHand.add(card);
    }

    public int getScore() {
        int total = 0;
        for(Card card : this.playerHand) {
            total += card.getValueFromEnum();
        }
        return total;
    }

    public Card removeCardFromHand() {
        return this.playerHand.remove(0);
    }

}
