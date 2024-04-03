package com.google.android.exoplayer2.source.hls;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper f35031b;

    public /* synthetic */ a(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f35031b = hlsSampleStreamWrapper;
    }

    public final void run() {
        this.f35031b.maybeFinishPrepare();
    }
}
