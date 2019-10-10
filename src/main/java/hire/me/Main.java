package hire.me;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rowsQuantity;
        System.out.println("Input:");

        Scanner scanner = new Scanner(System.in);
        rowsQuantity = Integer.parseInt(scanner.nextLine());

        String[] enteredRows = new String[rowsQuantity];

        Arrays.setAll(enteredRows, v -> scanner.nextLine());

        AverageWaitingTimeCalculation avgWaitingTime = new AverageWaitingTimeCalculation();

        System.out.println("Output:");

        avgWaitingTime.averageWaitingTimeCalculation(enteredRows);
    }
}