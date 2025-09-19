
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.VariableType;

/**
 * The MakeString class is a concrete implementation of the abstract Command
 * class. It is used to create a string variable in the runtime memory with an
 * optional initial value.
 */
public class MakeString extends Command {

	// The name of the string variable to be created.
	private final String name;
	// The initial value of the string variable. Defaults to an empty string if not
	// specified.
	private final String initialValue;

	/**
	 * Constructs a MakeString command with the specified variable name. The initial
	 * value of the variable is set to an empty string by default.
	 *
	 * @param name The name of the string variable to create.
	 */
	public MakeString(String name) {
		this.name = name;
		this.initialValue = "";
	}

	/**
	 * Constructs a MakeString command with the specified variable name and initial
	 * value.
	 *
	 * @param name         The name of the string variable to create.
	 * @param initialValue The initial value of the string variable.
	 */
	public MakeString(String name, String initialValue) {
		this.name = name;
		this.initialValue = initialValue;
	}

	/**
	 * Executes the MakeString command. It creates a string variable in the runtime
	 * memory with the specified name and initial value.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               created.
	 */
	@Override
	public void run(Memory memory) {
		memory.makeVariable(name, VariableType.STRING, initialValue);
	}
}
