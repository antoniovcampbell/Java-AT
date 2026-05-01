package com.Java;


import com.Java.service.ServicoEmailFake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicoEmailTest {

    @Test
    void deveEnviarEmail() {
        ServicoEmailFake fake = new ServicoEmailFake();
        fake.enviar("a@email.com","msg");
        assertEquals(1, fake.enviados.size());
    }
}
