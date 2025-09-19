
package com.kassmon.modules.scriptingLang.core.commands.terminal;

import java.util.Scanner;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The BooleanInput class is a concrete implementation of the abstract Command
 * class. It is used to read a boolean value from the terminal and store it in
 * the runtime memory.
 */
public class BooleanInput extends Command {

	// The name of the variable where the input boolean value will be stored.
	public String resultVarName;

	/**
	 * Constructs a BooleanInput command with the specified result variable name.
	 *
	 * @param resultVarName The name of the variable to store the input boolean
	 *                      value.
	 */
	public BooleanInput(String resultVarName) {
		this.resultVarName = resultVarName;
	}

	/**
	 * Executes the BooleanInput command. It reads a boolean value from the terminal
	 * and stores it in the runtime memory under the specified variable name.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               stored.
	 */
	public void run(Memory memory) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		memory.setBool(resultVarName, scanner.nextBoolean());
	}
}
