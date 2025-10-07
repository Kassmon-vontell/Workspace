
package com.kassmon.modules.scriptSystem;

import javax.script.*;

/**
 * The `Engine` class provides a wrapper around the Java Scripting API's
 * `ScriptEngine`. It allows adding custom modules to the scripting engine and
 * executing scripts.
 */
public class Engine {

	private ScriptEngine engine;

	/**
	 * Constructs an `Engine` instance and initializes the scripting engine with the
	 * "nashorn" JavaScript engine.
	 */
	public Engine() {
		engine = new ScriptEngineManager().getEngineByName("nashorn");
	}

	/**
	 * Adds a custom module to the scripting engine.
	 *
	 * @param key    the name under which the module will be accessible in the
	 *               scripting engine
	 * @param module the module object to be added
	 */
	public void addModuleToEngine(String key, Module module) {
		engine.put(key, module);
	}

	/**
	 * Executes a script using the scripting engine.
	 *
	 * @param script the script code to be executed
	 */
	public void executeScript(String script) {
		try {
			engine.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
