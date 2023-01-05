package com.djxc.study.common.DesignMode.simpleFactory;

public class MulNumOperation implements NumOperation{
    @Override
    public double getResult(double num1, double num2) {
        return num1 * num2;
    }
}
