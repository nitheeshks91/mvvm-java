package com.ejugiter.virob.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.ejugiter.virob.R;


/**
 * Created by Vrinda on 8/23/2017.
 */

public class VRobEditText extends AppCompatEditText {

    String defaultFont = "Roboto-Regular.ttff";

    public VRobEditText(Context context) {
        super(context);
        initAttributes(null);
    }

    public VRobEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(attrs);
    }

    public VRobEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(attrs);
    }

    public void initAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.VRobEditText);
            String fontName = a.getString(R.styleable.VRobEditText_edt_fontface);
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


