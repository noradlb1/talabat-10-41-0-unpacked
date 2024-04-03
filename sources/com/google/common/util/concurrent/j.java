package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrustedListenableFutureTask f44714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f44715c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f44716d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f44717e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor f44718f;

    public /* synthetic */ j(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.f44714b = trustedListenableFutureTask;
        this.f44715c = settableFuture;
        this.f44716d = listenableFuture;
        this.f44717e = listenableFuture2;
        this.f44718f = taskNonReentrantExecutor;
    }

    public final void run() {
        ExecutionSequencer.lambda$submitAsync$0(this.f44714b, this.f44715c, this.f44716d, this.f44717e, this.f44718f);
    }
}
