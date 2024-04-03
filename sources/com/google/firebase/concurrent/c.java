package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47335b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47336c;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47335b = runnable;
        this.f47336c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f47335b, this.f47336c);
    }
}
