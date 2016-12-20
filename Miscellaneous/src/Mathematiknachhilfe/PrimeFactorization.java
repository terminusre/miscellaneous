package Mathematiknachhilfe;

import java.util.Random;

public class PrimeFactorization {

	public static void main(String[] args) {
		int[] prime_low = { 2, 3, 5, 7 };
		int[] prime_high = { 11, 13, 17, 19, 23 };

		// , 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101

		int max_count_factors = 4;
		Random random = new Random();

		int[] factors = new int[max_count_factors];

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < max_count_factors; j++) {
				factors[j] = prime_low[1];
			}
		}

		System.out.println(prime_low.length);

	}

	// public static printExcersise(){}

}
