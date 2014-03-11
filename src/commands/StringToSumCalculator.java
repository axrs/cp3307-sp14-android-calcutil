package commands;

import calculators.Calculator;


public class StringToSumCalculator implements Command {

	private Calculator calc;
	private String value;

	public StringToSumCalculator(Calculator c, String v){
		this.calc = c;		
		this.value = v;
	}


	@Override
	public void execute() {				
		calc.sum(Double.parseDouble(value));		
	}	

}
