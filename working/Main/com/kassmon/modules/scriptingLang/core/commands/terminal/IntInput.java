
package com.kassmon.modules.scriptingLang.core.commands.terminal;

import java.util.Scanner;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The IntInput class is a concrete implementation of the abstract Command
 * class. It is used to read an integer value from the terminal and store it in
 * the runtime memory.
 */
public class IntInput extends Command {

	// The name of the variable where the input integer value will be stored.
	public String resultVarName;

	/**
	 * Constructs an IntInput command with the specified result variable name.
	 *
	 * @param resultVarName The name of the variable to store the input integer
	 *                      value.
	 */
	public IntInput(String resultVarName) {
		this.resultVarName = resultVarName;
	}

	/**
	 * Executes the IntInput command. It reads an integer value from the terminal
	 * and stores it in the runtime memory under the specified variable name.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               stored.
	 */
	public void run(Memory memory) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		memory.setInt(resultVarName, scanner.nextInt());
	}
}
