package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.BandwidthMeter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f35060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35061c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35062d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f35063e;

    public /* synthetic */ a(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i11, long j11, long j12) {
        this.f35060b = handlerAndListener;
        this.f35061c = i11;
        this.f35062d = j11;
        this.f35063e = j12;
    }

    public final void run() {
        this.f35060b.listener.onBandwidthSample(this.f35061c, this.f35062d, this.f35063e);
    }
}
