package com.kassmon.modules.console;

import java.awt.Color;

import javax.swing.*;
import javax.swing.text.*;

@SuppressWarnings("unused")
public class ConsoleFrame {
	
	private JFrame frame;
	private JTextPane displayArea;
	private JTextField inputField;
	
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	
	private ConsoleFrame () {
		initFrame();
		initMenuBar();
		initUi();
		frame.setVisible(true);
	}
	
	public static ConsoleFrame makeConsole () {
        return new ConsoleFrame();
    }
	
	private void initFrame() {
		frame = new JFrame("Console");
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setBounds(100, 100, 800, 600);
	}
	
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
	
	private void initUi() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, frame.getWidth() - 40, frame.getHeight() - 120);
		frame.add(scrollPane);
		scrollPane.setVisible(true);
		
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		displayArea.setVisible(true);
		scrollPane.setViewportView(displayArea);
		
		inputField = new JTextField();
		inputField.setBounds(10, frame.getHeight() - 100, frame.getWidth() - 40, 30);
		frame.add(inputField);
		inputField.setVisible(true);
		
	}
	
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
	
	public void outputLineToConsole(String text) {
		appendColoredText(text + "\n", Color.black);
	}
	
	public void outputErrorToConsole(String text) {
		appendColoredText(text + "\n", Color.red);
	}
	
	public void outputWarningToConsole(String text) {
		appendColoredText(text + "\n", Color.orange);
	}
	
}
