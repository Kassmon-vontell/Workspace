
package com.kassmon.hackGame.ui;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import static com.kassmon.hackGame.settings.SettingsManger.*;

/**
 * Desktop is a JFrame that can be displayed in borderless fullscreen or
 * maximized windowed mode. It provides an exit button and allows adding custom
 * components.
 */
@SuppressWarnings("serial")
public class Desktop extends JFrame implements ActionListener {

	private final boolean borderless; // Whether the window is borderless/fullscreen
	private JButton exit; // Exit button
	private JToolBar toolBar; // Toolbar containing the exit button
	private JDesktopPane desktopPane; // Pane to hold internal frames
	/**
	 * Constructs a Desktop window.
	 * @param borderless true for borderless fullscreen, false for maximized windowed mode
	 * @throws HeadlessException if the environment does not support a display
	 */
	public Desktop(boolean borderless) throws HeadlessException {
		this.borderless = borderless;
		

		initDesktopWindow();
		initToolBar();
	}

	/** Initializes the game window based on the borderless setting. */
	private void initDesktopWindow() {
		setTitle("game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(borderless);
		getContentPane().setLayout(null);

		if (borderless) {
			setFullScreen();
		} else {
			setExtendedState(MAXIMIZED_BOTH);
			setVisible(true);
		}
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 35, getWidth(), getHeight() - 35);
	}

	/** Sets the window to fullscreen mode if supported, otherwise maximized. */
	private void setFullScreen() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			gd.setFullScreenWindow(this);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(screenSize.width, screenSize.height);
		} else {
			setExtendedState(MAXIMIZED_BOTH);
		}
		setVisible(true);
	}

	/** Initializes the toolbar and adds the exit button to it. */
	private void initToolBar() {
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, getWidth() - 20, 35);
		add(toolBar);

		toolBar.add(Box.createHorizontalGlue());
		initExitButton();
	}

	/** Initializes the exit button and adds it to the toolbar. */
	private void initExitButton() {
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, Integer.parseInt(getElementValue("FontSize"))));
		toolBar.add(exit);
	}

	/**
	 * Adds a custom component to the window's content pane.
	 * @param component the component to add
	 */
	public void addComponent(JComponent component) {
		desktopPane.add(component);
	}
	
	

	/**
	 * Handles the exit button action to close the application.
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
}
