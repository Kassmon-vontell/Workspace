
package com.kassmon.modules.tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tokenizer class for breaking input strings into tokens based on defined
 * patterns.
 */
public class Tokenizer {

	private String input = "";
	private final ArrayList<TokenPattern> patterns = new ArrayList<>();

	/**
	 * Adds a token pattern to the tokenizer.
	 *
	 * @param pattern the regex pattern to match
	 * @param type    the type of the token
	 */
	public void addPattern(Pattern pattern, String type) {
		patterns.add(new TokenPattern(pattern, type));
	}
	
	public void addPattern(String regex, String type) {
		patterns.add(new TokenPattern(Pattern.compile(regex), type));
	}

	/**
	 * Checks if there are more tokens to process.
	 *
	 * @return true if there are tokens remaining, false otherwise
	 */
	public boolean hasNextToken() {
		return !input.isEmpty();
	}

	/**
	 * Retrieves the next token without modifying the input.
	 *
	 * @return the next token or a null token if none exist
	 */
	public Token getNextToken() {
		return getNextToken(false);
	}

	/**
	 * Retrieves the next token, optionally peeking without consuming it.
	 *
	 * @param peek if true, the input remains unchanged
	 * @return the next token or a null token if none exist
	 */
	public Token getNextToken(boolean peek) {
		if (!hasNextToken())
			return new Token("null", "null");
		input = input.trim();
		for (TokenPattern pattern : patterns) {
			Matcher matcher = pattern.getPattern().matcher(input);
			if (matcher.find()) {
				String tokenValue = matcher.group().trim();
				if (!peek)
					input = matcher.replaceFirst("");
				return new Token(tokenValue, pattern.getType());
			}
		}
		return new Token("null", "null");
	}

	/**
	 * Sets the input string to tokenize.
	 *
	 * @param input the input string
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * Retrieves the current input string.
	 *
	 * @return the input string
	 */
	public String getInput() {
		return input;
	}

	public Token[] getAllTokens() {
		ArrayList<Token> tokens = new ArrayList<>();
		while (hasNextToken()) {
			tokens.add(getNextToken());
		}
		return tokens.toArray(new Token[0]);
	}

}
