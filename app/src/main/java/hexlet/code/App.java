package hexlet.code;

import java.util.Scanner;

public class App {

    private static final int COMMAND_GREETINGS = 1;

    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        printMenu();

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        System.out.println();

        if (command == COMMAND_GREETINGS) {
            Cli.greetingUser(scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
    }
}
