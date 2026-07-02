package com.cognizant.junitbasic;

public class Calculator {

    private int result;

    public int add(int a, int b) {
        result = a + b;
        return result;
    }

    public int subtract(int a, int b) {
        result = a - b;
        return result;
    }

    public int multiply(int a, int b) {
        result = a * b;
        return result;
    }

    public int divide(int a, int b) {
        result = a / b;
        return result;
    }

    public int getResult() {
        return result;
    }

    public void clear() {
        result = 0;
    }
}
