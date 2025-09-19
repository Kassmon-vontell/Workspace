package com.kassmon.modules.scriptingLang.core.tokenizer;

public enum TokenType {
	// Single-character tokens
	LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, COMMA, DOT, SEMICOLON, SLASH,

	//One or two character tokens
	BANG, BANG_EQUAL, EQUAL, EQUAL_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL,

	//Literals
	IDENTIFIER,
	
	//keywords
	
	True, False, INT, BOOLEAN, STRING, FUNCTION,
	
	//command types
	VAR, MATH, COMPARE, OUT, IN,
	
	//command keys
	SET, EQUELS, NOTEQUALS, GRATER, LESSTHAN, OR, AND, XOR, ADD, SUB, MUL, DIV,
	PRINT, READ, 
	
	NULL, NOOP, EOF
}
