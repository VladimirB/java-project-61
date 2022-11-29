package hexlet.code.games;

import hexlet.code.Question;

import java.util.Random;

public final class PrimeGame implements Game {

    private static final int MAX_RANDOM_NUM = 101;

    private static final String YES = "yes";
    private static final String NO = "no";

    @Override
    public String getCaption() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Question generateQuestion() {
        Random random = new Random();

        int number = random.nextInt(MAX_RANDOM_NUM) + 1;
        String answer = isPrime(number) ? YES : NO;
        return new Question(String.valueOf(number), answer);
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
