package com.kassmon.modules.console;

import java.awt.Color;

import com.kassmon.modules.console.commands.ConsoleCommand;

public interface Console {
	void addCommand(ConsoleCommand command, String regex, String type);
	void clearConsoleOutput();
	void clearConsoleInput();
	void outputToConsole(String trim, Color black);
	
	
}
