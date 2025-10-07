package com.kassmon.modules.console.commands;

import com.kassmon.modules.console.ui.ConsoleIF;
import com.kassmon.modules.tokenizer.Token;

public abstract class Command {
	
	private String name;
	private String description;
	private String usage;
	
	private ConsoleIF console;
	
	abstract public void execute(Token[] args);
	
	
	public Command(ConsoleIF console, String name, String description, String usage) {
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
	
	public ConsoleIF getConsole() {
		return console;
	}
	
}
