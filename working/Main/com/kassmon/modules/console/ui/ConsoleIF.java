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
	
	public void println(String text) {
		outputToConsole(text + "\n", Color.black);
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

	@Override
	public String getInput() {
		return this.inputField.getText();
	}
	
	
}