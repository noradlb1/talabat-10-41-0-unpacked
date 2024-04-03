package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f47332b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f47333c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f47334d;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, long j11, TimeUnit timeUnit) {
        this.f47331a = delegatingScheduledExecutorService;
        this.f47332b = callable;
        this.f47333c = j11;
        this.f47334d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f47331a.lambda$schedule$5(this.f47332b, this.f47333c, this.f47334d, completer);
    }
}
