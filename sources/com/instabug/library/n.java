package com.instabug.library;

import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;

class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50582b;

    public n(c0 c0Var, String str) {
        this.f50582b = str;
    }

    public void run() {
        Filters.applyOn(this.f50582b).apply(h.e()).thenDo(h.b());
    }
}
