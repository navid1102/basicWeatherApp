package com.nf.sun.coustomView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by KarAmad-user on 5/22/2018.
 */

public class PersionTextView extends AppCompatTextView{


    public PersionTextView(Context context) {
        super(context);
        setFont(context);
    }



    public PersionTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }



    public PersionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    public void setFont(Context context){

        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/BZar.ttf");
        setTypeface(typeface);
    }
}
