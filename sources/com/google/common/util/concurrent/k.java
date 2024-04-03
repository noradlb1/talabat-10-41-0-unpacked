package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Futures.InCompletionOrderState f44719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableList f44720c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f44721d;

    public /* synthetic */ k(Futures.InCompletionOrderState inCompletionOrderState, ImmutableList immutableList, int i11) {
        this.f44719b = inCompletionOrderState;
        this.f44720c = immutableList;
        this.f44721d = i11;
    }

    public final void run() {
        this.f44719b.recordInputCompletion(this.f44720c, this.f44721d);
    }
}
