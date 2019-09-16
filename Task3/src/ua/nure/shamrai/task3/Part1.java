package ua.nure.shamrai.task3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final String EOL = System.lineSeparator();
	private static final int MIN = 1000;
	private static final int MAX = 9000;

	public static void main(String[] args) {
		String input = Util.readFile("part1.txt");
		System.out.println(Part1.convert1(input));
		System.out.println(Part1.convert2(input));
		System.out.println(Part1.convert3(input));
		System.out.println(Part1.convert4(input));
	}

	public static String convert1(String input) {
		StringBuilder strb = new StringBuilder();
		Pattern pattern = Pattern.compile("(.*);(.*);(.+@.+)");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			strb.append(matcher.group(1));
			strb.append(": ");
			strb.append(matcher.group(3));
			strb.append(EOL);
		}
		return strb.toString();
	}

	public static String convert2(String input) {
		StringBuilder b = new StringBuilder();
		Pattern p = Pattern.compile("(.*);(.*) (.*);(.*)");
		Matcher m = p.matcher(input);
		while (m.find()) {
			b.append(m.group(3));
			b.append(' ');
			b.append(m.group(2));
			b.append(" (email: ");
			b.append(m.group(4));
			b.append(')');
			b.append(EOL);

		}
		return b.toString();
	}

	public static String convert3(String input) {
		Pattern pattern = Pattern.compile("(.*);(.*) (.*)@(.*)");
		Matcher matcher = pattern.matcher(input);
		StringBuilder strb = new StringBuilder();
		String[] names = new String[0];
		int i = 0;
		while (matcher.find()) {
			Pattern pattern1 = Pattern.compile("(.*);(.*) (.*)@(" + matcher.group(4) + ')');
			Matcher m = pattern1.matcher(input);
			StringBuilder stra = new StringBuilder();
			stra.append(matcher.group(4));
			stra.append(" ==> ");
			if (strb.indexOf(matcher.group(4)) == -1) {
				while (m.find()) {
					if (names.length == 0) {
						names = new String[names.length + 1];
					} else {
						String[] tmp = names;
						names = new String[tmp.length + 1];
						System.arraycopy(tmp, 0, names, 0, tmp.length);
					}
					names[i++] = m.group(1);
				}
				stra.append(String.join(", ", names));
				stra.append(EOL);
				strb.append(stra);
				names = new String[0];
				i = 0;
			}
		}
		return strb.toString();
	}

	public static String convert4(String input) {
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder strb = new StringBuilder();
		Pattern p = Pattern.compile("(.*);(.*);(.*)");
		Matcher m = p.matcher(input);
		m.find();
		strb.append(m.group());
		strb.append(";Password");
		strb.append(System.lineSeparator());

		while (m.find()) {
			int password = secureRandom.nextInt(MAX) + MIN;
			strb.append(m.group());
			strb.append(';');
			strb.append(password);
			strb.append(EOL);
		}
		return strb.toString();
	}

}
