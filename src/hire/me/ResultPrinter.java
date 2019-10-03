package hire.me;

public class ResultPrinter {
    public static void resultPrinter(int timeSum, int countedRows) {
        if(countedRows != 0) {
            System.out.println("time sum = " + timeSum / countedRows);
        } else {
            System.out.println("-");
        }
    }
}
