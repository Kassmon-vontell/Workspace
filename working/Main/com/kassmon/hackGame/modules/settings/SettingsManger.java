
package com.kassmon.hackGame.modules.settings;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

/**
 * The SettingsManger class provides functionality to manage application
 * settings using an XML file. It allows initializing settings, setting default
 * values, retrieving and updating specific settings, and saving changes to the
 * file.
 */
public class SettingsManger {
	private static Document document; // XML Document object to manage settings

	/**
	 * Initializes the settings manager with the specified XML file. If the file
	 * does not exist, it creates a new one with default settings.
	 *
	 * @param filePath The path to the XML file to be used for settings.
	 */
	public static void init(String filePath) {
		try {
			File xmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			if (!xmlFile.exists()) {
				document = dBuilder.newDocument(); // Initialize document
				setDefaultSettings(); // Set default settings
				save(filePath); // Save default settings to file
			} else {
				document = dBuilder.parse(xmlFile); // Parse existing file
				document.getDocumentElement().normalize(); // Normalize the document
			}
		} catch (Exception e) {
			e.printStackTrace();
			document = null; // Ensure document is null if initialization fails
		}
	}

	/**
	 * Sets default settings in the XML document. This method is called when the
	 * settings file does not exist.
	 */
	public static void setDefaultSettings() {
		if (document == null) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				document = dBuilder.newDocument(); // Initialize document
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}

		setElementValue("FontSize", "16"); // Set default font size
	}

	/**
	 * Creates a new XML element with the specified tag name and value.
	 *
	 * @param tagName The name of the XML element.
	 * @param value   The value to be set for the element.
	 * @return The created XML element.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	private static Element makeElement(String tagName, String value) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		Element element = document.createElement(tagName);
		element.setTextContent(value);
		return element;
	}

	/**
	 * Retrieves the value of the specified XML element.
	 *
	 * @param tagName The name of the XML element to retrieve.
	 * @return The value of the element, or null if the element does not exist.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	public static String getElementValue(String tagName) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		NodeList nodeList = document.getElementsByTagName(tagName);
		if (nodeList != null && nodeList.getLength() > 0) {
			Node node = nodeList.item(0);
			return node.getTextContent();
		}
		return null;
	}

	/**
	 * Sets the value of the specified XML element. If the element does not exist,
	 * it creates a new one.
	 *
	 * @param tagName The name of the XML element to set.
	 * @param value   The value to be set for the element.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	public static void setElementValue(String tagName, String value) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		NodeList nodeList = document.getElementsByTagName(tagName);
		if (nodeList != null && nodeList.getLength() > 0) {
			Node node = nodeList.item(0);
			node.setTextContent(value);
		} else {
			Element newElement = makeElement(tagName, value);
			document.getDocumentElement().appendChild(newElement);
		}
	}

	/**
	 * Saves the current state of the XML document to the specified file.
	 *
	 * @param filePath The path to the file where the document should be saved.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	public static void save(String filePath) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Format output
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result); // Save to file
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
