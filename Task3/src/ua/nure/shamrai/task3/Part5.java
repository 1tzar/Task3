package ua.nure.shamrai.task3;

public class Part5 {
	private static final int I = 1;
	private static final int V = 5;
	private static final int X = 10;
	private static final int L = 50;
	private static final int C = 100;
	private static final int ONE_HUNDRED = 100;
	public static void main(String[] args) {
		String roman = "";
		int decimal = 0;
		for (int i = 1; i <= ONE_HUNDRED; i++) {
			roman = decimal2Roman(i);
			decimal = roman2Decimal(roman);
			System.out.println(i + " —> " + roman + " —> " + decimal);
		}
	}

	public static int roman2Decimal(String s) {
		int number = 0;
		int previousNumber = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int currentNumber = getDecimalNumber(s.charAt(i));
			if (currentNumber >= previousNumber) {
				number += currentNumber;
			} else {
				number -= currentNumber;
			}
			previousNumber = currentNumber;
		}
		return number;
	}

	public static String oneToRome(int num, char a1, char a2, char a3) {
		StringBuilder strb = new StringBuilder();

		if (num != 0) {
			if (num < 4) {
				while (num > 0) {
					strb.append(a1);
					num--;
				}
				return strb.toString();
			} else if (num == 4) {
				strb.append(a1);
				strb.append(a2);
			} else if (num == 5) {
				strb.append(a2);
			} else if (num == 9) {
				strb.append(a1);
				strb.append(a3);
				return strb.toString();
			} else {
				strb.append(a2);
				while (num > 5) {
					strb.append(a1);
					num--;
				}
				return strb.toString();
			}
		}

		return strb.toString();
	}

	public static String decimal2Roman(int x) {
		char[] numbs = Integer.toString(x).toCharArray();
		String string = "";

		if (numbs.length == 1) {
			return oneToRome(x, 'I', 'V', 'X');
		} else if (numbs.length == 2) {
			string += oneToRome(Character.getNumericValue(numbs[0]), 'X', 'L', 'C');
			string += oneToRome(Character.getNumericValue(numbs[1]), 'I', 'V', 'X');
			return string;
		}

		return "C";
	}

	public static int getDecimalNumber(char romanNumber) {
		int decimalNumber = 0;
		switch (romanNumber) {
		case 'I':
			decimalNumber = I;
			break;
		case 'V':
			decimalNumber = V;
			break;
		case 'X':
			decimalNumber = X;
			break;
		case 'L':
			decimalNumber = L;
			break;
		case 'C':
			decimalNumber = C;
			break;
		default:
			decimalNumber = 0;
			break;
		}
		return decimalNumber;
	}
}
