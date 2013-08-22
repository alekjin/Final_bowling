package bowling;

import java.util.ArrayList;

public class ScoreBoard {
    private final String STRIKE = "X";
    private final String SPARE = "/";
    private final String ZERO = "-";
    private final String BLANK = " ";
    private final String FOURBLANK = "    ";
    private final String SIXBLANK = "      ";
    private final String NEW_LINE = System.getProperty("line.separator");
    private final String VERTICAL = "┃";
    private final String TOPLINE        = "┏━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━━┓";
    private final String FRAMELINE      = "┃ ① ┃ ② ┃ ③ ┃ ④ ┃ ⑤ ┃ ⑥ ┃ ⑦ ┃ ⑧ ┃ ⑨ ┃  ⑩  ┃";
    private final String TOPMIDLINE     = "┣━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━━┫";
    private final String BOTTOMMIDLINE  = "┣━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━╋━━━┫";
    private final String BOTTOMLINE     = "┗━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━━┛";

    private StringBuilder scoreBoard = new StringBuilder();
    private InputOutputInterface InputOutputInterface = new InputOutputConsole();
    private ArrayList<Frame> frameList = new ArrayList<Frame>();
    private ArrayList<Integer> scoreList = new ArrayList<Integer>();
    private ArrayList<Integer> scoreCumulativeList = new ArrayList<Integer>();
    private int nowFrame;

    ScoreBoard(ArrayList<Frame> frameList, Score score, int nowFrame) {
        this.frameList = frameList;
        this.scoreList = score.getScoreList();
        this.nowFrame = nowFrame;
    }

    void printScoreBoard() {
        scoreBoard.append(
                TOPLINE + NEW_LINE +
                FRAMELINE + NEW_LINE +
                TOPMIDLINE + NEW_LINE +
                makeScoreLine() + NEW_LINE +
                BOTTOMMIDLINE + NEW_LINE +
                makeTotalScoreLine() + NEW_LINE +
                BOTTOMLINE + NEW_LINE);
        InputOutputInterface.print(scoreBoard);
    }

    StringBuilder makeScoreLine() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < 10 ; i++) {
            if (frameList.get(i).isFirstShotStrike())
                stringBuilder.append(
                    VERTICAL + BLANK + VERTICAL + STRIKE
                );

            else if (frameList.get(i).isSecondShotSpare())
                stringBuilder.append(
                    VERTICAL + getScore(i, 0) + VERTICAL + SPARE
                );

            else
                stringBuilder.append(
                    VERTICAL + getScore(i, 0) + VERTICAL + getScore(i, 1)
                );
        }
            stringBuilder.append(
               BLANK + getScore(9, 2) + VERTICAL
            );
        return stringBuilder;
    }

    StringBuilder makeTotalScoreLine() {
        StringBuilder stringBuilder = new StringBuilder();
        calcScore();

        if (nowFrame == 0) {
            if (frameList.get(nowFrame).isFirstShotStrike())
                stringBuilder.append(makeEachFrameScore(nowFrame));
            else if (frameList.get(nowFrame).isSecondShotSpare())
                stringBuilder.append(makeEachFrameScore(nowFrame));
            else
                stringBuilder.append(makeEachFrameScore(nowFrame + 1));
        }

        if (nowFrame > 0 & nowFrame != 9) {
            if (frameList.get(nowFrame).isFirstShotStrike()) {
                if (frameList.get(nowFrame-1).isFirstShotStrike())
                    stringBuilder.append(makeEachFrameScore(nowFrame - 1));
                else
                    stringBuilder.append(makeEachFrameScore(nowFrame));
            }
            else if (frameList.get(nowFrame).isSecondShotSpare()) {
                stringBuilder.append(makeEachFrameScore(nowFrame));
            }
            else
                stringBuilder.append(makeEachFrameScore(nowFrame + 1));


        }

        if (nowFrame == 9)
            stringBuilder.append(makeEachFrameScore(nowFrame));
        return stringBuilder;
    }

    String getScore(int frameNum, int pinNum) {
        if (frameList.get(frameNum).countPins(pinNum) == 10)
            return STRIKE;
        if (frameList.get(frameNum).getPins(pinNum) == -1)
            return BLANK;
        if (frameList.get(frameNum).countPins(pinNum) == 0)
            return ZERO;

        return String.valueOf(frameList.get(frameNum).countPins(pinNum));
    }

    void calcScore() {
        for (int i = 0 ; i < 10 ; i++)
            scoreCumulativeList.add(0);

        for (int i = 0 ; i < 10 ; i++)
            scoreCumulativeList.set(i, calcCumulativeScore(i+1));

        System.out.println(scoreCumulativeList);
    }

    int calcCumulativeScore(int frame) {
        int sum = 0;
        for (int i = 0 ; i < frame ; i++)
            sum = sum + scoreList.get(i);
        return sum;
    }

    StringBuilder makeEachFrameScore(int nowframe) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < nowframe ; i++) {
            stringBuilder.append(
                    VERTICAL + String.format("% 4d", scoreCumulativeList.get(i))
            );
        }

        for (int i = nowframe ; i < 9 ; i++) {
            stringBuilder.append(
                    VERTICAL + FOURBLANK
            );
        }

        if (frameList.get(nowframe).getClass() == LastFrame.class)
            stringBuilder.append(
                    VERTICAL + String.format("% 6d", scoreCumulativeList.get(nowframe)) + VERTICAL
            );

        if (frameList.get(nowframe).getClass() == NormalFrame.class)
            stringBuilder.append(
                    VERTICAL + SIXBLANK + VERTICAL
            );


        return stringBuilder;
    }

    int getFinalScore() {
        System.out.println(scoreCumulativeList.size());
        return scoreCumulativeList.get(9);
    }
}
