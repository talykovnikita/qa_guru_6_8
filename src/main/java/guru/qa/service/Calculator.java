package guru.qa.service;

import guru.qa.service.impl.ConsoleReader;
import guru.qa.service.impl.ConsoleWriter;

public class Calculator {

    private final Reader reader;
    private final Writer writer;

    public Calculator(Reader reader, Writer writer) {

        this.reader = reader;
        this.writer = writer;
    }

    public String start() {
        writer.handleString(Messages.WelcomeMessage.getMessage());
        int first = reader.readFirstArg();
        int second = reader.readSecondArg();
        writer.handleString(Messages.RequestForOperator.getMessage());
        Operation po = reader.readMathOperation();
        int result = po.getOperation().invoke(first, second);

        String output = first + " " + po.getSymbol() + " " + second + " = " + result;
        writer.handleString(String.format(Messages.ResultTemplate.getMessage(), output));
        return output;
    }
}
