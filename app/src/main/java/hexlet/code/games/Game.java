package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;

import java.util.Scanner;

public abstract class Game {

    public abstract String getCaption();

    public abstract Question generateQuestion();

    public final void play(Scanner scanner) {
        Engine.play(this, scanner);
    }
}
