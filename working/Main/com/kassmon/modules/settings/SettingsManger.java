
package com.kassmon.modules.settings;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.nio.file.*;
import java.util.Base64;

/**
 * The `SettingsManger` class provides functionality to manage application
 * settings using an XML file that is Base64-encoded. It supports initializing
 * settings, setting default values, retrieving and updating specific settings,
 * and saving changes to the file.
 */
public class SettingsManger {
	private static Document document; // XML document to manage settings

	/**
	 * Initializes the settings manager with the specified Base64-encoded XML file.
	 * If the file does not exist, it creates a new one with default settings.
	 *
	 * @param filePath The path to the Base64-encoded XML file to be used for
	 *                 settings.
	 */
	public static void init(String filePath) {
		try {
			File xmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			if (!xmlFile.exists()) {
				document = dBuilder.newDocument(); // Create a new XML document
				setDefaultSettings(); // Set default settings
				save(filePath); // Save default settings to file
			} else {
				// Read Base64-encoded content
				String base64Content = new String(Files.readAllBytes(Paths.get(filePath)));
				byte[] decodedBytes = Base64.getDecoder().decode(base64Content);
				String xmlContent = new String(decodedBytes);

				// Parse the decoded XML content
				document = dBuilder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));
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

		loadDefaultsValues(); // Load default values into the document
	}

	/**
	 * Loads default values into the XML document. This method should be customized
	 * to define the default settings for the application.
	 */
	public static void loadDefaultsValues() {
		
	}

	/**
	 * Creates an XML element with the specified tag name and value.
	 *
	 * @param tagName The name of the XML tag.
	 * @param value   The value to be set for the tag.
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
	 * Retrieves the value of the specified XML tag.
	 *
	 * @param tagName The name of the XML tag.
	 * @return The value of the tag, or null if the tag does not exist.
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
	 * Sets the value of the specified XML tag. If the tag does not exist, it
	 * creates a new tag with the specified value.
	 *
	 * @param tagName The name of the XML tag.
	 * @param value   The value to be set for the tag.
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
	 * Saves an array of values as a comma-separated string in the specified XML
	 * tag.
	 *
	 * @param tagName The name of the XML tag.
	 * @param values  The array of values to be saved.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	public static void setArrayElementValue(String tagName, String[] values) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		String joinedValues = String.join(",", values);
		setElementValue(tagName, joinedValues);
	}

	/**
	 * Retrieves an array of values from a comma-separated string in the specified
	 * XML tag.
	 *
	 * @param tagName The name of the XML tag.
	 * @return The array of values, or null if the tag does not exist.
	 * @throws IllegalStateException if the document is not initialized.
	 */
	public static String[] getArrayElementValue(String tagName) {
		if (document == null) {
			throw new IllegalStateException("Document is not initialized.");
		}
		String value = getElementValue(tagName);
		return value != null ? value.split(",") : null;
	}

	/**
	 * Saves the current state of the XML document to the specified file as a
	 * Base64-encoded string.
	 *
	 * @param filePath The path to the file where the Base64-encoded XML document
	 *                 should be saved.
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
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			transformer.transform(new DOMSource(document), new StreamResult(outputStream));
			String xmlString = outputStream.toString();

			// Encode the XML string into Base64
			String base64EncodedXml = Base64.getEncoder().encodeToString(xmlString.getBytes());

			// Save the Base64 string to the file
			try (FileWriter file = new FileWriter(filePath)) {
				file.write(base64EncodedXml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
