package com.instabug.library.tracking;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class c0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ y f51920b;

    public /* synthetic */ c0(y yVar) {
        this.f51920b = yVar;
    }

    public final void accept(Object obj) {
        y.a(this.f51920b, (ActivityLifeCycleEvent) obj);
    }
}
