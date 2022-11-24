package hexlet.code.games;

import hexlet.code.question.Question;

public interface Game {

    String getCaption();

    Question generateQuestion();
}
