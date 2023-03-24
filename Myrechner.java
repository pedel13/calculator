package Rechner;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Myrechner {
	public static void main(String[] args) {
		//neu(); //ein wenig sketchy aber okey

		boolean running = true; // ein aus schalt knopf
		Scanner first = new Scanner(System.in); //first.close(); sollte verwendet werden sobald du fertig bist mit dem objekt first
		int resultat = 0; //resulat wird hier definiert da es auserhalb von while bleiben soll. 

		ArrayList<String> kalkulator = new ArrayList<String>();
		kalkulator.add("+");
		kalkulator.add("-");
		kalkulator.add("*");
		kalkulator.add("/");
		kalkulator.add("=");
		kalkulator.add("c");
		
		int zahl1 = 0;
		while(running){
			if(resultat == 0){
				System.out.println("wath do you want calculate or c for delete:");
				zahl1 = first.nextInt();
			}

			String operator = first.next(); //char wäre besser als string weil du hier nur einen operator brauchst.
			if(operator.equals("+")){
				int zahl2 = first.nextInt();
				resultat = resultat + zahl1 + zahl2;
			}
			if(operator.equals("-")){
				int zahl2 = first.nextInt();
				resultat = zahl1 - zahl2;
			}
			if(operator.equals("/")){
				int zahl2 = first.nextInt();
				resultat = zahl1 / zahl2;
			}
			if(operator.equals("*")){
				int zahl2 = first.nextInt();
				resultat = zahl1 * zahl2;
			}
			if(operator.equals("&")){
				running = false;
			}
			if(operator.equals("c")){
				resultat = 0;
			}
			System.out.println(resultat);
			zahl1 = 0;
		}
		first.close(); // schützt gegen memory leaks wichtig bei grossen applikationen.

	}

	public static void neu() {

		Scanner first = new Scanner(System.in); //first.close(); sollte verwendet werden sobald du fertig bist mit dem objekt first

		System.out.println("wath do you want calculate or c for delete:");
		int zahl1 = first.nextInt();
		String operator = first.next(); //char wäre besser als string weil du hier nur einen operator brauchst.
		
		if (operator.equals("+")) {
			int zahl2 = first.nextInt();
			int plus = zahl1 + zahl2; //unnötig einfach resultat = zahl1 + zahl2
			int resultat = plus;
			System.out.println(resultat);
			weiter(resultat, operator);
		} else if (operator.equals("-")) {
			int zahl2 = first.nextInt();
			int minus = zahl1 - zahl2;
			int resultat = minus;
			System.out.println(resultat);
			weiter(resultat, operator);
		} else if (operator.equals("*")) {
			int zahl2 = first.nextInt();
			int mal = zahl1 * zahl2;
			int resultat = mal;
			System.out.println(resultat);
			weiter(resultat, operator);
		} else if (operator.equals("/")) {
			int zahl2 = first.nextInt();
			int durch = zahl1 / zahl2;
			int resultat = durch;
			System.out.println(resultat);
			weiter(resultat, operator);
		} else if (operator.equals("c")) {
			System.out.flush();
			neu();
		}

		else {
			System.out.println("wrong operator");
		}
		System.out.flush();
		neu();
	}

	public static void weiter(int resultat, String operator) {

		int zahl = 0;
		ArrayList<String> kalkulator = new ArrayList<String>();
		kalkulator.add("+");
		kalkulator.add("-");
		kalkulator.add("*");
		kalkulator.add("/");
		kalkulator.add("=");
		kalkulator.add("c");
		System.out.println(": ");
		Scanner sc = new Scanner(System.in);
		operator = sc.nextLine();

		if (kalkulator.contains(operator)) {
			switch (operator) {

				case ("+"):
					zahl = sc.nextInt();
					resultat = (resultat + zahl);
					System.out.println(resultat);
					weiter(resultat, operator); //rekursion 

				case ("-"):
					zahl = sc.nextInt();
					resultat = (resultat - zahl);
					System.out.println(resultat);
					weiter(resultat, operator);

				case ("*"):
					zahl = sc.nextInt();
					resultat = (resultat * zahl);
					System.out.println(resultat);
					weiter(resultat, operator);

				case ("/"):
					zahl = sc.nextInt();
					resultat = (resultat / zahl);
					System.out.println(resultat);
					weiter(resultat, operator);

				case ("="):
					System.out.println(resultat);
					weiter(resultat, operator);

				case ("c"):
					System.out.flush();
					neu();
			}
		} else {
			System.out.println("wrong operator");
			System.out.flush();
			neu();
		}

	}

}
