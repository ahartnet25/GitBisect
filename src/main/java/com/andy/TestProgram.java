package com.andy;

public class TestProgram {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        
        Calculator calculator = new Calculator();
        
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + calculator.add(num1,num2));
    }
        
    
}
