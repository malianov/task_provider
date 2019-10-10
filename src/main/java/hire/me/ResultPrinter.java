package hire.me;

import java.util.OptionalDouble;

public class ResultPrinter {
    public static void resultPrinter(OptionalDouble value) {
        if(value.isPresent()) {
            System.out.println( (int) value.getAsDouble());
        } else {
            System.out.println("-");
        }
    }
}
