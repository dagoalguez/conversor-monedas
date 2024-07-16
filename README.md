# Conversor de Monedas

Este proyecto es un conversor de monedas que utiliza la API de ExchangeRate para obtener tasas de cambio en tiempo real. Permite convertir entre diferentes pares de monedas, incluyendo Dólar estadounidense, Peso argentino, Real brasileño y Peso colombiano.

## Características

- Conversión entre múltiples pares de monedas
- Uso de tasas de cambio en tiempo real
- Interfaz de línea de comandos fácil de usar

## Requisitos previos

- Java JDK 11 o superior
- Maven
- Una clave API de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Configuración

1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/conversor-monedas.git
   ```

2. Navega al directorio del proyecto:
   ```
   cd conversor-monedas
   ```

3. Instala las dependencias con Maven:
   ```
   mvn install
   ```

4. Abre el archivo `CurrencyConverter.java` y reemplaza `"tu_api_key_aqui"` con tu clave API real de ExchangeRate-API.

## Uso

Para ejecutar el conversor de monedas, usa el siguiente comando:

```
mvn exec:java -Dexec.mainClass="CurrencyConverter"
```

Sigue las instrucciones en pantalla para seleccionar las monedas y los montos que deseas convertir.

## Estructura del proyecto

- `CurrencyConverter.java`: Clase principal que maneja la interfaz de usuario y la lógica de conversión.
- `ExchangeRateApiClient.java`: Cliente para interactuar con la API de ExchangeRate.
- `pom.xml`: Archivo de configuración de Maven con las dependencias del proyecto.

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir los cambios que te gustaría hacer.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
