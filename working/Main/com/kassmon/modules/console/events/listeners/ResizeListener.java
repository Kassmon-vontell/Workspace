package com.kassmon.modules.console.events.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.kassmon.modules.console.api.ConsoleControler;

public class ResizeListener implements ComponentListener {
	
	private ConsoleControler consoleControler;
	
	public ResizeListener(ConsoleControler consoleControler) {
		this.consoleControler = consoleControler;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		consoleControler.resizeConsole();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

}
