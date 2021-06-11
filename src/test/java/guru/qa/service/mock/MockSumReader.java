package guru.qa.service.mock;

import guru.qa.service.Operation;
import guru.qa.service.Reader;

public class MockSumReader implements Reader {
    @Override
    public int readFirstArg() {
        return 10;
    }

    @Override
    public int readSecondArg() {
        return 5;
    }

    @Override
    public Operation readMathOperation() {
        return Operation.SUM;
    }
}
