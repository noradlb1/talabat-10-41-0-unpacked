package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f47340b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47341c;

    public /* synthetic */ e(Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f47340b = callable;
        this.f47341c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$3(this.f47340b, this.f47341c);
    }
}
