package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f47372c;

    public /* synthetic */ o(Runnable runnable, Object obj) {
        this.f47371b = runnable;
        this.f47372c = obj;
    }

    public final Object call() {
        return this.f47371b.run();
    }
}
