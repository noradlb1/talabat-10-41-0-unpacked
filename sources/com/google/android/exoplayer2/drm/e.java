package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSession f34929b;

    public /* synthetic */ e(DefaultDrmSession defaultDrmSession) {
        this.f34929b = defaultDrmSession;
    }

    public final void run() {
        this.f34929b.release((DrmSessionEventListener.EventDispatcher) null);
    }
}
