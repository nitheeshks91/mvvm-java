package com.ejugiter.virob.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.ejugiter.virob.R;


/**
 * Created by vrinda on 21/2/18.
 */

public class VrobRadioButton extends AppCompatRadioButton {

    String defaultFont = "Roboto-Regular.ttf";

    public VrobRadioButton(Context context) {
        super(context);
        initAttributes(null);
    }

    public VrobRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(attrs);
    }

    public VrobRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(attrs);
    }

    public void initAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.VrobRadioButton);
            String fontName = a.getString(R.styleable.VrobRadioButton_rb_fontface);
            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                    setTypeface(myTypeface);
                } else {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + defaultFont);
                    setTypeface(myTypeface);
                }


            } catch (Exception e) {
                e.printStackTrace();

            }
            a.recycle();

        }

    }

}

