package com.kassmon.game.ui.Api;

/**
 * The UIComponent interface defines the contract for UI components in the game.
 * All UI elements should implement this interface to provide basic identification.
 */
public interface UIComponent {
	/**
	 * Retrieves the name of this UI component.
	 *
	 * @return the component name
	 */
	String getName();
	
	/**
	 * Retrieves the unique identifier of this UI component.
	 *
	 * @return the component ID
	 */
	int getId();
}
