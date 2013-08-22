package bowling;

import java.util.Scanner;

public class InputOutputConsole implements InputOutputInterface {
    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void print(Object string) {
        System.out.println(string);
    }


}
