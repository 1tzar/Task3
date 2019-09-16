package ua.nure.shamrai.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

	public static void main(String[] args) {
		String input = Util.readFile("part6.txt");
		System.out.println(convert(input));
	}

	public static String convert(String input) {
		int i = 0;
		Pattern p = Pattern.compile("(?U)\\w+");
		Matcher m = p.matcher(input);
		while (m.find()) {
			if (findStr(m.group(),input)) {
				input = input.substring(0, m.start() + i) + '_' + input.substring(m.start() + i);
				++i;
			}
		}
		return input;
	}

	public static boolean findStr(String target,String input) {
		String[] array = input.split("[^A-Za-zÀ-ß¨²¯à-ÿ¸³¿]+");
		int count = 0;
		for (int i = 0; i < array.length; i++){
			if (target.equals(array[i])) {
				++count;
			}
			if (count == 2) {
				return true;
			}
		}
		return false;
	}

}