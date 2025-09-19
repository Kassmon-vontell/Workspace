
package com.kassmon.modules.scriptingLang.core.commands.terminal;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.exceptions.VariableNameException;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The Outputline class is a concrete implementation of the abstract Command
 * class. It is responsible for printing the value of a variable from the
 * runtime memory to the console. If the variable does not exist, it throws a
 * VariableNameException.
 */
public class Outputline extends Command {

	// The name of the variable whose value will be printed.
	private String var1Name;

	/**
	 * Constructs an Outputline command with the specified variable name.
	 *
	 * @param var1Name The name of the variable to be printed.
	 */
	public Outputline(String var1Name) {
		this.var1Name = var1Name;
	}

	/**
	 * Executes the Outputline command. If the variable exists in the memory, its
	 * value is printed to the console. Otherwise, a VariableNameException is
	 * thrown.
	 *
	 * @param memory The runtime memory environment where variables are stored.
	 * @throws VariableNameException If the variable does not exist in the memory.
	 */
	@Override
	public void run(Memory memory) {
		if (memory.nameExists(var1Name)) {
			// Print the value of the variable to the console.
			System.out.println(memory.getString(var1Name));
		} else {
			System.out.println(var1Name);
		}
	}
}
