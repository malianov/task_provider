package hire.me;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RowC_Test {

    AtomicInteger rowNumber = new AtomicInteger(10);
    String row = "C 1.1 8.15.1 P 15.10.2012 83";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    Row_C row_c = new Row_C(row, rowNumber);

    @Test
    @DisplayName("Get correct \"service_id\" from row type_C")
    public void TestGetServiceIdFromRowC() {
        assertEquals(1, row_c.getService_id(), "The \"service_id\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"variation_id\" from row type_C")
    public void TestGetVariationIdFromRowC() {
        assertEquals(1, row_c.getVariation_id(), "The \"variation_id\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"question_type_id\" from row type_C")
    public void TestGetQuestionTypeIdFromRowC() {
        assertEquals(8, row_c.getQuestion_type_id(), "The \"question_type_id\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"category_id\" from row type_C")
    public void TestGetCategoryIdFromRowC() {
        assertEquals(1, row_c.getVariation_id(), "The \"category_id\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"sub-category_id\" from row type_C")
    public void TestGetSubCategoryIdFromRowC() {
        assertEquals(1, row_c.getSub_category_id(), "The \"sub-category_id\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"time\" from row type_C")
    public void TestGettingWaitingTimeFromRowC() {
        assertEquals(83, row_c.getTime(), "The waiting \"time\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get correct \"date\" from row type_C")
    public void TestGettingDateFromRowC() {
        assertEquals(LocalDate.parse("15.10.2012", formatter), row_c.getDate(), "The \"date\" extracted from row type_C is incorrect");
    }
}
