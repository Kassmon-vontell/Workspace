
package com.kassmon.modules.scriptingLang.runtimeEnvironment;

import com.kassmon.modules.scriptingLang.exceptions.VariableNameException;

public class Variable {

	private final VariableType type;
	private final Object value;

	public Variable(VariableType type, Object value) {
		this.type = type;
		this.value = value;
	}

	public Integer asInt() {
		if (type != VariableType.INT)
			throw new VariableNameException("Not an Integer variable");
		return (Integer) value;
	}

	public String asString() {
		if (type != VariableType.STRING)
			throw new VariableNameException("Not a String variable");
		return (String) value;
	}

	public Boolean asBool() {
		if (type != VariableType.BOOL)
			throw new VariableNameException("Not a Boolean variable");
		return (Boolean) value;
	}

	public VariableType getType() {
		return type;
	}
}
