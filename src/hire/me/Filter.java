package hire.me;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filter {
    public static boolean dateFilter(LocalDate questionDate, LocalDate queryStartDate, LocalDate queryEndDate) {
        return (questionDate.isAfter(queryStartDate) & questionDate.isBefore(queryEndDate)) ||
                questionDate.isEqual(queryStartDate) | questionDate.isEqual(queryEndDate);
    }

    public static boolean responseTypeFilter(int i, int k, ArrayList<Row_C> c_data_rows, ArrayList<Row_D> d_data_rows) {
        return d_data_rows.get(i).getResponse_type().equals(c_data_rows.get(k).getResponse_type());
    }

    public static boolean serviceFilter(int i, int k, ArrayList<Row_C> c_data_rows, ArrayList<Row_D> d_data_rows) {
        if(d_data_rows.get(i).getService_id() == 0) {
            return true;
        }
        if (d_data_rows.get(i).getVariation_id() != 0) {
            return d_data_rows.get(i).getService_id() == c_data_rows.get(k).getService_id() &&
                    d_data_rows.get(i).getVariation_id() == c_data_rows.get(k).getVariation_id();
        }
        if (d_data_rows.get(i).getVariation_id() == 0) {
            return d_data_rows.get(i).getService_id() == c_data_rows.get(k).getService_id();
        }
        return false;
    }

    public static boolean questionFilter(int i, int k, ArrayList<Row_C> c_data_rows, ArrayList<Row_D> d_data_rows) {
        if(d_data_rows.get(i).getQuestion_type_id() == 0) {
            return true;
        }
        if (d_data_rows.get(i).getCategory_id() != 0 & d_data_rows.get(i).getSub_category_id() != 0) {
            return d_data_rows.get(i).getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id() &&
                    d_data_rows.get(i).getCategory_id()  == c_data_rows.get(k).getCategory_id()  &&
                    d_data_rows.get(i).getSub_category_id() == c_data_rows.get(k).getSub_category_id();
        }
        if (d_data_rows.get(i).getCategory_id()  != 0 & d_data_rows.get(i).getSub_category_id() == 0) {
            return d_data_rows.get(i).getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id() &&
                    d_data_rows.get(i).getCategory_id()  == c_data_rows.get(k).getCategory_id() ;
        }
        if (d_data_rows.get(i).getCategory_id()  == 0) {
            return d_data_rows.get(i).getQuestion_type_id() == c_data_rows.get(k).getQuestion_type_id();
        }
        return false;
    }
}
