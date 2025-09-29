package com.kassmon.modules.console.commands;

import com.kassmon.modules.tokenizer.Token;

public abstract class ConsoleCommand {
	
	abstract public String getName();
	abstract public String getDescription();
	abstract public String getUsage();
	
	abstract public void execute(Token[] args);
	
	
	
}
