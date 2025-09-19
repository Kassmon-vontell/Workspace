
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;

/**
 * The SetBoolean class is a concrete implementation of the abstract Command
 * class. It is used to set a boolean value to a specified variable in the
 * runtime memory.
 */
public class SetBoolean extends Command {

	// The name of the variable to set the value for.
	private String varName;
	// The boolean value to assign to the variable.
	private boolean value;

	/**
	 * Constructs a SetBoolean command with the specified variable name and value.
	 *
	 * @param varName The name of the variable to set.
	 * @param value   The boolean value to assign to the variable.
	 */
	public SetBoolean(String varName, boolean value) {
		this.varName = varName;
		this.value = value;
	}

	/**
	 * Executes the SetBoolean command. It sets the specified boolean value to the
	 * variable in the runtime memory.
	 *
	 * @param memory The runtime memory environment where variables are stored.
	 */
	@Override
	public void run(Memory memory) {
		memory.setBool(varName, value);
	}
}
