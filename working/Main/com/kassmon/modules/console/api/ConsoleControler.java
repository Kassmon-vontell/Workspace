package com.kassmon.modules.console.api;

import java.util.ArrayList;

import com.kassmon.modules.console.events.casters.EventOutputFormConsole;
import com.kassmon.modules.console.ui.*;

public class ConsoleControler {
	
	private static final int FRAME = 1, INTERNALFRAME = 2;
	
	private Console c;
	
	private ArrayList<EventOutputFormConsole> eventListeners;
	
	private ConsoleControler (int frameType) {
		if (frameType == FRAME) c = new ConsoleF(this);
		if (frameType == INTERNALFRAME) c = new ConsoleF(this);
		
	}
	
	public static ConsoleControler makeConsoleFrame() {
		return new ConsoleControler(FRAME);
	}
	
	public static  ConsoleControler makeConsoleInternalFrame() {
		return new ConsoleControler(INTERNALFRAME);
	}
	
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
	
	public void addOutputEventListeners(EventOutputFormConsole e) {
		this.eventListeners.add(e);
	}
	
	public void outputEventCast() {
		for (EventOutputFormConsole e: eventListeners) {
			e.consoleConsoleOutput(c.getInput());
		}
		clearConsoleInput();
	}
	
	public void resizeConsole() {
		c.resizeConsole();
	}
	
	public void clearConsoleInput() {
		c.clearConsoleInput();
	}
	
	public void clearConsoleOutput() {
		c.clearConsoleOutput();
	}
	
}
