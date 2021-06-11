package guru.qa.service.impl;

import guru.qa.service.OperationHandler;

public class DivOperationHandler implements OperationHandler {

    @Override
    public int invoke(int first, int second) {
        int result;

        try {
            result = first / second;
        }catch (Exception e){
            throw new ArithmeticException("ZeroDivisionError");
        }
        return result;
    }
}
