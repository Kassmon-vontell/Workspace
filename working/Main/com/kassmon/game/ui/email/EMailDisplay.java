package com.kassmon.game.ui.email;

import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "unused", "serial" })
public class EMailDisplay extends JInternalFrame {
	
	private ArrayList<Email> mailList;
	
	private JButton mailButtons[] = new JButton[10];
	private JButton next, previous, deleteMail, missionTermnal;
	
	private int vewOffset = 0;
	private int lookingAtEmailNumber = 0;
	
	public EMailDisplay() {
		super("Email");
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(10, 10, 800, 400);
		this.setClosable(true);
		this.setResizable(true);
		
		mailList = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			mailButtons[i] = new JButton();
			mailButtons[i].setBounds(10, 10 + (30 * i), 190, 25);
			mailButtons[i].setVisible(false);
			this.add(mailButtons[i]);
		}
		
		next = new JButton("Next");
		next.setBounds(10, 310, 90, 25);
		next.setVisible(false);
		this.add(next);
		
		previous = new JButton("Previous");
		previous.setBounds(110, 310, 90, 25);
		previous.setVisible(false);
		this.add(previous);
		
	}
	
	public void updateEmailList() {
		// Hide all buttons initially
		for (JButton button : mailButtons) {
			button.setVisible(false);
		}
		next.setVisible(false);
		previous.setVisible(false);
		// Determine the range of emails to display
		int start = vewOffset * 10;
		int end = Math.min(start + 10, mailList.size());
		// Update the visible buttons with email headers
		for (int i = start; i < end; i++) {
			mailButtons[i - start].setText(mailList.get(i).getHeader());
			mailButtons[i - start].setVisible(true);
		}
		// Show "Next" button if there are more emails to display
		if (end < mailList.size()) {
			next.setVisible(true);
		}
		// Show "Previous" button if not on the first page
		if (vewOffset > 0) {
			previous.setVisible(true);
		}
	}
	
	public void addEMailToList(Email email) {
		mailList.add(email);
		updateEmailList();
	}
	
	
}
