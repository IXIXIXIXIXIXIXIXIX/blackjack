import java.util.HashMap;
import java.util.Set;

public class Outputter {

    public static void printLogo(){

        System.out.println("    ____  __           __       __           __");
        System.out.println("   / __ )/ /___ ______/ /__    / /___ ______/ /__");
        System.out.println("  / __  / / __ `/ ___/ //_/_  / / __ `/ ___/ //_/");
        System.out.println(" / /_/ / / /_/ / /__/ ,< / /_/ / /_/ / /__/ ,<");
        System.out.println("/_____/_/\\__,_/\\___/_/|_|\\____/\\__,_/\\___/_/|_|");
        System.out.println("\n");
    }

    public static void printBust() {

        System.out.println("    ____             __  __");
        System.out.println("   / __ )__  _______/ /_/ /");
        System.out.println("  / __  / / / / ___/ __/ /");
        System.out.println(" / /_/ / /_/ (__  ) /_/_/");
        System.out.println("/_____/\\__,_/____/\\__(_)");
        System.out.printf("\n");
    }

    public static void printCard(Card card) {

            System.out.println("____");
            System.out.println("|"+ String.valueOf(card.getRank().getView())+"|");
            System.out.println("| "+ String.valueOf(card.getSuit().getSymbol())+"|");
            System.out.println("----");
    }

    public static void printGameStatus(Game game) {
        HashMap<String, String> scores = game.getPrintableScores();
        Set<String> keys = scores.keySet();

        System.out.println("===================================");
        System.out.println("Game Status:");
//        System.out.println("___________________________________");

        System.out.println("Name\t\t\tScore");

        for (String name : keys)
        {
            System.out.println(name + "\t\t\t" + scores.get(name));
        }
        System.out.println("===================================");
        System.out.println("Dealer's face card:");
        Outputter.printCard(game.getDealerFaceCard());
        System.out.println("\n");
        System.out.println(game.getCurrentPlayer().getName() + " to draw.");
    }

    public static void printHand(Player player)
    {
       String topLine = "";
       String rankLine = "";
       String suitLine = "";
       String bottomLine = "";

       for(Card card: player.getHand())
       {
           topLine += "____ ";
           rankLine += String.format("|%s| ", card.getRank().getView());
           suitLine += String.format("| %s| ", card.getSuit().getSymbol());
           bottomLine += "---- ";
       }

        System.out.println(topLine);
        System.out.println(rankLine);
        System.out.println(suitLine);
        System.out.println(bottomLine);
        System.out.println("Hand total: " + player.getScore());
    }

    public Outputter() {
    }


}
