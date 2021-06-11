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
        writer.write(Messages.WelcomeMessage.getMessage());
        int first = reader.readFirstArg();
        int second = reader.readSecondArg();
        writer.write(Messages.RequestForOperator.getMessage());
        Operation po = reader.readMathOperation();
        int result = po.getOperation().invoke(first, second);

        String output = first + " " + po.getSymbol() + " " + second + " = " + result;
        writer.write(String.format(Messages.ResultTemplate.getMessage(), output));
        return output;
    }

    public static void main(String[] args) {
        new Calculator(new ConsoleReader(), new ConsoleWriter()).start();
    }
}
