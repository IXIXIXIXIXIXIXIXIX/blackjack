import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        game.dealToAllPlayers(3);
        Player winner;
        if (!game.isDraw()) {
            if (player1.getScore() >= player2.getScore()) {
                winner = player1;
            } else {
                winner = player2;
            }

            if (game.getDealerScore() >= winner.getScore())
            {
                // Method getDealer only for testing purposes - remove in production
                winner = game.getDealer();
            }
            assertEquals(winner, game.checkWinner());
        }
        else{
            assertEquals(true, game.isDraw());
        }
    }

    @Test
    public void isDraw() {
        player1.addCardToHand(card);
        player2.addCardToHand(card);
        assertEquals(true, game.isDraw());
    }

}
