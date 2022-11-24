package hexlet.code;

import hexlet.code.engine.Engine;
import hexlet.code.games.*;

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

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        System.out.println();

        switch (command) {
            case COMMAND_GREETINGS -> Cli.greetingUser(scanner);
            case EVEN_GAME -> Engine.play(new EvenGame(), scanner);
            case CALC_GAME -> Engine.play(new CalcGame(), scanner);
            case NOD_GAME -> Engine.play(new NodGame(), scanner);
            case PROGRESSION_GAME -> Engine.play(new ProgressionGame(), scanner);
            case PRIME_GAME -> Engine.play(new PrimeGame(), scanner);
        }

        scanner.close();
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
}
