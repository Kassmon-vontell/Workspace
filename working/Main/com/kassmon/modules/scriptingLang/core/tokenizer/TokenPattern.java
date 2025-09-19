package com.kassmon.modules.scriptingLang.core.tokenizer;

import java.util.regex.Pattern;

public class TokenPattern {

	private TokenType type;
	private Pattern pattern;

	public TokenPattern(TokenType type, Pattern pattern) {
		this.type = type;
		this.pattern = pattern;
	}

	public TokenType getType() {
		return type;
	}

	public Pattern getPattern() {
		return pattern;
	}
}
