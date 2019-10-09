package hire.me;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filter {
    public static boolean dateFilter(LocalDate questionDate, LocalDate queryStartDate, LocalDate queryEndDate) {
        return (questionDate.isAfter(queryStartDate) & questionDate.isBefore(queryEndDate)) ||
                questionDate.isEqual(queryStartDate) | questionDate.isEqual(queryEndDate);
    }

    public static boolean responseTypeFilter(int k, ArrayList<Row_C> c_data_rows, Row row) {
        return row.getResponse_type().equals(c_data_rows.get(k).getResponse_type());
    }

    public static boolean serviceFilter(int k, ArrayList<Row_C> c_data_rows, Row row) {
        if(row.getService_id() == 0) {
            return true;
        }
        if (row.getVariation_id() != 0) {
            return row.getService_id() == c_data_rows.get(k).getService_id() &&
                    row.getVariation_id() == c_data_rows.get(k).getVariation_id();
        }
        if (row.getVariation_id() == 0) {
            return row.getService_id() == c_data_rows.get(k).getService_id();
        }
        return false;
    }

    public static boolean questionFilter(int k, ArrayList<Row_C> c_data_rows, Row row) {
        if(row.getQuestion_type_id() == 0) {
            return true;
        }
        if (row.getCategory_id() != 0 & row.getSub_category_id() != 0) {
            return row.getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id() &&
                    row.getCategory_id()  == c_data_rows.get(k).getCategory_id()  &&
                    row.getSub_category_id() == c_data_rows.get(k).getSub_category_id();
        }
        if (row.getCategory_id()  != 0 & row.getSub_category_id() == 0) {
            return row.getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id() &&
                    row.getCategory_id()  == c_data_rows.get(k).getCategory_id() ;
        }
        if (row.getCategory_id()  == 0) {
            return row.getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id();
        }
        return false;
    }
}
