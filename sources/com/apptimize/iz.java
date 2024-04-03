package com.apptimize;

import android.graphics.Color;

public class iz extends jb<Integer> {
    /* renamed from: a */
    public Integer b(int i11, int i12, int i13) {
        return Integer.valueOf(Color.rgb(i11, i12, i13));
    }

    /* renamed from: a */
    public int[] c(Integer num) {
        return new int[]{Color.red(num.intValue()), Color.green(num.intValue()), Color.blue(num.intValue()), Color.alpha(num.intValue())};
    }

    public Class<Integer> b() {
        return Integer.class;
    }
}
