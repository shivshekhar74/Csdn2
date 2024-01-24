package comc.shiv.csdn;

import android.content.Context;
import android.graphics.Typeface;

import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class custom_text extends AppCompatTextView {

    public custom_text(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public custom_text(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public custom_text(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                    "philosopher.regular.ttf");
            setTypeface(tf);
        }
    }
}