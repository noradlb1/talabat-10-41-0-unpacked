package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35082c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35083d;

    public /* synthetic */ y0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f35081b = forwardingEventListener;
        this.f35082c = pair;
        this.f35083d = mediaLoadData;
    }

    public final void run() {
        this.f35081b.lambda$onUpstreamDiscarded$4(this.f35082c, this.f35083d);
    }
}
