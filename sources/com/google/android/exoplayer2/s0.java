package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f34993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f34994c;

    public /* synthetic */ s0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f34993b = forwardingEventListener;
        this.f34994c = pair;
    }

    public final void run() {
        this.f34993b.lambda$onDrmKeysRestored$9(this.f34994c);
    }
}
