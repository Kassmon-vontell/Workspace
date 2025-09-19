package com.kassmon.modules.tokenizer;

/**
 * The Token class represents a token with a specific value and type. It is used
 * to encapsulate the lexical elements of a program or text.
 */
public class Token {

	// The value of the token (e.g., a string representation of the token).
	private final String value;

	// The type of the token (e.g., identifier, keyword, operator).
	private final String type;

	/**
	 * Constructs a Token with the specified value and type.
	 *
	 * @param value The value of the token.
	 * @param type  The type of the token.
	 */
	public Token(String value, String type) {
		this.value = value;
		this.type = type;
	}

	/**
	 * Retrieves the value of the token.
	 *
	 * @return The value of the token.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Retrieves the type of the token.
	 *
	 * @return The type of the token.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns a string representation of the token.
	 *
	 * @return A string in the format "Token[type=TYPE, value=VALUE]".
	 */
	@Override
	public String toString() {
		return String.format("Token[type=%s, value=%s]", type, value);
	}
}
