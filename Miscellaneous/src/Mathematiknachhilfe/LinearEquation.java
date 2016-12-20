package Mathematiknachhilfe;

import java.util.Random;

public class LinearEquation {
	private int variables;
	private Rational[] varibleFactors;

	public LinearEquation(int variables, int maxFactor, int maxDenominator, int maxConstant) {
		varibleFactors = new Rational[(variables + 1) * 2];
		this.variables = variables;
		Random random = new Random();
		for (int i = 0; i < (variables + 1) * 2; ++i) {
			if (i % (variables + 1) != variables)
				varibleFactors[i] = new Rational(1, random.nextInt(maxDenominator) + 1)
						.add(new Rational(random.nextInt() % maxFactor));
			else
				varibleFactors[i] = new Rational(random.nextInt() % maxConstant);
		}
	}

	public LinearEquation() {
		this(3, 5, 10, 100);
	}

	public Rational getFactor(int i) {
		return varibleFactors[i];
	}

	public void add(LinearEquation equation) {
		for (int i = 0; i < (variables + 1) * 2; ++i)
			varibleFactors[i] = varibleFactors[i].add(equation.getFactor(i));
	}

	public void sub(LinearEquation equation) {
		for (int i = 0; i < (variables + 1) * 2; ++i)
			varibleFactors[i] = varibleFactors[i].sub(equation.getFactor(i));
	}

	public void mul(Rational factor) {
		for (int i = 0; i < (variables + 1) * 2; ++i)
			varibleFactors[i] = varibleFactors[i].mul(factor);
	}

	public void div(Rational r) {
		for (int i = 0; i < (variables + 1) * 2; ++i)
			varibleFactors[i] = varibleFactors[i].div(r);
	}

	public void eval(int variable, Rational value) {
		varibleFactors[variables] = varibleFactors[variables].add(varibleFactors[variable].mul(value));
		varibleFactors[(variables * 2) + 1] = varibleFactors[(variables * 2) + 1]
				.add(varibleFactors[variables + 1 + variable].mul(value));
		varibleFactors[variable] = new Rational(0, 1);
		varibleFactors[variables + 1 + variable] = new Rational(0, 1);
	}

	@Override
	public String toString() {
		boolean firstPartEmpty = true;
		boolean secondPartEmpty = true;
		String string = "";
		Rational factor;
		for (int i = 0; i < (variables + 1) * 2; ++i) {
			factor = varibleFactors[i];
			if (factor.zaehler != 0) {
				if (i > 0)
					string += " ";
				if (factor.zaehler > 0)
					string += "+";
				string += factor.toString();
				if (factor.zaehler != 0) {
					if (i < variables + 1)
						firstPartEmpty = false;
					else
						secondPartEmpty = false;
				}
				if (i % (variables + 1) != variables)
					string += (char) ('A' + (i % (variables + 1)));
			}
			if (i == variables)
				string += " =";
		}
		if (firstPartEmpty)
			string = "0" + string;
		if (secondPartEmpty)
			string = string + " 0";
		return string;
	}

}
