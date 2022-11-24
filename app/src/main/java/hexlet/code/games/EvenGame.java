package hexlet.code.games;

import hexlet.code.question.Question;

import java.util.Random;

public final class EvenGame implements Game {

    private static final int MAX_RANDOM_NUM = 100;

    private static final String YES = "yes";
    private static final String NO = "no";

    @Override
    public String getCaption() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public Question generateQuestion() {
        Random random = new Random();
        int number = random.nextInt(MAX_RANDOM_NUM + 1);
        String answer = number % 2 == 0 ? YES : NO;
        return new Question(String.valueOf(number), answer);
    }
}
