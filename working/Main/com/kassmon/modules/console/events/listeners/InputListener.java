package com.kassmon.modules.console.events.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.kassmon.modules.console.api.ConsoleControler;

public class InputListener implements ActionListener {
	
	private ConsoleControler consoleControler;
	
	public InputListener(ConsoleControler consoleControler) {
		this.consoleControler = consoleControler;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		consoleControler.outputEventCast();
	}

}
