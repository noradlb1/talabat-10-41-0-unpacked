package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f34990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f34991c;

    public /* synthetic */ r0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f34990b = forwardingEventListener;
        this.f34991c = pair;
    }

    public final void run() {
        this.f34990b.lambda$onDrmKeysLoaded$7(this.f34991c);
    }
}
