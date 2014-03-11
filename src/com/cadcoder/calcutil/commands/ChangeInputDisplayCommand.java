package com.cadcoder.calcutil.commands;

import com.cadcoder.calcutil.R;
import com.cadcoder.calcutil.R.id;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * ChangeInputDisplayCommand
 * 
 * Command used to handle the changing of the calculator inputs 
 * 
 * @author Alex
 *
 */
public class ChangeInputDisplayCommand implements Command {

	ViewGroup vg;
	public ChangeInputDisplayCommand(ViewGroup viewGroup){
		vg = viewGroup;		
	}
	
	/**
	 * Executes the change
	 */
	@Override
	public void execute() {
		for (int i =0; i < vg.getChildCount(); i++){
			View child = vg.getChildAt(i);

			if (child instanceof Button){
				Button b = (Button) child;
				
				switch (b.getId()){
				case R.id.button1:
					b.setText(String.valueOf(0.5));
					break;
				case R.id.button2:
					b.setText(String.valueOf(10));
					break;
				case R.id.button3:
					b.setText(String.valueOf(100));
					break;

				default:
					child.setVisibility(Button.INVISIBLE);

				}
			} else if (child instanceof ViewGroup){
				new ChangeInputDisplayCommand((ViewGroup)child).execute();
			}			
		}
	}	
	
}
