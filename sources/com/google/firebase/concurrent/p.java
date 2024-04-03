package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class p implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47373b;

    public /* synthetic */ p(Runnable runnable) {
        this.f47373b = runnable;
    }

    public final Object call() {
        return this.f47373b.run();
    }
}
