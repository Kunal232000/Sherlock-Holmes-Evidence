package pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clue {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T;
		String pattern;
		String text;
		String result;

		T = scan.nextInt();
		if (T >= 1 && T <= 100) {

			scan.nextLine();

			for (int i = 0; i < T; i++) {

				pattern = scan.nextLine();
				if (pattern.length() >= 1 && pattern.length() <= 1000) {

					text = scan.nextLine();

					if (text.length() >= 1 && text.length() <= 100000) {
						result = checkClue(pattern, text);
						System.out.println(result);
					} else {
						System.out.println("Enter a String of length Between 1 to 100000");
					}

				} else {
					System.out.println("Enter a String of length between 1 to 1000");
				}

			}

		} else {
			System.out.println("Enter a value between 1 to 100");
		}

	}

	public static String checkClue(String pattern, String text) {
		if (pattern.length() > text.length()) {
			return "NO";
		}

		Map<Character, Integer> patternCount = new HashMap<>();
		Map<Character, Integer> textCount = new HashMap<>();

		for (char ch : pattern.toCharArray()) {
			patternCount.put(ch, patternCount.getOrDefault(ch, 0) + 1);

		}
		int start = 0;
		int end = 0;

		while (end < text.length()) {
			char currentChar = text.charAt(end);

			textCount.put(currentChar, textCount.getOrDefault(currentChar, 0) + 1);

			if (end - start + 1 > pattern.length()) {
				char removedChar = text.charAt(start);
				if (textCount.get(removedChar) == 1) {
					textCount.remove(removedChar);
				} else {
					textCount.put(removedChar, textCount.get(removedChar) - 1);
				}
				start++;
			}

			if (textCount.equals(patternCount)) {
				return "YES";
			}

			end++;
		}

		return "NO";

	}
}
