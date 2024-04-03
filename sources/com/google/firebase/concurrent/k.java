package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class k implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f47359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f47360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f47361c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f47362d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f47363e;

    public /* synthetic */ k(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        this.f47359a = delegatingScheduledExecutorService;
        this.f47360b = runnable;
        this.f47361c = j11;
        this.f47362d = j12;
        this.f47363e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f47359a.lambda$scheduleAtFixedRate$8(this.f47360b, this.f47361c, this.f47362d, this.f47363e, completer);
    }
}
