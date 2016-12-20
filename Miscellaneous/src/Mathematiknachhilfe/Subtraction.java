package Mathematiknachhilfe;

import java.util.Random;

public class Subtraction {
	public static void main(String[] args) {
		// case0(15);
		// System.out.println("------------------");
		// case1(15);
		// System.out.println("------------------");
		case2(15);
		Random random = new Random();
		for (int i = 0; i < 55; i++) {
			switch (random.nextInt(3)) {
			case 0:
				case0(1);
				break;
			case 1:
				case1(1);
				break;
			case 2:
				case2(1);
				break;
			}
		}
	}

	private static void big() {
		Random random = new Random();
		for (int i = 0; i < 55; i++)
			System.out.println("(" + (random.nextInt(2) == 1 ? "+" : "-") + random.nextInt(50) + ") "
					+ (random.nextInt(2) == 1 ? "+" : "-") + " (" + (random.nextInt(2) == 1 ? "+" : "-")
					+ random.nextInt(50) + ") " + (random.nextInt(2) == 1 ? "+" : "-") + " ("
					+ (random.nextInt(2) == 1 ? "+" : "-") + random.nextInt(50) + ") = ");
	}

	private static void small() {
		Random random = new Random();
		for (int i = 0; i < 55; i++)
			System.out.println(" 0 + " + "(" + (random.nextInt(2) == 1 ? "+" : "-") + (random.nextInt(7) + 2) + ") "
					+ (random.nextInt(2) == 1 ? "+" : "-") + " (" + (random.nextInt(2) == 1 ? "+" : "-")
					+ (random.nextInt(7) + 2) + ") =                  |              " + " 0 + " + "("
					+ (random.nextInt(2) == 1 ? "+" : "-") + (random.nextInt(7) + 2) + ") "
					+ (random.nextInt(2) == 1 ? "+" : "-") + " (" + (random.nextInt(2) == 1 ? "+" : "-")
					+ (random.nextInt(7) + 2) + ") =");
	}

	private static void case0(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++)
			System.out.println(
					(random.nextInt(20) + 1) + " - " + (random.nextInt(20) + 1) + " =                  |              "
							+ (random.nextInt(20) + 1) + " - " + (random.nextInt(20) + 1) + " =");
	}

	private static void case1(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++)
			System.out.println("-" + (random.nextInt(20) + 1) + " + " + (random.nextInt(20) + 1)
					+ " =                  |              " + "-" + (random.nextInt(20) + 1) + " + "
					+ (random.nextInt(20) + 1) + " =");
	}

	private static void case2(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++)
			System.out.println("-" + (random.nextInt(20) + 1) + " - " + (random.nextInt(20) + 1)
					+ " =                  |              " + "-" + (random.nextInt(20) + 1) + " - "
					+ (random.nextInt(20) + 1) + " =");
	}

}
