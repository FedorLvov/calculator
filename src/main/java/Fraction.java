import lombok.Data;

public @Data class Fraction { //Класс дробь
	private final int numerator, denominator; //Поля: числитель и знаменатель

	public Fraction(int numerator, int denominator) throws Exception { //конструктор
		int gcd = greatestCommonDivider(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
		if (denominator == 0)
			throw new Exception("Знаменатель не должен быть равен 0");
	}

	private int greatestCommonDivider(int num, int den) { //метод находящий НОД, нужен метода сокращения дроби
		return den == 0 ? num : greatestCommonDivider(den, num % den);
	}

	private int leastCommonMultiple(int a, int b) { //метод находящий НОК, нужен для метода нахождения общего знаменателя
		return a * (b / greatestCommonDivider(a, b));
	}

	public Fraction add(Fraction fr2) throws Exception { //Метод сложения дробей
		int lcm = leastCommonMultiple(this.denominator, fr2.denominator);
		int mul1 = lcm / this.denominator;
		int mul2 = lcm / fr2.denominator;
		return new Fraction(this.numerator * mul1 + fr2.numerator * mul2, this.denominator * mul1);
	}

	public Fraction sub(Fraction fr2) throws Exception { //Метод вычитания дробей
		int lcm = leastCommonMultiple(this.denominator, fr2.denominator);
		int mul1 = lcm / this.denominator;
		int mul2 = lcm / fr2.denominator;
		return new Fraction(this.numerator * mul1 - fr2.numerator * mul2, this.denominator * mul1);
	}

	public Fraction mul(Fraction fr2) throws Exception { //Метод умножения дробей
		return new Fraction(this.numerator * fr2.numerator, this.denominator * fr2.denominator);
	}

	public Fraction div(Fraction fr2) throws Exception { //Метод деления дробей
		return new Fraction(this.numerator * fr2.denominator, this.denominator * fr2.numerator);
	}

	@Override
	public String toString() { //Метод преобразующий дробь в тип String для вывода в консоль и в файл XML
		return this.numerator + "/" + this.denominator;
	}
}
