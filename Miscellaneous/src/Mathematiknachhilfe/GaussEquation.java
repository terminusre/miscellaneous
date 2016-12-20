package Mathematiknachhilfe;

import java.util.Random;

public class GaussEquation {

	private int variables;
	private Rational[] varibleFactors;

	public GaussEquation(int variables, int maxFactor, int maxDenominator, int maxConstant) {
		varibleFactors = new Rational[variables + 1];
		this.variables = variables;
		Random random = new Random();
		for (int i = 0; i < variables; ++i)
			varibleFactors[i] = new Rational(1, random.nextInt(maxDenominator) + 1)
					.add(new Rational(random.nextInt() % maxFactor));
		varibleFactors[variables] = new Rational(random.nextInt() % maxConstant);
	}

	public GaussEquation() {
		this(3, 5, 10, 100);
	}

	public Rational getValue(int i) {
		return varibleFactors[i];
	}

	public void add(GaussEquation equation) {
		for (int i = 0; i < variables + 1; ++i)
			varibleFactors[i] = varibleFactors[i].add(equation.getValue(i));
	}

	public void sub(GaussEquation equation) {
		for (int i = 0; i < variables + 1; ++i)
			varibleFactors[i] = varibleFactors[i].sub(equation.getValue(i));
	}

	public void mul(Rational factor) {
		for (int i = 0; i < variables + 1; ++i)
			varibleFactors[i] = varibleFactors[i].mul(factor);
	}

	public void div(Rational r) {
		for (int i = 0; i < variables + 1; ++i)
			varibleFactors[i] = varibleFactors[i].div(r);
	}

	public void eval(int variable, Rational value) {
		varibleFactors[variables] = varibleFactors[variables].sub(varibleFactors[variable].mul(value));
		varibleFactors[variable] = new Rational(0, 1);
	}

	public void normalize(int i) {
		varibleFactors[variables] = varibleFactors[variables].div(varibleFactors[i]);
		varibleFactors[i] = new Rational(1, 1);
	}

	// public void eval(GaussEquation equation) {
	// int i = 0;
	// while (equation.getValue(i).zaehler == 0)
	// i++;
	// eval(i, equation.getConstant());
	// }
	//
	// public void eval(GaussEquation[] equations) {
	// int i;
	// for (GaussEquation equation : equations) {
	// i = 0;
	// while (equation.getValue(i).zaehler == 0)
	// i++;
	// eval(i, equation.getConstant());
	// }
	// }
	//
	// public void normalize() {
	// int i = 0;
	// while (varibleFactors[i].zaehler == 0)
	// i++;
	// varibleFactors[variables] =
	// varibleFactors[variables].div(varibleFactors[i]);
	// varibleFactors[i] = new Rational(1, 1);
	// }
	//
	// private Rational getConstant() {
	// return varibleFactors[variables];
	// }

	@Override
	public String toString() {
		String string = "";
		boolean firstPartEmpty = true;
		Rational factor;
		for (int i = 0; i < variables; ++i) {
			factor = varibleFactors[i];
			if (factor.zaehler != 0) {
				if (!firstPartEmpty)
					string += " ";
				if (factor.zaehler > 0 && !firstPartEmpty)
					string += "+";
				if (!(factor.zaehler == 1 && factor.nenner == 1))
					if (factor.zaehler == -1 && factor.nenner == 1)
						string += "-";
					else
						string += factor;
				string += (char) ('A' + i);
				firstPartEmpty = false;
			}
		}
		if (firstPartEmpty)
			string = "0";
		string += " = " + varibleFactors[variables];
		// String s = "";
		// for(Rational r: varibleFactors)
		// s += r + " ";
		// string += " ||| " + s;
		return string;
	}
}
