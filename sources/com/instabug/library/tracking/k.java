package com.instabug.library.tracking;

import android.view.MotionEvent;
import com.instabug.library.f0;
import com.instabug.library.g0;
import com.instabug.library.usersteps.g;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f51932a;

    private k() {
    }

    public static k a() {
        if (f51932a == null) {
            f51932a = new k();
        }
        return f51932a;
    }

    public void b(MotionEvent motionEvent) {
        f0[] f0VarArr = new f0[motionEvent.getPointerCount()];
        for (int i11 = 0; i11 < motionEvent.getPointerCount(); i11++) {
            f0VarArr[i11] = new f0((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
        }
        g0.a().a(f0VarArr);
        g.d().a(motionEvent);
    }
}
