
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.VariableType;

/**
 * The MakeInt class is a concrete implementation of the abstract Command class.
 * It is used to create an integer variable in the runtime memory with an
 * optional initial value.
 */
public class MakeInt extends Command {

	// The name of the integer variable to be created.
	private final String name;
	// The initial value of the integer variable. Defaults to 0 if not specified.
	private final int initialValue;

	/**
	 * Constructs a MakeInt command with the specified variable name. The initial
	 * value of the variable is set to 0 by default.
	 *
	 * @param name The name of the integer variable to create.
	 */
	public MakeInt(String name) {
		this.name = name;
		this.initialValue = 0;
	}

	/**
	 * Constructs a MakeInt command with the specified variable name and initial
	 * value.
	 *
	 * @param name         The name of the integer variable to create.
	 * @param initialValue The initial value of the integer variable.
	 */
	public MakeInt(String name, int initialValue) {
		this.name = name;
		this.initialValue = initialValue;
	}

	/**
	 * Executes the MakeInt command. It creates an integer variable in the runtime
	 * memory with the specified name and initial value.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               created.
	 */
	@Override
	public void run(Memory memory) {
		memory.makeVariable(name, VariableType.INT, initialValue);
	}
}
