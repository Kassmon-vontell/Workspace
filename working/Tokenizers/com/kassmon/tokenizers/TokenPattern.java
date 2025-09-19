package com.kassmon.tokenizers;

import java.util.regex.Pattern;

public class TokenPattern {
	
	private Pattern pattern;
	private String type;
	
	public TokenPattern(Pattern pattern, String type) {
		this.pattern = pattern;
		this.type = type;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
	public String getType() {
		return type;
	}
	
}