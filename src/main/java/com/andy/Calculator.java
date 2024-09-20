package com.andy;


public class Calculator {
    
        
    public  int add(int num1, int num2) {
        return num1 + num2;
    }

    public  int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public  int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public  int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int roundUp(double num1) {
        return (int)Math.abs(num1);
    }

    public int roundDown(double num1) {
        return (int)Math.floor(num1);
    }

    public double power (int num1, int num2) {
        return Math.pow(num1, num2);
    }
    
}
