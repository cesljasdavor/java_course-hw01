package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Ovaj program koristi se za izračun opsega i površine na temlje predanih
 * vrijednosti. Argumenti se mogu predati na dva načina: 1) Preko naredbenog
 * redka unosi se točno dva argumenta od kojih prvi predstavlja širinu ,a drugi
 * visinu pravokutnika. 2) Ukoliko se ne unese niti jedan parametar naredbenim
 * redkom pokrenuti će se učitavanje argumenata (širine i visine) preko
 * standardnog ulaza (obično tipkovnice).
 * 
 * 
 * Ukoliko unesete bilo koji drugi broj parametara u naredbeni redak program će
 * dojaviti pogrešku
 *
 *
 * @author Davor Češljaš
 *
 */
public class Rectangle {

	/**
	 * Indeks argumenta u polju argumenata iz naredbenog redka kojem odgovara
	 * širina pravokutnika
	 */
	public static int WIDTH_INDEX = 0;

	/**
	 * Indeks argumenta u polju argumenata iz naredbenog redka kojem odgovara
	 * visina pravokutnika
	 */
	public static int HEIGHT_INDEX = 1;

	/**
	 * Broj potrebnih argumenata u polju argumenata naredbenog redka kako bi
	 * program uzimao parametre (širinu i visinu) iz naredbenog redka
	 */
	public static int REQUIRED_ELEMENTS = 2;

	/**
	 * Metoda od koje kreće izvođenje programa
	 *
	 * @param args
	 *            ako je atribut polja length jednak 2 tada se parametri (širina
	 *            i visina) uzimaju iz naredbenog redka ,odnosno iz ovog polja
	 */
	public static void main(String[] args) {
		// postoji točno 2 argumenta naredbenog redka
		// pitati čupića jel treba provjera tu
		if (args.length == REQUIRED_ELEMENTS) {

			double width = parseInput(args[WIDTH_INDEX]);
			double height = parseInput(args[HEIGHT_INDEX]);

			if (width < 0 || height < 0) {
				// izađi iz programa
				System.exit(0);
			}

			// ako je sve korektno ispiši riješenje
			printResult(width, height);

			// nema argumenata naredbenog redka
		} else if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			boolean widthSet = false;
			double width = 0;
			double height = 0;

			// postavi width i height
			while (true) {
				if (!widthSet) {
					System.out.print("Unesite širinu > ");
					double number = parseInput(sc.next());
					if (number > 0) {
						width = number;
						widthSet = true;
					}
				} else {
					System.out.print("Unesite visinu > ");
					double number = parseInput(sc.next());
					if (number > 0) {
						height = number;
						break;
					}
				}
			}
			sc.close();
			
			// ispiši riješenje
			printResult(width, height);

		} else {
			System.out.format("Broj unesenih argumenata: %d. Broj argumenata je %s.%n", args.length,
					args.length < 2 ? "nedovoljan" : "prevelik");
		}

	}

	/**
	 * Metoda računa i ispisuje opseg i površinu pravokutnika
	 *
	 * @param width
	 *            širina pravokutnika
	 * @param height
	 *            visina pravokutnika
	 */
	public static void printResult(double width, double height) {
		System.out.format("Pravokutnik širine %.1f i visine %.1f ima površinu %.1f te opseg %.1f.", width, height,
				width * height, 2 * width + 2 * height);
	}

	/**
	 * Metoda koja parsira argument sa standardnog ulaza. Ukoliko je dotični
	 * argument moguće isparsirati u tip double te ukoliko je dobiveni broj veći
	 * od 0, metoda vraća taj broj. U slučaju da to ne vrijedi ispisuje se
	 * odgovarajuća poruka i vraća se -1, što označava da je došlo do pogreške
	 *
	 * @param input
	 *            argument koji pokušavamo isparsirati
	 * @return vrijednost argumenta ukoliko je parsiranje moguće ili -1 ukoliko
	 *         parsiranje nije moguće
	 */
	public static double parseInput(String input) {
		Scanner sc = new Scanner(input);
		if (sc.hasNextDouble()) {
			double number = sc.nextDouble();
			sc.close();
			if (number < 0) {
				System.out.println("Unijeli ste negativnu vrijednost.");
				return -1;
			} else if (number == 0) {
				System.out.println("Unijeli ste vrijednost nula.");
				return -1;
			} else {
				return number;
			}
		} else {
			sc.close();
			System.out.format("'%s' se ne može protumačiti kao broj.%n", input);
		}
		return -1;
	}

}
