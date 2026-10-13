/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *This deals with the json responses converting objects into json and sends them to website using http.
 * this will be resused for all the controllers so we aint so DRY haha
 * @author parks
 */
public final class JsonHandlerUtil {

    private static final Gson GSON = new Gson();

    private JsonHandlerUtil() {
      
    }

    public static void sendJson(
            HttpExchange exchange,
            int statusCode,
            Object data) throws IOException {

        String json = GSON.toJson(data);
        byte[] response = json.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
                "Content-Type",
                "application/json; charset=UTF-8"
        );

        exchange.sendResponseHeaders(statusCode, response.length);

        try (var output = exchange.getResponseBody()) {
            output.write(response);
        }
    }
}
