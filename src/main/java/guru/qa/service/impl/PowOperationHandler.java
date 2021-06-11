package guru.qa.service.impl;

import guru.qa.service.OperationHandler;

public class PowOperationHandler implements OperationHandler {

    @Override
    public int invoke(int first, int second) {
        return (int) Math.pow(new Double(first), new Double(second));
    }
}
