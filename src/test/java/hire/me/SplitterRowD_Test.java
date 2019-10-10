package hire.me;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hire.me.Splitter.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitterRowD_Test {
    AtomicInteger rowNumber = new AtomicInteger(10);
    String row_D = "D 1.1 8.2.2 P 01.01.2012-01.12.2012";
    String row_X = "X 1.1 8 P 01.01.2012-01.12.2012";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    @DisplayName("Get correct \"row_type\" from row type_D")
    public void TestGetRowTypeFromRowD() {
        assertEquals('D', rowType(row_D), "The \"row_type\" extracted from row type_D is incorrect");
    }

    @Test
    @DisplayName("Get incorrect \"row_type\" from row type_X")
    public void TestGetRowTypeFromRowX() {
        assertNotEquals('D', rowType(row_X), "The \"row_type\" extracted from row type_X is incorrect");
    }

    @Test
    @DisplayName("Get correct \"value of fields\" from row type_D")
    public void TestRowSplitter() {
        assertAll(row_D,
                () -> assertEquals('D', rowType(row_D), "Expected D"),
                () -> {
                    String[] rowDSplitted = rowSplitter(row_D);
                    assertAll(row_D,
                            () -> {
                                assertEquals(2, serviceSplitter(rowDSplitted).length, "Expected length 2");
                                assertAll(row_D,
                                        () -> assertEquals("1", serviceSplitter(rowDSplitted)[0], "Expected 1"),
                                        () -> assertEquals("1", serviceSplitter(rowDSplitted)[1], "Expected 1"));
                            }/*,
                            () -> {
                                assertEquals(1, serviceSplitter(rowDSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("1", serviceSplitter(rowDSplitted)[0]));
                            }*/,
                            () -> {
                                assertEquals(3, questionSplitter(rowDSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("8", questionSplitter(rowDSplitted)[0]),
                                        () -> assertEquals("2", questionSplitter(rowDSplitted)[1]),
                                        () -> assertEquals("2", questionSplitter(rowDSplitted)[2]));
                            }/*,
                            () -> {
                                assertEquals(2, questionSplitter(rowDSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("8", questionSplitter(rowDSplitted)[0]),
                                        () -> assertEquals("2", questionSplitter(rowDSplitted)[1]));
                            },
                            () -> {
                                assertEquals(1, questionSplitter(rowDSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("8", questionSplitter(rowDSplitted)[0]));
                            }*/
                    );
                }
        );
    }
}
