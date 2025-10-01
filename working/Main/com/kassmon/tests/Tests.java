package com.kassmon.tests;

import java.awt.Color;

import com.kassmon.modules.console.Console;
import com.kassmon.modules.console.ConsoleFrame;

public class Tests {
	public static void main(String[] args) {
		Console console = ConsoleFrame.makeConsole();
		console.outputToConsole("Hello, World!" + System.lineSeparator(), Color.blue);
	}
}
