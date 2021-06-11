package guru.qa.service.mock;

import guru.qa.service.Operation;
import guru.qa.service.Reader;

public class MockZeroDivReader implements Reader {

    @Override
    public int readFirstArg() {
        return 10;
    }

    @Override
    public int readSecondArg() {
        return 0;
    }

    @Override
    public Operation readMathOperation() {
        return Operation.DIV;
    }
}
