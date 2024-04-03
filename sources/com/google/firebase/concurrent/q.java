package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class q implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f47375c;

    public /* synthetic */ q(Runnable runnable, Object obj) {
        this.f47374b = runnable;
        this.f47375c = obj;
    }

    public final Object call() {
        return this.f47374b.run();
    }
}
