package com.kassmon.game.ui.console;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.kassmon.game.ui.Api.UIComponent;

/**
 * The Console class provides a console UI component as an internal frame.
 * It displays a scrollable text area for output and a text field for input.
 * Supports colored output for different message types (info, warning, error, success).
 */
@SuppressWarnings("serial")
public class Console extends JInternalFrame implements UIComponent {
	
	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	String name;
	int id;
	
	/**
	 * Constructs a new Console with the specified name and ID.
	 *
	 * @param name the name of the console
	 * @param id   the unique identifier of the console
	 */
	public Console(String name, int id) {
		initConsole();
		resizeConsole();
		this.name = name;
		this.id = id;
	}
	
	/**
	 * Initializes the console components including the display area,
	 * scroll pane, and input field.
	 */
	private void initConsole() {
		setTitle("Console");
		setSize(400, 300);
		setLayout(null);
		setResizable(true);
		
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		
		
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setVisible(true);
		
		inputField = new JTextField();
		inputField.setVisible(true);
		
		this.add(scrollPane);
		this.add(inputField);
	}
	
	/**
	 * Resizes the console components to fit the current window size.
	 */
	public void resizeConsole() {
		int width = this.getWidth();
		int height = this.getHeight();
		scrollPane.setBounds(10, 10, width - 30, height - 100);
		inputField.setBounds(10, height - 80, width - 30, 30);
	}
	
	/**
	 * Outputs text to the console with the specified color.
	 *
	 * @param text  the text to display
	 * @param color the color to use for the text
	 */
	private void outputToConsole(String text, Color color) {
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
	 * Prints a line of text to the console in default color (black).
	 *
	 * @param text the text to print
	 */
	public void println(String text) {
		outputToConsole(text + "\n", Color.black);
	}
	
	/**
	 * Prints a blank line to the console.
	 */
	public void println() {
		outputToConsole("\n", Color.black);
	}
	
	/**
	 * Prints a warning message to the console in orange.
	 *
	 * @param text the warning message to print
	 */
	public void printWarning(String text) {
		outputToConsole(text + "\n", Color.orange);
	}
	
	/**
	 * Prints an error message to the console in red.
	 *
	 * @param text the error message to print
	 */
	public void printError(String text) {
		outputToConsole(text + "\n", Color.red);
	}
	
	/**
	 * Prints an informational message to the console in blue.
	 *
	 * @param text the info message to print
	 */
	public void printInfo(String text) {
		outputToConsole(text + "\n", Color.blue);
	}
	
	/**
	 * Prints a success message to the console in green.
	 *
	 * @param text the success message to print
	 */
	public void printSuccess(String text) {
		outputToConsole(text + "\n", Color.green);
	}
	
	/**
	 * Clears all output from the console display area.
	 */
	public void clearConsoleOutput() {
		displayArea.setText("");
	}
	
	/**
	 * Clears the console input field.
	 */
	public void clearConsoleInput() {
		inputField.setText("");
	}

	/**
	 * Retrieves the current text from the console input field.
	 *
	 * @return the input text
	 */
	public String getInput() {
		return this.inputField.getText();
	}
	
	/**
	 * Retrieves the name of this console component.
	 *
	 * @return the console name
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves the unique identifier of this console component.
	 *
	 * @return the console ID
	 */
	@Override
	public int getId() {
		return id;
	}
	
}
