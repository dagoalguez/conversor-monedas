import com.google.gson.JsonObject;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String apiKey = "c89adc69e009ed9079576886";
        ExchangeRateApiClient client = new ExchangeRateApiClient(apiKey);

        try {
            double rate = client.getExchangeRate("USD", "EUR");
            System.out.println("1 USD = " + rate + " EUR");

            JsonObject allRates = client.getLatestRates("USD");
            System.out.println("Todas las tasas: " + allRates);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}