package hexlet.code.games;

import hexlet.code.question.Question;

import java.util.Random;

public class ProgressionGame implements Game {

    private static final int MAX_START_PROGRESSION_NUMBER = 50;

    private static final int MAX_STEP = 10;

    private static final int NUMBERS_COUNT = 10;

    @Override
    public String getCaption() {
        return "What number is missing in the progression?";
    }

    @Override
    public Question generateQuestion() {
        Random random = new Random();

        int startNumber = random.nextInt(MAX_START_PROGRESSION_NUMBER + 1);
        int step = random.nextInt(MAX_STEP);
        int[] array = createArray(startNumber, step);

        int answerPosition = random.nextInt(NUMBERS_COUNT);
        String text = getQuestionText(array, answerPosition);
        String answer = String.valueOf(array[answerPosition]);
        return new Question(text, answer);
    }

    private int[] createArray(int startNumber, int step) {
        int[] numbers = new int[NUMBERS_COUNT];
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers[i] = startNumber;
            startNumber += step;
        }
        return numbers;
    }

    private String getQuestionText(int[] array, int answerPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String item = i == answerPosition ? ".." : String.valueOf(array[i]);
            sb.append(item)
                    .append(" ");
        }
        return sb.toString();
    }
}
