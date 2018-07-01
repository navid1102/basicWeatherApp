package com.nf.sun.coustomView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class AwesomeView extends AppCompatTextView {

    public AwesomeView(Context context) {
        super(context);
        setView(context);
    }

    public AwesomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);
    }

    public AwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    void setView(Context context){

        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/weathericons-regular-webfont.ttf");
        setTypeface(typeface);
    }
}
