package bowling;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private int numOfPeople;
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<Frame> frameSet = new ArrayList<Frame>();
    private ArrayList<Score> scoreSet = new ArrayList<Score>();
    private ArrayList<ArrayList<Frame>> gameList = new ArrayList<ArrayList<Frame>>();

    InputOutputInterface inputOutputInterface = new InputOutputConsole();


    Game() {
        initializePeople();
        initialize();
        execute();
        score();
    }

    void initializePeople() {

        inputOutputInterface.print("How many people play the bowling? : ");
        this.numOfPeople = inputOutputInterface.inputInt();

        for (int i = 0 ; i < numOfPeople ; i++) {
            inputOutputInterface.print("What is " + (i+1) + " player's name? : ");
            nameList.add(inputOutputInterface.inputString());
            inputOutputInterface.print("Hello, " + nameList.get(i));
        }
    }

    void initialize() {
        for (int i = 0; i < 9; i++)
            frameSet.add(new NormalFrame());
        frameSet.add(new LastFrame());

        for (int i = 0 ; i < numOfPeople ; i++) {
            gameList.add(frameSet);
            scoreSet.add(new Score());
        }
    }

    void rollABall(int noOfPeople, int frame) {
        inputOutputInterface.print((frame + 1) + " Frame!");
        gameList.get(noOfPeople).get(frame).setScore();
    }

    void execute() {
        for (int i = 0; i < 10; i++) {

            for (int noOfPeople = 0; noOfPeople < numOfPeople ; noOfPeople++) {
                rollABall(noOfPeople, i);
                scoreSet.get(noOfPeople).getScore(frameSet);
                inputOutputInterface.print((noOfPeople+1) + "Player's Score : ");
                new ScoreBoard(frameSet, scoreSet.get(noOfPeople), i).printScoreBoard();
            }

        }
    }

    void score() {
        ArrayList<Integer> finalScore = new ArrayList<Integer>();
        for (int noOfPeople = 0 ; noOfPeople < numOfPeople ; noOfPeople++) {
            finalScore.set(noOfPeople, new ScoreBoard(frameSet, scoreSet.get(noOfPeople), 9).getFinalScore());
        }
        inputOutputInterface.print(Collections.max(finalScore) + " is the Highest Score");

    }


}
