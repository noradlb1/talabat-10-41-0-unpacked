package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35087c;

    public /* synthetic */ z0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f35086b = forwardingEventListener;
        this.f35087c = pair;
    }

    public final void run() {
        this.f35086b.lambda$onDrmSessionReleased$11(this.f35087c);
    }
}
