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

@SuppressWarnings("serial")
public class ConsoleIF extends JInternalFrame {
	
	public static final int MODE_DEFAULT = 0, MODE_CONTROL = 1, MODE_INTERACTIVE_SCRIPTING = 2;
	
	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	private int consoleMode = 0;
	private String consoleTarget = "default";
	
	public ConsoleIF() {
        this.initUI();
        this.initMenuBar();
        this.resizeConsole();
        
        this.setTitle("Console");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
	
	private void initMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
	}
	
	private void initUI() {
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setVisible(true);
		
		inputField = new JTextField();
		inputField.setVisible(true);
		
		this.add(scrollPane);
		this.add(inputField);
		
	}
	
	public void resizeConsole() {
		int width = this.getWidth();
		int height = this.getHeight();
		scrollPane.setBounds(10, 10, width - 30, height - 120);
		inputField.setBounds(10, height - 100, width - 30, 30);
	}
	
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
	
	public void println() {
		outputToConsole("\n", Color.black);
	}
	
	public void printWarning(String text) {
		outputToConsole(text + "\n", Color.orange);
	}
	
	public void printError(String text) {
		outputToConsole(text + "\n", Color.red);
	}
	
	public void printInfo(String text) {
		outputToConsole(text + "\n", Color.blue);
	}
	
	public void printSuccess(String text) {
		outputToConsole(text + "\n", Color.green);
	}
	
	public void clearConsoleOutput() {
		displayArea.setText("");
	}
	
	public void clearConsoleInput() {
		inputField.setText("");
	}
	
	public void setConsoleMode(int mode) {
		this.consoleMode = mode;
	}
	
	public int getConsoleMode() {
		return this.consoleMode;
	}
	
	public void setConsoleTarget(String target) {
		this.consoleTarget = target;
	}
	
	public String getConsoleTarget() {
		return this.consoleTarget;
	}
	
}
