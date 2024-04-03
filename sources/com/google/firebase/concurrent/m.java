package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47367b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47368c;

    public /* synthetic */ m(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47367b = runnable;
        this.f47368c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$0(this.f47367b, this.f47368c);
    }
}
