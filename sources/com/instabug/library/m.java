package com.instabug.library;

import android.util.Pair;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;

class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50579b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50580c;

    public m(c0 c0Var, String str, String str2) {
        this.f50579b = str;
        this.f50580c = str2;
    }

    public void run() {
        Filters.applyOn(new Pair(this.f50579b, this.f50580c)).apply(h.f()).thenDo(h.d());
    }
}
