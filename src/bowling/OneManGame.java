package bowling;

import java.util.ArrayList;

public class OneManGame {
    private Score score = new Score();
    private ArrayList<Frame> frameSet = new ArrayList<Frame>();
    private InputOutputInterface InputOutputInterface = new InputOutputConsole();

    OneManGame() {
        InputOutputInterface.print("Enter Your Name : ");
        String name = InputOutputInterface.inputString();
        InputOutputInterface.print("Hi! " + name + ", Welcome to Bowling Game!");

        initialize();
        execute();
    }

    void rollABall(int i) {
        InputOutputInterface.print((i + 1) + " Frame!");
        frameSet.get(i).setScore();
    }

    void initialize() {
        for (int i = 0; i < 9; i++)
            frameSet.add(new NormalFrame());
        frameSet.add(new LastFrame());
    }

    void execute() {
        for (int i = 0; i < 10; i++) {

            rollABall(i);
            score.getScore(frameSet);
            new ScoreBoard(frameSet, score, i).printScoreBoard();
        }
    }
}
