package com.kassmon.modules.console.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.kassmon.modules.console.api.Console;
import com.kassmon.modules.console.api.ConsoleControler;
import com.kassmon.modules.console.events.listeners.InputListener;
import com.kassmon.modules.console.events.listeners.ResizeListener;

/**
 * The ConsoleIF class implements a console as a JInternalFrame.
 * It provides a console suitable for embedding within a desktop pane,
 * with a menu bar, scrollable output area, and input field.
 * This implementation supports being closable, iconifiable, and resizable.
 */
@SuppressWarnings("serial")
public class ConsoleIF extends JInternalFrame implements Console {
	
	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	private ConsoleControler consoleControler;
	
	/**
	 * Constructs a new ConsoleIF (console internal frame) with the specified controller.
	 * Initializes the UI components, menu bar, and event listeners.
	 *
	 * @param consoleControler the console controller managing this console
	 */
	public ConsoleIF(ConsoleControler consoleControler) {
        this.initUI();
        this.initMenuBar();
        this.resizeConsole();
        
        this.setTitle("Console");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.consoleControler = consoleControler;
    }
	
	/**
	 * Initializes the menu bar with File, Edit, and Help menus.
	 * Also adds a resize listener to the console.
	 */
	private void initMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
		
		this.addComponentListener(new ResizeListener(consoleControler));
		
	}
	
	/**
	 * Initializes the UI components including the display area,
	 * scroll pane, and input field with event listeners.
	 */
	private void initUI() {
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setVisible(true);
		
		inputField = new JTextField();
		inputField.setVisible(true);
		
		this.add(scrollPane);
		this.add(inputField);
		
		inputField.addActionListener(new InputListener(consoleControler));
		
	}
	
	/**
	 * Resizes the console components to fit the current window size.
	 */
	public void resizeConsole() {
		int width = this.getWidth();
		int height = this.getHeight();
		scrollPane.setBounds(10, 10, width - 30, height - 120);
		inputField.setBounds(10, height - 100, width - 30, 30);
	}
	
	/**
	 * Outputs text to the console with the specified color.
	 *
	 * @param text  the text to display
	 * @param color the color to use for the text
	 */
	public void outputToConsole(String text, Color color) {
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
	@Override
	public String getInput() {
		return this.inputField.getText();
	}
	
	
}