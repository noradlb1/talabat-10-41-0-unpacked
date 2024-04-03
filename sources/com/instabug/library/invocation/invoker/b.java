package com.instabug.library.invocation.invoker;

import com.instabug.library.invocation.invoker.FloatingButtonInvoker;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FloatingButtonInvoker.c f51336b;

    public b(FloatingButtonInvoker.c cVar) {
        this.f51336b = cVar;
    }

    public void run() {
        FloatingButtonInvoker.this.hideFAB();
    }
}
