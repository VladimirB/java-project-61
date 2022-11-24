package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    private static final int MAX_QUESTIONS = 3;

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String YES = "yes";
    private static final String NO = "no";

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
        int number = random.nextInt(100);
        System.out.println("Question: " + number);
        return number % 2 == 0 ? 1 : 0;
    }

    private static int readAnswer(Scanner scanner) {
        System.out.print("Answer: ");
        String answer = scanner.next();
        return YES.equals(answer) ? 1 : 0;
    }

    private static boolean isAnswerCorrect(int answer, int userInput, String userName) {
        if (answer == userInput) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%1s' is wrong answer ;(. Correct answer was '%2s'.%n",
                    getAnswerFromInt(userInput),
                    getAnswerFromInt(answer));
            System.out.printf("Let's try again, %s!%n", userName);
        }
        return answer == userInput;
    }

    private static String getAnswerFromInt(int answer) {
        return answer == 1 ? YES : NO;
    }

    private static void printCongratulation(String userName) {
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
