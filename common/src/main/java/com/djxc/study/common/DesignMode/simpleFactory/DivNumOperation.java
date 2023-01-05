package com.djxc.study.common.DesignMode.simpleFactory;

public class DivNumOperation implements NumOperation{
    @Override
    public double getResult(double num1, double num2) {
        if (num2 == 0) {
            throw new Error("num can not be 0");
        }
        return num1 / num2;
    }
}
