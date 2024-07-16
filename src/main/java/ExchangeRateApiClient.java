import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;
    private final HttpClient httpClient;
    private final Gson gson;

    public ExchangeRateApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public JsonObject getLatestRates(String baseCurrency) throws IOException, InterruptedException {
        String url = API_URL + apiKey + "/latest/" + baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return gson.fromJson(response.body(), JsonObject.class);
        } else {
            throw new IOException("Error en la solicitud: " + response.statusCode());
        }
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        JsonObject rates = getLatestRates(baseCurrency);

        if (rates.get("result").getAsString().equals("success")) {
            JsonObject conversionRates = rates.getAsJsonObject("conversion_rates");
            return conversionRates.get(targetCurrency).getAsDouble();
        } else {
            throw new IOException("Error al obtener las tasas de cambio: " + rates.get("error-type").getAsString());
        }
    }
}