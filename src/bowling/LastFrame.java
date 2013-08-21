package bowling;

public class LastFrame extends Frame {

    LastFrame() {
        numOfPins.add(-1);
        numOfPins.add(-1);
        numOfPins.add(-1);
    }

    protected void setScore() {
        getEntirePins(0);
        takeAShot(0);

        if (isFirstShotStrike()) {
            resetEntirePins();
            takeAShot(1);
        } else {
            getEntirePins(0);
            takeAShot(1);
        }

        if (isFirstShotStrike()) {
            if (getPins(1) != 10) {
                getEntirePins(1);
                takeAShot(2);
            } else {
                resetEntirePins();
                takeAShot(2);
            }
        } else if (isSecondShotSpare()) {
            resetEntirePins();
            takeAShot(2);
        }
    }
}
