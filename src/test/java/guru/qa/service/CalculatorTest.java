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
        MockWriter mockWriter = new MockWriter();
        new Calculator(mockReader, mockWriter).start();

        String[] output = mockWriter.readFromOutputStream().split("\n");
        System.out.println(output);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(output[0])
                .isEqualTo("Enter 2 digit: ");
        softAssertions.assertThat(output[1])
                .isEqualToIgnoringCase("Enter operator (+, *, -, /, ^): ");
        softAssertions.assertThat(output[2])
                .isEqualToIgnoringCase("Result: 3 * 5 = 15");
        softAssertions.assertAll();
    }
}