package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f35013b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdPlaybackState f35014c;

    public /* synthetic */ e(AdsMediaSource.ComponentListener componentListener, AdPlaybackState adPlaybackState) {
        this.f35013b = componentListener;
        this.f35014c = adPlaybackState;
    }

    public final void run() {
        this.f35013b.lambda$onAdPlaybackState$0(this.f35014c);
    }
}
