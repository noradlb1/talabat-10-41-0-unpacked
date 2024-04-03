package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class v0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35069c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35070d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35071e;

    public /* synthetic */ v0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f35068b = forwardingEventListener;
        this.f35069c = pair;
        this.f35070d = loadEventInfo;
        this.f35071e = mediaLoadData;
    }

    public final void run() {
        this.f35068b.lambda$onLoadCanceled$2(this.f35069c, this.f35070d, this.f35071e);
    }
}
