package hire.me;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static hire.me.ResultPrinter.resultPrinter;


public class Main {
    public static void main(String[] args) {
        final int[] timeSum = {0};
        final int[] countedRows = {0};
        AtomicInteger counter = new AtomicInteger();

        ArrayList<Row_C> c_data_rows = new ArrayList<>();
        ArrayList<Row_D> d_data_rows = new ArrayList<>();

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
                        counter.getAndIncrement();
                        Row_C row = new Row_C(i, counter);
                        c_data_rows.add(row);
                    } else if ('D' == Splitter.rowType(i)) {
                        Row_D row = new Row_D(i, counter);
                            for (int k = 0; k < counter.intValue(); k++) {
                                if (Filter.questionFilter(k, c_data_rows, row)) {
                                    if (Filter.serviceFilter(k, c_data_rows, row)) {
                                        if (Filter.responseTypeFilter(k, c_data_rows, row)) {
                                            if (Filter.dateFilter(c_data_rows.get(k).getDate(), row.getStart_date(), row.getEnd_date())) {
                                                timeSum[0] += c_data_rows.get(k).getTime();
                                                ++countedRows[0];
                                            }
                                        }
                                    }
                                }
                            }
                            resultPrinter(timeSum[0], countedRows[0]);

                            timeSum[0] = 0;
                            countedRows[0] = 0;
                    } else {
                        System.out.println("It is smth unpredictable " + counter);
                    }
                });

        /*for (int i = 0; i < d_data_rows.size(); i++) {
            for (int k = 0; k < d_data_rows.get(i).getRowNumber(); k++) {

                if (Filter.questionFilter(i, k, c_data_rows, d_data_rows)) {
                    if (Filter.serviceFilter(i, k, c_data_rows, d_data_rows)) {
                        if (Filter.responseTypeFilter(i, k, c_data_rows, d_data_rows)) {
                            questionDate = c_data_rows.get(k).getDate();
                            queryStartDate = d_data_rows.get(i).getStart_date();
                            queryEndDate = d_data_rows.get(i).getEnd_date();

                            if (Filter.dateFilter(questionDate, queryStartDate, queryEndDate)) {
                                timeSum += c_data_rows.get(k).getTime();
                                ++countedRows;
                            }
                        }
                    }
                }
            }
            resultPrinter(timeSum, countedRows);

            timeSum = 0;
            countedRows = 0;
        }*/
    }
}