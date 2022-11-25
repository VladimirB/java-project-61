package hexlet.code.games;

import hexlet.code.question.Question;

import java.util.Random;

public final class NodGame implements Game {

    private static final int MAX_RANDOM_NUM = 100;

    private static final int MIN_DIVIDER = 1;

    @Override
    public String getCaption() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Question generateQuestion() {
        Random random = new Random();

        int num1 = random.nextInt(MAX_RANDOM_NUM + 1);
        int num2 = random.nextInt(MAX_RANDOM_NUM + 1);

        String text = String.format("%d %d", num1, num2);
        String answer = String.valueOf(findNod(num1, num2));
        return new Question(text, answer);
    }

    private int findNod(int num1, int num2) {
        int div = Math.min(num1, num2);
        while (div > MIN_DIVIDER) {
            if (num1 % div == 0 && num2 % div == 0) {
                break;
            }
            div--;
        }
        return div;
    }
}
