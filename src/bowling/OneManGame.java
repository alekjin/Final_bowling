package bowling;

import java.util.ArrayList;

public class OneManGame {
    private Score score = new Score();
    private ArrayList<Frame> frameSet = new ArrayList<Frame>();
    private ExecuteStrategy executeStrategy = new ExecuteConsole();

    OneManGame() {
        executeStrategy.print("Enter Your Name : ");
        String name = executeStrategy.inputString();
        executeStrategy.print("Hi! " + name + ", Welcome to Bowling Game!");

        initialize();
        execute();
    }

    void rollABall(int i) {
        executeStrategy.print((i + 1) + " Frame!");
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
            new ScoreBoard(frameSet, score, i);
        }
    }
}
