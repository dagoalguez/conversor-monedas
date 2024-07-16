import java.util.Scanner;
import java.io.IOException;

public class CurrencyConverter {
    private static final ExchangeRateApiClient client = new ExchangeRateApiClient("c89adc69e009ed9079576886");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int option = getValidOption();
            if (option == 7) {
                System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta luego!");
                break;
            }
            processOption(option);
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("*****************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real Brasileño");
        System.out.println("4) Real Brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano >> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("*****************************************************");
    }

    private static int getValidOption() {
        int option;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            option = scanner.nextInt();
        } while (option < 1 || option > 7);
        return option;
    }

    private static void processOption(int option) {
        String fromCurrency, toCurrency;
        switch (option) {
            case 1: fromCurrency = "USD"; toCurrency = "ARS"; break;
            case 2: fromCurrency = "ARS"; toCurrency = "USD"; break;
            case 3: fromCurrency = "USD"; toCurrency = "BRL"; break;
            case 4: fromCurrency = "BRL"; toCurrency = "USD"; break;
            case 5: fromCurrency = "USD"; toCurrency = "COP"; break;
            case 6: fromCurrency = "COP"; toCurrency = "USD"; break;
            default: return;
        }

        System.out.println("Ingresa el valor que desea convertir:");
        double amount = scanner.nextDouble();

        try {
            double rate = client.getExchangeRate(fromCurrency, toCurrency);
            double result = amount * rate;
            System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                    amount, fromCurrency, result, toCurrency);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}