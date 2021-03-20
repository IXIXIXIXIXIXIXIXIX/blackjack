import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game;

        System.out.println("Welcome to:");
        Outputter.printLogo();
        ArrayList<Player> players = new ArrayList<>();
        Character option;

        // Add players to list of players (max 5) as long as user opts to
        do
        {
            System.out.println("Enter player name:");
            String name = scanner.next();
            players.add(new Player(name));

            option = Decider.getYorN(scanner, "Would you like to add another player? (y/n)");

            if (players.size() == 5){
                System.out.println("Sorry! There are only 5 places at the table.");
                option = 'n';
            }

        }
        while(option == 'y');

        System.out.println("\n");
        System.out.println("Players at the table:");
        System.out.println("Dealer");
        for (Player player : players)
        {
            System.out.println(player.getName());
        }

        // Initialise game with list of players
        game = new Game(players);
        Player currentPlayer;


        do {
            // Deal initial 2 cards
            game.dealToAllPlayers(2);

            while(!game.areAllPlayersDone())
            {
                Outputter.printGameStatus(game);
                currentPlayer = game.getCurrentPlayer();
                Outputter.printHand(currentPlayer);
                while(!currentPlayer.isBust() && Decider.getYorN(scanner, "Would you like another card? (y/n)") == 'y')
                {
                    System.out.println("Your new card is:");
                    Outputter.printCard(game.deal(currentPlayer));
                    Outputter.printGameStatus(game);
                    Outputter.printHand(currentPlayer);
                }

                if(currentPlayer.isBust())
                {
                    Outputter.printBust();
                }

                game.nextPlayer();
            }

            // Dealer section of game
            Outputter.printGameStatus(game);
            ArrayList<String> notBust = game.getNotBust();
            if (notBust.size() == 1)
            {
                System.out.println("Dealer's hand:");
                Outputter.printHand(game.getDealer());
                System.out.println("Dealer Wins!");
            }
            else
                {
                System.out.println("Dealer Draws...");
                game.dealerDraw();
                if (game.getDealer().isBust()) {
                    Outputter.printHand(game.getDealer());
                    System.out.println("Dealer is bust!");

                    notBust = game.getNotBust();
                    if (notBust.size() == 1)
                    {
                        System.out.println("Winner is " + notBust.get(0));
                    }
                    else
                    {
                        System.out.println("Winners are:");
                        for (String name: notBust)
                        {
                            System.out.println(name);
                        }
                    }
                } else {
                    System.out.println("Dealer's hand:");
                    Outputter.printHand(game.getDealer());
                    System.out.println("Dealer score is " + game.getDealer().getScore());
                    System.out.println("Winner is " + game.checkWinner().getName() + "!");
                }

            }
            game.reset();
            option = Decider.getYorN(scanner, "Would you like to play another round? (y/n)");
        }
        while(option == 'y');




    }
}
