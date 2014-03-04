package com.cadcoder.calcutil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Calculator _calc = new GenericCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void AddToCalculator(View view){
    	System.out.println("Button Pressed");
    	
    	Button b = (Button)view;
    	int value = Integer.parseInt((String) b.getText());
    	_calc.sum(value);
    	updateResult();
    }
    
    public void ClearCalculator(View view){
    	_calc.clear();
    	updateResult();
    }
    
    private void updateResult(){
    	TextView resultLabel = (TextView) findViewById(R.id.calculatorResult);
    	resultLabel.setText(String.valueOf(_calc.value()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
}
