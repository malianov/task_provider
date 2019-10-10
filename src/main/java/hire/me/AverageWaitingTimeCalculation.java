package hire.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;

import static hire.me.ResultPrinter.resultPrinter;

public class AverageWaitingTimeCalculation {
    AtomicInteger rowNumber = new AtomicInteger();
    ArrayList<Row_C> c_data_rows = new ArrayList<>();

    public void averageWaitingTimeCalculation(String[] enteredRows) {
        Arrays.stream(enteredRows)
                .forEach(i -> {
                    if ('C' == Splitter.rowType(i)) {
                        rowNumber.getAndIncrement();
                        Row_C row = new Row_C(i, rowNumber);
                        c_data_rows.add(row);
                    } else if ('D' == Splitter.rowType(i)) {
                        Row_D row = new Row_D(i, rowNumber);
                        OptionalDouble averageWaitingTime = c_data_rows.stream()
                                .limit(rowNumber.intValue())
                                .filter(rw -> Filter.serviceFilter(rw, row))
                                .filter(rw -> Filter.questionFilter(rw, row))
                                .filter(rw -> Filter.responseTypeFilter(rw, row))
                                .filter(rw -> Filter.dateFilter(rw.getDate(), row.getStart_date(), row.getEnd_date()))
                                .mapToInt(Row_C::getTime)
                                .average();

                        resultPrinter(averageWaitingTime);
                    } else {
                        System.out.println("It is wrong input " + rowNumber);
                    }
                });
    }
}