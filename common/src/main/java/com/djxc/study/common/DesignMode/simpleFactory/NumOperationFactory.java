package com.djxc.study.common.DesignMode.simpleFactory;

public class NumOperationFactory {
    public NumOperation getOperation(String operate) {
        NumOperation numOperation = new AddNumOperation();
        switch (operate) {
            case "+":
                numOperation = new AddNumOperation();
                break;
            case "/":
                numOperation = new DivNumOperation();
                break;
            case "*":
                numOperation = new MulNumOperation();
                break;
        }
        return numOperation;
    }
}
