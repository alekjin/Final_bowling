package bowling;

import java.util.ArrayList;

public class Score {
    private ArrayList<Object> scoreList = new ArrayList<Object>();

    private int firstScore = 0;
    private int secondScore = 0;

    private int firstBonusScore;
    private int secondBonusScore;
    private int bonusScore;

    Score() {
        initialize();
    }

    void initialize() {
        for (int i = 0; i < 10; i++)
            scoreList.add(0);
    }

    void getScore(ArrayList<Frame> frameList) {
        for (int i = 0; i < 8; i++) {
            firstScore = frameList.get(i).countPins(0);
            secondScore = frameList.get(i).countPins(1);
            firstBonusScore = frameList.get(i + 1).countPins(0);
            secondBonusScore = frameList.get(i + 1).countPins(1);

            if (frameList.get(i).isFirstShotStrike())
                scoreList.set(i, firstScore + firstBonusScore + secondBonusScore);
            if (frameList.get(i + 1).isFirstShotStrike())
                scoreList.set(i, firstScore + firstBonusScore + frameList.get(i + 2).countPins(0));
            else if (frameList.get(i).isSecondShotSpare())
                scoreList.set(i, firstScore + secondScore + firstBonusScore);
            else
                scoreList.set(i, firstScore + secondScore);
        }

        firstScore = frameList.get(8).countPins(0);
        secondScore = frameList.get(8).countPins(1);
        firstBonusScore = frameList.get(9).countPins(0);
        secondBonusScore = frameList.get(9).countPins(1);

        if (frameList.get(8).isFirstShotStrike())
            scoreList.set(8, firstScore + firstBonusScore + secondBonusScore);
        else if (frameList.get(8).isSecondShotSpare())
            scoreList.set(8, firstScore + secondScore + firstBonusScore);

        firstScore = frameList.get(9).countPins(0);
        secondScore = frameList.get(9).countPins(1);
        bonusScore = frameList.get(9).countPins(2);

        scoreList.set(9, firstScore + secondScore + bonusScore);

        System.out.println(scoreList);
    }

    ArrayList getScoreList() {
        return scoreList;
    }
}
