package hexlet.code.games;

import java.util.Random;

public class CalcGame implements Game {

    private enum OperationType {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION
    }

    private static final int MAX_RANDOM_NUM = 15;

    private String lastCorrectAnswer;

    @Override
    public String getCaption() {
        return "What is the result of the expression?";
    }

    @Override
    public String generateQuestion() {
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

        var answer = switch (operationType) {
            case ADDITION -> num1 + num2;
            case SUBTRACTION -> num1 - num2;
            case MULTIPLICATION -> num1 * num2;
        };
        lastCorrectAnswer = String.valueOf(answer);

        return String.format("%d %s %d", num1, op, num2);
    }

    @Override
    public String getCorrectAnswer() {
        return lastCorrectAnswer;
    }
}
