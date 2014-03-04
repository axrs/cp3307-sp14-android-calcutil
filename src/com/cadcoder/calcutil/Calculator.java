package com.cadcoder.calcutil;

/**
 * 
 * @author Alex
 *
 */
public interface Calculator {
	
	/**
	 * Adds the value to the current calculator value
	 * @param value Value to add
	 */
	void sum(int value);
	
	/**
	 * Resets the calculator
	 */
	void clear();
	
	/**
	 * Gets the calculators value
	 * @return Current Calculator value
	 */
	int value();
}
