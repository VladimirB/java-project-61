package hexlet.code.games;

import java.util.Random;

public class EvenGame implements Game {

    private static final int MAX_RANDOM_NUM = 100;

    private static final String YES = "yes";
    private static final String NO = "no";

    private String lastCorrectAnswer;

    @Override
    public String getCaption() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        Random random = new Random();
        int number = random.nextInt(MAX_RANDOM_NUM);
        lastCorrectAnswer = number % 2 == 0 ? YES : NO;
        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer() {
        return lastCorrectAnswer;
    }
}
