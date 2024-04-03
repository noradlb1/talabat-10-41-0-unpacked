package com.google.android.exoplayer2.source.hls;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper f35032b;

    public /* synthetic */ b(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f35032b = hlsSampleStreamWrapper;
    }

    public final void run() {
        this.f35032b.onTracksEnded();
    }
}
