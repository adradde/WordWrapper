package com.epam.lisovyn;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adrade on 14.05.2016.
 */
public class WordWrapper {

	public static final String WHITESPACE = " ";

	public String wrap(String text, int lineLengthDelimeter) {
		List<String> words = Arrays.asList(text.split(" |\\n"));
		StringBuilder result = new StringBuilder();
		int currentLineLength = 0;
		for (String word : words) {

			if (wordExceedsLineLength(word, lineLengthDelimeter)) {
				result.append(word.substring(0, lineLengthDelimeter) + System.lineSeparator());
				currentLineLength = 0;
			} else if (lineIsExceeded(word, currentLineLength, lineLengthDelimeter)) {
				result.replace(result.length() - 1, result.length(), System.lineSeparator());
				result.append(word);
				currentLineLength = 0;
			} else {
				result.append(word).append(WHITESPACE);
				currentLineLength = word.length() + 1;
			}
		}
		return result.toString();
	}

	private boolean lineIsExceeded(String word, int symbolsInLine, int lineLength) {
		return symbolsInLine + word.length() >= lineLength;
	}

	private boolean wordExceedsLineLength(String word, int lineLength) {
		return word.length() >= lineLength;
	}
}
