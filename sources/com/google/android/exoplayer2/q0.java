package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f34985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f34986c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34987d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34988e;

    public /* synthetic */ q0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f34985b = forwardingEventListener;
        this.f34986c = pair;
        this.f34987d = loadEventInfo;
        this.f34988e = mediaLoadData;
    }

    public final void run() {
        this.f34985b.lambda$onLoadStarted$0(this.f34986c, this.f34987d, this.f34988e);
    }
}
