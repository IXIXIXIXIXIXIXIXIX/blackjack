import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Card card;

    @Before
    public void before() {
        player1 = new Player("Laureline");
        card = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void hasName() {
        assertEquals("Laureline", player1.getName());
    }

    @Test
    public void playerHandStartsEmpty() {
        assertEquals(0, player1.getHandSize());
    }

    @Test
    public void canAddCardToHand() {
        player1.addCardToHand(card);
        assertEquals(1, player1.getHandSize());
    }

    @Test
    public void canGetScore() {
        player1.addCardToHand(card);
        assertEquals(1, player1.getScore());
    }

    @Test
    public void canRemoveCardFromHand() {
        player1.addCardToHand(card);
        player1.removeCardFromHand();

        assertEquals(0, player1.getHandSize());
    }

}
