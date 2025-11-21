package com.kassmon.tests;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.kassmon.game.saveSystem.userInfo.UserData;

@SuppressWarnings("unused")
public class DevWindow {
	
	private static JFrame devWindow;
	private static JTextField userID;
	private static JTextField fontSize;
	private static JTextField fontType;
	private static JTextField backgroundColor;
	private static JTextField fontColor;
	private static JTextField borderColor;
	
	private static JTextField level;
	private static JTextField experience;
	private static JTextField money;
	
	private static JTextField holoVectorLabsAccess;
	private static JTextField holoVectorLabsReputation;
	private static JTextField holoVectorLabsMissionCompleateLvl1;
	private static JTextField holoVectorLabsMissionCompleateLvl2;
	private static JTextField holoVectorLabsMissionCompleateLvl3;
	
	public static void initDevWindow() {
		
		devWindow = new JFrame("Dev Window");
        devWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        devWindow.setSize(600, 600);
        devWindow.setLayout(new GridLayout(0, 2));
        
        userID = new JTextField(UserData.getUserId());
        fontSize = new JTextField(String.valueOf(UserData.getFountSize()));
        fontType = new JTextField(UserData.getFont());
        backgroundColor = new JTextField(String.valueOf(UserData.getBackgroundColor().getRGB()));
        fontColor = new JTextField(String.valueOf(UserData.getFontColor().getRGB()));
        borderColor = new JTextField(String.valueOf(UserData.getBorderColor().getRGB()));
        
        level = new JTextField(String.valueOf(UserData.getLevel()));
        experience = new JTextField(String.valueOf(UserData.getExperience()));
        money = new JTextField(String.valueOf(UserData.getMoney()));
        
        holoVectorLabsAccess = new JTextField(String.valueOf(UserData.getHoloVectorLabsAccess()));
        holoVectorLabsReputation = new JTextField(String.valueOf(UserData.getHoloVectorLabsReputation()));
        holoVectorLabsMissionCompleateLvl1 = new JTextField(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl1()));
        holoVectorLabsMissionCompleateLvl2 = new JTextField(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl2()));
        holoVectorLabsMissionCompleateLvl3 = new JTextField(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl3()));
        
        devWindow.add(new JLabel("User ID:"));
        devWindow.add(userID);
        devWindow.add(new JLabel("Font Size:"));
        devWindow.add(fontSize);
        devWindow.add(new JLabel("Font Type:"));
        devWindow.add(fontType);
        devWindow.add(new JLabel("Background Color (RGB):"));
        devWindow.add(backgroundColor);
        devWindow.add(new JLabel("Font Color (RGB):"));
        devWindow.add(fontColor);
        devWindow.add(new JLabel("Border Color (RGB):"));
        devWindow.add(borderColor);
        
        devWindow.add(new JLabel("Level:"));
        devWindow.add(level);
        devWindow.add(new JLabel("Experience:"));
        devWindow.add(experience);
        devWindow.add(new JLabel("Money:"));
        devWindow.add(money);
        
        devWindow.add(new JLabel("HoloVector Labs Access:"));
        devWindow.add(holoVectorLabsAccess);
        devWindow.add(new JLabel("HoloVector Labs Reputation:"));
        devWindow.add(holoVectorLabsReputation);
        devWindow.add(new JLabel("HoloVector Labs Mission Complete Lvl 1:"));
        devWindow.add(holoVectorLabsMissionCompleateLvl1);
        devWindow.add(new JLabel("HoloVector Labs Mission Complete Lvl 2:"));
        devWindow.add(holoVectorLabsMissionCompleateLvl2);
        devWindow.add(new JLabel("HoloVector Labs Mission Complete Lvl 3:"));
        devWindow.add(holoVectorLabsMissionCompleateLvl3);
        
        JButton updateButton = new JButton("Update Display");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDevWindow();
            }
        });

        devWindow.add(new JLabel()); // Placeholder for alignment
        devWindow.add(updateButton);
        
        devWindow.setVisible(true);
		
	}
	
	public static void updateDevWindow() {
		userID.setText(UserData.getUserId());
		fontSize.setText(String.valueOf(UserData.getFountSize()));
		fontType.setText(UserData.getFont());
		backgroundColor.setText(String.valueOf(UserData.getBackgroundColor().getRGB()));
		fontColor.setText(String.valueOf(UserData.getFontColor().getRGB()));
		borderColor.setText(String.valueOf(UserData.getBorderColor().getRGB()));

		level.setText(String.valueOf(UserData.getLevel()));
		experience.setText(String.valueOf(UserData.getExperience()));
		money.setText(String.valueOf(UserData.getMoney()));

		holoVectorLabsAccess.setText(String.valueOf(UserData.getHoloVectorLabsAccess()));
		holoVectorLabsReputation.setText(String.valueOf(UserData.getHoloVectorLabsReputation()));
		holoVectorLabsMissionCompleateLvl1.setText(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl1()));
		holoVectorLabsMissionCompleateLvl2.setText(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl2()));
		holoVectorLabsMissionCompleateLvl3.setText(String.valueOf(UserData.getHoloVectorLabsMissionCompleateLvl3()));
	}
	
}
