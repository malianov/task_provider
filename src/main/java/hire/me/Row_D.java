package hire.me;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static hire.me.Splitter.*;

public class Row_D extends Row {
    private LocalDate start_date;
    private LocalDate end_date;

    public Row_D(String data_rows, AtomicInteger counter) {
        setRowNumber(counter);
        if(serviceSplitter(rowSplitter(data_rows))[0].equals("*")) {
            setService_id(0);
        } else {
            setService_id(parseInt(serviceSplitter(rowSplitter(data_rows))[0]));
        }
        if(serviceSplitter(rowSplitter(data_rows)).length > 1) {
            setVariation_id(parseInt(serviceSplitter(rowSplitter(data_rows))[1]));
        }
        if(questionSplitter(rowSplitter(data_rows))[0].equals("*")) {
            setQuestion_type_id(0);
        } else {
            setQuestion_type_id(parseInt(questionSplitter(rowSplitter(data_rows))[0]));
        }
        if(questionSplitter(rowSplitter(data_rows)).length > 1) {
            setCategory_id(parseInt(questionSplitter(rowSplitter(data_rows))[1]));
        }

        if(questionSplitter(rowSplitter(data_rows)).length > 2) {
            setSub_category_id(parseInt(questionSplitter(rowSplitter(data_rows))[2]));
        }
        setResponse_type(rowSplitter(data_rows)[3]);
        setStart_date(dateSplitter(rowSplitter(data_rows)[4])[0]);
        setEnd_date(dateSplitter(rowSplitter(data_rows)[4])[1]);
    }

    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(String date) {
        this.start_date = LocalDate.parse(date, formatter);
    }

    public LocalDate getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String date) {
        this.end_date = LocalDate.parse(date, formatter);
    }
}
