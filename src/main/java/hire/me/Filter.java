package hire.me;

import java.time.LocalDate;

public class Filter {

    public static boolean dateFilter(LocalDate questionDate, LocalDate queryStartDate, LocalDate queryEndDate) {
        return (questionDate.isAfter(queryStartDate) & questionDate.isBefore(queryEndDate)) ||
                questionDate.isEqual(queryStartDate) | questionDate.isEqual(queryEndDate);
    }

    public static boolean responseTypeFilter(Row_C c_data_row, Row row) {
        return row.getResponse_type().equals(c_data_row.getResponse_type());
    }

    public static boolean serviceFilter(Row_C c_data_row, Row row) {
        if(row.getService_id() == 0) {
            return true;
        }
        if (row.getVariation_id() != 0) {
            return row.getService_id() == c_data_row.getService_id() &&
                    row.getVariation_id() == c_data_row.getVariation_id();
        }
        if (row.getVariation_id() == 0) {
            return row.getService_id() == c_data_row.getService_id();
        }
        return false;
    }

    public static boolean questionFilter(Row_C c_data_row, Row row) {
        if(row.getQuestion_type_id() == 0) {
            return true;
        }
        if (row.getCategory_id() != 0 & row.getSub_category_id() != 0) {
            return row.getQuestion_type_id() == c_data_row.getQuestion_type_id() &&
                    row.getCategory_id()  == c_data_row.getCategory_id()  &&
                    row.getSub_category_id() == c_data_row.getSub_category_id();
        }
        if (row.getCategory_id()  != 0 & row.getSub_category_id() == 0) {
            return row.getQuestion_type_id() == c_data_row.getQuestion_type_id() &&
                    row.getCategory_id()  == c_data_row.getCategory_id() ;
        }
        if (row.getCategory_id()  == 0) {
            return row.getQuestion_type_id() == c_data_row.getQuestion_type_id();
        }
        return false;
    }
}
