package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f47349c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f47350d;

    public /* synthetic */ h(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, TimeUnit timeUnit) {
        this.f47347a = delegatingScheduledExecutorService;
        this.f47348b = runnable;
        this.f47349c = j11;
        this.f47350d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f47347a.lambda$schedule$2(this.f47348b, this.f47349c, this.f47350d, completer);
    }
}
