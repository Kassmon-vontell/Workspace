package com.kassmon.modules.console.api;

import java.awt.Color;

public interface Console {
	void resizeConsole();
	void outputToConsole(String text, Color color);
	void println(String text);
	void println();
	void printWarning(String text);
	void printError(String text);
	void printInfo(String text);
	void printSuccess(String text);
	void clearConsoleOutput();
	void clearConsoleInput();
	
	String getInput();
	
}
