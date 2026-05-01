package com.Java;


import com.Java.service.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    @Test
    void TesteSoma() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(2, 3);
        assertEquals(5, resultado);
        calc = null;
    }

    @Test
    void testeSubtracao() {

        Calculadora calc = new Calculadora();
        int resultado = calc.subtrair(5, 3);
        assertEquals(2, resultado);
        calc = null;
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        Calculadora calc = new Calculadora();

        assertThrows(ArithmeticException.class, () -> {
            calc.dividir(10, 0);
        });
    }
}