import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void emptyString() {
        String input = "";
        Assertions.assertEquals(0, calculator.add(input));
    }

    @org.junit.jupiter.api.Test
    void addTwoPositiveNumbers() {
        String input = "0,1";
        Assertions.assertEquals(1, calculator.add(input));
    }
}