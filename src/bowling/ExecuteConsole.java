package bowling;

import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteConsole {
    private PinStrategy pinStrategy = new PinStrategyManual();
    private ArrayList<Frame> frameList = new ArrayList<Frame>();
    private ArrayList<Score> scoreList = new ArrayList<Score>();

    ExecuteConsole() {

    }

    void execute() {
        initialize();

        while (true) {
        System.out.println("Welcome to Bowling Game!");

        System.out.println("Roll the first Ball!");

        Scanner scanner1 = new Scanner(System.in);
        int order1 = scanner1.nextInt();

        frameList.get(0).setFirstScore(order1);
        System.out.println(frameList.get(0).getFirstScore());

        System.out.println("Roll the second Ball!");

        Scanner scanner2 = new Scanner(System.in);
        int order2 = scanner2.nextInt();

        frameList.get(0).setSecondScore(order2);
        System.out.println(frameList.get(0).getSecondScore());
        }
    }

    void setPinStrategy(PinStrategy pinStrategy) {
        this.pinStrategy = pinStrategy;
    }

    int getPin(int pin) {
        return pinStrategy.getNumofPins(pin);
    }

    void initialize() {
        for (int i = 0 ; i < 9 ; i++)
            frameList.add(new NormalFrame());
        frameList.add(new LastFrame());

        for (int i = 0 ; i < 10 ; i++)
            scoreList.add(new Score());


    }


}
