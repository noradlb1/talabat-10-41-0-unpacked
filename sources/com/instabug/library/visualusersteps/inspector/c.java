package com.instabug.library.visualusersteps.inspector;

import android.view.View;
import io.reactivex.functions.Predicate;

class c implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f52164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f52165c;

    public c(float f11, float f12) {
        this.f52164b = f11;
        this.f52165c = f12;
    }

    /* renamed from: a */
    public boolean test(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        int width = view.getWidth() + i11;
        int height = iArr[1] + view.getHeight();
        float f11 = this.f52164b;
        if (f11 < ((float) i11) || f11 >= ((float) width)) {
            return false;
        }
        float f12 = this.f52165c;
        if (f12 < ((float) i12) || f12 >= ((float) height)) {
            return false;
        }
        return true;
    }
}
