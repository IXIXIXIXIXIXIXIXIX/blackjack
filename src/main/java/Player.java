import java.util.ArrayList;
import java.util.Collection;

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
        boolean containsAce = false;

        for(Card card : this.playerHand) {
            total += card.getValueFromEnum();
            if (card.getRank() == RankType.ACE)
            {
                containsAce = true;
            }
        }

        // If there is an ace that can be scored 11, do so
        if (total < 12 && containsAce)
        {
            total += 10;
        }
        return total;
    }

    public Card removeCardFromHand() {
        return this.playerHand.remove(0);
    }

    public boolean isBust() {
        return !(this.getScore() <= 21);
    }

    public Card getCard(int index){
        return this.playerHand.get(index);
    }

    public ArrayList<Card> getHand() {
        return this.playerHand;
    }
}
