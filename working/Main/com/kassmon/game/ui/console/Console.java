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



@SuppressWarnings("serial")
public class Console extends JInternalFrame implements UIComponent {
	
	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	String name;
	int id;
	
	public Console(String name, int id) {
		initConsole();
		resizeConsole();
		this.name = name;
		this.id = id;
	}
	
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
	
	public void resizeConsole() {
		int width = this.getWidth();
		int height = this.getHeight();
		scrollPane.setBounds(10, 10, width - 30, height - 1000);
		inputField.setBounds(10, height - 80, width - 30, 30);
	}
	
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

	public String getInput() {
		return this.inputField.getText();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
}
