package hire.me;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import static hire.me.Splitter.*;
import static hire.me.Splitter.questionSplitter;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SplitterRowC_Test {
    AtomicInteger rowNumber = new AtomicInteger(10);
    String row_C = "C 1.1 8.15.1 P 15.10.2012 83";
    String row_X = "X 1.1 8.15.1 P 15.10.2012 83";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    @DisplayName("Get correct \"row_type\" from row type_C")
    public void TestGetRowTypeFromRowC() {
        assertEquals('C', rowType(row_C), "The \"row_type\" extracted from row type_C is incorrect");
    }

    @Test
    @DisplayName("Get incorrect \"row_type\" from row type_X")
    public void TestGetRowTypeFromRowX() {
        assertNotEquals('C', rowType(row_X), "The \"row_type\" extracted from row type_X is incorrect");
    }

    @Test
    @DisplayName("Get correct \"value of fields\" from row type_D")
    public void TestRowSplitter() {
        assertAll(row_C,
                () -> assertEquals('C', rowType(row_C), "Expected C"),
                () -> {
                    String[] rowCSplitted = rowSplitter(row_C);
                    assertAll(row_C,
                            () -> {
                                assertEquals(2, serviceSplitter(rowCSplitted).length, "Expected length 2");
                                assertAll(row_C,
                                        () -> assertEquals("1", serviceSplitter(rowCSplitted)[0], "Expected 1"),
                                        () -> assertEquals("1", serviceSplitter(rowCSplitted)[1], "Expected 1"));
                            }/*,
                            () -> {
                                assertEquals(1, serviceSplitter(rowDSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("1", serviceSplitter(rowDSplitted)[0]));
                            }*/,
                            () -> {
                                assertEquals(3, questionSplitter(rowCSplitted).length);
                                assertAll(row_C,
                                        () -> assertEquals("8", questionSplitter(rowCSplitted)[0]),
                                        () -> assertEquals("15", questionSplitter(rowCSplitted)[1]),
                                        () -> assertEquals("1", questionSplitter(rowCSplitted)[2]));
                            }/*,
                            () -> {
                                assertEquals(2, questionSplitter(rowCSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("8", questionSplitter(rowCSplitted)[0]),
                                        () -> assertEquals("2", questionSplitter(rowCSplitted)[1]));
                            },
                            () -> {
                                assertEquals(1, questionSplitter(rowCSplitted).length);
                                assertAll(row_D,
                                        () -> assertEquals("8", questionSplitter(rowCSplitted)[0]));
                            }*/
                    );
                }
        );
    }
}
