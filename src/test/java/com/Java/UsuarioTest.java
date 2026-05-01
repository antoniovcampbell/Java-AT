package com.Java;


import com.Java.model.Usuario;
import com.Java.util.GeradorDeUsuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioTest {

    @Test
    void deveCriarUsuarioComHelper() {
        Usuario u = GeradorDeUsuarios.criar();

        assertNotNull(u);
        assertEquals("Antonio", u.getNome());
        assertEquals("antonio@email.com", u.getEmail());
    }

    @Test
    void deveAlterarDadosUsuario() {
        Usuario u = GeradorDeUsuarios.criar();

        u.setNome("Novo Nome");
        u.setEmail("novo@email.com");

        assertEquals("Novo Nome", u.getNome());
        assertEquals("novo@email.com", u.getEmail());
    }
}