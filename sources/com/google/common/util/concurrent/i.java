package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AggregateFuture f44712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableCollection f44713c;

    public /* synthetic */ i(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.f44712b = aggregateFuture;
        this.f44713c = immutableCollection;
    }

    public final void run() {
        this.f44712b.lambda$init$1(this.f44713c);
    }
}
