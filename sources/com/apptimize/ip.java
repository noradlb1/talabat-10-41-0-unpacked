package com.apptimize;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.ArrayList;

public class ip {
    public static io a(Drawable drawable) throws hk {
        if (drawable == null) {
            return new ir();
        }
        iq a11 = iq.a(drawable);
        Drawable b11 = iq.b(drawable);
        if (b11 instanceof BitmapDrawable) {
            return new im(a11, (BitmapDrawable) b11);
        }
        if (b11 instanceof ColorDrawable) {
            return new in(a11, ((ColorDrawable) b11).getColor());
        }
        if (b11 instanceof StateListDrawable) {
            return new it(a11, (StateListDrawable) b11, new ArrayList());
        }
        throw new il(b11);
    }
}
