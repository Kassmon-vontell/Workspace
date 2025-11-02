package com.kassmon.tests;

import com.kassmon.game.ui.desktop.Desktop;
import com.kassmon.game.ui.loginWindow.LoginScreen;

public class StartScreanTest {
	
	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		
		LoginScreen loginScreen = new LoginScreen();
		LoginScreen loginScreen2 = new LoginScreen();
		
		loginScreen2.setTitle("Login Screen 2");
		
		desktop.addWindow(loginScreen);
		desktop.addWindow(loginScreen2);
		
		
	}
	
}
