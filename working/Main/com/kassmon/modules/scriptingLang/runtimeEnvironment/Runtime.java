
package com.kassmon.modules.scriptingLang.runtimeEnvironment;

import com.kassmon.modules.scriptingLang.core.Block;

/**
 * The Runtime class serves as the main entry point for executing a scripting
 * language program. It manages program blocks and provides runtime information.
 */
public class Runtime {

	private static final String VERSION = "0.0.1-alpha";
	private static final String NAME = "Scripting Language Runtime Environment";

	private String startBlock;
	private final Memory memory;
	
	public Runtime() {
		this.memory = new Memory();
	}
	
	public Runtime(Memory memory) {
		this.memory = memory;
	}

	/**
	 * Prints runtime information including the name and version.
	 */
	public void info() {
		System.out.println(NAME + " v" + VERSION);
	}

	/**
	 * Executes the program starting from the defined start block. If no start block
	 * is defined or found, an error message is displayed.
	 */
	public void runProgram() {
		if (startBlock == null) {
			System.err.println("No start block defined.");
			return;
		}
		if (!memory.functionExists(startBlock)) {
			System.err.println("Start block '" + startBlock + "' not found.");
			return;
		}
		memory.getFunction(startBlock).run(memory);
	}

	/**
	 * Sets the name of the start block for the program.
	 *
	 * @param name the name of the start block
	 */
	public void setStartBlock(String name) {
		this.startBlock = name;
	}

	/**
	 * Adds a program block to the runtime environment.
	 *
	 * @param name  the name of the block
	 * @param block the block to add
	 */
	public void addProgramBlock(String name, Block block) {
		memory.setFunction(name, block);
	}
}
