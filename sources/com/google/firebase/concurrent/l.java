package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47364b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47365c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47366d;

    public /* synthetic */ l(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47364b = delegatingScheduledExecutorService;
        this.f47365c = runnable;
        this.f47366d = completer;
    }

    public final void run() {
        this.f47364b.lambda$schedule$1(this.f47365c, this.f47366d);
    }
}
