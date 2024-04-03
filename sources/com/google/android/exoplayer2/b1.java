package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f34916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f34917c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34918d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34919e;

    public /* synthetic */ b1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f34916b = forwardingEventListener;
        this.f34917c = pair;
        this.f34918d = loadEventInfo;
        this.f34919e = mediaLoadData;
    }

    public final void run() {
        this.f34916b.lambda$onLoadCompleted$1(this.f34917c, this.f34918d, this.f34919e);
    }
}
