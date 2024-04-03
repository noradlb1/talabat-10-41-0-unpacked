package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource f35006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f35007c;

    public /* synthetic */ b(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.f35006b = adsMediaSource;
        this.f35007c = componentListener;
    }

    public final void run() {
        this.f35006b.lambda$prepareSourceInternal$0(this.f35007c);
    }
}
