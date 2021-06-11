package guru.qa.service;

import guru.qa.service.mock.MockDivReader;
import guru.qa.service.mock.MockMultReader;
import guru.qa.service.mock.MockWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.SoftAssertions;

class CalculatorTest {

    private Calculator calculator;

    @Test
    void calculatorMultTest() {
        Reader mockReader = new MockMultReader();
        MockWriter mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("3 * 5 = 15", result);
    }

    @Test
    void calculatorDivTest() {
        Reader mockReader = new MockDivReader();
        MockWriter mockWriter = new MockWriter();
        calculator = new Calculator(mockReader, mockWriter);
        String result = calculator.start();
        Assertions.assertEquals("10 / 5 = 2", result);
    }

    @Test
    void messagesMultTest() {
        Reader mockReader = new MockMultReader();
        Writer mockWriter = new MockWriter();
        new Calculator(mockReader, mockWriter).start();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(mockWriter.handleString(Messages.WelcomeMessage.getMessage()))
                .isEqualTo("Enter 2 digit: \n");
        softAssertions.assertThat(mockWriter.handleString(Messages.RequestForOperator.getMessage()))
                .isEqualTo("Enter operator (+, *, -, /, ^): \n");
        softAssertions.assertThat(String.format(Messages.ResultTemplate.getMessage(), "3 * 5 = 15"))
                .isEqualTo("Result: 3 * 5 = 15");
        softAssertions.assertAll();
    }
}