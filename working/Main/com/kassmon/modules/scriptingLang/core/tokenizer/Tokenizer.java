package com.kassmon.modules.scriptingLang.core.tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	
	private String input = "";
	private ArrayList<TokenPattern> patterns;
	
	public Tokenizer() {
        patterns = new ArrayList<>();
	}
	
	public void addPattern(TokenPattern pattern) {
		patterns.add(pattern);
	}
	
	public void addPattern(TokenType type, String regex) {
		patterns.add(new TokenPattern(type, Pattern.compile(regex)));
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getInput() {
		return input;
	}
	
	public Token getNextToken(boolean peek) {
		input = input.trim();
		if (input.isEmpty()) return new Token(TokenType.EOF, "null");
		for (TokenPattern pattern : patterns) {
			Matcher matcher = pattern.getPattern().matcher(input);
			if (matcher.find()) {
				String tokenValue = matcher.group().trim();
				if (!peek)
					input = matcher.replaceFirst("");
				return new Token(pattern.getType(), tokenValue);
			}
		}
		return new Token(TokenType.EOF, "null");
	}
	
}
