package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Hello world!
 *
 */
public class App {
    private static final String API = "http://localhost:8080/";
    public static void main( String[] args ) throws IOException, InterruptedException {
        App app = new App();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = app.GETRequestHandler("getChatrooms");
        HttpRequest request1 = app.POSTRequestHandler("createUser", "testuser15");

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<?> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());

        System.out.println(response1.body());
        System.out.println(response.body());
    }

    public HttpRequest GETRequestHandler(String req){
        return HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API + req))
                .build();
    }

    public HttpRequest POSTRequestHandler(String req, String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(name);

        return HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(API + req))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
    }

}
