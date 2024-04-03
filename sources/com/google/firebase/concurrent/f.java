package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f47343c;

    public /* synthetic */ f(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f47342b = runnable;
        this.f47343c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f47342b, this.f47343c);
    }
}
