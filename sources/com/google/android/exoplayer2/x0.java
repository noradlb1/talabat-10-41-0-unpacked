package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35079c;

    public /* synthetic */ x0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f35078b = forwardingEventListener;
        this.f35079c = pair;
    }

    public final void run() {
        this.f35078b.lambda$onDrmKeysRemoved$10(this.f35079c);
    }
}
