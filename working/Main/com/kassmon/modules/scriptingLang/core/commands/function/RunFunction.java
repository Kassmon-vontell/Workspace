package com.kassmon.modules.scriptingLang.core.commands.function;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

public class RunFunction extends Command{
	
    private String functionName;
    
	public RunFunction(String functionName) {
		this.functionName = functionName;
	}
    
	@Override
	public void run(Memory memory) {
		if (memory.functionExists(functionName)) {
			memory.getFunction(functionName).run(memory);;
		} else {
			System.err.println("Function " + functionName + " does not exist.");
		}
	}

}
