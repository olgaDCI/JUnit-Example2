package com.example;

import java.util.List;

public class Calculator {
    public int integerDivision(int dividend, int divisor){
    return dividend/divisor;
    }

    public int add(int a, int b){
        return a+b;

    }

    public int multiply(int a, int b){
        return a * b;

    }

    public void doSomething(int a, int b){
        System.out.println(a);
    }

    public int calculateTotal(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
}
