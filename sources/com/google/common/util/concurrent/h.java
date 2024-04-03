package com.google.common.util.concurrent;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AggregateFuture f44709b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f44710c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f44711d;

    public /* synthetic */ h(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i11) {
        this.f44709b = aggregateFuture;
        this.f44710c = listenableFuture;
        this.f44711d = i11;
    }

    public final void run() {
        this.f44709b.lambda$init$0(this.f44710c, this.f44711d);
    }
}
