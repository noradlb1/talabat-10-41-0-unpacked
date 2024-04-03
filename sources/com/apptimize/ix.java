package com.apptimize;

import android.graphics.Typeface;
import android.widget.TextView;
import java.lang.reflect.Method;

public class ix implements iw<Integer, TextView> {
    public Class<TextView> b() {
        return TextView.class;
    }

    private static int b(TextView textView) {
        Typeface typeface = textView.getTypeface();
        if (typeface == null) {
            return 0;
        }
        boolean z11 = typeface.isBold() || textView.getPaint().isFakeBoldText();
        boolean z12 = typeface.isItalic() || textView.getPaint().getTextSkewX() != 0.0f;
        if (!z11 && !z12) {
            return 0;
        }
        if (!z11 || z12) {
            return (z11 || !z12) ? 3 : 2;
        }
        return 1;
    }

    public Method a() throws NoSuchMethodException {
        return TextView.class.getMethod("setTypeface", new Class[]{Typeface.class, Integer.TYPE});
    }

    public void a(TextView textView, Integer num) {
        textView.setTypeface(textView.getTypeface(), num.intValue());
    }

    public Integer a(TextView textView) {
        return Integer.valueOf(b(textView));
    }
}
