package com.kassmon.modules.scriptingLang.core.tokenizer;

public class Token {
	
	private TokenType type;
	private String TokenData;
	
	public Token(TokenType type, String tokenData) {
		this.type = type;
		TokenData = tokenData;
	}
	
	public TokenType getType() {
		return type;
	}
	
	public String getTokenData() {
		return TokenData;
	}
	
}
