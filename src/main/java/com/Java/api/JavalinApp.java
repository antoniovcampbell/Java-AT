package com.Java.api;

import com.Java.model.Usuario;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class JavalinApp {

    public static void start() {
        Javalin app = Javalin.create().start(7000);

        Map<Long, Usuario> banco = new HashMap<>();
        AtomicLong idGen = new AtomicLong();

        app.get("/hello", ctx -> ctx.result("Hello, World!"));

        app.get("/usuarios", ctx -> ctx.json(banco.values()));

        app.post("/usuarios", ctx -> {
            Usuario u = ctx.bodyAsClass(Usuario.class);
            u.setId(idGen.incrementAndGet());
            banco.put(u.getId(), u);
            ctx.json(u);
        });

        app.get("/usuarios/{id}", ctx -> {
            Long id = Long.parseLong(ctx.pathParam("id"));
            Usuario u = banco.get(id);
            if (u == null) ctx.status(404);
            else ctx.json(u);
        });

        app.delete("/usuarios/{id}", ctx -> {
            banco.remove(Long.parseLong(ctx.pathParam("id")));
        });
    }
}