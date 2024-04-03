package com.apptimize;

import android.content.res.ColorStateList;
import android.graphics.Color;

public class ja extends jb<ColorStateList> {
    /* renamed from: a */
    public ColorStateList b(int i11, int i12, int i13) {
        return ColorStateList.valueOf(Color.rgb(i11, i12, i13));
    }

    public Class<ColorStateList> b() {
        return ColorStateList.class;
    }

    /* renamed from: a */
    public int[] c(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        return new int[]{Color.red(defaultColor), Color.green(defaultColor), Color.blue(defaultColor), Color.alpha(defaultColor)};
    }
}
