package dat;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat.dtos.ChuckJokeDTO;
import dat.dtos.DadJokeDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeService {

    public static DadJokeDTO fetchDadjoke() {
        HttpResponse<String> response;
        ObjectMapper objectMapper = new ObjectMapper();
        String uri = "https://icanhazdadjoke.com";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), DadJokeDTO.class);
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChuckJokeDTO fetchChuckJoke() {
        HttpResponse<String> response;
        ObjectMapper objectMapper = new ObjectMapper();
        String uri = "https://api.chucknorris.io/jokes/random";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), ChuckJokeDTO.class);
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
