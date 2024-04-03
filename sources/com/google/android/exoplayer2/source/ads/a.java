package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource f35004b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f35005c;

    public /* synthetic */ a(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.f35004b = adsMediaSource;
        this.f35005c = componentListener;
    }

    public final void run() {
        this.f35004b.lambda$releaseSourceInternal$1(this.f35005c);
    }
}
