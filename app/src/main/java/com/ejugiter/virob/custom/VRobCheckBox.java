package com.ejugiter.virob.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.ejugiter.virob.R;


/**
 * Created by Vrinda on 11/9/2017.
 */

public class VRobCheckBox extends AppCompatCheckBox {
    String defaultFont = "Roboto-Regular.ttf";


    public VRobCheckBox(Context context) {
        super(context);
        initAttributes(null);
    }

    public VRobCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(attrs);
    }

    public VRobCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(attrs);
    }

    public void initAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.VRobCheckBox);
            String fontName = a.getString(R.styleable.VRobCheckBox_cb_fontface);
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
