package howdoyouevencode;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("program.txt");
			Scanner sc = new Scanner(fr);
			Scanner in = new Scanner(System.in);
			int db = Integer.parseInt(sc.nextLine());
			String[] programok = new String[db];
			int sorszam;

			for (int i = 0; i < db; i++) {
				programok[i] = sc.nextLine();
			}

			System.out.println("2. feladat: Adjon meg egy sorszámot, es a program megmondja, egyszerusitheto e!");

			do {
				sorszam = Integer.parseInt(in.nextLine());
				if (sorszam <= 0 || sorszam > db) {
					System.out.println(
							"A sorszam tul nagy/tul kicsi! Az elerheto sorszamok szama: " + db + ", próbálja ujra");
				}
			} while (sorszam <= 0 || sorszam > db);

			egyszerusithetoE(programok[sorszam - 1]);

			System.out.println("3. Feladat: az adott út megtétele után hány lépés kell, hogy visszajusson a robot?");

			int[] robotut = { 0, 0 };

			System.out.println(programok[sorszam - 1]);

			for (int i = 0; i < programok[sorszam - 1].length(); i++) {
				switch (programok[sorszam - 1].charAt(i)) {
				case 'K':
					robotut[0] = robotut[0] + 1;
					break;
				case 'D':
					robotut[1] = robotut[1] - 1;
					break;
				case 'N':
					robotut[0] = robotut[0] - 1;
					break;
				case 'E':
					robotut[1] = robotut[1] + 1;
					break;

				}
			}

			/*
			 * for(int i = 0; i<programok[sorszam-1].length(); i++) {
			 * if(programok[sorszam-1].charAt(i) == 'K') { robotut[0] = robotut[0]+1; } else
			 * if (programok[sorszam-1].charAt(i) == 'D') { robotut[1] = robotut[1]-1; }
			 * else if (programok[sorszam-1].charAt(i) == 'N') { robotut[0] = robotut[0]-1;
			 * } else if (programok[sorszam-1].charAt(i) == 'E') { robotut[1] =
			 * robotut[1]+1;
			 * 
			 * }
			 */

			System.out.println(Math.abs(robotut[1]) + " Lépést kell tenni az ED, " + Math.abs(robotut[0])
					+ " Lepest kell tenni a KN tengely mentén.");

			System.out.println("4. Feladat; Energia");

			int[] energia = new int[db];
			for (int i = 0; i < programok.length; i++) {
				energia[i] = energia[i] + 3;
				for (int y = 1; y < programok[i].length(); y++) {
					if (programok[i].charAt(y) == programok[i].charAt(y - 1)) {
						energia[i] = energia[i] + 1;
					} else {
						energia[i] = energia[i] + 3;
					}
				}
			}

			for (int i = 0; i < energia.length; i++) {
				if (energia[i] <= 100) {
					System.out.println(i + 1 + " Sorszámu utasitássorhoz szükséges energia: " + energia[i]);
				}
			}

			System.out.println("5.ik feladat.");
			FileWriter fw = new FileWriter("ujprog.txt");
			for (int i = 0; i < programok.length; i++) {
				int index = 1;
				for (int y = 0; y < programok[i].length() - 1; y++) {
					if (programok[i].charAt(y) == programok[i].charAt(y + 1)) {
						index++;

					} else if (programok[i].charAt(y) != programok[i].charAt(y + 1)) {
						if (index == 1) {
							fw.write(programok[i].charAt(y));

						} else {
							fw.write(index + "" + programok[i].charAt(y));
							index = 1;

						}

					}

				}
				fw.write("\n");

			}

			fw.close();

			System.out.println("6. feladat, az elozo megforditasa;");

			fr = new FileReader("ujprog.txt");
			sc = new Scanner(fr);

			String NewInput = sc.nextLine();

			for (int i = 0; i < NewInput.length(); i++) {

				if (Character.isDigit(NewInput.charAt(i)) == true) {

					for (int x = 0; x < Integer.parseInt(String.valueOf(NewInput.charAt(i))) - 1; x++) {
						System.out.print(NewInput.charAt(i + 1));
					}
				} else
					System.out.print(NewInput.charAt(i));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void egyszerusithetoE(String program) {
		if (program.contains("ED") || program.contains("DE") || program.contains("NK") || program.contains("KN")) {
			System.out.println("A program egyszerusitheto");
		} else
			System.out.println("A program nem egyszerusitheto");
	}

}
