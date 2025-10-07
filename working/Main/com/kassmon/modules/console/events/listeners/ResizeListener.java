package com.kassmon.modules.console.events.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.kassmon.modules.console.ui.ConsoleIF;

public class ResizeListener implements ComponentListener {
	
	private ConsoleIF console;
	
	private ResizeListener(ConsoleIF console) {
		this.console = console;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		console.resizeConsole();
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
