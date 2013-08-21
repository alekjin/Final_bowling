package bowling;

import java.util.Scanner;

public class ExecuteConsole implements ExecuteStrategy {
    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();
        return order;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        return order;
    }

    public void print(Object string) {
        System.out.println(string);
    }


}
