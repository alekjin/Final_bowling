package bowling;

public abstract class Frame {
    public enum FrameStatus {
        STRIKE('X'),
        SPARE('/'),
        OPEN('.');

        private char symbol;

        private FrameStatus(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }
    }

    protected FrameStatus frameStatus;

    Frame(FrameStatus frameStatus) {
        this.frameStatus = frameStatus;
    }

    abstract void initializeFrame();

    abstract void startFrame();
}
