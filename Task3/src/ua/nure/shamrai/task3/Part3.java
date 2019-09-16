package ua.nure.shamrai.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public static void main(String[] args) {
		String input = Util.readFile("part3.txt");
		System.out.println(convert(input));

	}

	public static String convert(String input) {
		Pattern pattern = Pattern.compile("(?U)\\w{3,}");
		String changedString = "";
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String foundString = matcher.group();
			char firstChar = foundString.charAt(0);
			if (Character.isUpperCase(foundString.charAt(0))) {
				changedString = Character.toLowerCase(firstChar) + foundString.substring(1);
			} else {
				changedString = Character.toUpperCase(firstChar) + foundString.substring(1);
			}
			input = input.substring(0, matcher.start()) + changedString + input.substring(matcher.end());
		}
		return input;
	}

}
