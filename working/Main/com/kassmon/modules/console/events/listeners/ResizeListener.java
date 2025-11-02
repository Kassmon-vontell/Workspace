package com.kassmon.modules.console.events.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.kassmon.modules.console.api.ConsoleControler;

/**
 * The ResizeListener class handles component resize events for the console.
 * When the console window is resized, this listener notifies the console
 * controller to adjust the layout of console components.
 */
public class ResizeListener implements ComponentListener {
	
	private ConsoleControler consoleControler;
	
	/**
	 * Constructs a ResizeListener with the specified console controller.
	 *
	 * @param consoleControler the console controller to notify on resize events
	 */
	public ResizeListener(ConsoleControler consoleControler) {
		this.consoleControler = consoleControler;
	}
	
	/**
	 * Invoked when the component has been resized.
	 * Triggers the console controller to resize console components.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		consoleControler.resizeConsole();
	}

	/**
	 * Invoked when the component's position has been changed.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	/**
	 * Invoked when the component has been made visible.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentShown(ComponentEvent e) {
		
	}

	/**
	 * Invoked when the component has been made invisible.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

}
