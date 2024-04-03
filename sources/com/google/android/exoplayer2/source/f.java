package com.google.android.exoplayer2.source;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f35027b;

    public /* synthetic */ f(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.f35027b = progressiveMediaPeriod;
    }

    public final void run() {
        this.f35027b.maybeFinishPrepare();
    }
}
