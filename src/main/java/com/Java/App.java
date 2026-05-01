package com.Java;

import com.Java.api.ApiClient;
import com.Java.api.JavalinApp;

public class App {

    public static void main(String[] args) throws Exception {
        ApiClient.getPost(1);
        JavalinApp.start();
    }
}