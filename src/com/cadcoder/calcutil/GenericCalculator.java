package com.cadcoder.calcutil;

/**
 * @author Alex
 *
 */
public class GenericCalculator implements Calculator {
	private int _result = 0;
		
	@Override
	public void sum(int value) {
		_result += value;
	}

	@Override
	public void clear() {
		_result = 0;
	}
	
	@Override
	public int value() {
		return _result;
	}

}
