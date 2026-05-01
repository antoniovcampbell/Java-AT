package com.Java.service;

import java.util.ArrayList;
import java.util.List;

public class ServicoEmailFake implements ServicoEmail {

    public List<String> enviados = new ArrayList<>();

    public void enviar(String d, String m) {
        enviados.add(d + ":" + m);
    }
}