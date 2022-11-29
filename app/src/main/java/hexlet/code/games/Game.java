package hexlet.code.games;

import hexlet.code.Question;

public interface Game {

    String getCaption();

    Question generateQuestion();
}
