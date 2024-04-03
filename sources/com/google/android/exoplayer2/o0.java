package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPeriodQueue f34972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f34973c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f34974d;

    public /* synthetic */ o0(MediaPeriodQueue mediaPeriodQueue, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f34972b = mediaPeriodQueue;
        this.f34973c = builder;
        this.f34974d = mediaPeriodId;
    }

    public final void run() {
        this.f34972b.lambda$notifyQueueUpdate$0(this.f34973c, this.f34974d);
    }
}
