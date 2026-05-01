package com.Java.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    public static void getPost(int userId) throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=" + userId);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        System.out.println("Status: " + status);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}
