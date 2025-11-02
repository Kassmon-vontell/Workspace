package com.kassmon.modules.console.events.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.kassmon.modules.console.api.ConsoleControler;

/**
 * The InputListener class handles input events from the console.
 * When the user submits input (e.g., by pressing Enter), this listener
 * triggers the console controller to process and broadcast the output.
 */
public class InputListener implements ActionListener {
	
	private ConsoleControler consoleControler;
	
	/**
	 * Constructs an InputListener with the specified console controller.
	 *
	 * @param consoleControler the console controller to notify on input events
	 */
	public InputListener(ConsoleControler consoleControler) {
		this.consoleControler = consoleControler;
	}
	
	/**
	 * Invoked when an action occurs (e.g., user presses Enter in the input field).
	 * Triggers the console controller to broadcast the output event.
	 *
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		consoleControler.outputEventCast();
	}

}
