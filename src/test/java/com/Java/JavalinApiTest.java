package com.Java;


import io.javalin.Javalin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavalinApiTest {

    private static Javalin app;

    @BeforeAll
    static void setup() {
        app = Javalin.create().start(7070);

        app.get("/hello", ctx -> ctx.result("Hello, World!"));

        app.post("/usuarios", ctx -> {
            ctx.status(201);
            ctx.result(ctx.body());
        });

        app.get("/usuarios/{id}", ctx -> {
            ctx.status(404);
        });
    }

    @AfterAll
    static void teardown() {
        app.stop();
    }

    @Test
    void happyPath_criarUsuario() throws Exception {

        URL url = new URL("http://localhost:7070/usuarios");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        String json = "{\"nome\":\"Antonio\",\"email\":\"antonio@email.com\"}";

        try(OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes(StandardCharsets.UTF_8));
        }

        int status = con.getResponseCode();

        assertEquals(201, status);
    }

    @Test
    void cornerCase_usuarioInexistente() throws Exception {

        URL url = new URL("http://localhost:7070/usuarios/999");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        assertEquals(404, status);
    }
}