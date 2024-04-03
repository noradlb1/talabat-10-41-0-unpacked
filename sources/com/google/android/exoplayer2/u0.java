package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35058c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35059d;

    public /* synthetic */ u0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f35057b = forwardingEventListener;
        this.f35058c = pair;
        this.f35059d = mediaLoadData;
    }

    public final void run() {
        this.f35057b.lambda$onDownstreamFormatChanged$5(this.f35058c, this.f35059d);
    }
}
