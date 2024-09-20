package com.andy;

public class TestProgram {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        double num3 = 68.56;
        
        Calculator calculator = new Calculator();
        
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + calculator.add(num1,num2));

        System.out.println("The difference of " + num1 + " and " + num2 + " is: " + calculator.subtract(num1,num2));

        System.out.println("The multiple of " + num1 + " and " + num2 + " is: " + calculator.multiply(num1,num2));

        System.out.println("The dividened of " + num1 + " and " + num2 + " is: " + calculator.divide(num1,num2));

        System.out.println("Rounding up " + num3 + " is: " + calculator.roundUp(num3));

    }
        
    
}
