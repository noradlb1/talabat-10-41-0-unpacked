package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35074b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35075c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f35076d;

    public /* synthetic */ w0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i11) {
        this.f35074b = forwardingEventListener;
        this.f35075c = pair;
        this.f35076d = i11;
    }

    public final void run() {
        this.f35074b.lambda$onDrmSessionAcquired$6(this.f35075c, this.f35076d);
    }
}
