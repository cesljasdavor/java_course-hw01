package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Ovaj program se koristi za unos brojeva sa standardnog ulaza (obično
 * tipovnica). Program unesene brojeve smješta u uređeno binrano stablo. Program
 * koristi razred {@code TreeNode} kao pomoćnu struktura za izvođenje programa.
 * Kada korisnik unese "kraj" na standardni ulaz, unos se zaustavlja i korisniku
 * se na standardni izlaz (obično ekran) ispisuju elementi stabla. Prvi ispis su
 * elementi od najmanjeg prema najvećem, a drugi od najvećeg prema najmanjem.
 * Napomena: samo cijeli brojevi smiju biti uneseni, dakle svi nizovi znakova
 * koji se ne mogu isprasirati u cijeli broj neće biti uneseni u stablo i
 * korisniku će se ispisati odgovarajuća poruka
 * 
 * @author Davor Češljaš
 */
public class UniqueNumbers {

	/**
	 * Razred predstavlja jedan čvor binarnog stabla. Čvor binarnog stabla
	 * sastoji se od dvoje djece (lijevog i desnog djeteta) i vrijednosti
	 * upisane u čvor. Razred ne sadrži metode niti konstruktore
	 */
	public static class TreeNode {

		/** Lijevo dijete čvora binarnog stabla */
		public TreeNode left;

		/** Desno dijete čvora binarnog stabla */
		public TreeNode right;

		/** The value. */
		public int value;
	}

	/**
	 * Metoda koja se koristi za rekurzivno dodavanje čvora u uređeno binrano
	 * stablo. Ova metoda gradi uređeno binrano stablo tako da se čvorovi koji
	 * imaju manju vrijednost od trenutnog čvora postavljaju lijevo od trenutnog
	 * čvora. Čvorovi koji imaju vrijednost veću od trenutnog čvora idu desno od
	 * trenutnog čvora. Stablo izgrađeno pomoću ove metode neće imati duplikata.
	 * Kao pomoćna struktura koristi se podklasa {@code TreeNode}.
	 *
	 * @param root
	 *            trenutni čvor koji se razmatra
	 * @param value
	 *            vrijednost temeljem koje određujemo gdje postaviti novi čvor.
	 *            Ujedino i atribut {@code value} od novog čvora klase
	 *            {@code TreeNode}
	 * 
	 * @return pozivatelju vraća korijen stabla sa dodanim čvorom (Ukoliko
	 *         vrijednost već ne postoji).
	 */
	public static TreeNode addNode(TreeNode root, int value) {
		// našao sam poziciju ili je root na početku null
		if (root == null) {
			TreeNode node = new TreeNode();
			/*
			 * inicijalno su članske varijable (koje su reference) postavljene
			 * na null pa to neću ovdje dodatno raditi
			 */
			node.value = value;
			return node;
		}

		// nisam pronašao poziciju te rekurzivno iteriram kroz stablo
		if (value < root.value) {
			// idi lijevo
			root.left = addNode(root.left, value);
		} else if (value > root.value) {
			// idi desno
			root.right = addNode(root.right, value);
		}
		// ukoliko je root.value == value samo se vrati (ništa ne mijenjaj)
		return root;
	}

	/**
	 * Metoda se koristi za određivanje veličine stabla (koliko stablo ima
	 * čvorova)
	 *
	 * @param root
	 *            korijen stabla kojem se određuje veličina
	 * @return veličinu stabla
	 */
	public static int treeSize(TreeNode root) {
		// prazno stablo ili smo došli do djece od lista
		if (root == null) {
			return 0;
		}

		return 1 + treeSize(root.left) + treeSize(root.right);
	}

	/**
	 * Metoda pomoću koja ispituje sadrži li stablo čvor čija je vrijednst
	 * jednaka zadanom parametru {@code value}
	 *
	 * @param root
	 *            korijen stabla koje se ispituje
	 * @param value
	 *            vrijednost koju tražimo u stablu
	 * @return ako postoji vraća vrijednost {@code true} , u suprotnom vraća
	 *         {@code false}
	 */
	public static boolean containsValue(TreeNode root, int value) {
		if (root == null) {
			return false;
		}

		if (root.value == value) {
			return true;
		}
		boolean leftContains = containsValue(root.left, value);
		boolean rightContains = containsValue(root.right, value);
		return leftContains || rightContains;
	}

	/**
	 * Metoda koja se koristi za ispis vrijednosti stabla. Koristi metode
	 * printAscending i printDescending za ispis stabla. Ispisuje vrijednosti iz
	 * stabla prvo od najmanje prema najvećoj, a potom u obrnutom redoslijedu
	 *
	 * @param root
	 *            korijen stabla koje se ispisuje
	 */
	private static void print(TreeNode root) {
		// bespotrebno zauzeće memorije
		if (root == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Ispis od najmanjeg:");
		printAscending(root, sb);
		sb.append("\n").append("Ispis od najvećeg:");
		printDescending(root, sb);
		System.out.println(sb.toString());

	}

	/**
	 * Pomoćna metoda metode print koja u predani {@code StringBuilder} nadodaje
	 * vrijednosti stabla od najmanje prema najvećoj
	 * 
	 * @param root
	 *            korijen stabla koje ispisujemo u metodi print. Ujedino i
	 *            trenutni čvor prilikom rekurzivnog poziva
	 * @param sb
	 *            instanca razreda StringBuilder u koju upisujemo vrijednosti.
	 */
	private static void printAscending(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		printAscending(root.left, sb);
		sb.append(" ").append(root.value);
		printAscending(root.right, sb);
	}

	/**
	 * Pomoćna metoda metode print koja u predani {@code StringBuilder} nadodaje
	 * vrijednosti stabla od najveće prema najmanjoj
	 * 
	 * @param root
	 *            korijen stabla koje ispisujemo u metodi print. Ujedino i
	 *            trenutni čvor prilikom rekurzivnog poziva
	 * @param sb
	 *            instanca razreda StringBuilder u koju upisujemo vrijednosti.
	 */
	private static void printDescending(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		printDescending(root.right, sb);
		sb.append(" ").append(root.value);
		printDescending(root.left, sb);
	}

	/**
	 * Metoda od koje kreće izvođenje programa.
	 *
	 * @param args
	 *            argumenti naredbenog redka. Ne koriste se u ovom programu
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode root = null;

		while (true) {
			System.out.print("Unesite broj > ");
			if (sc.hasNextInt()) {
				int value = sc.nextInt();
				if (!containsValue(root, value)) {
					root = addNode(root, value);
					System.out.println("Dodano.");
				} else {
					System.out.println("Broj već postoji. Preskačem.");
				}
			} else {
				String input = sc.next();
				if (input.equals("kraj")) {
					break;
				} else {
					System.out.format("'%s' nije cijeli broj.%n", input);
				}
			}
		}

		sc.close();

		// ispis
		print(root);

	}
}
