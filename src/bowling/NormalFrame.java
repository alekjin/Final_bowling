package bowling;

public class NormalFrame extends Frame {

    NormalFrame() {
        numOfPins.add(-1);
        numOfPins.add(-1);
    }

    protected void setScore() {
        resetEntirePins();
        for (int i = 0; i < MAX_CHANCE; i++) {
            takeAShot(i);
            getEntirePins(i);

            if (isFirstShotStrike()) {
                break;
            }
        }
    }


}
