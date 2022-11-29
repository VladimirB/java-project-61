package hexlet.code.games;

import hexlet.code.Question;

import java.util.Random;

public final class CalcGame implements Game {

    private static final String[] OPERATIONS = {"+", "-", "*"};

    private static final int MAX_RANDOM_NUM = 15;

    @Override
    public String getCaption() {
        return "What is the result of the expression?";
    }

    @Override
    public Question generateQuestion() {
        Random random = new Random();

        int num1 = random.nextInt(MAX_RANDOM_NUM + 1);
        int num2 = random.nextInt(MAX_RANDOM_NUM + 1);

        int index = random.nextInt(OPERATIONS.length);
        String operation = OPERATIONS[index];

        var answer = calcExpression(operation, num1, num2);
        var text = String.format("%d %s %d", num1, operation, num2);
        return new Question(text, String.valueOf(answer));
    }

    private int calcExpression(String sign, int num1, int num2) {
        return switch (sign) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new UnsupportedOperationException("Operation is not support: " + sign);
        };
    }
}
