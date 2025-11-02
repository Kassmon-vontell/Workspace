package com.kassmon.modules.console.events.casters;

/**
 * The EventOutputFormConsole interface defines a listener for console output events.
 * Implementations receive notifications when output is generated from the console.
 */
public interface EventOutputFormConsole {
	/**
	 * Called when output is generated from the console.
	 *
	 * @param text the output text from the console
	 */
	void consoleConsoleOutput(String text);
}
