package com.kassmon.modules.console.api;

import java.util.ArrayList;

import com.kassmon.modules.console.events.casters.EventOutputFormConsole;
import com.kassmon.modules.console.ui.*;

/**
 * The ConsoleControler class manages console instances and handles console events.
 * It provides factory methods for creating console frames and internal frames,
 * and coordinates output operations and event listeners.
 */
public class ConsoleControler {
	
	private static final int FRAME = 1, INTERNALFRAME = 2;
	
	private Console c;
	
	private ArrayList<EventOutputFormConsole> eventListeners;
	
	/**
	 * Constructs a ConsoleControler with the specified frame type.
	 *
	 * @param frameType the type of frame (FRAME or INTERNALFRAME)
	 */
	private ConsoleControler (int frameType) {
		if (frameType == FRAME) c = new ConsoleF(this);
		if (frameType == INTERNALFRAME) c = new ConsoleF(this);
		
	}
	
	/**
	 * Creates a new console as a standalone frame.
	 *
	 * @return a new ConsoleControler instance with a JFrame-based console
	 */
	public static ConsoleControler makeConsoleFrame() {
		return new ConsoleControler(FRAME);
	}
	
	/**
	 * Creates a new console as an internal frame.
	 *
	 * @return a new ConsoleControler instance with a JInternalFrame-based console
	 */
	public static  ConsoleControler makeConsoleInternalFrame() {
		return new ConsoleControler(INTERNALFRAME);
	}
	
	/**
	 * Outputs text to the console with the specified output level.
	 *
	 * @param text  the text to output
	 * @param level the output level determining the text color and style
	 */
	public void outputToConsole(String text, OutputLevel level) {
		switch (level) {
		case DEFAULT:
			c.println(text);
			break;
		case INFO:
			c.printInfo(text);
			break;
		case ERROR:
			c.printError(text);
			break;
		case WARNING:
			c.printWarning(text);
			break;
		case SUCCESS:
			c.printSuccess(text);
			break;
		}
	}
	
	/**
	 * Adds an output event listener to this console controller.
	 *
	 * @param e the event listener to add
	 */
	public void addOutputEventListeners(EventOutputFormConsole e) {
		this.eventListeners.add(e);
	}
	
	/**
	 * Broadcasts console output to all registered event listeners.
	 * After broadcasting, the console input is cleared.
	 */
	public void outputEventCast() {
		for (EventOutputFormConsole e: eventListeners) {
			e.consoleConsoleOutput(c.getInput());
		}
		clearConsoleInput();
	}
	
	/**
	 * Resizes the console to fit the current window dimensions.
	 */
	public void resizeConsole() {
		c.resizeConsole();
	}
	
	/**
	 * Clears the console input field.
	 */
	public void clearConsoleInput() {
		c.clearConsoleInput();
	}
	
	/**
	 * Clears the console output display area.
	 */
	public void clearConsoleOutput() {
		c.clearConsoleOutput();
	}
	
}
