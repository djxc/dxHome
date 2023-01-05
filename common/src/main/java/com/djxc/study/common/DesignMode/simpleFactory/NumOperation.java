package com.djxc.study.common.DesignMode.simpleFactory;

/**
 * 数值运算的接口
 * 1、具有一个抽象方法需要实现该接口的类实现该方法
 */
public interface NumOperation {
    double getResult(double num1, double num2);
}
