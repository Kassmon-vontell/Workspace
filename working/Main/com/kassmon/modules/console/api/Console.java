package com.kassmon.modules.console.api;

import java.awt.Color;

/**
 * The Console interface defines the contract for console operations.
 * Implementations of this interface provide functionality for displaying
 * output with different color levels and managing console input/output.
 */
public interface Console {
	/**
	 * Resizes the console components to fit the current window size.
	 */
	void resizeConsole();
	
	/**
	 * Outputs text to the console with the specified color.
	 *
	 * @param text  the text to display
	 * @param color the color to use for the text
	 */
	void outputToConsole(String text, Color color);
	
	/**
	 * Prints a line of text to the console.
	 *
	 * @param text the text to print
	 */
	void println(String text);
	
	/**
	 * Prints a blank line to the console.
	 */
	void println();
	
	/**
	 * Prints a warning message to the console.
	 *
	 * @param text the warning message to print
	 */
	void printWarning(String text);
	
	/**
	 * Prints an error message to the console.
	 *
	 * @param text the error message to print
	 */
	void printError(String text);
	
	/**
	 * Prints an informational message to the console.
	 *
	 * @param text the info message to print
	 */
	void printInfo(String text);
	
	/**
	 * Prints a success message to the console.
	 *
	 * @param text the success message to print
	 */
	void printSuccess(String text);
	
	/**
	 * Clears all output from the console display area.
	 */
	void clearConsoleOutput();
	
	/**
	 * Clears the console input field.
	 */
	void clearConsoleInput();
	
	/**
	 * Retrieves the current text from the console input field.
	 *
	 * @return the input text
	 */
	String getInput();
	
}
