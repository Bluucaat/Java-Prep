package robot;

import java.util.Scanner;
import java.io.FileReader;

public class Robot {

	public static double legvonal(int x, int y) {

		double t = Math.sqrt(x * x + y * y);

		return Math.round(t * 1000.0) / 1000.0;

	}

	public static void main(String[] args) {

		// 1.feladat
		System.out.println("1. feladat");
		try {

			FileReader fr = new FileReader("program.txt");
			Scanner sc = new Scanner(fr);

			int db = Integer.parseInt(sc.nextLine());
			String[] robot = new String[db];

			for (int i = 0; i < robot.length; i++) {

				robot[i] = sc.nextLine();
				// System.out.println(robot[i]);

			}

			// 2.feladat

			System.out.println("2.feladat");

			for (int i = 0; i < db; i++) {

				if (robot[i].contains("ED") || robot[i].contains("DE") || robot[i].contains("KN")
						|| robot[i].contains("NK")) {
					System.out.print("Egyszerusitheto: ");
				} else {
					System.out.print("Nem egyszerusitheto: ");
				}
				System.out.println(robot[i]);
			}

			// 2/b feladat

			int x = 0;
			int y = 0;

			for (int i = 0; i < robot.length; i++) {
				x = 0;
				y = 0;
				for (int j = 0; j < robot[i].length(); j++) {

					switch (robot[i].charAt(j)) {

					case 'E':
						y++;
						break;

					case 'D':
						y--;
						break;

					case 'N':
						x--;
						break;

					case 'K':
						x++;
						break;

					}

				}

				System.out.println(y + " lepest kell tenni ED iranyba, " + x + " lepes kell tenni KN iranyba.");

			}

			// 2/c feladat

			System.out.println("2/c feladat");

		}

		catch (Exception e) {

			System.out.println(e);
		}

	}

}
