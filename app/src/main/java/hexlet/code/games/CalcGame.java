package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {

    private enum OperationType {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION
    }

    private static final int MAX_QUESTIONS = 3;

    private static final int MAX_RANDOM_NUM = 15;

    private static final String RULES = "What is the result of the expression?";

    public static void play(String userName, Scanner scanner) {
        printGameRules();

        for (int i = 0; i < MAX_QUESTIONS; i++) {
            int answer = askQuestion();
            int input = readAnswer(scanner);

            if (!isAnswerCorrect(answer, input, userName)) {
                return;
            }
        }

        printCongratulation(userName);
    }

    private static void printGameRules() {
        System.out.println(RULES);
    }

    private static int askQuestion() {
        Random random = new Random();

        int num1 = random.nextInt(MAX_RANDOM_NUM);
        int num2 = random.nextInt(MAX_RANDOM_NUM);

        int ordinal = random.nextInt(OperationType.values().length);
        OperationType operationType = OperationType.values()[ordinal];

        String op = switch (operationType) {
            case ADDITION -> "+";
            case SUBTRACTION -> "-";
            case MULTIPLICATION -> "*";
        };

        System.out.printf("Question: %d %s %d%n", num1, op, num2);

        return switch (operationType) {
            case ADDITION -> num1 + num2;
            case SUBTRACTION -> num1 - num2;
            case MULTIPLICATION -> num1 * num2;
        };
    }

    private static int readAnswer(Scanner scanner) {
        System.out.print("Answer: ");
        return scanner.nextInt();
    }

    private static boolean isAnswerCorrect(int answer, int userInput, String userName) {
        if (answer == userInput) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%1s' is wrong answer ;(. Correct answer was '%2s'.%n",
                    userInput,
                    answer);
            System.out.printf("Let's try again, %s!%n", userName);
        }
        return answer == userInput;
    }

    private static void printCongratulation(String userName) {
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
