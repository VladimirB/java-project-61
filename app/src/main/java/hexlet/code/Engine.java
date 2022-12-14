package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public class Engine {

    private static final int MAX_QUESTIONS = 3;

    public static void play(Game game, Scanner scanner) {
        String userName = Cli.greetingUser(scanner);
        System.out.println(game.getCaption());

        for (int i = 0; i < MAX_QUESTIONS; i++) {
            Question question = game.generateQuestion();
            System.out.println("Question: " + question.text());
            String answer = readAnswer(scanner);

            String correctAnswer = question.answer();
            if (!isAnswerCorrect(answer, correctAnswer)) {
                System.out.printf("Let's try again, %s!%n", userName);
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", userName);
    }

    private static String readAnswer(Scanner scanner) {
        System.out.print("Answer: ");
        return scanner.next();
    }

    private static boolean isAnswerCorrect(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n",
                    actual,
                    expected);
        }

        return actual.equals(expected);
    }
}
