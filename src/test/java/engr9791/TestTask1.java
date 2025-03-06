package engr9791;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing TASK 1 - StringList class")
class TestTask1 {

    @Order(1)
    @ParameterizedTest
    @DisplayName("Testing add(String element) function")
    @ValueSource(strings = {"a", "b", "c"})
    void testAdd(String element) {
        StringList list = new StringList();
        list.add(element);
        assertEquals("Printing List: [" + element + "]", list.toString());
    }

    @Order(2)
    @Test
    @DisplayName("Testing add(String element) with grow() inside")
    void testAddGrow() {
        StringList list = new StringList();
        String[] element = {"a", "b", "c", "d", "e"};
        String listTest;
        for (int i = 0; i < element.length; i++) {
            list.add(element[i]);
        }

        listTest = element[0];
        for (int i = 1; i < element.length; i++) {
            listTest += ", " + element[i];
        }

        assertEquals("Printing List: [" + listTest + "]", list.toString());
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("Testing IllegalArgumentException of get() function")
    @ValueSource(ints = {-1,-9,5,6,99})
    void testGetThrow(int index) {
        StringList list = new StringList();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.get(index));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("Testing get() function")
    @ValueSource(ints = {0,1,2})
    void testGet(int index) {
        StringList list = new StringList();
        String[] testList = {"a", "b", "c"};
        list.add("a");
        list.add("b");
        list.add("c");
        assertEquals(testList[index], list.get(index));
    }

    @Order(5)
    @Test
    @DisplayName("Testing toString() function with size = 0")
    void testToStringSize0() {
        StringList list = new StringList();
        assertEquals("List is empty: []", list.toString());
    }

}
