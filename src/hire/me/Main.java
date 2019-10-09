package hire.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;

import static hire.me.ResultPrinter.resultPrinter;

public class Main {
    public static void main(String[] args) {
        AtomicInteger rowNumber = new AtomicInteger();
        ArrayList<Row_C> c_data_rows = new ArrayList<>();

        String[] data_rows = {
                "C 1.1 8.15.1 P 15.10.2012 83",
                "C 1 10.1 P 01.12.2012 65",
                "C 1.1 5.5.1 P 01.11.2012 117",
                "D 1.1 8 P 01.01.2012-01.12.2012",
                "C 3 10.2 N 02.10.2012 100",
                "D 1 * P 8.10.2012-20.11.2012",
                "D 3 10 P 01.12.2012"
        };

        Arrays.stream(data_rows)
                .forEach(i -> {
                    if ('C' == Splitter.rowType(i)) {
                        rowNumber.getAndIncrement();
                        Row_C row = new Row_C(i, rowNumber);
                        c_data_rows.add(row);
                    } else if ('D' == Splitter.rowType(i)) {
                        Row_D row = new Row_D(i, rowNumber);
                        OptionalDouble averageWaitingTime = c_data_rows.stream()
                                .limit(rowNumber.intValue())
                                .filter(rw -> Filter.dateFilter(rw.getDate(), row.getStart_date(), row.getEnd_date()))
                                .filter(rw -> Filter.responseTypeFilter(rw, row))
                                .filter(rw -> Filter.questionFilter(rw, row))
                                .filter(rw -> Filter.serviceFilter(rw, row))
                                .mapToInt(Row_C::getTime)
                                .average();

                        resultPrinter(averageWaitingTime);

                    } else {
                        System.out.println("It is smth unpredictable " + rowNumber);
                    }
                });
    }
}