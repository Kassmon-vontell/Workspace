
package com.kassmon.game.ui.loginWindow;

import javax.swing.*;

import com.kassmon.game.ui.Api.UIComponent;

/**
 * The LoginScreen class provides a user interface for user authentication.
 * It displays a login form with username selection via combo box, password field,
 * and login/register buttons. This class extends JInternalFrame and implements
 * the UIComponent interface.
 */
@SuppressWarnings("serial")
public class LoginScreen extends JInternalFrame implements UIComponent {

	private JLabel WelcomeLabel;
	private JLabel UsernameLabel;
	private JComboBox<String> UsernameComboBox;
	private JLabel PasswordLabel;
	private JPasswordField PasswordField;
	private JButton LoginButton;
	private JButton RegisterButton;

	/**
	 * Constructs a new LoginScreen and initializes all UI components.
	 * The login screen is displayed as an internal frame with a fixed size.
	 */
	public LoginScreen() {
		super("Login Screen");
		setLayout(null); // Use null layout manager

		// Initialize components
		WelcomeLabel = new JLabel("Welcome! Please log in.");
		UsernameLabel = new JLabel("Username:");
		UsernameComboBox = new JComboBox<>();
		PasswordLabel = new JLabel("Password:");
		PasswordField = new JPasswordField(15);
		LoginButton = new JButton("Login");
		RegisterButton = new JButton("Register");

		// Set bounds for components
		WelcomeLabel.setBounds(80, 10, 200, 25);
		UsernameLabel.setBounds(30, 50, 80, 25);
		UsernameComboBox.setBounds(120, 50, 150, 25);
		PasswordLabel.setBounds(30, 90, 80, 25);
		PasswordField.setBounds(120, 90, 150, 25);
		LoginButton.setBounds(30, 130, 100, 25);
		RegisterButton.setBounds(140, 130, 100, 25);

		// Add components to the frame
		add(WelcomeLabel);
		add(UsernameLabel);
		add(UsernameComboBox);
		add(PasswordLabel);
		add(PasswordField);
		add(LoginButton);
		add(RegisterButton);
		
		setSize(300, 250);
		setLocation(100, 100);
		setVisible(true);
	}

	/**
	 * Retrieves the name of this UI component.
	 *
	 * @return the component name "LoginScrean"
	 */
	@Override
	public String getName() {
		return "LoginScrean";
	}

	/**
	 * Retrieves the unique identifier of this UI component.
	 *
	 * @return the component ID (0)
	 */
	@Override
	public int getId() {
		return 0;
	}
}
