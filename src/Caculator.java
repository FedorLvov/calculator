import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculator {

	private static String process(String stringToProcess) {
		try {
			int[] parsed = parseLine(stringToProcess);
			Fraction f1 = new Fraction(parsed[0], parsed[1]);
			Fraction f2 = new Fraction(parsed[2], parsed[3]);
			Fraction res = null;
			switch (parsed[4]) {
			case 1:
				res = f1.add(f2);
				break;
			case 2:
				res = f1.sub(f2);
				break;
			case 3:
				res = f1.mul(f2);
				break;
			case 4:
				res = f1.div(f2);
				break;
			default:
				throw new Exception("Неизвестный оператор");
			}
			return stringToProcess + " = " + res.toString();
		} catch (Exception e) {
			return stringToProcess + " < " + e.getMessage();
		}
	}


	
	public static int[] parseLine(String st) throws Exception {

		st = st.replace(" ", "");
		Boolean isNumenator = true, isAlreadyHasOperator = false, isInsideFraction = true;
		int[] arr = { 0, 1, 0, 1, 0, 0 };

		for (int i = 0; ((i < st.length()) && arr[5] == 0); i++) {

			switch (st.charAt(i)) {
				
			case '+':
				if (!isAlreadyHasOperator)
					isAlreadyHasOperator = isInsideFraction = isNumenator = true;
				else
					throw new Exception("Выражение содержит более одного операнда");
				arr[4] = 1;
				break;

			case '-':
				if (!isAlreadyHasOperator)
					isAlreadyHasOperator = isInsideFraction = isNumenator = true;
				else
					throw new Exception("Выражение содержит более одного операнда");
				arr[4] = 2;
				break;

			case '*':
				if (!isAlreadyHasOperator)
					isAlreadyHasOperator = isInsideFraction = isNumenator = true;
				else
					throw new Exception("Выражение содержит более одного операнда");
				arr[4] = 3;
				break;

			case '/':
				if (isInsideFraction)
					isNumenator = isInsideFraction = false;
				else if (!isAlreadyHasOperator) {
					isAlreadyHasOperator = isInsideFraction = isNumenator = true;
					arr[4] = 4;
				} else
					throw new Exception("Выражение содержит более одного операнда");
				break;

			default:
				if (Character.isDigit(st.charAt(i))){
					int j = 1;
					for (; i + j < st.length(); j++) {
						int val = Character.getNumericValue(st.charAt(i + j));
						if ((val > 9) || (val < 0))
							break;
					}

					int fullParsedNumber = Integer.parseInt(st.substring(i, i + j));
					if (isNumenator) {
						if (!isAlreadyHasOperator)
							arr[0] = fullParsedNumber;
						else
							arr[2] = fullParsedNumber;
					} else {
						if (fullParsedNumber != 0) {
							if (!isAlreadyHasOperator)
								arr[1] = fullParsedNumber;
							else
								arr[3] = fullParsedNumber;
						} else
							throw new Exception("Знаменатель не должен быть равен 0");
					}
					i += j - 1;
					break;
				}
				else throw new Exception("Выраение содержит недопустимые символы");
			}
		}
		if (isInsideFraction)
			throw new Exception("Не корретный ввод дроби");
		if (!isAlreadyHasOperator)
			throw new Exception("Выражение не содержит операнда");
		return arr;
	}

	public static void main(String[] args) {
		System.out.println("Программа \"Калькулятор обычных дробей\". Автор: Львов Фёдор.\n"
				+ "Скобки являются недопустимыми символами. Операнды должны быть положительными\n ");
		String finalres = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("Fraction.txt"));

			String line = null;
			for (int linenumber = 1; (line = in.readLine()) != null; linenumber++) {
				String res = process(line);
				System.out.println(linenumber + ") " + res);
				finalres += linenumber + ") " + res + '\n';
			}
			
			FileWriter fw = new FileWriter("Result.xml");
			fw.write(finalres);
			fw.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
