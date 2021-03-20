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

    private int getHighScore() {
        int high = 0;

        for (Player player: this.players)
        {
            if (player.getScore() > high)
            {
                high = player.getScore();
            }
        }
        return high;
    }

    private boolean allBust() {
        return this.getNotBust().size() == 0;
    }

    public boolean isDraw() {

        if (allBust())
        {
            return true;
        }

        int highScore = getHighScore();
        int highCount = 0;

        for(Player player : this.players) {
            if (player.getScore() == highScore)
            {
                ++highCount;
            }
        }

        if(highCount > 1)
        {
            return true;
        } else
        {
            return false;
        }
    }

    private Card compareCards(Card card1, Card card2)
    {
        if (card1 == card2)
        {
            return card1;
        }
        if (card1.getRankPrecedence() > card2.getRankPrecedence())
        {
            return card1;
        }

        if (card1.getRankPrecedence() < card2.getRankPrecedence())
        {
            return card2;
        }

        if (card1.getSuitPrecedence() > card2.getSuitPrecedence())
        {
            return card1;
        }
        else
        {
            return card2;
        }
    }

    private Card highCard(Player player) {

        ArrayList<Card> hand = player.getHand();
        Card highest = hand.get(0);

        for(Card card: hand)
        {
            highest = this.compareCards(highest, card);
        }

        return highest;
    }

    private Player compareTiedPlayers(Player player1, Player player2){

        if (player1 == player2)
        {
            return player1;
        }
        if (compareCards(highCard(player1), highCard((player2))) == highCard(player1))
        {
            return player1;
        }
        else
        {
            return player2;
        }
    }

    public Player checkWinner() {

        Player winner;
        if (!isDraw()) {
            winner = this.getNotBust().get(0);
            for (Player player: this.players) {
                if (winner.getScore() <= player.getScore()) {
                    winner = player;
                }
            }
            return winner;
        }


        int highScore = getHighScore();
        ArrayList<Player> topPlayers = new ArrayList<>();
        for(Player player: this.players)
        {
            if (player.getScore() == highScore)
            {
                topPlayers.add(player);
            }
        }

        winner = topPlayers.get(0);

        for(Player player: topPlayers)
        {
            winner = compareTiedPlayers(winner, player);
        }

        return winner;
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

    public ArrayList<Player> getNotBust() {
        ArrayList<Player> notBust = new ArrayList<>();

        for(Player player : this.players)
        {
            if(!player.isBust())
            {
                notBust.add(player);
            }
        }
        return notBust;
    }


}
