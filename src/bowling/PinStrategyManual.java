package bowling;

public class PinStrategyManual implements PinStrategy {
    InputOutputInterface InputOutputInterface = new InputOutputConsole();

    @Override
    public int getNumofPins() {
        return InputOutputInterface.inputInt();
    }
}
