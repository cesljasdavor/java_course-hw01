package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Ovaj program koristi se za izračun faktorijela brojeva u rasponu [1,20]. Unos
 * bilo kojeg decimalnog broja, riječi ili sl. ispisati će odgovarajuću poruku.
 * Unosom riječi "kraj" (dakle malim slovima) program prestaje s radom
 *
 * @author Davor Češljaš
 */
public class Factorial {

	/** Donja granica raspona (u ovom slučaju jednaka 1) */
	public static int LOWER_LIMIT = 1;

	/** Gornja granica raspona (u ovom slučaju jednaka 20) */
	public static int UPPER_LIMIT = 20;

	/**
	 * Metoda od koje kreće izvođenje programa
	 *
	 * @param args
	 *            argumenti iz naredbenog redka.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Unesite broj > ");
			if (sc.hasNextInt()) {
				int number = sc.nextInt();
				if ((number >= LOWER_LIMIT) && (number <= UPPER_LIMIT)) {
					long result = computeFactorail(number);
					System.out.format("%d! = %d%n", number, result);
				} else {
					System.out.format("'%d' nije broj u dozvoljenom rasponu.%n", number);
				}
			} else {
				// moguće je da sc.
				String input = sc.next();
				if (input.equals("kraj")) {
					System.out.println("Doviđenja.");
					break;
				}
				System.out.format("'%s' nije cijeli broj%n", input);
			}
		}

		sc.close();
	}

	/**
	 * Metoda koja se koristi za računanje faktorijela. Od korisnika ove metode
	 * zahtjeva se da kao argument preda broj od kojeg želi dobiti faktorijel.
	 * Argument mora biti prirodan broj. Metoda izračunava faktorijel predanog
	 * broja i vraća ga kroz povratnu vrijednost. Ukoliko se preda negativan
	 * broj ili 0 metoda vraća -1. Ukoliko faktorijel argumenta prijeđe gornju
	 * granicu domene tipa long metoda vraća 0
	 *
	 * @param argument
	 *            Broj od kojeg računamo faktorijel
	 * 
	 * @return Faktorijel broja zadanog kao argument. U slučaju predaje
	 *         negativnog broja ili 0 kao argumenta vraća se -1. U slučaju da
	 *         faktorijel prijeđe gornju granicu tipa long vraća se 0.
	 */
	public static long computeFactorail(int argument) {
		if (argument <= 0) {
			return -1;
		}

		//izračun faktorijela
		long result = 1;
		for (int i = 1; i <= argument; i++) {
			result *= i;
			
			// dakle probijena je gornja granica domene tipa long
			if (result < 0) {
				return 0;
			}
		}

		return result;
	}

}
