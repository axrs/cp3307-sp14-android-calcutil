package com.cadcoder.calcutil.commands;

import com.cadcoder.calcutil.R;
import com.cadcoder.calcutil.R.id;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * RevertInputDisplayCommand
 * 
 * Command used to reset the view of the calculator inputs 
 * 
 * @author Alex
 *
 */
public class RevertInputDisplayCommand implements Command {
	
	private ViewGroup vg;
	

	public RevertInputDisplayCommand(ViewGroup viewGroup) {
		this.vg = viewGroup;
	}

	/**
	 * Executes the reset
	 */
	@Override
	public void execute() {
		for (int i =0; i < vg.getChildCount(); i++){
			View child = vg.getChildAt(i);

			if (child instanceof Button){
				Button b = (Button) child;
				switch (b.getId()){
				case R.id.button1:
					b.setText(String.valueOf(1));
					break;
				case R.id.button2:
					b.setText(String.valueOf(2));
					break;
				case R.id.button3:
					b.setText(String.valueOf(3));
					break;

				default:
					child.setVisibility(Button.VISIBLE);
				}

			} else if (child instanceof ViewGroup){
			 new RevertInputDisplayCommand((ViewGroup)child).execute();
			}			
		}
		
	}
}
