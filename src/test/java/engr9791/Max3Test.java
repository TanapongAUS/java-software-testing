package engr9791;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Max3Test {
    Max3 max3test = new Max3();
    @Test
    void max3() { assertEquals(9, max3test.max3(9,8,7)); }

    @Test
    void max3_num2() {
        assertEquals(10, max3test.max3(8,10,9));
    }

    @Test
    void max3_num3() {
        assertEquals(11, max3test.max3(9,10,11));
    }

    @Test
    void max3_num1Minus() { assertEquals(-3, max3test.max3(-3,-4,-5)); }

    @Test
    void max3_num2Minus() {
        assertEquals(-2, max3test.max3(-4,-2,-3));
    }

    @Test
    void max3_num3Minus() {
        assertEquals(-1, max3test.max3(-3,-2,-1));
    }
}