package engr9791;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BmiCalculatorTest {

    @ParameterizedTest
    @DisplayName("Test getWeight() and getHeight() in constructor")
    @CsvSource({
            "70.4, 174.5",
            "80.2, 180.2",
            "60.9, 162.7"
    })
    void testConstructor(double weight, double height) {
        BmiCalculator bmiCalculator = new BmiCalculator(weight, height);

        assertEquals(weight, bmiCalculator.weight());
        assertEquals(height, bmiCalculator.height());
    }

    @ParameterizedTest
    @DisplayName("Test calculateBMI(), and check for the correct BMI and type of weight")
    @CsvSource({
            "45, 160, 17.6, Underweight",
            "70, 170, 24.2, Normal",
            "85, 180, 26.2, Overweight",
            "120, 165, 44.1, Obese"
    })
    void calculateBMI(double weight, double height, double bmi, String expectedRange) {
        BmiCalculator bmiCalculator = new BmiCalculator(weight, height);
        String actualRange = bmiCalculator.calculateBMI();

        assertEquals("Your BMI is " + bmi + ", which means you are in the "
                + expectedRange + " range."
                , actualRange);
    }
}