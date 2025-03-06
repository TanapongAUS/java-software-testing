package engr9791;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing cup class")
class CupTest {

    @ParameterizedTest
    @DisplayName("Testing negative capacity for constructor")
    @ValueSource(ints = {-1,-9,-99,-999})
    void throwCupConstructor(int capacity) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cup(capacity));
        assertEquals("Capacity must be positive", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Testing fill function() with negative int amount")
    @ValueSource(ints = {-1,-9,-99})
    void fillNegative(int amount) {
        Cup cup = new Cup(1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cup.fill(amount));
        assertEquals("Amount must be non-negative", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Testing fill function() with currentVolume + amount > capacity")
    @CsvSource({"1, 2", "99, 101", "599, 600"})
    void fillOver(int capacity, int amount) {
        Cup cup = new Cup(capacity);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cup.fill(amount));
        assertEquals("Exceeds cup capacity", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Testing function() empty the cup, currentVolume = 0")
    @CsvSource({"9, 9", "100, 10", "999, 888"})
    void empty(int capacity, int amount) {
        Cup cup = new Cup(capacity);
        cup.fill(amount);
        cup.empty();

        assertEquals(0, cup.getCurrentVolume(), "Cup must be equal to 0 after calling empty()");
    }

    @ParameterizedTest
    @DisplayName("Get the capacity volume of the cup")
    @ValueSource (ints = {1,9,99,999})
    void getCapacity(int capacity) {
        Cup cup = new Cup(capacity);
        assertEquals(capacity, cup.getCapacity());
    }

    @ParameterizedTest
    @DisplayName("Get the current volume of the cup")
    @CsvSource({"1,1", "9,1", "999,99"})
    void getCurrentVolume(int capacity, int amount) {
        Cup cup = new Cup(capacity);
        cup.fill(amount);
        assertEquals(amount, cup.getCurrentVolume());
    }

    @ParameterizedTest
    @DisplayName("Check true/false with isEmpty()")
    @ValueSource (ints = {0, 1, 9, 99})
    void isEmptyTrue(int amount) {
        Cup cup = new Cup(99);
        cup.fill(amount);

        if (amount == 0) {
            assertTrue(cup.isEmpty());
        } else {
            assertFalse(cup.isEmpty());
        }
    }

    @ParameterizedTest
    @DisplayName("Check true/false with isFull()")
    @CsvSource({"1,1", "9,9", "99,98", "111,55"})
    void isFull(int capacity, int amount) {
        Cup cup = new Cup(capacity);
        cup.fill(amount);

        if (capacity == amount){
            assertTrue(cup.isFull());
        } else {
            assertFalse(cup.isFull());
        }
    }
}