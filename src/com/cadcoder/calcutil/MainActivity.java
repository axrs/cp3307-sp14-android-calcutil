package com.cadcoder.calcutil;

import com.cadcoder.calcutil.calculators.Calculator;
import com.cadcoder.calcutil.calculators.GenericCalculator;
import com.cadcoder.calcutil.commands.ChangeInputDisplayCommand;
import com.cadcoder.calcutil.commands.RevertInputDisplayCommand;
import com.cadcoder.calcutil.commands.StringToSumCalculator;
import com.cadcoder.calcutil.utilities.StringUtility;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Calculator _calc = new GenericCalculator();
	private boolean defaultViewShown = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * Toggles the main calculator input controls
	 * @param view
	 */
	public void DisplayOther(View view){
		View v = findViewById(R.id.inputControls);

		if (v instanceof ViewGroup){
			if (defaultViewShown){
				new ChangeInputDisplayCommand((ViewGroup)v).execute();
			}else{
				new RevertInputDisplayCommand((ViewGroup)v).execute();
			}
		}	

		defaultViewShown = !defaultViewShown;
	}


	/**
	 * Add value to Calculator
	 * @param view
	 */
	public void AddToCalculator(View view){    	
		if (view instanceof Button){
			Button b = (Button)view;
			new StringToSumCalculator(_calc, (String) b.getText()).execute();
		}
		updateResult();
		
		if (!defaultViewShown){
			DisplayOther(view);
		}
	}

	/**
	 * Clears the Calculator
	 * @param view UI Sender
	 */
	public void ClearCalculator(View view){
		_calc.clear();
		updateResult();
	}

	/**
	 * Update the result label
	 */
	private void updateResult(){
		TextView resultLabel = (TextView) findViewById(R.id.calculatorResult);
		resultLabel.setText(StringUtility.fmt(_calc.value()));
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}    
}
