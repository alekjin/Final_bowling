package bowling;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final int MAX_PIN = 10;
    private final String STRIKE = "X";
    private final String SPARE = "/";
    private final String ERROR = "F";
    private final String ZERO = "-";
    private final String NEW_LINE = System.getProperty("line.separator");
    private final String HORIZON = "━";
    private final String VERTICAL = "┃";
    private final String CROSS = "╋";
    private final String TOPLINE        = "┏━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━━┓";
    private final String FRAMELINE      = "┃ ① ┃ ② ┃ ③ ┃ ④ ┃ ⑤ ┃ ⑥ ┃ ⑦ ┃ ⑧ ┃ ⑨ ┃  ⑩  ┃";
    private final String TOPMIDLINE     = "┣━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━━┫";
    private final String SCORELINE      = "┃-┃2┃2┃2┃2┃4┃/┃3┃9┃4┃3┃3┃3┃4┃2┃4┃6┃5┃3┃3 6┃";
    private final String BOTTOMMIDLINE  = "┣━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━━┫";
    private final String TOTALSCORELINE = "┃  56┃  34┃  34┃  34┃  34┃  34┃  23┃  23┃  23┃    23┃";
    private final String BOTTOMLINE     = "┗━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━━┛";

    private StringBuilder scoreBoard = new StringBuilder();
    private ExecuteStrategy executeStrategy = new ExecuteConsole();
    private ArrayList<Frame> frameList = new ArrayList<Frame>();
    private ArrayList<Integer> scoreList = new ArrayList<Integer>();
//    private int nowFrame;

    ScoreBoard(ArrayList<Frame> frameList, Score score) {
        this.frameList = frameList;
        this.scoreList = score.getScoreList();
//        this.nowFrame = nowFrame;
        printScoreBoard();
    }

    void printScoreBoard() {
        scoreBoard.append(TOPLINE + NEW_LINE +
                FRAMELINE + NEW_LINE +
                TOPMIDLINE + NEW_LINE +
                makeScoreLine() + NEW_LINE +
                BOTTOMMIDLINE + NEW_LINE +
                makeTotalScoreLine() + NEW_LINE +
                BOTTOMLINE + NEW_LINE);
        executeStrategy.print(scoreBoard);
    }

    StringBuilder makeScoreLine() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < 9 ; i++)
        {
            if (frameList.get(i).isFirstShotStrike())
                stringBuilder.append(
                        "┃ ┃" + STRIKE
                );

            else if (frameList.get(i).isSecondShotSpare())
                stringBuilder.append(
                        "┃" + getScore(i, 0) + "┃" + STRIKE
                );

            else
                stringBuilder.append(
                    "┃" + getScore(i, 0) + "┃" + getScore(i, 1)
                );
        }

            stringBuilder.append(
                "┃" + getScore(9, 0) + "┃" + getScore(9, 1) + " " + getScore(9, 2) + "┃"
            );
        return stringBuilder;
    }

    StringBuilder makeTotalScoreLine() {
        StringBuilder stringBuilder = new StringBuilder();
        int scoreSum = 0;
        String.format("% 4d", scoreSum);



        for (int i = 0 ; i < 9 ; i++) {
            scoreSum = scoreSum + scoreList.get(i);
            stringBuilder.append(
                 "┃" + String.format("% 4d", scoreSum)
            );
        }

        scoreSum = scoreSum + scoreList.get(9);
        stringBuilder.append(
                "┃" + String.format("% 6d", scoreSum) + "┃"
        );


        return stringBuilder;
    }

    String getScore(int frameNum, int pinNum) {
        if (frameList.get(frameNum).countPins(pinNum) == 0)
            return ZERO;
        else if (frameList.get(frameNum).countPins(pinNum) == 10)
            return STRIKE;
        return String.valueOf(frameList.get(frameNum).countPins(pinNum));
    }
}
