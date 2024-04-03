package com.google.firebase.concurrent;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LimitedConcurrencyExecutor f47369b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47370c;

    public /* synthetic */ n(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        this.f47369b = limitedConcurrencyExecutor;
        this.f47370c = runnable;
    }

    public final void run() {
        this.f47369b.lambda$decorate$0(this.f47370c);
    }
}
