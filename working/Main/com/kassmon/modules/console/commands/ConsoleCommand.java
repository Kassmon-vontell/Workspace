package com.kassmon.modules.console.commands;

import com.kassmon.modules.console.Console;
import com.kassmon.modules.tokenizer.Token;

public abstract class ConsoleCommand {
	
	private String name;
	private String description;
	private String usage;
	
	private Console console;
	
	abstract public void execute(Token[] args);
	
	
	public ConsoleCommand(Console console, String name, String description, String usage) {
		this.console = console;
		this.name = name;
		this.description = description;
		this.usage = usage;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getUsage() {
		return usage;
	}
	
	public Console getConsole() {
		return console;
	}
	
}
