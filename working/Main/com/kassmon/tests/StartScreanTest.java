package com.kassmon.tests;

import com.kassmon.game.ui.desktop.Desktop;
import com.kassmon.game.ui.loginWindow.LoginScreen;

/**
 * The StartScreanTest class is a test application that demonstrates
 * the desktop environment with multiple login screen windows.
 * It creates a desktop and adds two login screen internal frames to it.
 */
public class StartScreanTest {
	
	/**
	 * Main entry point for the test application.
	 * Creates a desktop environment and adds two login screen windows.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		
		LoginScreen loginScreen = new LoginScreen();
		LoginScreen loginScreen2 = new LoginScreen();
		
		loginScreen2.setTitle("Login Screen 2");
		
		desktop.addWindow(loginScreen);
		desktop.addWindow(loginScreen2);
		
		
	}
	
}
