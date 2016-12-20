package Mathematiknachhilfe;

import java.util.Random;

public class Brueche {

	public static void main(String[] args) {
		int[] prime_factors_small = { 2, 3 };
		int[] prime_factors_middle = { 5, 7 };
		int[] prime_factors_large = { 11, 13, /* 17, 19, 23 */ };
		Random random = new Random();
		Rational summand0;
		Rational summand1;
		Rational result;
		for (int i = 0; i < 55; i++)

			System.out.println((random.nextInt(32) + 1) + "/" + (random.nextInt(32) + 1) + " + "
					+ (random.nextInt(32) + 1) + "/" + (random.nextInt(32) + 1) + " = ");
	}

}
