package com.andy;

import com.ibm.j9ddr.vm29.structure.double1;

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
        return (int)Math.round(num1);
    }
    
}
