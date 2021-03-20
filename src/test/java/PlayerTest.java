import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;
    private Card card;
    private Card tenSpades;
    private Card tenDiamonds;
    private Card twoDiamonds;

    @Before
    public void before() {
        player1 = new Player("Laureline");
        card = new Card(SuitType.SPADES, RankType.ACE);
        tenSpades = new Card(SuitType.SPADES, RankType.TEN);
        tenDiamonds = new Card(SuitType.DIAMONDS, RankType.TEN);
        twoDiamonds = new Card(SuitType.DIAMONDS, RankType.TWO);

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
        assertEquals(11, player1.getScore());
    }

    @Test
    public void canRemoveCardFromHand() {
        player1.addCardToHand(card);
        player1.removeCardFromHand();

        assertEquals(0, player1.getHandSize());
    }

    @Test
    public void canCheckNotBust(){
        player1.addCardToHand(tenDiamonds);
        player1.addCardToHand(tenSpades);
        player1.addCardToHand(card);

        assertEquals(false, player1.isBust());
    }

    @Test
    public void canCheckIsBust(){
        player1.addCardToHand(tenDiamonds);
        player1.addCardToHand(tenSpades);
        player1.addCardToHand(twoDiamonds);

        assertEquals(true, player1.isBust());
    }

    @Test
    public void canGetPlayerHand() {
        player1.addCardToHand(card);
        player1.addCardToHand(tenSpades);

        assertEquals(2, player1.getHand().size());
    }

}
