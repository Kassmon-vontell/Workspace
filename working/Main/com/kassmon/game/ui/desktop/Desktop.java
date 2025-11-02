
package com.kassmon.game.ui.desktop;

import javax.swing.*;

/**
 * The Desktop class provides a desktop environment using Swing components.
 * It manages a main frame with a desktop pane that can contain multiple
 * internal frames (windows). The desktop includes a menu bar with
 * Programs, Tools, and Views menus.
 */
public class Desktop {

	private JFrame frame;
	private JDesktopPane desktop;

	private JMenuBar menuBar;
	private JMenu menuPrograms;
	private JMenu menuTools;
	private JMenu menuViews;

	/**
	 * Constructs a new Desktop instance and initializes the desktop environment.
	 */
	public Desktop() {
		initDesktop();
		
	}

	/**
	 * Initializes the desktop frame, desktop pane, and menu bar.
	 * Sets up the main window with maximized state and creates the menu structure.
	 */
	private void initDesktop() {
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

	   
	}
	
	/**
	 * Adds an internal frame window to the desktop.
	 *
	 * @param window the JInternalFrame to add to the desktop
	 */
	public void addWindow(JInternalFrame window) {
		desktop.add(window);
	}
	
	/**
	 * Removes an internal frame window from the desktop.
	 *
	 * @param window the JInternalFrame to remove from the desktop
	 */
	public void removeWindow(JInternalFrame window) {
		desktop.remove(window);
	}
	
	/**
	 * Makes the desktop frame visible.
	 */
	public void show() {
		frame.setVisible(true);
	}

}
