package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.AdPrepareListener f35008b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f35009c;

    public /* synthetic */ c(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f35008b = adPrepareListener;
        this.f35009c = mediaPeriodId;
    }

    public final void run() {
        this.f35008b.lambda$onPrepareComplete$0(this.f35009c);
    }
}
