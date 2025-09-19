
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The SetInt class is a concrete implementation of the abstract Command class.
 * It is used to set an integer value to a specified variable in the runtime
 * memory.
 */
public class SetInt extends Command {

	// The name of the variable to set the value for.
	private String varName;
	// The integer value to assign to the variable.
	private int value;

	/**
	 * Constructs a SetInt command with the specified variable name and value.
	 *
	 * @param varName The name of the variable to set.
	 * @param value   The integer value to assign to the variable.
	 */
	public SetInt(String varName, int value) {
		this.varName = varName;
		this.value = value;
	}

	/**
	 * Executes the SetInt command. It sets the specified integer value to the
	 * variable in the runtime memory.
	 *
	 * @param memory The runtime memory environment where variables are stored.
	 */
	@Override
	public void run(Memory memory) {
		memory.setInt(varName, value);
	}
}
