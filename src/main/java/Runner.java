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

            for (int playerNumber = 1; playerNumber < game.playerCount(); ++playerNumber)
            {

                // loop until decline or bust
                //print status

                Decider.getYorN(scanner, "Would you like another card? (y/n)");
            }

            // Dealer's turn
            // print status
            // Get and print winner

            Decider.getYorN(scanner, "Would you like to play another round? (y/n)");
        }
        while(option == 'y');




    }
}
