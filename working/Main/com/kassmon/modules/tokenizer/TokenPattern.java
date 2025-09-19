
package com.kassmon.modules.tokenizer;

import java.util.regex.Pattern;

/**
 * Represents a pattern used to match tokens with a specific type.
 */
public class TokenPattern {

	private final Pattern pattern;
	private final String type;

	/**
	 * Constructs a TokenPattern with a compiled regex pattern and type.
	 *
	 * @param pattern the compiled regex pattern
	 * @param type    the type of the token
	 */
	public TokenPattern(Pattern pattern, String type) {
		this.pattern = pattern;
		this.type = type;
	}

	/**
	 * Constructs a TokenPattern with a regex string and type.
	 *
	 * @param pattern the regex string
	 * @param type    the type of the token
	 */
	public TokenPattern(String pattern, String type) {
		this(Pattern.compile(pattern), type);
	}

	/**
	 * Retrieves the regex pattern.
	 *
	 * @return the compiled regex pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * Retrieves the type of the token.
	 *
	 * @return the token type
	 */
	public String getType() {
		return type;
	}
}
