package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

public class LPaint extends Paint {
    public LPaint() {
    }

    public void setAlpha(int i11) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((MiscUtils.clamp(i11, 0, 255) << 24) | (getColor() & 16777215));
            return;
        }
        super.setAlpha(MiscUtils.clamp(i11, 0, 255));
    }

    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public LPaint(int i11) {
        super(i11);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int i11, PorterDuff.Mode mode) {
        super(i11);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
