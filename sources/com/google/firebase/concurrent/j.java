package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47357c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47358d;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47356b = delegatingScheduledExecutorService;
        this.f47357c = runnable;
        this.f47358d = completer;
    }

    public final void run() {
        this.f47356b.lambda$scheduleWithFixedDelay$10(this.f47357c, this.f47358d);
    }
}
