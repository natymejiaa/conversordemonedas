package com.aluracursos.conversordemoneda;

import com.aluracursos.conversordemoneda.Model.CurrencyAPIModel;
import com.aluracursos.conversordemoneda.Model.CurrencyModel;
import com.aluracursos.conversordemoneda.Service.QueryCurrency;
import com.aluracursos.conversordemoneda.Utils.CurrencyConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CurrencyCoverterApplication {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		QueryCurrency queryCurrency = new QueryCurrency();
		CurrencyConverter currencyConverter = new CurrencyConverter();

		while (true) {
			System.out.println("            Conversor de Monedas");
			System.out.println("Seleccione la moneda de origen:");
			System.out.println("1. ARS - Peso argentino");
			System.out.println("2. BOB - Boliviano boliviano");
			System.out.println("3. BRL - Real brasileño");
			System.out.println("4. CLP - Peso chileno");
			System.out.println("5. COP - Peso colombiano");
			System.out.println("6. USD - Dólar estadounidense");
			System.out.println("7. Salir");
			System.out.print("Opción: ");
			int opcionOrigen = input.nextInt();
			input.nextLine();  // Consumir la nueva línea

			if (opcionOrigen == 7) {
				System.out.println("Seleccionó salir de la aplicación");
				break;
			}

			String monedaOrigenString;

			switch (opcionOrigen) {
				case 1:
					monedaOrigenString = "ARS";
					break;
				case 2:
					monedaOrigenString = "BOB";
					break;
				case 3:
					monedaOrigenString = "BRL";
					break;
				case 4:
					monedaOrigenString = "CLP";
					break;
				case 5:
					monedaOrigenString = "COP";
					break;
				case 6:
					monedaOrigenString = "USD";
					break;
				default:
					System.out.println("Opción no válida. Intente nuevamente.");
					continue;
			}

			System.out.println("====================================");
			System.out.println("Seleccione la moneda de destino:");
			System.out.println("1. ARS - Peso argentino");
			System.out.println("2. BOB - Boliviano boliviano");
			System.out.println("3. BRL - Real brasileño");
			System.out.println("4. CLP - Peso chileno");
			System.out.println("5. COP - Peso colombiano");
			System.out.println("6. USD - Dólar estadounidense");
			System.out.println("7. Salir");
			System.out.print("Opción: ");
			int opcionDestino = input.nextInt();
			input.nextLine();  // Consumir la nueva línea

			if (opcionDestino == 7) {
				System.out.println("Seleccionó salir de la aplicación");
				break;
			}

			String monedaDestinoString;

			switch (opcionDestino) {
				case 1:
					monedaDestinoString = "ARS";
					break;
				case 2:
					monedaDestinoString = "BOB";
					break;
				case 3:
					monedaDestinoString = "BRL";
					break;
				case 4:
					monedaDestinoString = "CLP";
					break;
				case 5:
					monedaDestinoString = "COP";
					break;
				case 6:
					monedaDestinoString = "USD";
					break;
				default:
					System.out.println("La moneda seleccionada no esta en la lista. Elija una de la lista");
					continue;
			}

			CurrencyAPIModel initialCurrency = queryCurrency.getCurrency(monedaOrigenString);
			CurrencyModel monedaOrigen = new CurrencyModel(initialCurrency);

			CurrencyAPIModel monedaDestinoAPI = queryCurrency.getCurrency(monedaDestinoString);
			CurrencyModel monedaDestino = new CurrencyModel(monedaDestinoAPI);

			System.out.println("====================================");
			System.out.print("Ingrese la cantidad que quiere convertir de " + monedaOrigen.getCurrency() + " a " + monedaDestino.getCurrency() + ": ");
			double cantidad = input.nextDouble();
			double tasaConversion = monedaOrigen.getConversion(monedaDestino.getCurrency());
			double cantidadConvertida = currencyConverter.convert(cantidad, tasaConversion);

			System.out.println("====================================");
			System.out.println(cantidad + " " + monedaOrigen.getCurrency() + " equivalen a " + cantidadConvertida + " " + monedaDestino.getCurrency());
			System.out.println("====================================");
		}

		input.close();
	}
}
