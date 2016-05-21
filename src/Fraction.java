import lombok.Data;

public @Data class Fraction {
	private final int numerator, denominator;

	public Fraction(int numerator, int denominator) throws Exception {
		int gcd = greatestCommonDivider(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
		if (denominator == 0)
			throw new Exception("Знаменатель не должен быть равен 0");
	}

	private int greatestCommonDivider(int num, int den) {
		return den == 0 ? num : greatestCommonDivider(den, num % den);
	}

	private int leastCommonMultiple(int a, int b) {
		return a * (b / greatestCommonDivider(a, b));
	}

	public Fraction add(Fraction fr2) throws Exception {
		int lcm = leastCommonMultiple(this.denominator, fr2.denominator);
		int mul1 = lcm / this.denominator;
		int mul2 = lcm / fr2.denominator;
		return new Fraction(this.numerator * mul1 + fr2.denominator * mul2, this.denominator * mul1);
	}

	public Fraction sub(Fraction fr2) throws Exception {
		int lcm = leastCommonMultiple(this.denominator, fr2.denominator);
		int mul1 = lcm / this.denominator;
		int mul2 = lcm / fr2.denominator;
		return new Fraction(this.numerator * mul1 - fr2.denominator * mul2, this.denominator * mul1);
	}

	public Fraction mul(Fraction fr2) throws Exception {
		return new Fraction(this.numerator * fr2.numerator, this.denominator * fr2.denominator);
	}

	public Fraction div(Fraction fr2) throws Exception {
		return new Fraction(this.numerator * fr2.denominator, this.denominator * fr2.numerator);
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
}
