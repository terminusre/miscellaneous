package Mathematiknachhilfe;

import java.util.Random;

public class ExercisesBasicMaths {

	public static void main(String[] args) {
		int upper;
		int saltUpper = 149;
		int lower;
		int saltLower = 57;
		Random random = new Random();
		int mode = 3;
		int exercises = 140;
		int absoluteValue = 0;
		int outputMode = 1;
		String results = "";

		switch (mode) {
		// Addition
		// http://www.mathematik-wissen.de/schriftliches_addieren.htm
		case 0:
			for (int i = 0; i < exercises; i++) {
				lower = random.nextInt(1000) + saltLower;
				upper = random.nextInt(10000) + lower + saltUpper;
				if (outputMode == 0)
					System.out.format("%10d +%4d =%32d\n--------------------------------------------------\n", upper,
							lower, (upper + lower));
				else {
					System.out.format("%10d +%4d =\n", upper, lower);
					results += (upper + lower) + "\n";
				}
			}
			break;
		// Subtraktion
		// http://www.mathematik-wissen.de/schriftliches_subtrahieren.htm
		case 1:
			for (int i = 0; i < exercises; i++) {
				lower = random.nextInt(1000) + saltLower;
				upper = random.nextInt(10000) + lower + saltUpper;
				if (outputMode == 0)
					System.out.format("%10d -%4d =%32d\n--------------------------------------------------\n", upper,
							lower, (upper - lower));
				else {
					System.out.format("%10d -%4d =\n", upper, lower);
					results += (upper - lower) + "\n";
				}
			}
			break;
		// Multiplikation
		// http://www.mathematik-wissen.de/schriftliches_multiplizieren.htm
		case 2:
			for (int i = 0; i < exercises; i++) {
				lower = random.nextInt() % 900;
				if (lower < 0)
					lower -= saltLower;
				else
					lower += saltLower;
				upper = random.nextInt() % 10000;
				absoluteValue = lower;
				if (absoluteValue < 0)
					absoluteValue = -absoluteValue;
				if (upper < 0)
					upper -= absoluteValue + saltUpper;
				else
					upper += absoluteValue + saltUpper;
				if (outputMode == 0)
					System.out.format("%10d *%4d =%32d\n--------------------------------------------------\n", upper,
							lower, (upper * lower));
				else {
					System.out.format("%10d *%4d =\n", upper, lower);
					results += (upper * lower) + "\n";
				}
			}
			break;
		// Division
		// http://www.mathematik-wissen.de/schriftliches_dividieren.htm
		case 3:
			System.out.format("%37cQuotient, Rest\n", ' ');
			for (int i = 0; i < exercises; i++) {
				lower = random.nextInt() % 80;
				if (lower < 3 && lower > -3)
					lower = 3;
				upper = random.nextInt() % 10000;
				absoluteValue = lower;
				if (absoluteValue < 0)
					absoluteValue = -absoluteValue;
				if (upper < 0)
					upper -= absoluteValue + saltUpper;
				else
					upper += absoluteValue + saltUpper;
				if (outputMode == 0)
					System.out.format("%10d :%3d =%28d, %3d\n--------------------------------------------------\n",
							upper, lower, (upper / lower), (upper % lower));
				else {
					System.out.format("%10d :%4d =\n", upper, lower);
					results += (upper / lower) + ", " + (upper % lower) + "\n";
				}
			}
			break;
		default:
			System.out.println("Error: mode doesn't exist!");
			break;
		}
		if (outputMode == 1)
			System.out.print(results);
	}
}
