package com.kassmon.modules.console;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.*;

import com.kassmon.modules.console.commands.*;
import com.kassmon.modules.tokenizer.Tokenizer;

public class ConsoleFrame implements Console, ActionListener, ComponentListener  {
	
	private JFrame frame;
	
	private JScrollPane scrollPane;
	private JTextPane displayArea;
	private JTextField inputField;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	private ArrayList<ConsoleCommand> commands;
	
	private Tokenizer tokenizer;
	
	private ConsoleFrame () {
		initFrame();
        initMenuBar();
        initUI();
        initCommandSystem();
        
        frame.addComponentListener(this);
        
        resizeConsole();
        
        frame.setSize(800, 600);
	}
	
	public static Console makeConsole () {
		return new ConsoleFrame();
	}
	
	private void initFrame() {
		frame = new JFrame("Console");
		frame.setBounds(100, 100, 600, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void initMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		frame.setJMenuBar(menuBar);
	}
	
	private void initUI() {
		
		displayArea = new JTextPane();
		displayArea.setEditable(false);
		
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setVisible(true);
		
		
		inputField = new JTextField();
		inputField.setVisible(true);
		
		frame.add(scrollPane);
		frame.add(inputField);
		
		inputField.addActionListener(this);
		
	}
	
	private void initCommandSystem() {
		tokenizer = new Tokenizer();
		commands = new ArrayList<>();
		
		addCommand(new Clear(this) , "^clear$", "COMMAND");
		addCommand(new Echo(this) , "^echo", "COMMAND");
		
		tokenizer.addPattern("[a-zA-Z0-9]*", "text");
	}
	
	public void addCommand(ConsoleCommand command, String Regex, String type) {
		commands.add(command);
		tokenizer.addPattern(Regex, type);
	}
	
	private void resizeConsole() {
		int width = frame.getWidth();
		int height = frame.getHeight();
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
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(inputField)) {
			tokenizer.setInput(inputField.getText());
			for (ConsoleCommand command : commands) {
				if (tokenizer.getNextToken(true).getValue().equals(command.getName().toLowerCase())) {
					command.execute(tokenizer.getAllTokens());
					clearConsoleInput();
					return;
				} 
			}
		}
		clearConsoleInput();
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		resizeConsole();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
