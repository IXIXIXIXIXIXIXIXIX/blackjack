import java.util.Scanner;

public class Decider {

    public static Character getYorN(Scanner scanner, String prompt){

        Character option;

        do {
            System.out.println("Would you like to add another player? (y/n)");
            option = Character.toLowerCase(scanner.next().toCharArray()[0]);
        }
        while(option != 'y' && option != 'n');

        return option;
    }
}
