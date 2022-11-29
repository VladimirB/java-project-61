package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.NodGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    private static final int COMMAND_GREETINGS = 1;

    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int NOD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;

    public static void main(String[] args) {
        printMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = readChoice(scanner);

            if (choice == COMMAND_GREETINGS) {
                Cli.greetingUser(scanner);
                return;
            }

            Game game = switch (choice) {
                case EVEN_GAME -> new EvenGame();
                case CALC_GAME -> new CalcGame();
                case NOD_GAME -> new NodGame();
                case PROGRESSION_GAME -> new ProgressionGame();
                case PRIME_GAME -> new PrimeGame();
                default -> null;
            };
            if (game != null) {
                Engine.play(game, scanner);
            }
        }
    }

    private static void printMenu() {
        String sb = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - NOD
                5 - Progression
                6 - Prime
                0 - Exit""";
        System.out.println(sb);
    }

    private static int readChoice(Scanner scanner) {
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        System.out.println();
        return choice;
    }
}
