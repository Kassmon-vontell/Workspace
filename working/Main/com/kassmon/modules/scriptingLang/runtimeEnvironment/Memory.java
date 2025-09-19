
package com.kassmon.modules.scriptingLang.runtimeEnvironment;

import java.util.HashMap;
import java.util.Map;

import com.kassmon.modules.scriptingLang.core.Block;
import com.kassmon.modules.scriptingLang.exceptions.VariableNameException;

/**
 * The Memory class provides a runtime environment for storing and managing
 * variables of different types (Integer, String, Boolean) and functions. It
 * ensures type safety and prevents duplicate names.
 */
public class Memory {

	private final Map<String, Variable> variables = new HashMap<>(); // Stores variables by name
	private final Map<String, Block> functions = new HashMap<>(); // Stores functions by name

	// Variable Management

	/**
	 * Creates a variable with the specified name, type, and initial value.
	 * 
	 * @param name  the name of the variable
	 * @param type  the VariableType of the variable
	 * @param value the initial value of the variable
	 * @throws VariableNameException if the variable name already exists
	 */
	public void makeVariable(String name, VariableType type, Object value) {
		checkNotExists(name);
		variables.put(name, new Variable(type, value));
	}
	
	/**
	 * Creates a variable with the specified name and type, initializing its value
	 * to null.
	 * 
	 * @param name the name of the variable
	 * @param type the VariableType of the variable
	 * @throws VariableNameException if the variable name already exists
	 */
	public void makeVariable(String name, VariableType type) {
		checkNotExists(name);
		if (type == VariableType.INT)
			variables.put(name, new Variable(type, 0));
		else if (type == VariableType.STRING)
			variables.put(name, new Variable(type, ""));
		else if (type == VariableType.BOOL)
			variables.put(name, new Variable(type, false));
		
	}
	
	/**
	 * Removes a variable by its name.
	 *
	 * @param name the name of the variable to remove
	 * @throws VariableNameException if the variable does not exist
	 */
	public void removeVariable(String name) {
	    checkExists(name); // Ensure the variable exists
	    variables.remove(name); // Remove the variable from the map
	}
	
	/**
	 * Retrieves an Integer variable by its name.
	 * 
	 * @param name the name of the variable
	 * @return the Integer value of the variable
	 * @throws VariableNameException if the variable does not exist
	 */
	public Integer getInt(String name) {
		checkExists(name);
		return variables.get(name).asInt();
	}

	/**
	 * Stores an Integer variable with the given name.
	 * 
	 * @param name  the name of the variable
	 * @param value the Integer value to store
	 * @throws VariableNameException if the variable name already exists
	 */
	public void setInt(String name, Integer value) {
		checkNotExists(name);
		variables.put(name, new Variable(VariableType.INT, value));
	}

	/**
	 * Retrieves a String variable by its name.
	 * 
	 * @param name the name of the variable
	 * @return the String value of the variable
	 * @throws VariableNameException if the variable does not exist
	 */
	public String getString(String name) {
		checkExists(name);
		return variables.get(name).asString();
	}

	/**
	 * Stores a String variable with the given name.
	 * 
	 * @param name  the name of the variable
	 * @param value the String value to store
	 * @throws VariableNameException if the variable name already exists
	 */
	public void setString(String name, String value) {
		checkNotExists(name);
		variables.put(name, new Variable(VariableType.STRING, value));
	}

	/**
	 * Retrieves a Boolean variable by its name.
	 * 
	 * @param name the name of the variable
	 * @return the Boolean value of the variable
	 * @throws VariableNameException if the variable does not exist
	 */
	public Boolean getBool(String name) {
		checkExists(name);
		return variables.get(name).asBool();
	}

	/**
	 * Stores a Boolean variable with the given name.
	 * 
	 * @param name  the name of the variable
	 * @param value the Boolean value to store
	 * @throws VariableNameException if the variable name already exists
	 */
	public void setBool(String name, Boolean value) {
		checkNotExists(name);
		variables.put(name, new Variable(VariableType.BOOL, value));
	}

	/**
	 * Checks if a variable with the given name exists.
	 * 
	 * @param name the name of the variable
	 * @return true if the variable exists, false otherwise
	 */
	public boolean nameExists(String name) {
		return variables.containsKey(name);
	}

	/**
	 * Retrieves the type of a variable by its name.
	 * 
	 * @param name the name of the variable
	 * @return the VariableType of the variable
	 * @throws VariableNameException if the variable does not exist
	 */
	public VariableType getVariableType(String name) {
		checkExists(name);
		return variables.get(name).getType();
	}

	// Function Management

	/**
	 * Retrieves a function (Block) by its name.
	 * 
	 * @param name the name of the function
	 * @return the Block object representing the function
	 * @throws VariableNameException if the function does not exist
	 */
	public Block getFunction(String name) {
		if (!functionExists(name)) {
			throw new VariableNameException("Function name does not exist: " + name);
		}
		return functions.get(name);
	}

	/**
	 * Stores a function (Block) with the given name.
	 * 
	 * @param name  the name of the function
	 * @param block the Block object representing the function
	 * @throws VariableNameException if the function name already exists
	 */
	public void setFunction(String name, Block block) {
		if (functionExists(name)) {
			throw new VariableNameException("Function name already exists: " + name);
		}
		functions.put(name, block);
	}

	/**
	 * Checks if a function with the given name exists.
	 * 
	 * @param name the name of the function
	 * @return true if the function exists, false otherwise
	 */
	public boolean functionExists(String name) {
		return functions.containsKey(name);
	}

	// Validation Helpers

	/**
	 * Validates that a variable with the given name exists.
	 * 
	 * @param name the name of the variable
	 * @throws VariableNameException if the variable does not exist
	 */
	private void checkExists(String name) {
		if (!nameExists(name)) {
			throw new VariableNameException("Variable name does not exist: " + name);
		}
	}

	/**
	 * Validates that a variable with the given name does not exist.
	 * 
	 * @param name the name of the variable
	 * @throws VariableNameException if the variable already exists
	 */
	private void checkNotExists(String name) {
		if (nameExists(name)) {
			throw new VariableNameException("Variable name already exists: " + name);
		}
	}

	
}
