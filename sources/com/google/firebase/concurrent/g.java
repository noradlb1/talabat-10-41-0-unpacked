package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47345c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47346d;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47344b = delegatingScheduledExecutorService;
        this.f47345c = runnable;
        this.f47346d = completer;
    }

    public final void run() {
        this.f47344b.lambda$scheduleAtFixedRate$7(this.f47345c, this.f47346d);
    }
}
