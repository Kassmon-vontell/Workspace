package com.kassmon.modules.console;

import javax.swing.*;

public class Console {
	
	private JFrame frame;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	private JTextField textField;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	
	
	private Console () {
		frame = new JFrame("Console");
		frame.setLayout(null);
		
		
	}
	
	public static Console makeConsole () {
        return new Console();
    }
	
	private void initFrame() {
		frame = new JFrame("Console");
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setBounds(100, 100, 800, 600);
	}
	
}
