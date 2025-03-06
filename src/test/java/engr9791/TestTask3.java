package engr9791;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing TASK 3 - StringList class")
class TestTask3 {

    @Order(1)
    @ParameterizedTest
    @DisplayName("Testing IllegalArgumentException of add(int index, String element) function")
    @ValueSource(ints = {-1,2})
    void testAddThrow2(int index) {
        StringList list = new StringList(1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.add(index, "test_text"));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @Order(2)
    @Test
    @DisplayName("Testing add(int index, String element) function including grow()")
    void testAdd2() {
        StringList list = new StringList(1);
        String[] element = {"a", "b", "c", "d", "e"};
        String listTest;

        // Check grow() & add()
        for (int i = 0; i < element.length; i++) {
            list.add(0, element[i]);
        }

        // Create the test String
        listTest = element[element.length - 1];
        for (int i = element.length - 2; i >= 0; i--) {
            listTest += ", " + element[i];
        }

        assertEquals("Printing List: [" + listTest + "]", list.toString());

    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("Testing IllegalArgumentException, invalid index of remove(int index) function")
    @CsvSource({"1, -1", "1, 1", "1, 2"})
    void testRemoveThrow(int capacity, int index) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.remove(index));
        assertEquals("Invalid index: " + index, exception.getMessage());

    }

    @Order(4)
    @Test
    @DisplayName("Testing remove(String element) function")
    void testRemove() {
        StringList list = new StringList(1);
        String[] testList = {"test_0", "test_1", "test_2", "test_3", "test_4"};

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < testList.length; i++) {
            list.add(i, testList[i]);
        }

        assertAll(
                () -> assertTrue(list.remove("test_0")),
                () -> assertTrue(list.remove("test_2")),
                () -> assertTrue(list.remove("test_4")),
                () -> assertFalse(list.remove("test_5"))
        );

    }

    @Order(5)
    @ParameterizedTest
    @DisplayName("Testing remove(int index) function")
    @CsvSource({"3, 0", "4, 1", "5, 4"})
    void testRemove2(int capacity, int index) {
        StringList list = new StringList(capacity);
        String testString = "";

        // Adding element into the test list regarding the capacity, including the test string
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);

            if (i == index) {
                continue;
            }
            if (i == 0) {
                testString += text;
            } else {
                if (index == 0 && i == 1) {
                    testString += text;
                } else {
                    testString += ", " + text;
                }
            }
        }

        // Remove
        list.remove(index);

        String finalTestString = testString;
        assertAll(
                () -> assertEquals(capacity - 1, list.size()),
                () -> assertEquals("Printing List: [" + finalTestString + "]", list.toString())
        );
    }

    @Order(6)
    @ParameterizedTest
    @DisplayName("Testing clear() function")
    @ValueSource(ints = {0, 1, 9, 99})
    void clear(int capacity) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        list.clear();
        assertEquals(0, list.size());
    }

    @Order(7)
    @ParameterizedTest
    @DisplayName("Testing isEmpty() function")
    @ValueSource(ints = {1, 9, 99})
    void isEmpty(int capacity) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }
        assertFalse(list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty());
    }

}
