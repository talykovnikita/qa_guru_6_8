package guru.qa.service;

import guru.qa.service.mock.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.SoftAssertions;

class CalculatorTest {

    private Calculator calculator;
    private Reader mockReader;
    private MockWriter mockWriter;

    @Test
    void calculatorMultTest() {
        mockReader = new MockMultReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("3 * 5 = 15", result);
    }

    @Test
    void calculatorSumTest() {
        mockReader = new MockSumReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("10 + 5 = 15", result);
    }

    @Test
    void calculatorDivTest() {
        mockReader = new MockDivReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("10 / 5 = 2", result);
    }

    @Test
    void calculatorZeroDivTest() {
        mockReader = new MockZeroDivReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        Exception caughtException = null;
        try {
            calculator.start();
        }catch (Exception e){
            caughtException = e;
        }
        Assertions.assertEquals("ZeroDivisionError", caughtException.getMessage());
    }

    @Test
    void calculatorMinusTest() {
        mockReader = new MockMinusReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("10 - 5 = 5", result);
    }

    @Test
    void calculatorPowTest() {
        mockReader = new MockPowReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("2 ^ 10 = 1024", result);
    }

    @Test
    void checkAllMessages() {
        mockReader = new MockMultReader();
        mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(mockWriter.handleString(Messages.WelcomeMessage.getMessage()))
                .isEqualTo("Enter 2 digit: \n");
        softAssertions.assertThat(mockWriter.handleString(Messages.RequestForOperator.getMessage()))
                .isEqualTo("Enter operator (+, *, -, /, ^): \n");
        softAssertions.assertThat(String.format(Messages.ResultTemplate.getMessage(), result))
                .isEqualTo("Result: 3 * 5 = 15");
        softAssertions.assertAll();
    }
}