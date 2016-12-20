package Mathematiknachhilfe;

public class EquationsBasicMaths {

	public static void main(String[] args) {
		int variables = 3;
		int maxFactor = 5;
		int maxConstant = 100;
		int maxDenominator = 1;

		GaussEquation[] equations = new GaussEquation[variables];

		// generate equations
		for (int i = 0; i < variables; ++i)
			equations[i] = new GaussEquation(variables, maxFactor, maxDenominator, maxConstant);
		p(equations);

		solve(equations, variables);
	}

	private static GaussEquation[] solve(GaussEquation[] equations, int u) {

		Rational inverse;
		// for (int i = 0; i < 1; ++i) {
		// eliminate variables
		inverse = equations[1].getValue(0).div(equations[0].getValue(0));
		equations[0].mul(inverse);
		equations[1].sub(equations[0]);

		// p(equations);
		// System.out.println(inverse);
		inverse = equations[2].getValue(0).div(equations[0].getValue(0));
		equations[0].mul(inverse);
		equations[2].sub(equations[0]);
		p(equations);

		inverse = equations[2].getValue(1).div(equations[1].getValue(1));
		equations[1].mul(inverse);
		equations[2].sub(equations[1]);
		equations[2].normalize(2);
		p(equations);

		equations[1].eval(2, equations[2].getValue(2));
		equations[0].eval(2, equations[2].getValue(2));
		equations[1].normalize(1);
		p(equations);

		equations[0].eval(1, equations[1].getValue(1));
		equations[0].normalize(0);
		p(equations);

		// }
		Rational r = new Rational(0, 1);
		for (int i = 0; i < u; ++i)
			r = r.add(equations[i].getValue(u));
		System.out.println(r);
		return null;
	}

	private static void p(GaussEquation[] equations) {
		for (int i = 0; i < equations.length; ++i)
			System.out.println(equations[i]);
		System.out.println();
	}

}
