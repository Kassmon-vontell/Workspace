package com.kassmon.modules.scriptSystem;

import javax.script.*;

public class Engine {
	
	private ScriptEngine engine;
	
	public Engine() {
		engine = new ScriptEngineManager().getEngineByName("nashorn");
		
	}
	
	public void addModuleToEngine(String key, Object module) {
        engine.put(key, module);
    }
	
	public void executeScript(String script) {
		try {
			engine.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
}
