package engr9791;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @ParameterizedTest
    @DisplayName("Testing negative value for factorial function")
    @ValueSource(ints = {-1,-9,-99})
    void facThrowNegative(int n) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        assertEquals("java.lang.IllegalArgumentException: Factorial is undefined for negative integers", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Testing input value over than 12 for factorial function")
    @ValueSource(ints = {13,99,999})
    void facthrowOver12(int n) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        assertEquals("java.lang.IllegalArgumentException: Factorial(" + n + ") is too large - overflow occurs!", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Testing the correctness of factorial function")
    @CsvSource({"0,1", "1,1", "9,362880", "12,479001600"})
    void factorial(int n, int expected) {
        assertEquals(expected, Factorial.factorial(n));
    }
}