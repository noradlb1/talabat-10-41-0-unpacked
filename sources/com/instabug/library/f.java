package com.instabug.library;

import android.annotation.SuppressLint;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SDKCoreEvent f50562b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f50563c;

    public f(g gVar, SDKCoreEvent sDKCoreEvent) {
        this.f50563c = gVar;
        this.f50562b = sDKCoreEvent;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void run() {
        g gVar = this.f50563c;
        gVar.f50565c.a(this.f50562b, gVar.f50564b);
        if (this.f50563c.f50565c.f50541i != null) {
            this.f50563c.f50565c.f50541i.removeCallbacks(this);
        }
    }
}
