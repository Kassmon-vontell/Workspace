
package com.kassmon.modules.scriptingLang.core.commands.Math;

import com.kassmon.modules.scriptingLang.core.commands.Command;
import com.kassmon.modules.scriptingLang.exceptions.VariableNameException;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.Memory;
import com.kassmon.modules.scriptingLang.runtimeEnvironment.VariableType;

/**
 * The Mul class is a concrete implementation of the abstract Command class. It
 * performs multiplication of two integers, which can be provided as direct
 * inputs or retrieved from the runtime memory. The result is stored in a
 * specified variable.
 */
public class Mul extends Command {

	// Direct integer input for the first operand.
	private int input1;
	// Direct integer input for the second operand.
	private int input2;
	// Name of the variable for the first operand (if used).
	private String var1Name;
	// Name of the variable for the second operand (if used).
	private String var2Name;
	// Name of the variable where the result will be stored.
	private String resultVarName;

	/**
	 * Constructs a Mul command with two direct integer inputs.
	 *
	 * @param input1        The first integer operand.
	 * @param input2        The second integer operand.
	 * @param resultVarName The name of the variable to store the result.
	 */
	public Mul(int input1, int input2, String resultVarName) {
		this.input1 = input1;
		this.input2 = input2;
		this.resultVarName = resultVarName;
	}

	/**
	 * Constructs a Mul command with one direct integer input and one variable
	 * operand.
	 *
	 * @param input1        The first integer operand.
	 * @param var2Name      The name of the variable for the second operand.
	 * @param resultVarName The name of the variable to store the result.
	 */
	public Mul(int input1, String var2Name, String resultVarName) {
		this.input1 = input1;
		this.var2Name = var2Name;
		this.resultVarName = resultVarName;
	}

	/**
	 * Constructs a Mul command with one variable operand and one direct integer
	 * input.
	 *
	 * @param var1Name      The name of the variable for the first operand.
	 * @param input2        The second integer operand.
	 * @param resultVarName The name of the variable to store the result.
	 */
	public Mul(String var1Name, int input2, String resultVarName) {
		this.var1Name = var1Name;
		this.input2 = input2;
		this.resultVarName = resultVarName;
	}

	/**
	 * Constructs a Mul command with two variable operands.
	 *
	 * @param var1Name      The name of the variable for the first operand.
	 * @param var2Name      The name of the variable for the second operand.
	 * @param resultVarName The name of the variable to store the result.
	 */
	public Mul(String var1Name, String var2Name, String resultVarName) {
		this.var1Name = var1Name;
		this.var2Name = var2Name;
		this.resultVarName = resultVarName;
	}

	/**
	 * Executes the Mul command. It retrieves operand values from memory if
	 * necessary, performs the multiplication, and stores the result in the
	 * specified variable.
	 *
	 * @param memory The runtime memory environment where variables are stored.
	 * @throws VariableNameException If any variable name does not exist or is of
	 *                               the wrong type.
	 */
	@Override
	public void run(Memory memory) {
		// Retrieve the value of the first operand from memory if a variable name is
		// provided.
		if (var1Name != null) {
			if (!memory.nameExists(var1Name))
				throw new VariableNameException(var1Name);
			if (memory.getVariableType(var1Name) == VariableType.INT)
				throw new VariableNameException(var1Name);
			input1 = memory.getInt(var1Name);
		}
		// Retrieve the value of the second operand from memory if a variable name is
		// provided.
		if (var2Name != null) {
			if (!memory.nameExists(var2Name))
				throw new VariableNameException(var2Name);
			if (memory.getVariableType(var2Name) == VariableType.INT)
				throw new VariableNameException(var2Name);
			input2 = memory.getInt(var2Name);
		}
		// Ensure the result variable exists in memory.
		if (!memory.nameExists(resultVarName))
			throw new VariableNameException(resultVarName);
		// Perform the multiplication and store the result in the specified variable.
		memory.setInt(resultVarName, input1 * input2);
		// Execute the next command in the chain if it exists.
		if (super.hasNextCommand())
			super.getNextCommand().run(memory);
	}
}
