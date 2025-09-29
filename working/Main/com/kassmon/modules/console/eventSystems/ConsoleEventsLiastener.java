package com.kassmon.modules.console.eventSystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.kassmon.modules.console.Console;

public class ConsoleEventsLiastener implements ActionListener {
	
	private Console console;
	private ArrayList<JComponent> componets  = new ArrayList<>();
	
	
	public ConsoleEventsLiastener(Console console) {
		this.console = console;
	}
	
	public void addComponent(JComponent component) {
		componets.add(component);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JComponent component : componets) {
			if (e.getSource() == component) {
				console.processInput(component);
				break;
			}
		}
	}

}
