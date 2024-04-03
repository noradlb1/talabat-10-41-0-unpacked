package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f47338c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47339d;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f47337b = delegatingScheduledExecutorService;
        this.f47338c = callable;
        this.f47339d = completer;
    }

    public final Object call() {
        return this.f47337b.lambda$schedule$4(this.f47338c, this.f47339d);
    }
}
