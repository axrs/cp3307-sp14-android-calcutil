package com.cadcoder.calcutil;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LCDTextView extends TextView {
	public LCDTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LCDTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LCDTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "DS-DIGI.ttf");
        setTypeface(tf ,1);
    }
}
