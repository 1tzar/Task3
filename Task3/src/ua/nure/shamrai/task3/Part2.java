package ua.nure.shamrai.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	private static final String EOL = System.lineSeparator();

	public static void main(String[] args) {
		String input = Util.readFile("part2.txt");
		System.out.println(convert(input));

	}

	public static String convert(String input) {
		String regEx = "[^A-Za-zÀ-ß¨¯Ià-ÿ¸¿³]+";
		int min = getMinWord(input, regEx);
		int max = getMaxWord(input, regEx);
		StringBuilder strb = new StringBuilder();
		String str = uniqueSequence(min, input);
		strb.append("Min: ");
		strb.append(str);
		strb.append(EOL);
		str = uniqueSequence(max, input);
		strb.append("Max: ");
		strb.append(str);
		return strb.toString();

	}

	public static String uniqueSequence(int number, String data) {
		Pattern pattern = Pattern.compile("\\b(?U)\\w{" + number + "}\\b");
		Matcher matcher = pattern.matcher(data);
		String foundString = "";
		boolean flag = false;
		int i = 0;
		String[] buffer = new String[0];
		while (matcher.find()) {
			foundString = matcher.group();
			flag = findElement(foundString, buffer);
			if (!flag) {
				if (buffer.length == 0) {
					buffer = new String[buffer.length + 1];
				} else {
					String[] tmp = buffer;
					buffer = new String[tmp.length + 1];
					System.arraycopy(tmp, 0, buffer, 0, tmp.length);
				}
				buffer[i++] = foundString;
			}
		}
		return String.join(", ", buffer);
	}

	public static boolean findElement(String elem, String[] src) {
		for (int j = 0; j < src.length; j++) {
			if (elem.equals(src[j])) {
				return true;
			}
		}
		return false;

	}

	public static int getMinWord(String input, String regEx) {
		String[] bufferMin = input.split(regEx);
		int minLength = bufferMin[0].length();
		for (int i = 1; i < bufferMin.length - 1; i++) {
			if (minLength > bufferMin[i].length()) {
				minLength = bufferMin[i].length();
			}
		}
		return minLength;
	}

	public static int getMaxWord(String input, String regEx) {
		String[] bufferMax = input.split(regEx);
		int maxLength = bufferMax[0].length();
		for (int i = 1; i < bufferMax.length - 1; i++) {
			if (maxLength < bufferMax[i].length()) {
				maxLength = bufferMax[i].length();
			}
		}
		return maxLength;
	}
}
