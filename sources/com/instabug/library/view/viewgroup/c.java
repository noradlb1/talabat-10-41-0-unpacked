package com.instabug.library.view.viewgroup;

import android.view.View;
import com.instabug.library.util.k;

class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final b f52122a;

    public c(b bVar) {
        this.f52122a = bVar;
    }

    public int[] a(int i11, int i12) {
        float a11 = k.a(this.f52122a.getScreenHeight(), (int) this.f52122a.getMaxHeightRatio());
        int size = View.MeasureSpec.getSize(i12);
        if (a11 > 0.0f && a11 < ((float) size)) {
            i12 = View.MeasureSpec.makeMeasureSpec((int) a11, View.MeasureSpec.getMode(i12));
        }
        return new int[]{i11, i12};
    }
}
