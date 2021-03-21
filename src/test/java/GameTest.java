import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;

    Player player1;
    Player player2;

    Deck deck;

    Card card;
    Card card2;

    @Before
    public void before() {
        player1 = new Player("Laureline");
        player2 = new Player("Scott");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        deck = new Deck();
        game = new Game(players);
        card = new Card(SuitType.SPADES, RankType.ACE);
        card2 = new Card(SuitType.SPADES, RankType.NINE);
    }

    @Test
    public void canCountPlayers() {
        assertEquals(3, game.playerCount());
    }

    @Test
    public void canDeal() {
        game.deal(player1);
        assertEquals(1, player1.getHandSize());
    }

    @Test
    public void dealToAllPlayers() {
        game.dealToAllPlayers(3);
        assertEquals(3, player1.getHandSize());
        assertEquals(3, player2.getHandSize());
    }

    @Test
    public void canGetDealerScore(){
        game.dealToAllPlayers(1);
        int dealerScore = game.getDealerScore();
        assertEquals(true, dealerScore > 0);
    }



    @Test
    public void canCheckWinner() {
        game.getDealer().addCardToHand(card);
        player1.addCardToHand(card);
        player1.addCardToHand(card2);

        player2.addCardToHand(card2);
        player2.addCardToHand(card2);
        player2.addCardToHand(card2);

        assertEquals(player1, game.checkWinner());
    }

    @Test
    public void isDraw() {
        player1.addCardToHand(card);
        player2.addCardToHand(card);
        assertEquals(true, game.isDraw());
    }

    @Test
    public void canDiscardSingleCard(){
        game.deal(player1);
        game.deal(player1);

        game.discardSingleCard(player1);

        assertEquals(1, player1.getHandSize());
    }

    @Test
    public void canDiscardHand() {

        game.deal(player1);
        game.deal(player1);

        game.discardHand(player1);
        assertEquals(0, player1.getHandSize());
    }

    @Test
    public void canResetGame() {
        game.dealToAllPlayers(2);
        game.reset();

        assertEquals(0, player1.getHandSize());
        assertEquals(0, player2.getHandSize());
    }

    @Test
    public void canGetCurrentPlayer() {
        assertEquals(player1, game.getCurrentPlayer());
    }
    @Test
    public void canCheckNotDone() {
        assertEquals(false, game.areAllPlayersDone());
    }

    @Test
    public void canAdvancePlayer(){
        game.nextPlayer();
        assertEquals(player2, game.getCurrentPlayer());
        assertEquals(false, game.areAllPlayersDone());

    }

    @Test
    public void canDetectLastPlayerDone(){
        game.nextPlayer();
        game.nextPlayer();
        assertEquals(true, game.areAllPlayersDone());
    }

    @Test
    public void canReturnScoresHashMap(){
        assertEquals(2, game.getPrintableScores().size());
    }



}
