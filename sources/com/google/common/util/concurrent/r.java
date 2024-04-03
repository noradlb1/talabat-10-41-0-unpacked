package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f44726b;

    public /* synthetic */ r(Callable callable) {
        this.f44726b = callable;
    }

    public final void run() {
        WrappingExecutorService.lambda$wrapTask$0(this.f44726b);
    }
}
