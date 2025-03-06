package engr9791;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing TASK 2 - StringList class")
class TestTask2 {

    @Order(1)
    @Test
    @DisplayName("Testing contains() function both true / false")
    void testContains() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");

        assertAll(
                () -> assertTrue(list.contains("a")),
                () -> assertTrue(list.contains("b")),
                () -> assertFalse(list.contains("c")),
                () -> assertFalse(list.contains("d"))
        );
    }

    @Order(2)
    @Test
    @DisplayName("Testing indexOf() function both return actual index, otherwise -1")
    void testIndexOf() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");

        assertAll(
                () -> assertEquals(0, list.indexOf("a")),
                () -> assertEquals(1, list.indexOf("b")),
                () -> assertEquals(-1, list.indexOf("z"))
        );
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("Testing IllegalArgumentException of set() function")
    @ValueSource(ints = {-1,2})
    void testSetThrow(int index) {
        StringList list = new StringList();
        list.add("a");
        list.add("b");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.set(index, "z"));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @Order(4)
    @Test
    @DisplayName("Testing set() function")
    void testSet() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");

        assertAll(
                () -> assertEquals("a", list.set(0, "c")),
                () -> assertEquals("b", list.set(1, "d")),
                () -> assertEquals("c", list.get(0)),
                () -> assertEquals("d", list.get(1))
        );
    }

    @Order(5)
    @ParameterizedTest
    @DisplayName("Testing size() function")
    @ValueSource(ints = {1,4,9,99})
    void testSize(int capacity) {
        StringList list = new StringList();
        for (int i = 0 ; i < capacity; i ++) {
            list.add("test_text");
        }

        assertEquals(capacity, list.size());
    }

}
