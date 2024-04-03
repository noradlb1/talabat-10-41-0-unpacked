package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import java.io.IOException;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.AdPrepareListener f35010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f35011c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f35012d;

    public /* synthetic */ d(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
        this.f35010b = adPrepareListener;
        this.f35011c = mediaPeriodId;
        this.f35012d = iOException;
    }

    public final void run() {
        this.f35010b.lambda$onPrepareError$1(this.f35011c, this.f35012d);
    }
}
