package hexlet.code;

import hexlet.code.games.CalcGame;

import java.util.Scanner;

public class App {

    private static final int COMMAND_GREETINGS = 1;

    private static final int EVEN_GAME = 2;

    private static final int CALC_GAME = 3;

    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        printMenu();

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        System.out.println();

        switch (command) {
            case COMMAND_GREETINGS -> Cli.greetingUser(scanner);
            case EVEN_GAME -> {
                String userName = Cli.greetingUser(scanner);
                EvenGame.play(userName, scanner);
            }
            case CALC_GAME -> {
                String userName = Cli.greetingUser(scanner);
                CalcGame.play(userName, scanner);
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
    }
}
