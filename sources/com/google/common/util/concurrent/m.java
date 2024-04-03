package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JdkFutureAdapters.ListenableFutureAdapter f44722b;

    public /* synthetic */ m(JdkFutureAdapters.ListenableFutureAdapter listenableFutureAdapter) {
        this.f44722b = listenableFutureAdapter;
    }

    public final void run() {
        this.f44722b.lambda$addListener$0();
    }
}
