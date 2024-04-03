package com.google.android.exoplayer2.source;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f35029b;

    public /* synthetic */ h(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.f35029b = progressiveMediaPeriod;
    }

    public final void run() {
        this.f35029b.lambda$onLengthKnown$2();
    }
}
