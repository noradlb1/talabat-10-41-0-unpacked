package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class i implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47351a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47352b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f47353c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f47354d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f47355e;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        this.f47351a = delegatingScheduledExecutorService;
        this.f47352b = runnable;
        this.f47353c = j11;
        this.f47354d = j12;
        this.f47355e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f47351a.lambda$scheduleWithFixedDelay$11(this.f47352b, this.f47353c, this.f47354d, this.f47355e, completer);
    }
}
