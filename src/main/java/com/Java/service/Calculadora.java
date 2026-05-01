package com.Java.service;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int dividir(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divisão por zero");
        return a / b;
    }
}