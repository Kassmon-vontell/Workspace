
package com.kassmon.modules.console.eventSystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.kassmon.modules.console.Console;

/**
 * A listener class that handles console events and processes input from
 * associated components.
 */
public class ConsoleEventsLiastener implements ActionListener, ComponentListener {

	private Console console;
	private ArrayList<JComponent> componets = new ArrayList<>();

	/**
	 * Constructs a ConsoleEventsLiastener with the specified console.
	 *@param console the console instance to process input
	 */
	public ConsoleEventsLiastener(Console console) {
		this.console = console;
	}

	/**
	 * Adds a component to the list of components monitored by this listener.
	 * @param component the component to be added
	 */
	public void addComponent(JComponent component) {
		componets.add(component);
	}

	/**
	 * Invoked when an action occurs. Processes input from the source component if
	 * it is in the monitored components list.
	 *@param e the action event triggered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JComponent component : componets) {
			if (e.getSource() == component) {
				console.processInput(component);
				break;
			}
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		console.setComponentSizes();
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
