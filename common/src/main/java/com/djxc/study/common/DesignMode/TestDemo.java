package com.djxc.study.common.DesignMode;

import com.djxc.study.common.DesignMode.simpleFactory.AddNumOperation;
import com.djxc.study.common.DesignMode.simpleFactory.NumOperation;

public class TestDemo {
    public static void main(String[] args) {
        NumOperation numOperation = new AddNumOperation();
        System.out.println(numOperation.getResult(0.2, 12.3));
    }
}
