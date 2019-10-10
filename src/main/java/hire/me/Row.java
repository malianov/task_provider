package hire.me;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Row {

    private int rowNumber;
    private int category_id;
    private int sub_category_id;
    private String response_type;
    private int service_id;
    private int variation_id;
    private int question_type_id;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public int getRowNumber() {
        return rowNumber;
    }
    public void setRowNumber(AtomicInteger rowNumber) {
        this.rowNumber = rowNumber.intValue();
    }

    public int getService_id() {
        return service_id;
    }
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getVariation_id() {
        return variation_id;
    }
    public void setVariation_id(int variation_id) {
        this.variation_id = variation_id;
    }

    public int getQuestion_type_id() {
        return question_type_id;
    }
    public void setQuestion_type_id(int question_type_id) {
        this.question_type_id = question_type_id;
    }

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSub_category_id() {
        return sub_category_id;
    }
    public void setSub_category_id(int sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getResponse_type() {
        return response_type;
    }
    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }
}
