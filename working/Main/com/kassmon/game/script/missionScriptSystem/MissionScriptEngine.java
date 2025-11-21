package com.kassmon.game.script.missionScriptSystem;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MissionScriptEngine {
	
	private ScriptEngine engine;

    public MissionScriptEngine() {
        // Initialize the JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("JavaScript");
    }

    public void executeScript(String script) {
        try {
            // Execute the JavaScript code
            engine.eval(script);
        } catch (ScriptException e) {
            System.err.println("Script execution error: " + e.getMessage());
        }
    }

    public void setVariable(String name, Object value) {
        // Set a variable in the script engine
        engine.put(name, value);
    }

    public Object getVariable(String name) {
        // Retrieve a variable from the script engine
        return engine.get(name);
    }
}