package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class a1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f34910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f34911c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f34912d;

    public /* synthetic */ a1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, Exception exc) {
        this.f34910b = forwardingEventListener;
        this.f34911c = pair;
        this.f34912d = exc;
    }

    public final void run() {
        this.f34910b.lambda$onDrmSessionManagerError$8(this.f34911c, this.f34912d);
    }
}
