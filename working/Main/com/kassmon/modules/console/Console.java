
package com.kassmon.modules.console;

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;

/**
 * Represents a customizable console UI component that can be displayed as a
 * JFrame, JInternalFrame, or JPanel. Provides methods for outputting text,
 * handling input, and managing the console's appearance.
 */
public class Console {

	// Console display types
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
	 *@param type the type of console (FRAME, INTERNALFRAME, or PANEL)
	 */
	private Console(int type) {
		if (type == FRAME)
			initFrame();
		if (type == INTERNALFRAME)
			initInternalFrame();
		if (type == PANEL)
			initPanel();
		if (type != PANEL)
			initMenuBar();
		initUi();
		setComponentSizes();
		if (type == FRAME)
			addComponentsToFrame();
		if (type == INTERNALFRAME)
			addComponentsToInternalFrame();
		if (type == PANEL)
			addComponentsToPanel();
	}

	/**
	 * Factory method to create a new Console instance.
	 *@param type the type of console (FRAME, INTERNALFRAME, or PANEL)
	 * @return a new Console instance
	 */
	public static Console makeConsole(int type) {
		return new Console(type);
	}

	/**
	 * Initializes the JFrame for the console.
	 */
	private void initFrame() {
		frame = new JFrame("Console");
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setBounds(100, 100, 800, 600);
	}

	/**
	 * Initializes the JInternalFrame for the console.
	 */
	private void initInternalFrame() {
		internalFrame = new JInternalFrame("Console");
		internalFrame.setLayout(null);
		internalFrame.setResizable(true);
		internalFrame.setBounds(100, 100, 800, 600);
	}

	/**
	 * Initializes the JPanel for the console.
	 */
	private void initPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 800, 600);
	}

	/**
	 * Sets the sizes of the console's components based on the frame dimensions.
	 */
	public void setComponentSizes() {
		scrollPane.setBounds(10, 10, frame.getWidth() - 40, frame.getHeight() - 120);
		inputField.setBounds(10, frame.getHeight() - 100, frame.getWidth() - 40, 30);
	}

	/**
	 * Initializes the menu bar and its menus for the console.
	 */
	private void initMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		editMenu = new JMenu("Edit");
		menuBar.add(editMenu);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
	}

	/**
	 * Initializes the UI components of the console.
	 */
	private void initUi() {
		scrollPane = new JScrollPane();
		scrollPane.setVisible(true);

		displayArea = new JTextPane();
		displayArea.setEditable(false);
		displayArea.setVisible(true);
		scrollPane.setViewportView(displayArea);

		inputField = new JTextField();
		inputField.setVisible(true);
	}

	/**
	 * Adds components to the JFrame.
	 */
	private void addComponentsToFrame() {
		frame.add(scrollPane);
		frame.add(inputField);
	}

	/**
	 * Adds components to the JInternalFrame.
	 */
	private void addComponentsToInternalFrame() {
		internalFrame.add(scrollPane);
		internalFrame.add(inputField);
	}

	/**
	 * Adds components to the JPanel.
	 */
	private void addComponentsToPanel() {
		panel.add(scrollPane);
		panel.add(inputField);
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
	 * Outputs a line of text to the console in black color.
	 *
	 * @param text the text to output
	 */
	public void outputLineToConsole(String text) {
		appendColoredText(text + "\n", Color.black);
	}

	/**
	 * Outputs an error message to the console in red color.
	 *
	 * @param text the error message to output
	 */
	public void outputErrorToConsole(String text) {
		appendColoredText("[ERROR]" + text + "\n", Color.red);
	}

	/**
	 * Outputs a warning message to the console in orange color.
	 *
	 * @param text the warning message to output
	 */
	public void outputWarningToConsole(String text) {
		appendColoredText("[WARNING]" + text + "\n", Color.orange);
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
			//TODO Implement input processing logic
		}
	}
}
