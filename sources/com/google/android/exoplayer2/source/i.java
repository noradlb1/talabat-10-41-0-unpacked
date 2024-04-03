package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.SeekMap;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f35036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SeekMap f35037c;

    public /* synthetic */ i(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.f35036b = progressiveMediaPeriod;
        this.f35037c = seekMap;
    }

    public final void run() {
        this.f35036b.lambda$seekMap$1(this.f35037c);
    }
}
