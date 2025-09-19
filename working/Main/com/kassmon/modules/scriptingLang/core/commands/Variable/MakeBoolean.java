
package com.kassmon.modules.scriptingLang.core.commands.Variable;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.VariableType;

/**
 * The MakeBoolean class is a concrete implementation of the abstract Command
 * class. It is used to create a boolean variable in the runtime memory with an
 * optional initial value.
 */
public class MakeBoolean extends Command {

	// The name of the boolean variable to be created.
	private final String name;
	// The initial value of the boolean variable. Defaults to false if not
	// specified.
	private final boolean initialValue;

	/**
	 * Constructs a MakeBoolean command with the specified variable name. The
	 * initial value of the variable is set to false by default.
	 *
	 * @param name The name of the boolean variable to create.
	 */
	public MakeBoolean(String name) {
		this.name = name;
		this.initialValue = false;
	}

	/**
	 * Constructs a MakeBoolean command with the specified variable name and initial
	 * value.
	 *
	 * @param name         The name of the boolean variable to create.
	 * @param initialValue The initial value of the boolean variable.
	 */
	public MakeBoolean(String name, boolean initialValue) {
		this.name = name;
		this.initialValue = initialValue;
	}

	/**
	 * Executes the MakeBoolean command. It creates a boolean variable in the
	 * runtime memory with the specified name and initial value.
	 *
	 * @param memory The runtime memory environment where the variable will be
	 *               created.
	 */
	@Override
	public void run(Memory memory) {
		memory.makeVariable(name, VariableType.BOOL, initialValue);
	}
}
