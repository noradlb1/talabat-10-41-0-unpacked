package com.instabug.bug.view.visualusersteps.steppreview;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f45956b;

    public f(h hVar, c cVar) {
        this.f45956b = cVar;
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "Error: " + th2.getMessage() + ", while previewing bitmap");
        this.f45956b.m();
    }
}
