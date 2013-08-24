package bowling;

import java.util.ArrayList;

public class NormalFrame extends Frame {
    private ArrayList<Shot> shots = new ArrayList<Shot>();

    NormalFrame(FrameStatus nowFrameStatus) {
        super(nowFrameStatus);
    }

    @Override
    void initializeFrame() {
        shots.add(new Shot());
        shots.add(new Shot());
    }

    @Override
    void startFrame () {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
