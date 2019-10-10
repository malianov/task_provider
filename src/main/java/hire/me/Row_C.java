package hire.me;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static hire.me.Splitter.*;

public class Row_C extends Row {
    private LocalDate date;
    private int time;

    public Row_C(String dataRow, AtomicInteger counter) {
        setRowNumber(counter);

        setService_id(parseInt(serviceSplitter(rowSplitter(dataRow))[0]));

        if(serviceSplitter(rowSplitter(dataRow)).length > 1) {
            setVariation_id(parseInt(serviceSplitter(rowSplitter(dataRow))[1]));
        }

        setQuestion_type_id(parseInt(questionSplitter(rowSplitter(dataRow))[0]));

        if(questionSplitter(rowSplitter(dataRow)).length > 1) {
            setCategory_id(parseInt(questionSplitter(rowSplitter(dataRow))[1]));
        }

        if(questionSplitter(rowSplitter(dataRow)).length > 2) {
            setSub_category_id(parseInt(questionSplitter(rowSplitter(dataRow))[2]));
        }

        setResponse_type(rowSplitter(dataRow)[3]);
        setDate(rowSplitter(dataRow)[4]);
        setTime(parseInt(rowSplitter(dataRow)[5]));
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = LocalDate.parse(date, formatter);
    }
}
