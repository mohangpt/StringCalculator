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

    @Test
    void addOnePositiveNumber() {
        String input = "1";
        Assertions.assertEquals(1, calculator.add(input));
    }

    @org.junit.jupiter.api.Test
    void addTwoPositiveNumbers() {
        String input = "0,1";
        Assertions.assertEquals(1, calculator.add(input));
    }

    @Test
    void addMultipleNumbers() {
        String input0 = "0,1,2";
        String input1 = "0,1,2,3";
        String input2 = "0,1,2,3,4";
        String input3 = "0,1,2,3,4,5";
        Assertions.assertEquals(3, calculator.add(input0));
        Assertions.assertEquals(6, calculator.add(input1));
        Assertions.assertEquals(10, calculator.add(input2));
        Assertions.assertEquals(15, calculator.add(input3));
    }

    @Test
    void addMultipleNumbersWithNewLine() {
        String input0 = "1\n2,3";
        Assertions.assertEquals(6, calculator.add(input0));
    }

    @Test
    void addWithCustomDelimiter() {
        String input = "//;\n1;2";
        Assertions.assertEquals(3, calculator.add(input));
    }

    @Test
    void addNegativeNumbers() {
        String input = "-1,0";
        try {
            calculator.add(input);
            fail("It did not failed at negative numbers!");
        }catch (Exception e){
            Assertions.assertEquals("negatives are not allowed", e.getMessage());
        }
    }

    @Test
    void addWithAvoidingNumbersMoreThan1000() {
        String input = "1,1001";
        Assertions.assertEquals(1, calculator.add(input));
    }
}