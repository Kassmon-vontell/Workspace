package com.kassmon.modules.console.commands;

import java.awt.Color;

import com.kassmon.modules.console.Console;
import com.kassmon.modules.tokenizer.Token;

public class Echo extends ConsoleCommand {
	
	
	public Echo(Console console) {
		super(console, "echo", "Echoes the input text back to the console.", "echo <text>");
	}

	@Override
	public void execute(Token[] args) {
		String output = "";
		for (Token t : args) {
			output += t.getValue() + " ";
		}
		super.getConsole().outputToConsole(output.trim(), Color.black);
	}

}
