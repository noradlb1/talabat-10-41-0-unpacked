package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f47393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f47394c;

    public /* synthetic */ b(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.f47393b = reportQueue;
        this.f47394c = countDownLatch;
    }

    public final void run() {
        this.f47393b.lambda$flushScheduledReportsIfAble$0(this.f47394c);
    }
}
