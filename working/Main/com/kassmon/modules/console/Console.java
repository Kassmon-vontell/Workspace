package com.kassmon.modules.console;

import java.awt.Color;

import javax.swing.*;
import javax.swing.text.*;

public class Console {
	
	public final int FRAME = 0;
	public final int INTERNALFRAME = 1;
	public final int PANEL = 2;
	
	
	private JFrame frame;
	private JInternalFrame internalFrame;
	private JPanel panel;
	
	JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	private Console(int type) {
		if (type == FRAME) initFrame();
		if (type == INTERNALFRAME) initInternalFrame();
		if (type == PANEL) initPanel();
		if (type != PANEL) initMenuBar();
		initUi();
		if (type == FRAME) addComponentsToFrame();
		if (type == INTERNALFRAME) addComponentsToInternalFrame();
		if (type == PANEL) addComponentsToPanel();
	}
	
	public static Console makeConsole(int type) {
		return new Console(type);
	}
	
	private void initFrame() {
		frame = new JFrame("Console");
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setBounds(100, 100, 800, 600);
	}
	
	private void initInternalFrame() {
		internalFrame = new JInternalFrame("Console");
		internalFrame.setLayout(null);
		internalFrame.setResizable(true);
		internalFrame.setBounds(100, 100, 800, 600);
	}
	
	private void initPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 800, 600);
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
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, frame.getWidth() - 40, frame.getHeight() - 120);
		scrollPane.setVisible(true);
		
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		displayArea.setVisible(true);
		scrollPane.setViewportView(displayArea);
		
		inputField = new JTextField();
		inputField.setBounds(10, frame.getHeight() - 100, frame.getWidth() - 40, 30);
		inputField.setVisible(true);
	}
	
	private void addComponentsToFrame() {
		frame.add(scrollPane);
		frame.add(inputField);
	}
	
	private void addComponentsToInternalFrame() {
		internalFrame.add(scrollPane);
		internalFrame.add(inputField);
	}
	
	private void addComponentsToPanel() {
		panel.add(scrollPane);
		panel.add(inputField);
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
	
	public void clearConsole() {
		displayArea.setText("");
	}
	
	public void processInput(JComponent component) {
		
	}
	
}
