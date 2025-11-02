
package com.kassmon.game.ui.desktop;

import javax.swing.*;

public class Desktop {

	private JFrame frame;
	private JDesktopPane desktop;

	private JMenuBar menuBar;
	private JMenu menuPrograms;
	private JMenu menuTools;
	private JMenu menuViews;

	public Desktop() {
		initDesktop();
		
	}

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
	
	public void addWindow(JInternalFrame window) {
		desktop.add(window);
	}
	
	public void removeWindow(JInternalFrame window) {
		desktop.remove(window);
	}
	
	public void show() {
		frame.setVisible(true);
	}

}
