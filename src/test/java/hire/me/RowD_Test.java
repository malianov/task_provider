package hire.me;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowD_Test {

    AtomicInteger rowNumber = new AtomicInteger(10);
    String row = "D 1.1 8 P 01.01.2012-01.12.2012";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    Row_D row_d = new Row_D(row, rowNumber);

    @Test
    @DisplayName("Get correct \"service_id\" from row type_D")
    public void TestGetServiceIdFromRowC() {
        assertEquals(1, row_d.getService_id(), "The \"service_id\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"variation_id\" from row type_D")
    public void TestGetVariationIdFromRowC() {
        assertEquals(1, row_d.getVariation_id(), "The \"variation_id\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"question_type_id\" from row type_D")
    public void TestGetQuestionTypeIdFromRowC() {
        assertEquals(8, row_d.getQuestion_type_id(), "The \"question_type_id\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"category_id\" from row type_D")
    public void TestGetCategoryIdFromRowC() {
        assertEquals(0, row_d.getCategory_id(), "The \"category_id\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"sub-category_id\" from row type_D")
    public void TestGetSubCategoryIdFromRowC() {
        assertEquals(0, row_d.getSub_category_id(), "The \"sub-category_id\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"start_date\" from row type_D")
    public void TestGettingStartDateFromRowD() {
        assertEquals(LocalDate.parse("01.01.2012", formatter), row_d.getStart_date(), "The start_date extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get correct \"end_date\" from row type_D")
    public void TestGettingEndDateFromRowD() {
        assertEquals(LocalDate.parse("01.12.2012", formatter), row_d.getEnd_date(), "The end_date extracted from row type_D is incorrect");
    }
}
