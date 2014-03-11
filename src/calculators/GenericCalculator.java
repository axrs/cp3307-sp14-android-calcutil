package calculators;

/**
 * @author Alex
 *
 */
public class GenericCalculator implements Calculator {
	private double _result = 0.0;
		
	@Override
	public void sum(double value) {
		_result += value;
	}

	@Override
	public void clear() {
		_result = 0;
	}
	
	@Override
	public double value() {
		return _result;
	}

}
