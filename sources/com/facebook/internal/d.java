package com.facebook.internal;

import com.facebook.internal.WorkQueue;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkQueue.WorkNode f33597b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkQueue f33598c;

    public /* synthetic */ d(WorkQueue.WorkNode workNode, WorkQueue workQueue) {
        this.f33597b = workNode;
        this.f33598c = workQueue;
    }

    public final void run() {
        WorkQueue.m8968execute$lambda2(this.f33597b, this.f33598c);
    }
}
