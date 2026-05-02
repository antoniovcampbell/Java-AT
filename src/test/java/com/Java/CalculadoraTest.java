package com.Java;


import com.Java.service.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void Calculadora(){
        calculadora = new Calculadora();
    }
    @Test
    void TesteSoma() {
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        calculadora = null;
    }

    @Test
    void testeSubtracao() {
        int resultado = calculadora.subtrair(5, 3);
        assertEquals(2, resultado);
        calculadora = null;
    }
    @Test
    void testeDivisao(){
        int resultado = calculadora.dividir(6, 2);
        assertEquals(3, resultado);
        calculadora = null;
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10, 0));
    }
}