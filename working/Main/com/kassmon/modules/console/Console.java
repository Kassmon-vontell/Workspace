
package com.kassmon.modules.console;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Represents a customizable console UI component that can be displayed as a
 * JFrame, JInternalFrame, or JPanel. Provides methods for outputting text,
 * handling input, and managing the console's appearance.
 */
public class Console {

	public static final int FRAME = 0;
	public static final int INTERNALFRAME = 1;
	public static final int PANEL = 2;

	private JFrame frame;
	private JInternalFrame internalFrame;
	private JPanel panel;

	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;

	/**
	 * Private constructor to initialize the console based on the specified type.
	 *
	 * @param type the type of console (FRAME, INTERNALFRAME, or PANEL)
	 */
	private Console(int type) {
		if (type == FRAME || type == INTERNALFRAME) {
			initWindow(type == FRAME);
			initMenuBar();
		} else {
			panel = new JPanel(null);
			panel.setBounds(100, 100, 800, 600);
		}
		initUiComponents();
		addComponents(type);
	}

	/**
	 * Factory method to create a new Console instance.
	 *
	 * @param type the type of console (FRAME, INTERNALFRAME, or PANEL)
	 * @return a new Console instance
	 */
	public static Console makeConsole(int type) {
		return new Console(type);
	}

	/**
	 * Initializes the JFrame or JInternalFrame.
	 *
	 * @param isFrame true if initializing a JFrame, false for JInternalFrame
	 */
	private void initWindow(boolean isFrame) {
		if (isFrame) {
			frame = new JFrame("Console");
			frame.setLayout(null);
			frame.setResizable(true);
			frame.setBounds(100, 100, 800, 600);
		} else {
			internalFrame = new JInternalFrame("Console");
			internalFrame.setLayout(null);
			internalFrame.setResizable(true);
			internalFrame.setBounds(100, 100, 800, 600);
		}
	}

	/**
	 * Initializes the UI components of the console.
	 */
	private void initUiComponents() {
		scrollPane = new JScrollPane();
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		scrollPane.setViewportView(displayArea);

		inputField = new JTextField();

		scrollPane.setVisible(true);
		displayArea.setVisible(true);
		inputField.setVisible(true);
	}

	/**
	 * Adds components to the appropriate container based on the console type.
	 *
	 * @param type the type of console (FRAME, INTERNALFRAME, or PANEL)
	 */
	private void addComponents(int type) {
		Container container = (type == FRAME) ? frame.getContentPane() : (type == INTERNALFRAME) ? internalFrame.getContentPane() : panel;
		container.add(scrollPane);
		container.add(inputField);
		setComponentSizes(container.getWidth(), container.getHeight());
	}

	/**
	 * Sets the sizes of the console's components based on the container dimensions.
	 *
	 * @param width  the width of the container
	 * @param height the height of the container
	 */
	private void setComponentSizes(int width, int height) {
		scrollPane.setBounds(10, 10, width - 40, height - 120);
		inputField.setBounds(10, height - 100, width - 40, 30);
	}

	/**
	 * Appends colored text to the console's display area.
	 *
	 * @param text  the text to append
	 * @param color the color of the text
	 */
	private void appendColoredText(String text, Color color) {
		StyledDocument doc = displayArea.getStyledDocument();
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setForeground(style, color);
		try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Outputs a line of text to the console in the specified color.
	 *
	 * @param text  the text to output
	 * @param color the color of the text
	 */
	public void outputToConsole(String text, Color color) {
		appendColoredText(text + "\n", color);
	}

	/**
	 * Clears all text from the console's display area.
	 */
	public void clearConsole() {
		displayArea.setText("");
	}

	/**
	 * Processes input from a specified component. This method is currently a
	 * placeholder for future implementation.
	 *
	 * @param component the component that triggered the input
	 */
	public void processInput(JComponent component) {
		if (component == inputField) {
			// TODO Implement input processing logic
		}
	}

	/**
	 * Initializes the menu bar and its menus for the console.
	 */
	private void initMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
	}
}
