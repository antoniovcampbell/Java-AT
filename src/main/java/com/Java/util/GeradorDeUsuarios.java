package com.Java.util;

import com.Java.model.Usuario;

public class GeradorDeUsuarios {

    public static Usuario criar() {
        return new Usuario(1L, "Antonio", "antonio@email.com");
    }
}
