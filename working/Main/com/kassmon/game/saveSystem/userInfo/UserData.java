package com.kassmon.game.saveSystem.userInfo;

import java.awt.Color;

public class UserData {
	
	private static String userId = "defaultUser";
	private static int fountSize = 14;
	private static String font = "Arial";
	private static Color backgroundColor = Color.LIGHT_GRAY;
	private static Color fontColor = Color.BLACK;
	private static Color borderColor = Color.BLACK;
	
	private static int level = 1;
	private static int experience = 0;
	private static int money = 0;
	
	private static int holoVectorLabsAccess = 0;
	private static int holoVectorLabsReputation = 0;
	private static int holoVectorLabsMissionCompleateLvl1 = 0;
	private static int holoVectorLabsMissionCompleateLvl2 = 0;
	private static int holoVectorLabsMissionCompleateLvl3 = 0;
	
	public static String getUserId() {
		return userId;
	}
	public static void setUserId(String userId) {
		UserData.userId = userId;
	}
	public static int getFountSize() {
		return fountSize;
	}
	public static void setFountSize(int fountSize) {
		UserData.fountSize = fountSize;
	}
	public static String getFont() {
		return font;
	}
	public static void setFont(String font) {
		UserData.font = font;
	}
	public static Color getBackgroundColor() {
		return backgroundColor;
	}
	public static void setBackgroundColor(Color backgroundColor) {
		UserData.backgroundColor = backgroundColor;
	}
	public static Color getFontColor() {
		return fontColor;
	}
	public static void setFontColor(Color fontColor) {
		UserData.fontColor = fontColor;
	}
	public static Color getBorderColor() {
		return borderColor;
	}
	public static void setBorderColor(Color borderColor) {
		UserData.borderColor = borderColor;
	}
	public static int getLevel() {
		return level;
	}
	public static void setLevel(int level) {
		UserData.level = level;
	}
	public static int getExperience() {
		return experience;
	}
	public static void setExperience(int experience) {
		UserData.experience = experience;
	}
	public static int getMoney() {
		return money;
	}
	public static void setMoney(int money) {
		UserData.money = money;
	}
	public static int getHoloVectorLabsAccess() {
		return holoVectorLabsAccess;
	}
	public static void setHoloVectorLabsAccess(int holoVectorLabsAccess) {
		UserData.holoVectorLabsAccess = holoVectorLabsAccess;
	}
	public static int getHoloVectorLabsReputation() {
		return holoVectorLabsReputation;
	}
	public static void setHoloVectorLabsReputation(int holoVectorLabsReputation) {
		UserData.holoVectorLabsReputation = holoVectorLabsReputation;
	}
	public static int getHoloVectorLabsMissionCompleateLvl1() {
		return holoVectorLabsMissionCompleateLvl1;
	}
	public static void setHoloVectorLabsMissionCompleateLvl1(int holoVectorLabsMissionCompleateLvl1) {
		UserData.holoVectorLabsMissionCompleateLvl1 = holoVectorLabsMissionCompleateLvl1;
	}
	public static int getHoloVectorLabsMissionCompleateLvl2() {
		return holoVectorLabsMissionCompleateLvl2;
	}
	public static void setHoloVectorLabsMissionCompleateLvl2(int holoVectorLabsMissionCompleateLvl2) {
		UserData.holoVectorLabsMissionCompleateLvl2 = holoVectorLabsMissionCompleateLvl2;
	}
	public static int getHoloVectorLabsMissionCompleateLvl3() {
		return holoVectorLabsMissionCompleateLvl3;
	}
	public static void setHoloVectorLabsMissionCompleateLvl3(int holoVectorLabsMissionCompleateLvl3) {
		UserData.holoVectorLabsMissionCompleateLvl3 = holoVectorLabsMissionCompleateLvl3;
	}
	
	
	
	
}
