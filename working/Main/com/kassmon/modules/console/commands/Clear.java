package com.kassmon.modules.console.commands;

import com.kassmon.modules.console.Console;
import com.kassmon.modules.tokenizer.Token;

public class Clear extends ConsoleCommand {

	public Clear(Console console) {
		super(console, "clear", "Clears the console display area.", "clear");
	}

	@Override
	public void execute(Token[] args) {
		super.getConsole().clearConsoleOutput();
	}

}
