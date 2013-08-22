package bowling;

public class PinStrategyAuto implements PinStrategy {
    @Override
    public int getNumofPins() {
        return (int) (Math.random() * 11);
    }
}
