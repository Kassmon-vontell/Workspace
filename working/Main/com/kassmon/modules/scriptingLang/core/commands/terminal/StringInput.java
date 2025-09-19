
package com.kassmon.modules.scriptingLang.core.commands.terminal;

import java.util.Scanner;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The StringInput class is a concrete implementation of the abstract Command
 * class. It is used to read a string value from the terminal and store it in
 * the runtime memory.
 */
public class StringInput extends Command {

	// The name of the variable where the input string value will be stored.
	public String resultVarName;

	/**
	 * Constructs a StringInput command with the specified result variable name.
	 *
	 * @param resultVarName The name of the variable to store the input string
	 *                      value.
	 */
	public StringInput(String resultVarName) {
		this.resultVarName = resultVarName;
	}

	/**
	 * Executes the StringInput command. It reads a string value from the terminal
	 * and stores it in the runtime memory under the specified variable name.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               stored.
	 */
	public void run(Memory memory) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		memory.setString(resultVarName, scanner.nextLine());
	}
}
