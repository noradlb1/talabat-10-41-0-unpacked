package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47376b;

    public /* synthetic */ r(Runnable runnable) {
        this.f47376b = runnable;
    }

    public final Object call() {
        return this.f47376b.run();
    }
}
