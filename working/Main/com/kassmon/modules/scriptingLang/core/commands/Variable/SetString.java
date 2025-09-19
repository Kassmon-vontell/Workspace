
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The SetString class is a concrete implementation of the abstract Command
 * class. It is used to set a string value to a specified variable in the
 * runtime memory.
 */
public class SetString extends Command {

	// The name of the variable to set the value for.
	private String varName;
	// The string value to assign to the variable.
	private String value;

	/**
	 * Constructs a SetString command with the specified variable name and value.
	 *
	 * @param varName The name of the variable to set.
	 * @param value   The string value to assign to the variable.
	 */
	public SetString(String varName, String value) {
		this.varName = varName;
		this.value = value;
	}

	/**
	 * Executes the SetString command. It sets the specified string value to the
	 * variable in the runtime memory.
	 *
	 * @param memory The runtime memory environment where variables are stored.
	 */
	@Override
	public void run(Memory memory) {
		memory.setString(varName, value);
	}
}
