
package com.kassmon.game.saveSystem;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.awt.Font;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

/**
 * The `SaveSystemManger` class provides functionality to manage application
 * settings using an XML file that is Base64-encoded.
 */
public class SaveSystemManger {
	private static Document document; // XML document to manage settings
	private static String userID = "default"; // Current user ID;

	// -------------------- Initialization --------------------

	/**
	 * Initializes the settings manager with the specified file path. If the file
	 * does not exist, it creates a new XML document with default settings.
	 *
	 * @param filePath The path to the settings file.
	 */
	public static void init(String filePath) {
		try {
			File xmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			if (!xmlFile.exists()) {
				document = dBuilder.newDocument();
				setDefaultSettings();
				save(filePath);
			} else {
				String base64Content = new String(Files.readAllBytes(Paths.get(filePath)));
				byte[] decodedBytes = Base64.getDecoder().decode(base64Content);
				String xmlContent = new String(decodedBytes);

				document = dBuilder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
				document.getDocumentElement().normalize();
			}
		} catch (Exception e) {
			e.printStackTrace();
			document = null;
		}
	}

	// -------------------- Default Settings --------------------

	/**
	 * Sets default settings in the XML document.
	 */
	private static void setDefaultSettings() {
		if (document == null) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				document = dBuilder.newDocument();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		loadDefaultsValues();
	}

	/**
	 * Loads default values into the XML document.
	 */
	private static void loadDefaultsValues() {
		makeUserAccount("default", "password");
	}

	// -------------------- User Account Management --------------------

	/**
	 * Creates a user account with the specified username and password.
	 *
	 * @param username The username of the account.
	 * @param password The password of the account.
	 */
	public static void makeUserAccount(String username, String password) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}

		NodeList userList = document.getElementsByTagName("users");
		Element users;

		if (userList.getLength() > 0) {
			users = (Element) userList.item(0);
		} else {
			users = document.createElement("users");
			document.appendChild(users);
		}

		Element userAccount = document.createElement("account");
		userAccount.setAttribute("username", username);
		userAccount.setAttribute("password", password);
		users.appendChild(userAccount);

		Element font = document.createElement("FontSize");
		font.setAttribute("size", "12");
		font.setAttribute("TypeFace", "Courier New");
		userAccount.appendChild(font);
	}

	/**
	 * Retrieves all user IDs as a String array.
	 *
	 * @return A String array of user IDs.
	 */
	public static String[] getAllUserIDs() {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}

		NodeList userList = document.getElementsByTagName("account");
		String[] userIds = new String[userList.getLength()];

		for (int i = 0; i < userList.getLength(); i++) {
			Element userAccount = (Element) userList.item(i);
			userIds[i] = userAccount.getAttribute("username");
		}

		return userIds;
	}

	/**
	 * Adds save data for the current user.
	 *
	 * @param key   The key for the save data.
	 * @param value The value for the save data.
	 */
	public static void addUserSaveData(String key, String value) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		NodeList userList = document.getElementsByTagName("account");
		for (int i = 0; i < userList.getLength(); i++) {
			Element userAccount = (Element) userList.item(i);
			if (userAccount.getAttribute("username").equals(userID)) {
				Element saveData = document.createElement("saveData");
				saveData.setAttribute(key, value); // Add one attribute
				userAccount.appendChild(saveData);
				break;
			}
		}
	}

	/**
	 * Retrieves save data for the current user by key.
	 *
	 * @param key The key for the save data.
	 * @return The value of the save data, or null if not found.
	 */
	public static String getUserSaveData(String key) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}

		NodeList userList = document.getElementsByTagName("account");
		for (int i = 0; i < userList.getLength(); i++) {
			Element userAccount = (Element) userList.item(i);
			if (userAccount.getAttribute("username").equals(userID)) {
				NodeList saveDataList = userAccount.getElementsByTagName("saveData");
				for (int j = 0; j < saveDataList.getLength(); j++) {
					Element saveData = (Element) saveDataList.item(j);
					if (saveData.getAttribute("key").equals(key)) {
						return saveData.getTextContent();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the font settings for the current user.
	 *
	 * @return A String array containing font size and typeface.
	 */

	public static Font getUserFont() {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		NodeList userList = document.getElementsByTagName("account");
		for (int i = 0; i < userList.getLength(); i++) {
			Element userAccount = (Element) userList.item(i);
			if (userAccount.getAttribute("username").equals(userID)) {
				NodeList fontList = userAccount.getElementsByTagName("FontSize");
				if (fontList.getLength() > 0) {
					Element font = (Element) fontList.item(0);
					String size = font.getAttribute("size");
					String typeFace = font.getAttribute("TypeFace");
					int fontSize = Integer.parseInt(size);
					return new Font(typeFace, Font.PLAIN, fontSize);
				}
			}
		}
		return new Font("Courier New", Font.PLAIN, 12); // Default font changed to Courier New
	}

	/**
	 * Sets the current user ID.
	 *
	 * @param id The user ID to set.
	 */
	public static void setUserID(String id) {
		userID = id;
	}

	// -------------------- Save and Load Operations --------------------

	/**
	 * Saves the XML document to the specified file path.
	 *
	 * @param filePath The path to save the file.
	 */
	private static void save(String filePath) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			transformer.transform(new DOMSource(document), new StreamResult(outputStream));
			String xmlString = outputStream.toString();

			String base64EncodedXml = Base64.getEncoder().encodeToString(xmlString.getBytes());

			try (FileWriter file = new FileWriter(filePath)) {
				file.write(base64EncodedXml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
