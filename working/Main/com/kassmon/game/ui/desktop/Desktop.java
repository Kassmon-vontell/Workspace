
package com.kassmon.game.ui.desktop;

import javax.swing.*;

import com.kassmon.game.ui.email.EMailDisplay;
import com.kassmon.game.ui.email.Email;

public class Desktop {

	private static JFrame frame;
	private static JDesktopPane desktop;

	private static JMenuBar menuBar;
	private static JMenu menuPrograms;
	private static JMenu menuTools;
	private static JMenu menuViews;
	
	private static EMailDisplay emailDisplay;
	
	public static void initDesktop() {
		// Create the main frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setVisible(true);

		desktop = new JDesktopPane();
		frame.getContentPane().add(desktop);
		desktop.setLayout(null);
		desktop.setBounds(0, 0, 800, 800);
		desktop.setSize(frame.getWidth(), frame.getHeight());
		desktop.setVisible(true);

		// Create the menu bar
		menuBar = new JMenuBar();
		menuPrograms = new JMenu("Programs");
		menuTools = new JMenu("Tools");
		menuViews = new JMenu("Views");
		menuBar.add(menuPrograms);
		menuBar.add(menuTools);
		menuBar.add(menuViews);
		frame.setJMenuBar(menuBar);
		
		initEmailDisplay();
	}

	public static void addWindow(JInternalFrame window) {
		desktop.add(window);
	}

	public static void removeWindow(JInternalFrame window) {
		desktop.remove(window);
	}

	public static void show() {
		frame.setVisible(true);
	}
	
	public static void addEmail(Email email) {
		if (emailDisplay != null) {
			emailDisplay.addEMailToList(email);
		}
	}
	
	public static void initEmailDisplay() {
	    emailDisplay = new EMailDisplay();
	    addWindow(emailDisplay);
	    emailDisplay.setVisible(true);
	}
	
}
