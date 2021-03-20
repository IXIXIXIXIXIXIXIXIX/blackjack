import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private boolean allPlayersDone;

    public Game(ArrayList<Player> players) {

        // Always start the game with a dealer to ensure dealer is always at index 0
        this.players = new ArrayList<Player>();
        this.players.add(new Player("Dealer"));

        // Add rest of players
        this.players.addAll(players);
        this.deck = new Deck();
        deck.populate();
        deck.shuffle();

        // Set current player
        this.currentPlayer = this.players.get(1);
        this.allPlayersDone = false;
    }

    public int playerCount() {
        return this.players.size();
    }

    public Card deal(Player player) {

        Card newCard = this.deck.dealOne();
        player.addCardToHand(newCard);
        return newCard;
    }

    public void dealToAllPlayers(int numberOfCards) {
        for(Player player : this.players) {
            for(int i=0; i<numberOfCards; i++) {
                this.deal(player);
            }
        }
    }

    public Player checkWinner() {
        Player winner = this.players.get(0);
        for(Player player : this.players) {
            if(winner.getScore() <= player.getScore()) {
                winner = player;
            }
        }
        return winner;
    }

    public boolean isDraw() {
        ArrayList<Integer> scores = new ArrayList<>();
        for(Player player : this.players) {
            scores.add(player.getScore());
        }
        Set<Integer> set = new HashSet<Integer>(scores);
        if(set.size() < scores.size()) {
            return true;
        } else {
            return false;
        }
    }

    public int getDealerScore() {
        Player dealer = this.players.get(0);
        return dealer.getScore();
    }

    public Player getDealer() {
        return this.players.get(0);
    }

    public void discardSingleCard(Player player) {

        deck.addCard(player.removeCardFromHand());
    }

    public void discardHand(Player player) {

        int cardsToRemove = player.getHandSize();

        for (int i = 0; i < cardsToRemove; ++i)
        {
            this.discardSingleCard(player);
        }
    }

    public void reset() {

        for (Player player: this.players)
        {
            this.discardHand(player);
        }

        // Set current player
        this.currentPlayer = players.get(1);
        this.allPlayersDone = false;

        this.deck.shuffle();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean areAllPlayersDone() {
        return allPlayersDone;
    }

    public void nextPlayer() {

        int currentIndex = this.players.indexOf(currentPlayer);
        if (currentIndex == this.playerCount() - 1)
        {
            // After last player, advance to dealer
            this.currentPlayer = this.players.get(0);
            this.allPlayersDone = true;
        }
        else
        {
            this.currentPlayer = this.players.get(currentIndex + 1);
        }
    }

    public Card getDealerFaceCard() {
        return this.players.get(0).getCard(0);
    }

    public HashMap<String, String> getPrintableScores() {

        Player player;
        HashMap<String, String> scores = new HashMap<>();

        for (int i = 1; i < this.playerCount(); ++i)
        {
            player = this.players.get(i);

            if(player.isBust())
            {
                scores.put(player.getName(), "Bust");
            }
            else
            {
                scores.put(player.getName(), String.valueOf(player.getScore()));
            }
        }
        return scores;
    }

    public void dealerDraw() {

        while (this.players.get(0).getScore() <= 16)
        {
            this.deal(this.players.get(0));
        }
    }

    public ArrayList<String> getNotBust() {
        ArrayList<String> notBust = new ArrayList<>();

        for(Player player : this.players)
        {
            if(!player.isBust())
            {
                notBust.add(player.getName());
            }
        }

        return notBust;
    }
}
