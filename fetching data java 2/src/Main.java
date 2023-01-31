import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key=39ffe9df294147429c7e897607cdc93d&include=minutely";

        //building a request
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        //getting the HttpClient Object
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //status code and body
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());

    }
}