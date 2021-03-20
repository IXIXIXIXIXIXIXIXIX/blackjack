import java.util.Scanner;

public class Decider {

    public static Character getYorN(Scanner scanner, String prompt){

        Character option;

        do {
            System.out.println(prompt);
            option = Character.toLowerCase(scanner.next().toCharArray()[0]);
        }
        while(option != 'y' && option != 'n');

        return option;
    }
}
