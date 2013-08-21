package bowling;

import java.util.ArrayList;

public abstract class Frame {
    protected final int MAX_PINS = 10;
    protected int MAX_CHANCE = 2;
    protected int entirePins;
    protected ExecuteStrategy executeStrategy = new ExecuteConsole();
    protected ArrayList<Integer> numOfPins = new ArrayList<Integer>();

    Frame() {
    }

    protected int getPins(int i) {
        return numOfPins.get(i);
    }

    protected int countPins(int i) {
        if (numOfPins.get(i) == -1)
            return 0;
        return numOfPins.get(i);
    }

    protected void setPins(int i, int pins) {
        numOfPins.set(i, pins);
    }

    protected void takeAShot(int i) {
        executeStrategy.print("Roll the " + (i + 1) + " Ball!");
        while (isNotOverPins(i)) {
            executeStrategy.print("Write Score : ");
            setPins(i, executeStrategy.inputInt());
            if (isNotOverPins(i))
                executeStrategy.print("Write Correct Number ( 0 <= num <= " + entirePins + " )");
        }

    }

    protected void getEntirePins(int i) {
        entirePins = MAX_PINS - countPins(i);
    }

    protected void resetEntirePins() {
        entirePins = 10;
    }


    protected boolean isFirstShotStrike() {
        return (getPins(0) == 10);
    }

    protected boolean isSecondShotSpare() {
        return (numOfPins.get(0) != 10) & (numOfPins.get(0) + numOfPins.get(1) == 10);
    }

    protected abstract void setScore();

    private boolean isNotOverPins(int i) {
        return (getPins(i) > entirePins | getPins(i) < 0);
    }
}
