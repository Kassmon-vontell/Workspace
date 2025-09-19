package com.kassmon.modules.scriptingLang.core.commands;

import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

public abstract class Command {
	
	private Command nextCommand;
	
	public abstract void run(Memory memory);
	
	public boolean hasNextCommand() {
		return nextCommand != null;
	}

	public Command getNextCommand() {
		return nextCommand;
	}

	public boolean setNextCommand(Command command) {
		if (hasNextCommand()) return false;
		nextCommand = command;
		return true;
	}

	public boolean addNextCommand(Command command) {
		Command current = this;
		while (current.hasNextCommand()) {
			current = current.getNextCommand();
		}
		return current.setNextCommand(command);
	}
}
