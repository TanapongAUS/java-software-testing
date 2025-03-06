package engr9791;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing TASK 4 - StringList class")
class TestTask4 {

    @Order(1)
    @ParameterizedTest
    @DisplayName("Testing lastIndexOf() function including returning of index & -1")
    @ValueSource(ints = {1, 9, 99})
    void testLastIndexOf(int capacity) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_text";
            list.add(i, text);
        }

        assertAll(
                () -> assertEquals(capacity - 1, list.lastIndexOf("test_text")),
                () -> assertEquals(- 1, list.lastIndexOf("wrong_text"))
        );

    }

    @Order(2)
    @ParameterizedTest
    @DisplayName("Testing subList(), fromIdx & toIdx are equal condition")
    @ValueSource(ints = {0, 1, 9, 99})
    void testSubListEqual(int capacity) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        assertEquals("List is empty: []", list.subList(capacity, capacity).toString());
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("Testing throw subList(), with the condition of indices out of order")
    @CsvSource({"0,-1,-2", "1,1,0", "5,3,2", "9,11,10"})
    void testSubListThrowOrder(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.subList(fromIndex, toIndex));
        assertEquals("Indices out of order", exception.getMessage());
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("Testing throw subList(), with the condition of invalid index")
    @CsvSource({"9,-1,9", "9,9,10", "1,-2,-1", "9,5,10"})
    void testSubListThrowIndex(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.subList(fromIndex, toIndex));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Order(5)
    @ParameterizedTest
    @DisplayName("Testing subList(int fromIndex, int toIndex) function")
    @CsvSource({"9,0,1", "1,0,1", "9,8,9", "9,1,8"})
    void testSubList(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);
        StringList testList = new StringList(toIndex - fromIndex);

        // Adding element into the test list regarding the capacity, including the test list
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);

            if (i >= fromIndex && i < toIndex) {
                testList.add(text);
            }
        }

        assertEquals(testList.toString(), list.subList(fromIndex, toIndex).toString());

    }

    @Order(6)
    @ParameterizedTest
    @DisplayName("Testing removeRange(), when fromIndex & toIndex are equal")
    @CsvSource({"9,0,0", "1,1,1", "9,9,9", "9,5,5"})
    void testRemoveRangeEqual(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);
        StringList testList = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
            testList.add(i, text);
        }

        list.removeRange(fromIndex, toIndex);
        assertEquals(testList.toString(), list.toString());
    }

    @Order(7)
    @ParameterizedTest
    @DisplayName("Testing throw removeRange(), when fromIndex > toIndex")
    @CsvSource({"0,-1,-2", "1,1,0", "5,3,2", "9,11,10"})
    void testRemoveRangeThrowOrder(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.removeRange(fromIndex, toIndex));
        assertEquals("Indices out of order", exception.getMessage());
    }

    @Order(8)
    @ParameterizedTest
    @DisplayName("Testing throw removeRange(), with the condition of invalid index")
    @CsvSource({"9,-1,9", "9,9,10", "1,-2,-1", "9,5,10"})
    void testRemoveRangeThrowIndex(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);

        // Adding element into the test list regarding the capacity
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> list.removeRange(fromIndex, toIndex));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Order(9)
    @ParameterizedTest
    @DisplayName("Testing removeRange(int fromIndex, int toIndex) function")
    @CsvSource({"9,0,1", "1,0,1", "9,8,9", "9,1,8"})
    void testRemoveRange(int capacity, int fromIndex, int toIndex) {
        StringList list = new StringList(capacity);
        StringList testList = new StringList(toIndex - fromIndex);

        // Adding element into the test list regarding the capacity, including the test list
        for (int i = 0; i < capacity; i++) {
            String text = "test_" + i;
            list.add(i, text);

            if (i < fromIndex || i >= toIndex) {
                testList.add(text);
            }
        }

        list.removeRange(fromIndex, toIndex);
        assertAll(
                () -> assertEquals(testList.toString(), list.toString()),
                () -> assertEquals(testList.size(), list.size())
        );

    }

    @Order(10)
    @Test
    @DisplayName("Testing equals() function, return both true and false")
    void testEquals() {
        StringList list = new StringList(3); // {"a", "b", "c"}
        StringList wrongSizeList = new StringList(4); // {"a", "b", "c", "d"}
        StringList wrongOrderList = new StringList(3); // {"c", "b", "a"}
        StringList wrongElementList = new StringList(3); // {"x", "y", "z"}
        StringList correctList = new StringList(3); // {"a", "b", "c"}

        // Adding elements into list and correctList
        String[] rightList = {"a", "b", "c"};
        for (int i = 0; i < rightList.length; i++) {
            list.add(rightList[i]);
            correctList.add(rightList[i]);
        }

        // Adding elements into wrongSizeList
        String[] wrongSize = {"a", "b", "c", "d"};
        for (int i = 0; i < wrongSize.length; i++) {
            wrongSizeList.add(wrongSize[i]);
        }

        // Adding elements into wrongOrderList
        String[] wrongOrder = {"c", "b", "a"};
        for (int i = 0; i < wrongOrder.length; i++) {
            wrongOrderList.add(wrongOrder[i]);
        }

        // Adding elements into wrongElementList
        String[] wrongElement = {"x", "y", "z"};
        for (int i = 0; i < wrongElement.length; i++) {
            wrongElementList.add(wrongElement[i]);
        }

        StringList cloneList = list;
        assertAll(
                () -> assertFalse(list.equals(null)),
                () -> assertFalse(list.equals(wrongSizeList)),
                () -> assertFalse(list.equals(wrongOrderList)),
                () -> assertFalse(list.equals(wrongElementList)),
                () -> assertTrue(list.equals(correctList)),
                () -> assertTrue(list.equals(cloneList)) // Compare object this
        );
    }

    @Order(11)
    @Test
    @DisplayName("Testing toArray() function")
    void toArray() {
        StringList list = new StringList(3); // {"a", "b", "c"}

        // Adding elements into list and correctList
        String[] testArray = {"a", "b", "c"};
        for (int i = 0; i < testArray.length; i++) {
            list.add(testArray[i]);
        }

        assertTrue(Arrays.equals(testArray, list.toArray()));
    }

}
